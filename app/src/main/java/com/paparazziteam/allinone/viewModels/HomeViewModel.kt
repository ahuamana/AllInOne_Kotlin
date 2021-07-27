package com.paparazziteam.allinone.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val _title = MutableLiveData<String>()
    val title: LiveData<String> = _title

    private val _subtitle = MutableLiveData<String>()
    val subtitle: LiveData<String> = _subtitle


    init {
        starVariables()
    }

    fun starVariables()
    {
        _title.value = "All in one"
        _subtitle.value= "Encuentra todo lo que necesita"
    }

}