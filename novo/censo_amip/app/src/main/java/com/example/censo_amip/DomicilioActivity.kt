package com.example.censo_amip

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DomicilioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_domicilio)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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

        val moradias = listOf("Sim", "Nao")

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

        try {
            val ruasAdapter = ArrayAdapter(this, R.layout.spinner_item, ruas)
            ruasAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
            spinnerRua.adapter = ruasAdapter

            val moradiasAdapter = ArrayAdapter(this, R.layout.spinner_item, moradias)
            moradiasAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
            spinnerMoradia.adapter = moradiasAdapter

            val tipoMoradiasAdapter = ArrayAdapter(this, R.layout.spinner_item, tipoMoradias)
            tipoMoradiasAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
            spinnerTipoMoradia.adapter = tipoMoradiasAdapter
        } catch (e: Exception) {
            Log.e("DomicilioActivity", "Erro ao configurar os Spinners", e)
        }
    }
}
