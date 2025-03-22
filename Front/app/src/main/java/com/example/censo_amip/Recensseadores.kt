package com.example.censo_amip

class Recenseadores(val id: Int = 0, val email: String = "", val senha: String = "") {

    companion object {
        // Lista para armazenar os recenseadores
        val recenseadoresList = mutableListOf<Recenseadores>()
    }

    fun verificarRecenseador(email: String, senha: String): Boolean {
        return recenseadoresList.any { it.email == email && it.senha == senha }
    }
}
