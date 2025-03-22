package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
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
            "Registro Civil",
            "Solteiro(a)",
            "Casado(a)",
            "Divorciado(a)",
            "Viúvo(a)"
        )

        val registroAdapter = ArrayAdapter(this, R.layout.spinner_item, registro)
        registroAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinneregistro.adapter = registroAdapter

        val opcaoRadioGroup: RadioGroup = findViewById(R.id.opcao)

        // Carregar dados salvos
        FormData.registroCivil?.let { registroCivil ->
            val position = registroAdapter.getPosition(registroCivil)
            spinneregistro.setSelection(position)
        }
        FormData.temCriancaAbaixoDe5Anos?.let { temCrianca ->
            val radioButtonId = when (temCrianca) {
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
            FormData.registroCivil = spinneregistro.selectedItem.toString()
            FormData.temCriancaAbaixoDe5Anos = when (opcaoRadioGroup.checkedRadioButtonId) {
                R.id.sim -> "Sim"
                R.id.nao -> "Não"
                else -> "Indefinido"
            }

            val intent = Intent(this, EducacaoActivity::class.java)
            startActivity(intent)
        }

        val btnAnterior: Button = findViewById(R.id.btnVoltar)
        btnAnterior.setOnClickListener {
            val intent = Intent(this, IndoMoradoresActivity::class.java)
            startActivity(intent)
        }
    }
}