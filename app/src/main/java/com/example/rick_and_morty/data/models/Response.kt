package com.example.rick_and_morty.data.models

import android.icu.text.IDNA
import com.google.gson.annotations.SerializedName

data class PagedResponse<T>(
    @SerializedName("info")
    val info: IDNA.Info,
    val results: List<T> = listOf()
)