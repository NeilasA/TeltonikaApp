package com.example.teltonikaapp.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usecase.GetBasketUseCase
import com.example.usecase.Product
import com.example.usecase.RemoveProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    private val getBasketUseCase: GetBasketUseCase,
    private val removeProductUseCase: RemoveProductUseCase,
) : ViewModel() {

    private var _basket = MutableLiveData<List<Product>>(emptyList())
    val basket: LiveData<List<Product>> = _basket

    private var _totalPrice = MutableLiveData<Int>()

    val totalPrice: LiveData<Int> = _totalPrice

    init {
        viewModelScope.launch {
            getBasketUseCase.invoke().onStart {}.map { products ->
                _basket.postValue(products)
                _totalPrice.postValue(products.sumOf { it.retailPrice })
            }.collect()
        }
    }

    fun onRemoveFromBasketClicked(product: Product) {
        viewModelScope.launch {
            removeProductUseCase.invoke(product)
        }
    }
}