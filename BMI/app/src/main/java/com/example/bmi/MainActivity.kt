package com.example.bmi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.bmi.R.color.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_bmi.setOnClickListener {

            if(weight_edit_text.text.isNotEmpty() && height_edit_text.text.isNotEmpty()){

                val weight = weight_edit_text.text.toString().toFloat()
                val height = height_edit_text.text.toString().toFloat()

                val myBmi = weight / (height * height)

                bmi_textview.text = myBmi.toString()

                if(myBmi < 18.5) {
                    bmi_imageview.setImageResource(R.drawable.ic_underweight)
                    weight_edit_text.setTextColor(ContextCompat.getColor(this, sky_blue))
                    height_edit_text.setTextColor(ContextCompat.getColor(this, sky_blue))
                    bmi_textview.setTextColor(ContextCompat.getColor(this, sky_blue))
                }
                else if(myBmi >= 18.8 && myBmi < 24.9) {
                    bmi_imageview.setImageResource(R.drawable.healthy)
                    weight_edit_text.setTextColor(ContextCompat.getColor(this, green))
                    height_edit_text.setTextColor(ContextCompat.getColor(
                        this,
                        green
                    ))
                    bmi_textview.setTextColor(ContextCompat.getColor(this, green))
                }
                else if(myBmi >= 24.9 && myBmi<29.9) {
                    bmi_imageview.setImageResource(R.drawable.ic_overweight)
                    weight_edit_text.setTextColor(ContextCompat.getColor(this, yellow))
                    height_edit_text.setTextColor(ContextCompat.getColor(this, yellow))
                    bmi_textview.setTextColor(ContextCompat.getColor(this, yellow))
                }
                else if(myBmi >= 29.9 ){
                    bmi_imageview.setImageResource(R.drawable.ic_obesity)
                    weight_edit_text.setTextColor(ContextCompat.getColor(this, red))
                    height_edit_text.setTextColor(ContextCompat.getColor(this, red))
                    bmi_textview.setTextColor(ContextCompat.getColor(this, red))
                }

            }
            else {
                Toast.makeText(this, "Please input weight and height",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }
}
