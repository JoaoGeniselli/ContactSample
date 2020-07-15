package com.sample.contact.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.sample.contact.R
import kotlinx.android.synthetic.main.fragment_profile.*

// OBJETO
// Esconde seu comportamento
class ProfileFragment : Fragment() {

    private val profile: ProfileVO? by lazy { arguments?.get(KEY_PROFILE) as? ProfileVO }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyProfileIntoView()
    }

    private fun applyProfileIntoView() {
        // Manuseia as propriedades de uma estrutura de dados.
        profile?.run {
            text_name.text = firstName
            text_phone.text = formattedPhoneNumber
        }
    }

    companion object {
        private const val KEY_PROFILE = "profile"

        fun create(profileVO: ProfileVO): ProfileFragment {
            val fragment = ProfileFragment()
            fragment.arguments = bundleOf(
                KEY_PROFILE to profileVO
            )
            return fragment
        }
    }
}