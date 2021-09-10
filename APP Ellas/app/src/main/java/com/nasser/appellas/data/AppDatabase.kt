package com.nasser.appellas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nasser.appellas.data.dao.BlogDao
import com.nasser.appellas.data.dao.ContactDao
import com.nasser.appellas.data.dao.UserDao
import com.nasser.appellas.data.entity.Blog
import com.nasser.appellas.data.entity.TrustContacts
import com.nasser.appellas.data.entity.User

@Database(version = 1, entities = [User::class, Blog::class, TrustContacts::class])
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun blogDao(): BlogDao
    abstract fun contactDao(): ContactDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) = INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "appellas_db"
            ).build()

            INSTANCE = instance
            instance
        }
    }

}