package com.mahmoudbashir.seenatask.pojo

import com.google.gson.annotations.SerializedName

data class media(
    @SerializedName("type")
    val type:String,
    @SerializedName("subtype")
    val subtype:String,
    @SerializedName("caption")
    val caption:String,
    @SerializedName("copyright")
    val copyright:String,
    @SerializedName("approved_for_syndication")
    val approved_for_syndication:Int,
    @SerializedName("media-metadata")
    val media_metadata:List<media_metadata>
)