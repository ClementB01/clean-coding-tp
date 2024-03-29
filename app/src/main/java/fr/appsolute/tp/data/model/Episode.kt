package fr.appsolute.tp.data.model

import com.google.gson.annotations.SerializedName

data class Episode (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val air_date: String,
    @SerializedName("episode") val episode: String,
    @SerializedName("character") val character: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)