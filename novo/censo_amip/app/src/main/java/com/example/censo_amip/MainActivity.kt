package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Referência ao botão no layout
        val button = findViewById<Button>(R.id.bt_intent)

        // Ao clicar no botão, inicia a SecondActivity
        button.setOnClickListener {
            // Cria uma Intent explícita para chamar a SecondActivity
            val intent = Intent(this, InicialActivity::class.java)

            // Inicia a SecondActivity
            startActivity(intent)
        }
    }
}