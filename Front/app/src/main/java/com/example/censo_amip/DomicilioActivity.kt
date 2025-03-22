package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class DomicilioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_domicilio)

        val spinnerRua: Spinner = findViewById(R.id.spinnerRua)
        val spinnerMoradia: Spinner = findViewById(R.id.spinnerMoradia)
        val spinnerTipoMoradia: Spinner = findViewById(R.id.spinnerTipoMoradia)
        val etEndereco: EditText = findViewById(R.id.et_endereco)
        val etEnderecoPostal: EditText = findViewById(R.id.et_enderecoPostal)
        val etAreaTerreno: EditText = findViewById(R.id.et_areaTerreno)
        val btnProxima: Button = findViewById(R.id.btnProxima)

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

        // Carregar dados salvos
        FormData.rua?.let { rua ->
            val position = ruasadapter.getPosition(rua)
            spinnerRua.setSelection(position)
        }
        FormData.exclusividadeMoradia?.let { moradia ->
            val position = moradiasadapter.getPosition(moradia)
            spinnerMoradia.setSelection(position)
        }
        FormData.tipoMoradia?.let { tipoMoradia ->
            val position = tipoMoradiaadapter.getPosition(tipoMoradia)
            spinnerTipoMoradia.setSelection(position)
        }
        etEndereco.setText(FormData.endereco)
        etEnderecoPostal.setText(FormData.enderecoPostal)
        etAreaTerreno.setText(FormData.areaTerreno)

        btnProxima.setOnClickListener {
            FormData.rua = spinnerRua.selectedItem.toString()
            FormData.exclusividadeMoradia = spinnerMoradia.selectedItem.toString()
            FormData.tipoMoradia = spinnerTipoMoradia.selectedItem.toString()
            FormData.areaTerreno = etAreaTerreno.text.toString()
            FormData.enderecoPostal = etEnderecoPostal.text.toString()
            FormData.endereco = etEndereco.text.toString()

            val intent = Intent(this, CaracteristicasDomActivity::class.java)
            startActivity(intent)
        }
        val btnAnterior: Button = findViewById(R.id.btnVoltar)
        btnAnterior.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}