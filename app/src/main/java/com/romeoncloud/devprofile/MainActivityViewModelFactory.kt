package com.romeoncloud.devprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(private val startingString: String) : ViewModelProvider.Factory {

    private lateinit var viewModel: MainActivityViewModel
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel("startingString") as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
