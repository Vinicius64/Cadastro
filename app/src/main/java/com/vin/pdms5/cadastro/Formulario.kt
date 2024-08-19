package com.vin.pdms5.cadastro

data class Formulario (
    val fullName: String,
    val phone: String,
    val mail: String,
    val joinEmailList: Boolean,
    val city: String,
    val uf: String,
    val gender: String
){
    override fun toString(): String {
        return "Nome Completo: $fullName\nTelefone: $phone\nEmail: $mail\nIngressar na lista de emails: $joinEmailList\nCidade: $city\nUF: $uf\nSexo: $gender"
    }
}