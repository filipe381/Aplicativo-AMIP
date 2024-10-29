package com.example.ola_mundo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ola_mundo.R

class InicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicial)

        // Ajusta as margens para exibir a imagem adequadamente com as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Referência ao botão no layout
        val button = findViewById<Button>(R.id.bt_recenseador)

        // Ao clicar no botão, inicia a SecondActivity
        button.setOnClickListener {
            // Cria uma Intent explícita para chamar a SecondActivity
            val intent = Intent(this, LoginRecenseadorActivity::class.java)

            // Inicia a SecondActivity
            startActivity(intent)
        }
    }
}