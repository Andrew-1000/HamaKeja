package com.example.hamakeja.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class PageViewModel: ViewModel() {
    private val _index = MutableLiveData<Int> ()
    val text: LiveData<String> = Transformations.map(_index) {
        "Swipe right if you want to move an left if you own a truck"
            }
    fun setIndex(i: Int) {
        _index.value = i
    }

}
