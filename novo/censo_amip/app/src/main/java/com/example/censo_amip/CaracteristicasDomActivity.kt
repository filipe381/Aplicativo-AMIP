package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CaracteristicasDomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_caracteristicas_dom)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinnerAbastecimentoAgua: Spinner = findViewById(R.id.spinneabastecimentoAgua)
        val abastecimentoAgua = listOf(
            "Forma de abastecimento de água",
            "Água encanada",
            "Poço",
            "Reutilização",
            "Água da chuva(Armazenada)",
            "Rios, lagos, açudes",
        )
        val abastecimentoAguaAdapter = ArrayAdapter(this, R.layout.spinner_item, abastecimentoAgua)
        abastecimentoAguaAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerAbastecimentoAgua.adapter = abastecimentoAguaAdapter

        // Carregar dados salvos
        FormData.abastecimentoAgua?.let { agua ->
            val position = abastecimentoAguaAdapter.getPosition(agua)
            spinnerAbastecimentoAgua.setSelection(position)
        }
        val btnAnterior: Button = findViewById(R.id.btnVoltarcaracteristicasDom)
        btnAnterior.setOnClickListener {
            FormData.abastecimentoAgua = spinnerAbastecimentoAgua.selectedItem.toString()

            val intent = Intent(this, DomicilioActivity::class.java)
            startActivity(intent)
        }


        val btnProxima: Button = findViewById(R.id.btnProximacaracteristicasDom)
        btnProxima.setOnClickListener {
            FormData.abastecimentoAgua = spinnerAbastecimentoAgua.selectedItem.toString()
            // Adicionar outros campos conforme necessário

            /*val intent = Intent(this, ProximaActivity::class.java)
            startActivity(intent)*/
        }
    }
}