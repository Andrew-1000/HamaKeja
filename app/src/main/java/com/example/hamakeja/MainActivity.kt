package com.example.hamakeja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private val message = "Welcome Back"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class OwnerFragment : Fragment(R.layout.fragment_owner);
    }

    fun welcomeBack(view: android.view.View) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}