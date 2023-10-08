package com.example.waterinquiry.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponse(
    val message: String
)