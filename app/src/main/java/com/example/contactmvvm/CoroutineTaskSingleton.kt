package com.example.contactmvvm

import android.app.Application
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoroutineTaskSingleton (application: Application) {

    companion object {
        @Volatile
        private var INSTANCE: CoroutineTaskSingleton? = null
        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: CoroutineTaskSingleton(application).also {
                    INSTANCE = it
                }
            }
    }

    fun InsertTask(contactDao:ContactDao, contacts: ContactEntity){

        CoroutineScope(Dispatchers.IO).launch {
            contactDao.insert(contacts)
        }

    }
}