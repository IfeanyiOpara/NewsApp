package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //the function is called upsert because it does the job of inserting and updating with the help of OnConflictStrategy
    // which checks if what is being inserted into the database already exists, then it replaces it.
    //These are suspend functions because they are going to be called in coroutines, which is as well a suspend function
    //and as far as we know, suspend functions can only be called in suspend functions
    suspend fun upsert(article: Article): Long // it returns long because it is going to return the id that was added

    @Query("SELECT * FROM articles")
    //the reason it wont be a suspend function is because it is going to return a live data object which doesn't work with suspend functions
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}