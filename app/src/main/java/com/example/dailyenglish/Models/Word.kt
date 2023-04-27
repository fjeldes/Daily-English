package com.example.dailyenglish.Models

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId


class Word: RealmObject {
    var word: String = ""
    var example: String = ""
}

object Database {
    val config = RealmConfiguration.Builder(
        schema = setOf(Word::class) // Pass the defined class as the object schema
    )
        .build()
    val realm = Realm.open(config)

    fun write(){
        val word = Word().apply {
            word = "Dog"
            example = "Pet"
        }

        val manageWord = realm.writeBlocking { copyToRealm(word) }
    }

    suspend  fun writeAsync(){
        val word = Word().apply {
            word = "Dog"
            example = "Pet"
        }

       realm.write { copyToRealm(word) }
    }

    fun query ():RealmResults<Word> {
        val all: RealmResults<Word> = realm.query<Word>().find()

        return all
    }
}