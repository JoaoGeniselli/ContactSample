package com.sample.contact.domain

import com.sample.contact.data.source.ProfileRepository
import com.sample.contact.data.source.UserProfileResponse
import com.sample.contact.domain.UseCase
import com.sample.contact.domain.UserProfile
import com.sample.contact.presentation.toProfile

// OBJETO
// Protege seus detalhes e expõe somente seu comportamento
class GetProfileUseCase(
    private val repository: ProfileRepository
) : UseCase<UserProfile> {

    override fun execute(onSuccess: (UserProfile) -> Unit, onError: () -> Unit) {
        repository.request(
            onSuccess = { response ->
                // Conversão entre limites: Camada de comunicação para camada de domínio
                response.toProfile()?.let(onSuccess) ?: onError()
            },
            onError = onError
        )
    }
}