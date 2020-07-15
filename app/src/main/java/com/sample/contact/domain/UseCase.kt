package com.sample.contact.domain

// OBJETO
// Protege seus detalhes
interface UseCase<Out> {
    fun execute(
        onSuccess: (Out) -> Unit,
        onError: () -> Unit
    )
}