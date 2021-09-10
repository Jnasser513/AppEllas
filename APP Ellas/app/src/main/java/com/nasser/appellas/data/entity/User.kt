package com.nasser.appellas.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey var username: String,
    var email: String,
    var password: String,
    var confirmPassword: String,
    var type: Boolean
)