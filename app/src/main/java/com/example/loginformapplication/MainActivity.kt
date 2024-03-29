package com.example.loginformapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setupSpinner()
        setupButton()
    }

    private lateinit var user : UserDetails

    private fun setupSpinner() {
        val spinner = findViewById<Spinner>(R.id.spinner_title)
        val spinnerItems = arrayOf("Mr.", "Mrs.", "Ms.", "Dr.", "Prof.")
        val titleAdapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, spinnerItems)

        spinner.adapter = titleAdapter
    }
    private fun setupButton() {
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            createUser()

            val nextActivity = Intent(this, ResultActivity::class.java)
            nextActivity.putExtra("User", user)
            startActivity(nextActivity)
        }
    }

    private fun createUser() {
        val title = findViewById<Spinner>(R.id.spinner_title).selectedItem as String
        val firstName = findViewById<TextInputEditText>(R.id.editText_firstName).text.toString()
        val lastName = findViewById<TextInputEditText>(R.id.editText_lastName).text.toString()
        val email = findViewById<TextInputEditText>(R.id.editText_email).text.toString()
        val phone = findViewById<TextInputEditText>(R.id.editText_phone).text.toString()
        val password = findViewById<TextInputEditText>(R.id.editText_password).text.toString()

        user = UserDetails(title, firstName, lastName, email, phone, password)
    }

}