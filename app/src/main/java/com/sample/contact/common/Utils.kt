package com.sample.contact.common

fun String.firstWord() = split(" ").takeIf { it.size > 1 }?.first() ?: this