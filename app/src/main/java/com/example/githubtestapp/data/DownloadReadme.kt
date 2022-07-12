package com.example.githubtestapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DownloadReadme {
    private var retrofit = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var getReadme: ReadmeInterface = retrofit.create(ReadmeInterface::class.java)
}