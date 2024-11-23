package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioGroup
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

        val opcaoRadioGroup: RadioGroup = findViewById(R.id.opcao)
        val opcao = when (opcaoRadioGroup.checkedRadioButtonId){
            R.id.sim -> "Sim"
            R.id.nao -> "Não"
            else -> "Indefinido"
        }

        val spinneresgoto: Spinner = findViewById(R.id.spinneresgoto)
        val esgotos = listOf(
            "Para onde o esgoto vai: ",
            "Rede geral",
            "Fossa",
            "Vala",
            "Rios, açudes, lagos, córregos",
            "Outro forma"
        )

        val esgotosAdapter = ArrayAdapter(this, R.layout.spinner_item, esgotos)
        esgotosAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinneresgoto.adapter = esgotosAdapter

        val spinnerlixo: Spinner = findViewById(R.id.spinnerlixo)
        val tiposlixo = listOf(
            "O lixo desse domicilio é: ",
            "Coleta em domicílio",
            "Caçamba",
            "Queimado em propriedade",
            "Jogando em terreno baldio",
            "Outro Forma"
        )

        val tiposLixoAdapter = ArrayAdapter(this, R.layout.spinner_item, tiposlixo)
        tiposLixoAdapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerlixo.adapter = tiposLixoAdapter

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