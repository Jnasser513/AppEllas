package com.nasser.appellas

import android.app.Application
import com.nasser.appellas.data.AppDatabase
import com.nasser.appellas.network.AppApi
import com.nasser.appellas.repository.AppRepository

class AppApplication: Application() {
    private val database by lazy {
        AppDatabase.getDatabase(this)
    }

    val appRepository by lazy {
        val userDao = database.userDao()
        val blogDao = database.blogDao()
        val contactDao = database.contactDao()
        AppRepository(userDao, blogDao, contactDao, AppApi)
    }
}