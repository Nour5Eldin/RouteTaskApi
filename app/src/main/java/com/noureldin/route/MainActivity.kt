package com.noureldin.route

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.noureldin.route.adapter.ProductAdapter
import com.noureldin.route.databinding.ActivityMainBinding
import com.noureldin.route.mvvm.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : ProductViewModel by viewModels()
    private val adapter = ProductAdapter(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = adapter

        viewModel.products.observe(this) { products ->
            adapter.setProducts(products)
        }

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Filter the product list based on the search query
                val filteredProducts = viewModel.products.value?.filter {
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
}