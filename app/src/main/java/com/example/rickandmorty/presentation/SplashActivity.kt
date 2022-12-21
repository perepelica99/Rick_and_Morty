package com.example.rickandmorty.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.ExperimentalPagingApi


@ExperimentalPagingApi
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, RootActivity::class.java)
        startActivity(intent)
        finish()
    }
}