package com.example.censo_amip

object FormData {
    var rua: String? = null
    var endereco: String? = null
    var enderecoPostal: String? = null
    var tipoMoradia: String? = null
    var areaTerreno: String? = null
    var exclusividadeMoradia: String? = null
    var abastecimentoAgua: String? = null
    var esgoto: String? = null
    var lixo: String? = null
    var temAguaEncanada: String? = null
    var nomeMorador: String? = null
    var parentesco: String? = null
    var dataNascimento: String? = null
    var telefone: String? = null
    var quantidadePessoas: String? = null
    var quantidadeCriancas: String? = null
    var cor: String? = null
    var sexo: String? = null
    var registroCivil: String? = null
    var temCriancaAbaixoDe5Anos: String? = null
    var sabeLerEscrever: String? = null
    var rendimentoDomiciliar: String? = null
    var nomeContato: String? = null
    var emailContato: String? = null
    var cpfContato: String? = null
    var telefoneContato: String? = null
    var prestacaoInfo: String? = null
    var problemasCalcadas: MutableList<String> = mutableListOf()
    var problemasCanal: MutableList<String> = mutableListOf()

    fun clear() {
        rua = null
        endereco = null
        enderecoPostal = null
        tipoMoradia = null
        areaTerreno = null
        exclusividadeMoradia = null
        abastecimentoAgua = null
        esgoto = null
        lixo = null
        temAguaEncanada = null
        nomeMorador = null
        parentesco = null
        dataNascimento = null
        telefone = null
        quantidadePessoas = null
        quantidadeCriancas = null
        cor = null
        sexo = null
        registroCivil = null
        temCriancaAbaixoDe5Anos = null
        sabeLerEscrever = null
        rendimentoDomiciliar = null
        nomeContato = null
        emailContato = null
        cpfContato = null
        telefoneContato = null
        prestacaoInfo = null
        problemasCalcadas.clear()
        problemasCanal.clear()
    }
}