package com.example.ola_mundo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ola_mundo.R
import com.example.ola_mundo.R.*

class InicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_inicial)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button = findViewById<Button>(id.bt_recenseador)
        val button2 = findViewById<Button>(id.bt_administrador)

        button.setOnClickListener {
            val intent = Intent(this, LoginRecenseadorActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, InicialAdministradorActivity::class.java)
            startActivity(intent)
        }
    }
}