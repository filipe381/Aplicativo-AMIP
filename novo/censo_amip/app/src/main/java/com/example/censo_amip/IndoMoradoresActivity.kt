package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class IndoMoradoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_indo_moradores)

        val spinnercor: Spinner = findViewById(R.id.spinnercor)
        val spinnersexo: Spinner = findViewById(R.id.spinnersexo)
        val etNomeMorador: EditText = findViewById(R.id.nomemorador)
        val etParentesco: EditText = findViewById(R.id.parentesco)
        val etDataNascimento: EditText = findViewById(R.id.datanascimento)
        val etTelefone: EditText = findViewById(R.id.telefone)
        val etQuantidadePessoas: EditText = findViewById(R.id.quantidadepessoas)
        val etQuantidadeCriancas: EditText = findViewById(R.id.quantascriancas)

        val cor = listOf(
            "Cor/Raça",
            "Branco(a)",
            "Pardo(a)",
            "Amarelo(a)",
            "Preto(a)",
            "Indigena"
        )

        val sexo = listOf(
            "Sexo: ",
            "Masculino",
            "Feminino"
        )

        val corAdapter = ArrayAdapter(this, R.layout.spinner_item, cor)
        corAdapter.setDropDownViewResource(R.layout.spinner_item)
        val sexoAdapter = ArrayAdapter(this, R.layout.spinner_item, sexo)
        sexoAdapter.setDropDownViewResource(R.layout.spinner_item)

        spinnercor.adapter = corAdapter
        spinnersexo.adapter = sexoAdapter

        // Carregar dados salvos
        FormData.nomeMorador?.let { etNomeMorador.setText(it) }
        FormData.parentesco?.let { etParentesco.setText(it) }
        FormData.dataNascimento?.let { etDataNascimento.setText(it) }
        FormData.telefone?.let { etTelefone.setText(it) }
        FormData.quantidadePessoas?.let { etQuantidadePessoas.setText(it) }
        FormData.quantidadeCriancas?.let { etQuantidadeCriancas.setText(it) }
        FormData.cor?.let { cor ->
            val position = corAdapter.getPosition(cor)
            spinnercor.setSelection(position)
        }
        FormData.sexo?.let { sexo ->
            val position = sexoAdapter.getPosition(sexo)
            spinnersexo.setSelection(position)
        }

        val btnProxima: Button = findViewById(R.id.btnProxima)
        btnProxima.setOnClickListener {
            FormData.nomeMorador = etNomeMorador.text.toString()
            FormData.parentesco = etParentesco.text.toString()
            FormData.dataNascimento = etDataNascimento.text.toString()
            FormData.telefone = etTelefone.text.toString()
            FormData.quantidadePessoas = etQuantidadePessoas.text.toString()
            FormData.quantidadeCriancas = etQuantidadeCriancas.text.toString()
            FormData.cor = spinnercor.selectedItem.toString()
            FormData.sexo = spinnersexo.selectedItem.toString()

            val intent = Intent(this, RegistroCivilActivity::class.java)
            startActivity(intent)
        }

        val btnAnterior: Button = findViewById(R.id.btnVoltar)
        btnAnterior.setOnClickListener {
            val intent = Intent(this, CaracteristicasDomActivity::class.java)
            startActivity(intent)
        }
    }
}