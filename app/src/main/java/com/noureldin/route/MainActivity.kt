package com.noureldin.route

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.noureldin.route.adapter.ProductAdapter
import com.noureldin.route.api.ApiResponse
import com.noureldin.route.databinding.ActivityMainBinding
import com.noureldin.route.mvvm.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : ProductViewModel by viewModels()
    private val adapter: ProductAdapter by lazy { ProductAdapter(emptyList(), this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = adapter

        viewModel.products.observe(this) { response ->
            when (response) {
                is ApiResponse.Success -> {
                    adapter.setProducts(response.data)
                }
                is ApiResponse.Error -> {
                    // Show error message
                    Toast.makeText(this, "Failed to fetch products: ${response.exception.message}", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Filter the product list based on the search query
                val filteredProducts = (viewModel.products.value as? ApiResponse.Success)?.data?.filter {
                    it.title.contains(newText ?: "", ignoreCase = true)
                } ?: emptyList()
                adapter.setProducts(filteredProducts)
                return true
            }
        })

        binding.search.setOnCloseListener{
            binding.search.setQuery("",false)
            binding.search.isIconified = true
            true
        }

    }

    override fun onBackPressed() {
        if (binding.search.isIconified){
            super.onBackPressed()
        }else {
            binding.search.setQuery("",false)
            binding.search.isIconified = true
        }
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        hideKeyboard()
        binding.search.clearFocus()
        return  super.onTouchEvent(event)
    }

    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }
}