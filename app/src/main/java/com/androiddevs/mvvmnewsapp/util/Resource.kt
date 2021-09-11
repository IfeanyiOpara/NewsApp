package com.androiddevs.mvvmnewsapp.util

//this is a wrapper class for our network requests that is recommended by google which is used to differentiate
// between success and failure. And also it can handle the loading state

//a sealed class is  like an abstract class but it gives us the ability to determine which class can inherit from it
sealed class Resource<T>(
    //the body
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()

}