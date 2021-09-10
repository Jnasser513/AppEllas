package com.nasser.appellas.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "blog_table",
        foreignKeys = [ForeignKey(
            entity = User::class,
            parentColumns = arrayOf("username"),
            childColumns = arrayOf("user_name"),
            onDelete = ForeignKey.CASCADE
        )]
)
data class Blog(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var title: String,
    var subtitle: String,
    var description: String,
    var user_name: String
)