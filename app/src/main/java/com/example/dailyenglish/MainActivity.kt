package com.example.dailyenglish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.dailyenglish.Models.Database
import com.example.dailyenglish.Models.Word
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cardViewWordDay = findViewById<CardView>(R.id.cardViewWordDay)

        cardViewWordDay.setOnClickListener {
            startActivity(Intent(this, WordDay::class.java))
        }

     // Database.write()
    }
}