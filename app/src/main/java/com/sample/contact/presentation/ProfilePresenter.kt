package com.sample.contact.presentation

import com.sample.contact.domain.UseCase
import com.sample.contact.domain.UserProfile

// OBJETO
// Protege suas propriedades e estratégias, mesmo se não implementasse sua interface pai.
class ProfilePresenter(
    private val view: ProfileContract.View,
    private val profileUseCase: UseCase<UserProfile>
) : ProfileContract.Presenter {

    override fun init() {
        view.showLoading()
        profileUseCase.execute(
            onSuccess = { profile ->
                // Conversão entre limites: Camada de domínio para camada de apresentação
                // "Data Transfer Objects"
                val viewObject = profile.toViewObject()
                view.hideLoading()
                view.displayProfile(viewObject)
            },
            onError = {
                view.hideLoading()
                view.displayError()
            }
        )
    }

    override fun onEditProfileClicked() {
        // ...
    }
}