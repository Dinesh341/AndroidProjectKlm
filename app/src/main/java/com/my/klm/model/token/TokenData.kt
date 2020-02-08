package com.my.klm.model.token



data class TokenData(

    val access_token: String,
    val token_type: String,
    val expires_in: Int,
    val refresh_token: String
)