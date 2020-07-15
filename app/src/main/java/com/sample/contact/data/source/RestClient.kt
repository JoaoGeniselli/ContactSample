package com.sample.contact.data.source

import android.os.Handler

// Esta classe existe por fins de exemplificação, ela age como um substituto mockado ao retrofit, por exemplo
object RestClient {

    fun requestUserProfile(callback: (Int, UserProfileResponse?) -> Unit) {
        simulateAsyncBehavior {
            val validResponse =
                UserProfileResponse(
                    id = 50,
                    name = "Johnny B. Goode",
                    phone = "19999998888"
                )
            callback(200, validResponse)
        }
    }

    private fun simulateAsyncBehavior(block: () -> Unit) {
        Handler().postDelayed(block, 2000)
    }
}