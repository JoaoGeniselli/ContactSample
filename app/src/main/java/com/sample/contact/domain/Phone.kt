package com.sample.contact.domain

import android.telephony.PhoneNumberUtils
import java.util.*

// OBJETO, representando um número de telefone
class Phone(
    private val rawPhone: String
) {
    fun formatted(): String = PhoneNumberUtils.formatNumber(
        rawPhone,
        Locale.getDefault().country
    )
}