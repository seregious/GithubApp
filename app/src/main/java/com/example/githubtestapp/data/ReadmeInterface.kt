package com.example.githubtestapp.data

import com.example.githubtestapp.domain.ReadMe
import retrofit2.http.GET
import retrofit2.http.Path

interface ReadmeInterface {
    @GET("{rep}/readme")
    suspend fun getReadme(@Path("rep") repUrl: String): ReadMe
}