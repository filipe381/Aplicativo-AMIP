package com.example.censo_amip

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegistroCivilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_civil)

        val spinneregistro: Spinner = findViewById(R.id.spinneregistro)
        val registro = listOf(
            ""
        )

        val opcaoRadioGroup: RadioGroup = findViewById(R.id.opcao)
        val opcao = when (opcaoRadioGroup.checkedRadioButtonId){
            R.id.sim -> "Sim"
            R.id.nao -> "Não"
            else -> "Indefinido"
        }

        val registroAdapter = ArrayAdapter(this, R.layout.spinner_item, registro)
        registroAdapter.setDropDownViewResource(R.layout.activity_registro_civil)

        spinneregistro.adapter = registroAdapter
    }
}