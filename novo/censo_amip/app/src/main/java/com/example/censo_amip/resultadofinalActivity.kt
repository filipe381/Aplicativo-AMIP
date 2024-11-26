package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class resultadofinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultadofinal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvResultado: TextView = findViewById(R.id.tvResultado)
        tvResultado.text = """
            Rua: ${FormData.rua}
            Endereço: ${FormData.endereco}
            Endereço Postal: ${FormData.enderecoPostal}
            Tipo de Moradia: ${FormData.tipoMoradia}
            Área do Terreno: ${FormData.areaTerreno}
            Exclusividade de Moradia: ${FormData.exclusividadeMoradia}
            Abastecimento de Água: ${FormData.abastecimentoAgua}
            Esgoto: ${FormData.esgoto}
            Lixo: ${FormData.lixo}
            Tem Água Encanada: ${FormData.temAguaEncanada}
            Nome do Morador: ${FormData.nomeMorador}
            Parentesco: ${FormData.parentesco}
            Data de Nascimento: ${FormData.dataNascimento}
            Telefone: ${FormData.telefone}
            Quantidade de Pessoas: ${FormData.quantidadePessoas}
            Quantidade de Crianças: ${FormData.quantidadeCriancas}
            Cor: ${FormData.cor}
            Sexo: ${FormData.sexo}
            Registro Civil: ${FormData.registroCivil}
            Tem Criança Abaixo de 5 Anos: ${FormData.temCriancaAbaixoDe5Anos}
            Sabe Ler e Escrever: ${FormData.sabeLerEscrever}
            Rendimento Domiciliar: ${FormData.rendimentoDomiciliar}
            Nome do Contato: ${FormData.nomeContato}
            Email do Contato: ${FormData.emailContato}
            CPF do Contato: ${FormData.cpfContato}
            Telefone do Contato: ${FormData.telefoneContato}
            Prestação de Informações: ${FormData.prestacaoInfo}
            Problemas nas Calçadas: ${FormData.problemasCalcadas.joinToString(", ")}
            Problemas no Canal: ${FormData.problemasCanal.joinToString(", ")}
        """.trimIndent()

        val btnProxima: Button = findViewById(R.id.btnProxima)
        btnProxima.setOnClickListener {
            FormData.clear()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val btnAnterior: Button = findViewById(R.id.btnVoltar)
        btnAnterior.setOnClickListener {
            val intent = Intent(this, ProblemasAreasComActivity::class.java)
            startActivity(intent)
        }
    }
}