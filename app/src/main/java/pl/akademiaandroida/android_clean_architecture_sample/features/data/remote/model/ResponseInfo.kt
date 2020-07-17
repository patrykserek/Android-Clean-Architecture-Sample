package pl.akademiaandroida.android_clean_architecture_sample.features.data.remote.model

import com.google.gson.annotations.SerializedName


data class ResponseInfo(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
)