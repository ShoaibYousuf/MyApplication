package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class DataClass(
    @SerializedName("quotes" ) var quotes : ArrayList<Quotes> = arrayListOf(),
    @SerializedName("total"  ) var total  : Int?              = null,
    @SerializedName("skip"   ) var skip   : Int?              = null,
    @SerializedName("limit"  ) var limit  : Int?              = null
)

data class Quotes (

    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("quote"  ) var quote  : String? = null,
    @SerializedName("author" ) var author : String? = null

)


