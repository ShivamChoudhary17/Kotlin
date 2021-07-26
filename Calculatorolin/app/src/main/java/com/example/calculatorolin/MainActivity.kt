package com.example.calculatorolin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private var number1: Float = 0.0f
    private var isPlus = false
    private var isMinus: Boolean = false
    private var isDiv: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = edittext
    }

    fun operationFunction(view: View) {
        when (view.id) {
            R.id.button_one -> {
                numberClicked(1)
            }
            R.id.button_two -> {
                numberClicked(2)
            }
            R.id.button_three -> {
                numberClicked(3)
            }
            R.id.button_four -> {
                numberClicked(4)
            }
            R.id.button_five -> {
                numberClicked(5)
            }
            R.id.button_six -> {
                numberClicked(6)
            }
            R.id.button_seven -> {
                numberClicked(7)
            }
            R.id.button_eight -> {
                numberClicked(8)
            }
            R.id.button_nine -> {
                numberClicked(9)
            }
            R.id.button_zero -> {
                numberClicked(0)
            }
            R.id.button_dot -> {
                dotClicked()
            }
            R.id.button_clear -> {
                editText.setText("")
            }
            R.id.button_plus -> {
                buttonClicked()
            }
            R.id.button_dash -> {
                buttonClicked()
            }
            R.id.button_div -> {
                buttonClicked()
            }
            R.id.button_equal -> {
                when {
                    isPlus -> {
                        plusClicked()
                    }
                    isMinus -> {
                        minusClicked()
                    }
                    isDiv -> {
                        divClicked()
                    }
                }

            }
        }
    }

    private fun numberClicked(numberClicked: Int) {
        val number = editText.text.toString() + numberClicked.toString()
        editText.setText(number)
    }

    private fun dotClicked() {
        val number = editText.text.toString() + "."
        editText.setText(number)
    }

    private fun buttonClicked() {
        number1 = editText.text.toString().toFloat()
        editText.setText("")
        isMinus = true
    }

    private fun plusClicked() {
        val number2 = editText.text.toString().toFloat()
        val result = number1 + number2
        editText.setText(result.toString())
        isPlus = false
    }

    private fun minusClicked() {
        val number2 = editText.text.toString().toFloat()
        val result = number1 - number2
        editText.setText(result.toString())
        isPlus = false
    }

    private fun divClicked() {
        val number2 = editText.text.toString().toFloat()
        val result = number1 / number2
        editText.setText(result.toString())
        isPlus = false
    }
}