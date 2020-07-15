package com.sample.contact.di

import com.sample.contact.data.source.ProfileRepository
import com.sample.contact.data.source.RestClient
import com.sample.contact.domain.UseCase
import com.sample.contact.presentation.ProfileContract
import com.sample.contact.domain.GetProfileUseCase
import com.sample.contact.presentation.ProfilePresenter
import com.sample.contact.domain.UserProfile

// Objeto simulador de uma injeção de dependências simples, para fins de exemplo
object DependencyInjection {

    fun presenter(view: ProfileContract.View): ProfileContract.Presenter =
        ProfilePresenter(
            view,
            useCase()
        )

    private fun useCase(): UseCase<UserProfile> = GetProfileUseCase(repository())

    private fun repository() = ProfileRepository(RestClient)
}