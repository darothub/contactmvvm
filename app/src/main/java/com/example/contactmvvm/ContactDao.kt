package com.example.contactmvvm

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {
    @Insert
    fun insert(note: ContactEntity?)

    @Update
    fun update(note: ContactEntity?)

    @Delete
    fun delete(note: ContactEntity?)

    @Query("DELETE FROM contacts_table")
    fun deleteAllContacts()

    @get:Query(
        "SELECT * FROM contacts_table"
    )
    val allContacts: LiveData<List<ContactEntity?>?>?
}