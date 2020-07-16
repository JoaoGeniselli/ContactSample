package com.sample.contact.presentation

import com.sample.contact.common.firstWord
import com.sample.contact.data.source.UserProfileResponse
import com.sample.contact.domain.Phone
import com.sample.contact.domain.UserProfile

fun UserProfileResponse.toProfile(): UserProfile? {
    return if(isValid()) {
        UserProfile(
            this.id,
            this.name!!,
            Phone(this.phone!!)
        )
    } else {
        null
    }
}

fun UserProfileResponse.isValid(): Boolean {
    val idIsOk = id != 0L
    val nameIsOk = !name.isNullOrEmpty()
    val phoneIsOk = phone.orEmpty().length == 11 && phone?.toLongOrNull() != null
    return idIsOk && nameIsOk && phoneIsOk
}

fun UserProfile.toViewObject() = ProfileVO(
    name.firstWord(),
    phone.formatted()
)