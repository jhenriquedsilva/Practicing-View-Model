package com.example.trainingviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var dataButton: Button
    lateinit var showButton: Button
    lateinit var editText: EditText
    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeData()
        initializeClick()
    }

    private fun initializeData() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        editText = findViewById(R.id.editText)
        dataButton = findViewById(R.id.dataButton)
        showButton = findViewById(R.id.showButton)

        mainViewModel.myCounter.observe(this, Observer {value ->
            editText.setText(value)
        })
    }

    private fun initializeClick() {
        dataButton.setOnClickListener {
            mainViewModel.contador()
        }

        showButton.setOnClickListener {
            Toast.makeText(applicationContext, "Counter velue: ${mainViewModel.myCounter.value}",Toast.LENGTH_SHORT).show()
        }
    }
}