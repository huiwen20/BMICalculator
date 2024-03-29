package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener {
            calculateBMI()
        }

        buttonReset.setOnClickListener {
            reset()
        }

    }

    private fun calculateBMI() {
        if (editTextHeight.text.isEmpty()) {
            editTextHeight.setError(getString(R.string.input_error));
            return
        }

        if(editTextWeight.text.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error));
            return
        }

        val weight = editTextWeight.text.toString().toFloat();
        val height = editTextHeight.text.toString().toFloat();
        val bmi = weight / (height/100).pow(2);

        if (bmi < 18.5) {
            textViewBMI.text = String.format("%s %.2f %s", getString(R.string.bmi), bmi, getString(R.string.under));
            imageView.setImageResource(R.drawable.under);

        }else if (bmi > 25) {
            textViewBMI.text = String.format("%s %.2f %s", getString(R.string.bmi), bmi, getString(R.string.over));
            imageView.setImageResource(R.drawable.over);
        }else {
            textViewBMI.text = String.format("%s %.2f %s", getString(R.string.bmi), bmi, getString(R.string.normal));
            imageView.setImageResource(R.drawable.normal);
        }


    }

    private fun reset() {
        editTextHeight.text.clear();
        editTextWeight.text.clear();
        textViewBMI.text = getString(R.string.bmi);
        imageView.setImageResource(R.drawable.empty);

    }
}

