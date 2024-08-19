package com.vin.pdms5.cadastro

data class Formulario (
    val fullName: string,
    val phone: string,
    val mail: string,
    val joinEmailList: boolean,
    val city: string,
    val uf: string,
    val gender: string
){
    override fun toString(): string {
        return "Nome Completo: $fullName\nTelefone: $phone\nEmail: $mail\nIngressar na lista de emails: $joinEmailList\nCidade: $city\nUF: $uf\nSexo: $gender"
    }
}