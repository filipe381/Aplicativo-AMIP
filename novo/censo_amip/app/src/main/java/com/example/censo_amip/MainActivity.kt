package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, InicialActivity::class.java)
            startActivity(intent)
        }, 1000) // 1000 milissegundos = 1 segundo
    }
}