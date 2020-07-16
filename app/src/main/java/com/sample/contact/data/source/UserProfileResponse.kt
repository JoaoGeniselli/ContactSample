package com.sample.contact.data.source

// ESTRUTURA DE DADOS
// Vinda de uma fonte externa, como por exemplo, um endpoint, sem garantia da validade dos dados
data class UserProfileResponse(
    val id: Long,
    val name: String?,
    val phone: String?
)