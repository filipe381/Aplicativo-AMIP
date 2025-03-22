package com.example.censo_amip

import com.example.censo_amip.Recenseadores.Companion.recenseadoresList

class Administrador {
    val id: Int = 0;
    val email: String = "";
    val senha: String = "";

    fun adicionarRecenseador(email: String, senha: String): Recenseadores {
        val novoId = if (recenseadoresList.isNotEmpty()) {
            recenseadoresList.maxOf { it.id } + 1 // Gera um novo ID baseado no maior ID atual
        } else {
            1 // Começa com ID 1 se a lista estiver vazia
        }
        val novoRecenseador = Recenseadores(novoId, email, senha)
        recenseadoresList.add(novoRecenseador)
        return novoRecenseador
    }
}