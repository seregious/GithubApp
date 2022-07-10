package com.example.githubtestapp.domain

data class Rep(
    val name: String,
    val description: String,
    val language: String,

    val url: String,
    val forks: Int,
    val stargazers_count: Int,
    val watchers_count: Int,
    val svn_url: String,
    val license: String?
)
