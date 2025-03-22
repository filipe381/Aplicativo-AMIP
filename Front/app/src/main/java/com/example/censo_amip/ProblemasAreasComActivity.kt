package com.example.censo_amip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProblemasAreasComActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_problemas_areas_com)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val checkboxSaliencias: CheckBox = findViewById(R.id.checkbox_saliencias)
        val checkboxDepressoes: CheckBox = findViewById(R.id.checkbox_depressoes)
        val checkboxSujeira: CheckBox = findViewById(R.id.checkbox_sujeira)
        val checkboxPostesArvores: CheckBox = findViewById(R.id.checkbox_postes_arvores)
        val checkboxAssoreado: CheckBox = findViewById(R.id.checkbox_assoreado)
        val checkboxBloqueado: CheckBox = findViewById(R.id.checkbox_bloqueado)
        val checkboxPoluido: CheckBox = findViewById(R.id.checkbox_poluid)
        val checkboxInvadindo: CheckBox = findViewById(R.id.checkbox_invadindo)
        val checkboxPostesArvoresCanal: CheckBox = findViewById(R.id.checkbox_postes_arvores_canal)
        val checkboxInsetos: CheckBox = findViewById(R.id.checkbox_insetos)

        // Carregar dados salvos
        FormData.problemasCalcadas.forEach { problema ->
            when (problema) {
                "Saliências ou buracos" -> checkboxSaliencias.isChecked = true
                "Depressões(Alagamentos)" -> checkboxDepressoes.isChecked = true
                "Sujeira e/ou excrementos" -> checkboxSujeira.isChecked = true
                "Postes/árvores velhos(Risco de queda)" -> checkboxPostesArvores.isChecked = true
            }
        }
        FormData.problemasCanal.forEach { problema ->
            when (problema) {
                "Assoreado" -> checkboxAssoreado.isChecked = true
                "Bloqueado por vegetação" -> checkboxBloqueado.isChecked = true
                "Poluído" -> checkboxPoluido.isChecked = true
                "Invadindo/alagando o terreno" -> checkboxInvadindo.isChecked = true
                "Postes/árvores velhos(Risco de queda)" -> checkboxPostesArvoresCanal.isChecked = true
                "Incidências de Insetos" -> checkboxInsetos.isChecked = true
            }
        }

        val btnProxima: Button = findViewById(R.id.btnProxima)
        btnProxima.setOnClickListener {
            FormData.problemasCalcadas.clear()
            if (checkboxSaliencias.isChecked) FormData.problemasCalcadas.add("Saliências ou buracos")
            if (checkboxDepressoes.isChecked) FormData.problemasCalcadas.add("Depressões(Alagamentos)")
            if (checkboxSujeira.isChecked) FormData.problemasCalcadas.add("Sujeira e/ou excrementos")
            if (checkboxPostesArvores.isChecked) FormData.problemasCalcadas.add("Postes/árvores velhos(Risco de queda)")

            FormData.problemasCanal.clear()
            if (checkboxAssoreado.isChecked) FormData.problemasCanal.add("Assoreado")
            if (checkboxBloqueado.isChecked) FormData.problemasCanal.add("Bloqueado por vegetação")
            if (checkboxPoluido.isChecked) FormData.problemasCanal.add("Poluído")
            if (checkboxInvadindo.isChecked) FormData.problemasCanal.add("Invadindo/alagando o terreno")
            if (checkboxPostesArvoresCanal.isChecked) FormData.problemasCanal.add("Postes/árvores velhos(Risco de queda)")
            if (checkboxInsetos.isChecked) FormData.problemasCanal.add("Incidências de Insetos")

            val intent = Intent(this, resultadofinalActivity::class.java)
            startActivity(intent)
        }

        val btnAnterior: Button = findViewById(R.id.btnVoltar)
        btnAnterior.setOnClickListener {
            val intent = Intent(this, PrestacoesInfoActivity::class.java)
            startActivity(intent)
        }
    }
}