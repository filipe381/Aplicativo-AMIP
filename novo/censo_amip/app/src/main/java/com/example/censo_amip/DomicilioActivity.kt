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
            "Selecione uma rua",
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
            "Exclusivamente moradia?",
            "Sim",
            "Nao"
        )

        val tipoMoradias = listOf(
            "Selecione o tipo de moradia",
            "Casa própria",
            "Casa alugada",
            "Casa cedida",
            "Apartamento próprio",
            "Apartamento alugado",
            "Apartamento cedido",
            "Barraco",
            "Chácara/Sítio"
        )

        val ruasadapter = ArrayAdapter(this, R.layout.spinner_item, ruas)
        ruasadapter.setDropDownViewResource(R.layout.spinner_item)
        val moradiasadapter = ArrayAdapter(this, R.layout.spinner_item, moradias)
        moradiasadapter.setDropDownViewResource(R.layout.spinner_item)
        val tipoMoradiaadapter = ArrayAdapter(this, R.layout.spinner_item, tipoMoradias)
        tipoMoradiaadapter.setDropDownViewResource(R.layout.spinner_item)

        spinnerRua.adapter = ruasadapter
        spinnerMoradia.adapter = moradiasadapter
        spinnerTipoMoradia.adapter = tipoMoradiaadapter




    }
    }
