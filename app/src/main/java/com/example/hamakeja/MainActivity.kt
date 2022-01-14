package com.example.hamakeja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private val message = "Welcome Back"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class OwnerFragment : Fragment(R.layout.fragment_home);
    }

    fun welcomeBack(view: android.view.View) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    fun openHomeActivity(view: android.view.View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}