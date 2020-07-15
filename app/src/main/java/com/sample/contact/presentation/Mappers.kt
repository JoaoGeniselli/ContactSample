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

fun UserProfile.toViewObject() = ProfileVO(
    name.firstWord(),
    phone.formatted()
)