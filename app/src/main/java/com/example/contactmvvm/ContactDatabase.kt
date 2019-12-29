package com.example.contactmvvm

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = [ContactEntity::class], version = 1, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun getContactDao():ContactDao


    private class PopulateDbAsyncTask(db: ContactDatabase?) : AsyncTask<Void?, Void?, Void?>(){

        private val contactDao = db!!.getContactDao()
        override fun doInBackground(vararg p0: Void?): Void? {
            contactDao.insert(ContactEntity("Darot", "Tosin", "M", "Atlantic View", "08060085192", R.drawable.maleavatar))
            contactDao.insert(ContactEntity("Tola", "Folawo", "M", "Atlantic View", "08060085192", R.drawable.femaleavatar))
            contactDao.insert(ContactEntity("Aisha", "Monday", "M", "Atlantic View", "08060085192", R.drawable.femaleavatar))
            contactDao.insert(ContactEntity("Peacedude", "LoveAce", "M", "Atlantic View", "08060085192", R.drawable.femaleavatar))
            return null
        }

    }


    companion object{
        private var instance: ContactDatabase? = null
        @kotlin.jvm.Synchronized
        fun getInstance(context: Context): ContactDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java, "contact_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()
            }
            return instance
        }

        private val roomCallback = object: Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance).execute()

            }

        }



    }




}

