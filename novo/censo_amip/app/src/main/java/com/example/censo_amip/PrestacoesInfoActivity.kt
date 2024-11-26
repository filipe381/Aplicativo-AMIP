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

class PrestacoesInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prestacoes_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinnerPrestacao: Spinner = findViewById(R.id.prestinfo)
        val prestacoes = listOf(
            "Quem prestou as informações?",
            "O próprio morador",
            "Outro morador",
            "Não morador"
        )
        val prestacoesAdapter = ArrayAdapter(this, R.layout.spinner_item, prestacoes)
        prestacoesAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerPrestacao.adapter = prestacoesAdapter

        // Carregar dados salvos
        FormData.prestacaoInfo?.let { prestacao ->
            val position = prestacoesAdapter.getPosition(prestacao)
            spinnerPrestacao.setSelection(position)
        }

        val btnProxima: Button = findViewById(R.id.btnProxima)
        btnProxima.setOnClickListener {
            FormData.prestacaoInfo = spinnerPrestacao.selectedItem.toString()

            val intent = Intent(this, ProblemasAreasComActivity::class.java)
            startActivity(intent)
        }

        val btnAnterior: Button = findViewById(R.id.btnVoltar)
        btnAnterior.setOnClickListener {
            val intent = Intent(this, DadosdeContatoActivity::class.java)
            startActivity(intent)
        }
    }
}