package com.sample.contact.data.source

// OBJETO
// Mesmo sem implementar uma interface, ele esconde sua estratégia
class ProfileRepository(
    private val restClient: RestClient
) {
    fun request(
        onSuccess: (UserProfileResponse) -> Unit,
        onError: () -> Unit
    ) {
        restClient.requestUserProfile { httpStatus, response ->
            if (200 == httpStatus && response != null) {
                onSuccess(response)
            } else {
                onError()
            }
        }
    }
}