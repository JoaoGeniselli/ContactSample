package com.sample.contact.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.sample.contact.R
import com.sample.contact.di.DependencyInjection
import kotlinx.android.synthetic.main.activity_main.*

// OBJETO
// Somente expõe seu comportamento através da interface pai
class MainActivity : FragmentActivity(), ProfileContract.View {

    private val presenter: ProfileContract.Presenter = DependencyInjection.presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.init()
    }

    override fun displayProfile(profileVO: ProfileVO) {
        replaceFragment(
            fragment = ProfileFragment.create(profileVO),
            tag = "ProfileFragment"
        )
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }

    private fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, fragment, tag)
            .commit()
    }

    override fun displayError() =
        Toast.makeText(this, R.string.profile_error, Toast.LENGTH_LONG).show()

}
