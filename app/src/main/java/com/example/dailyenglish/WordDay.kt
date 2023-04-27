package com.example.dailyenglish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dailyenglish.Models.Database

class WordDay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_day)

       val e  = Database.query()
       println(e.size)
        println("temblor")
        for (item in e) println(item.word)

    }
}