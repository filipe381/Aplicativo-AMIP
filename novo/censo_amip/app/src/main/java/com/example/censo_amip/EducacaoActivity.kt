package com.example.censo_amip

import android.os.Bundle
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

        val opcaoRadioGroup: RadioGroup = findViewById(R.id.opcao)
        val opcao = when (opcaoRadioGroup.checkedRadioButtonId){
            R.id.sim -> "Sim"
            R.id.nao -> "Não"
            else -> "Indefinido"
        }
    }
}