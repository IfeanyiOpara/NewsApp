package com.androiddevs.mvvmnewsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,

    //Room can only handle basic primitive data types such as string, Int and all of that but cant
    // handle our own custom data type like "Source" declared below. Therefore we need to create a
    //type converter to tell Room how to interprete the source class and convert it to a primitive
    //type like string for example
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable