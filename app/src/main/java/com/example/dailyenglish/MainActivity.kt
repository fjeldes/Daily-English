package com.example.dailyenglish

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.dailyenglish.Models.Database
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cardViewWordDay = findViewById<CardView>(R.id.cardViewWordDay)

        cardViewWordDay.setOnClickListener {
            startActivity(Intent(this, WordDay::class.java))
        }
        val fileInString: String =
            applicationContext.assets.open("word_example.json").bufferedReader().use { it.readText() }

        val resp: JsonObject = JsonParser().parse(fileInString).asJsonObject
        val jsonObject = JsonObject()
        jsonObject.add("data", resp)


        val objects = JSONObject(fileInString)
        val key = objects.names()
        for (i in 0 until key.length()) {
            val key = key.getString(i)
            val value = objects.getString(key)
            println("crespo:$key")
            println("polaco:$value")
            Database.write(key,value)
        }
    }
}