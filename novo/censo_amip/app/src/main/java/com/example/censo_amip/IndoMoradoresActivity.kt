package com.example.censo_amip

import android.os.Bundle
import android.widget.ArrayAdapter
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

        val parentesco = etParentesco.text.toString()
        val nomeMorador = etNomeMorador.text.toString()
        val dataNascimento = etDataNascimento.text.toString()
        val telefone = etTelefone.text.toString()
        val quantidadePessoa = etQuantidadePessoas.text.toString()
        val quantidadeCriancas = etQuantidadeCriancas.text.toString()


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



    }
}