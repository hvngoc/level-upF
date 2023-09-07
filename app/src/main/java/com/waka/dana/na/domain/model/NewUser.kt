package com.waka.dana.na.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by hvngoc on 8/14/23
 */
data class NewUser(
    @SerializedName("referralId")
    val referralId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("numPrice")
    val numPrice: String?,
    @SerializedName("numSell")
    val numSell: String?,
)