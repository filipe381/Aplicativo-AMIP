package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginAdministradorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_administrador)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etEmail: EditText = findViewById(R.id.pt_email)
        val etSenha: EditText = findViewById(R.id.senha)

        val senha = etSenha.text.toString()
        val email = etEmail.text.toString()


        val btnContinuar = findViewById<Button>(R.id.bt_intent)
        btnContinuar.setOnClickListener {
            val intent = Intent(this, DomicilioActivity::class.java)
            startActivity(intent)
        }
    }
}