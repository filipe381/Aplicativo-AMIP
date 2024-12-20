package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RendimentosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rendimentos)

        val spinnerRendimento: Spinner = findViewById(R.id.spinnerendimento)
        val rendimentos = listOf(
            "Rendimento Domiciliar",
            "Até 1000",
            "Até 3000",
            "Até 5000",
            "Até 8000",
            "Até 10000",
            "10000 ou mais",
            "Prefiro não responder"
        )
        val rendimentosAdapter = ArrayAdapter(this, R.layout.spinner_item, rendimentos)
        rendimentosAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerRendimento.adapter = rendimentosAdapter

        // Carregar dados salvos
        FormData.rendimentoDomiciliar?.let { rendimento ->
            val position = rendimentosAdapter.getPosition(rendimento)
            spinnerRendimento.setSelection(position)
        }

        val btnProxima: Button = findViewById(R.id.btnProxima)
        btnProxima.setOnClickListener {
            FormData.rendimentoDomiciliar = spinnerRendimento.selectedItem.toString()

            val intent = Intent(this, DadosdeContatoActivity::class.java)
            startActivity(intent)
        }

        val btnAnterior: Button = findViewById(R.id.btnVoltar)
        btnAnterior.setOnClickListener {
            val intent = Intent(this, EducacaoActivity::class.java)
            startActivity(intent)
        }
    }
}