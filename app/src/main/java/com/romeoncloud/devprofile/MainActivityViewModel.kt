package com.romeoncloud.devprofile

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingString: String): ViewModel() {

    private var food = "You clicked me!"

    init {
        food = startingString
    }
    fun getCurrentFood(): String {
        return food
    }
    fun getUpdatedFood(): String {
        return food
    }
}

