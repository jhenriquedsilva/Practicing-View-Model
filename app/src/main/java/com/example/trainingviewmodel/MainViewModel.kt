package com.example.trainingviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var myCounter = MutableLiveData<String>().apply { value = counter.toString() }
    private var counter = 0

    private fun setMyCounter() {
        myCounter.value = counter.toString()
    }

    private fun validateCounter() {
        counter++

        if (counter > 5) {
            counter = 0
        }

        setMyCounter()
    }

    fun contador() {
        validateCounter()
    }
}