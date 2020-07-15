package com.sample.contact.domain

import com.sample.contact.domain.Phone

// ESTRUTURA DE DADOS
// Imutável e com todos os dados válidos, sem opcionais, dispensa tratativas no domínio
class UserProfile(
    val id: Long,
    val name: String,
    val phone: Phone
)