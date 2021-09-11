package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import androidx.room.*
import com.androiddevs.mvvmnewsapp.models.Article
import com.androiddevs.mvvmnewsapp.util.Constants.Companion.DATABASE_VERSION

@Database(
    entities = [Article::class],
    version = DATABASE_VERSION
)
@TypeConverters(Converters::class) // this is telling the database that we are adding typeconverters to it
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object{
        @Volatile
        //recreate an instance of the database which is a singleton
        private var instance: ArticleDatabase? = null // the "?" means it can accept null values
        private val LOCK = Any()

        //whenever the instance of the article database class is created, we return the instance using the invoke function below.
        //but if it is null, we would set the instance in the synchronized block below and create the database in the "createDatabase" function below
        // the function of the "instance = it" is to set the non-null instance retrieved from the create database to the current instance
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}