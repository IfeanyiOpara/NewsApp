package com.androiddevs.mvvmnewsapp.db

import androidx.room.TypeConverter
import com.androiddevs.mvvmnewsapp.models.Source


class Converters {

    //to tell room that this is a converter function, we must use the annotation below
    @TypeConverter
    //this function converts from source to string
    fun fromSource(source: Source) : String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String) : Source {
        return Source(name,name)
    }

}