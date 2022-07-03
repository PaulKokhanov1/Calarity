package com.example.calarity.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calarity.R
import com.example.calarity.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.HashMap

class LoginPage : AppCompatActivity() {

    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        //Basic Firestore Add data test
//        firestore = FirebaseFirestore.getInstance()
//
//        var user : HashMap<String, Any> = HashMap<String, Any> ()
//        user.put("firstname", "Easy")
//        user.put("lastname", "Tuto")
//        user.put("description", "Yolo")
//
//        firestore.collection("users").add(user).addOnSuccessListener {
//            Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
//        }.addOnFailureListener {
//            Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
//        }

        binding.textviewRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.loginBtn.setOnClickListener {
            performLogin(binding)
        }
    }

    private fun performLogin(binding: ActivityLoginPageBinding) {
        if(binding.email.text.isEmpty() || binding.password.text.isEmpty()){
            Toast.makeText(this, "Please Fill all the Fields", Toast.LENGTH_SHORT).show()
            return
        }

        val inputEmail = binding.email.text.toString()
        val inputPassword = binding.password.text.toString()

        auth.signInWithEmailAndPassword(inputEmail, inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(baseContext, "Success",
                        Toast.LENGTH_SHORT).show()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(baseContext, "Authentication failed. ${it.localizedMessage}",
                    Toast.LENGTH_SHORT).show()
            }

    }
}