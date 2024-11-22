package com.example.censo_amip

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner

class DomicilioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_domicilio)

        val spinnerRua: Spinner = findViewById(R.id.spinnerRua)
        val spinnerMoradia: Spinner = findViewById(R.id.spinnerMoradia)
        val spinnerTipoMoradia: Spinner = findViewById(R.id.spinnerTipoMoradia)

        val ruas = listOf(
            "Marina das Estrelas",
            "Marina das Flores",
            "Marina dos Bosques",
            "Marina Porto Bali",
            "Marina das Hortênsias",
            "Marina Ponta Leste",
            "Marina da Lua",
            "Marina do Frade",
            "Marina do Sol",
            "Marina dos Coqueiros",
            "Canalzinho"
        )

        val moradias = listOf(
            "Sim",
            "Nao"
        )

        val tipoMoradias = listOf(
            "Casa própria",
            "Casa alugada",
            "Casa cedida",
            "Apartamento próprio",
            "Apartamento alugado",
            "Apartamento cedido",
            "Barraco",
            "Chácara/Sítio"

        )

        val ruasadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ruas)
        ruasadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val moradiasadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, moradias)
        moradiasadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val tipoMoradiaadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipoMoradias)
        tipoMoradiaadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerMoradia.adapter = ruasadapter
        spinnerRua.adapter = moradiasadapter
        spinnerTipoMoradia.adapter = tipoMoradiaadapter




    }
    }
