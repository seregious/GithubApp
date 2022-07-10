package com.example.githubtestapp.data

import com.example.githubtestapp.domain.Rep
import retrofit2.http.GET

interface RepInterface {
    @GET("repos?sort=created")
    suspend fun getReps(): ArrayList<Rep>
}