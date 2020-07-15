package com.sample.contact.data.source

// ESTRUTURA DE DADOS
// Vinda de uma fonte externa, como por exemplo, um endpoint, sem garantia da validade dos dados
data class UserProfileResponse(
    val id: Long,
    val name: String?,
    val phone: String?
) {
    fun isValid(): Boolean {
        val idIsOk = id != 0L
        val nameIsOk = !name.isNullOrEmpty()
        val phoneIsOk = phone.orEmpty().length == 11 && phone?.toLongOrNull() != null
        return idIsOk && nameIsOk && phoneIsOk
    }
}