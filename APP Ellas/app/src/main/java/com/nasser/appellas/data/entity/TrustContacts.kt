package com.nasser.appellas.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table",
        foreignKeys = [ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("username"),
            childColumns = arrayOf("user_name")
        )])
data class TrustContacts(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var number: Int,
    var user_name: String?
)
