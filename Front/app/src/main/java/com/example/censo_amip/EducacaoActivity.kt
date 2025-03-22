package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EducacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_educacao)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val opcaoRadioGroup: RadioGroup = findViewById(R.id.opcao)

        // Carregar dados salvos
        FormData.sabeLerEscrever?.let { sabeLerEscrever ->
            val radioButtonId = when (sabeLerEscrever) {
                "Sim" -> R.id.sim
                "Não" -> R.id.nao
                else -> -1
            }
            if (radioButtonId != -1) {
                opcaoRadioGroup.check(radioButtonId)
            }
        }

        val btnProxima: Button = findViewById(R.id.btnProxima)
        btnProxima.setOnClickListener {
            FormData.sabeLerEscrever = when (opcaoRadioGroup.checkedRadioButtonId) {
                R.id.sim -> "Sim"
                R.id.nao -> "Não"
                else -> "Indefinido"
            }

            val intent = Intent(this, RendimentosActivity::class.java)
            startActivity(intent)
        }

        val btnAnterior: Button = findViewById(R.id.btnVoltar)
        btnAnterior.setOnClickListener {
            val intent = Intent(this, RegistroCivilActivity::class.java)
            startActivity(intent)
        }
    }
}