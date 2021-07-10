package com.example.birthday_card

import android.content.Context
import android.content.Context.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createBirthdayCard(view: View) {

        val intent = Intent(this, BirthdayGreetingActivity::class.java)
        val editText = findViewById<EditText>(R.id.inputName)
        val name = editText.editableText.toString()
        intent.putExtra("name", name)
        startActivity(intent)

    }



}