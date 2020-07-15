package com.sample.contact.domain

import android.telephony.PhoneNumberUtils
import java.util.*

// ESTRUTURA DE DADO, com certo comportamento
class Phone(
    private val rawPhone: String
) {
    fun formatted(): String = PhoneNumberUtils.formatNumber(
        rawPhone,
        Locale.getDefault().country
    )
}