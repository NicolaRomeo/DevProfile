package com.romeoncloud.devprofile

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.romeoncloud.devprofile.databinding.ActivityMainBinding

import java.util.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        factory = MainActivityViewModelFactory("Clicked")  // Custom starting point for our counter
        // Initialize the ViewModel here
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)
        binding.apply {
            // create rounded logo
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.devslopesprofilelogo)
            val rounded = RoundedBitmapDrawableFactory.create(resources, bitmap)
            //set radius corner
            //rounded.cornerRadius = 15f
            rounded.isCircular = true
            logo?.setImageDrawable(rounded)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}