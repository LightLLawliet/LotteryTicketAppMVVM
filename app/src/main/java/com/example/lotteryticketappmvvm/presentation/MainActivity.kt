package com.example.lotteryticketappmvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lotteryticketappmvvm.NumberApp
import com.example.lotteryticketappmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button = binding.button
        val editText = binding.editText
        val textView = binding.textView
        viewModel = (application as NumberApp).viewModel

        viewModel.observe(this) {
            textView.text = it
        }

        button.setOnClickListener {
            editText.setText("")
            viewModel.update(editText.toString().toInt())
        }
        viewModel.init()
    }
}