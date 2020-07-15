package com.sample.contact.presentation

// OBJETOS
// Escondem seus detalhes
object ProfileContract {

    interface View {
        fun displayProfile(profileVO: ProfileVO)
        fun showLoading()
        fun hideLoading()
        fun displayError()
    }

    interface Presenter {
        fun init()
        fun onEditProfileClicked()
    }
}