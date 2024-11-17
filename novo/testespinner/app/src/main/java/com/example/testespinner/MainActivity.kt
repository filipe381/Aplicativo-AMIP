package com.example.testespinner

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner = findViewById<Spinner>(R.id.spinnerRuas)
        val ruas = listOf(
            "Rua Marina das Estrelas",
            "Rua Marina das Flores",
            "Rua Marina do Bosque",
            "Rua Marina Porto Bali",
            "Rua Marina das Hortênsias"
        )

        try {
            val adapter = ArrayAdapter(this, R.layout.spinner_item, ruas)
            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
            spinner.adapter = adapter
        } catch (e: Exception) {
            Log.e("MainActivity", "Erro ao configurar o Spinner", e)
        }


    }
}