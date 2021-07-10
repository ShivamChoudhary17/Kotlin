package com.example.birthday_card

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class BirthdayGreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_greeting)
        val name = intent.getStringExtra("name")
        val editText = findViewById<TextView>(R.id.birthdayGreeting)
        editText.text = "Happy Birthday $name"
    }
}