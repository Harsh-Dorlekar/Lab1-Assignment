package com.example.lab1_assignment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var sidEditText: EditText
    private lateinit var sNameEditText: EditText
    private lateinit var sAgeEditText: EditText
    private lateinit var sAddressEditText: EditText
    private lateinit var sEmailEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sidEditText = findViewById(R.id.SID)
        sNameEditText = findViewById(R.id.SName)
        sAgeEditText = findViewById(R.id.SAge)
        sAddressEditText = findViewById(R.id.SAddress)
        sEmailEditText = findViewById(R.id.SEmail)
        registerButton = findViewById(R.id.button)

        // Set up click listener for the Register button
        registerButton.setOnClickListener {
            // Get user input from EditText fields
            val studentId = sidEditText.text.toString()
            val studentName = sNameEditText.text.toString()
            val studentAge = sAgeEditText.text.toString()
            val studentAddress = sAddressEditText.text.toString()
            val studentEmail = sEmailEditText.text.toString()

            // Store student data in Firebase Database
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("students")

            val studentData = mapOf(
                "studentName" to studentName,
                "studentAge" to studentAge,
                "studentAddress" to studentAddress,
                "studentEmail" to studentEmail
            )

            myRef.child(studentId).setValue(studentData)

            sidEditText.text.clear()
            sNameEditText.text.clear()
            sAgeEditText.text.clear()
            sAddressEditText.text.clear()
            sEmailEditText.text.clear()
        }
    }
}
