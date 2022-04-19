package com.example.teltonikaapp.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usecase.AddProductUseCase
import com.example.usecase.GetProductsUseCase
import com.example.usecase.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val addProductUseCase: AddProductUseCase,
) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>(emptyList())
    val products: LiveData<List<Product>> = _products

    init {
        viewModelScope.launch {
            _products.value = getProductsUseCase.get()
        }
    }

    fun onAddToBasketClicked(product: Product) {
        viewModelScope.launch {
            addProductUseCase.invoke(product)
        }
    }
}