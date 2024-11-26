package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DadosdeContatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dadosde_contato)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNome: EditText = findViewById(R.id.et_nome)
        val etEmail: EditText = findViewById(R.id.et_email)
        val etCPF: EditText = findViewById(R.id.et_CPF)
        val etTelefone: EditText = findViewById(R.id.et_phone)

        // Carregar dados salvos
        FormData.nomeContato?.let { etNome.setText(it) }
        FormData.emailContato?.let { etEmail.setText(it) }
        FormData.cpfContato?.let { etCPF.setText(it) }
        FormData.telefoneContato?.let { etTelefone.setText(it) }

        val btnProxima: Button = findViewById(R.id.btnProxima)
        btnProxima.setOnClickListener {
            FormData.nomeContato = etNome.text.toString()
            FormData.emailContato = etEmail.text.toString()
            FormData.cpfContato = etCPF.text.toString()
            FormData.telefoneContato = etTelefone.text.toString()

            val intent = Intent(this, PrestacoesInfoActivity::class.java)
            startActivity(intent)
        }

        val btnAnterior: Button = findViewById(R.id.btnVoltar)
        btnAnterior.setOnClickListener {
            val intent = Intent(this, RendimentosActivity::class.java)
            startActivity(intent)
        }
    }
}