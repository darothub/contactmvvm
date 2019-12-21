package com.example.contactmvvm

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "contacts_table")
class ContactEntity(
    val firstName:String,
    val lastName:String,
    val sex: String,
    val address:String,
    val phone:String,
    val image:Int
    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}