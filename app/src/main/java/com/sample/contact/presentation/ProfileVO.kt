package com.sample.contact.presentation

import java.io.Serializable

// ESTRUTURA DE DADOS
// Simples, com dados já formatados e pronta para injetada e configurada em Activities/Fragments.
data class ProfileVO(
    val firstName: String,
    val formattedPhoneNumber: String
) : Serializable