package com.noureldin.route.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noureldin.route.api.ApiResponse
import com.noureldin.route.model.Product
import com.noureldin.route.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    private val _products = MutableLiveData<ApiResponse<List<Product>>>()
    val products: LiveData<ApiResponse<List<Product>>> get() = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            val response = productRepository.getProducts()
            _products.value = response
        }
    }
}