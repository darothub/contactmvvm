package com.example.contactmvvm

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ContactRepository(application: Application) {




    fun insert(contactEntity: ContactEntity?, application: Application){
//        InsertContactAsyncTask(contactDao).execute
//        CoroutineTask(contactDao).runInBackground(contactEntity!!)
//        CoroutineTask2(contactDao, contactEntity!!)
        CoroutineTaskSingleton.getInstance(application).InsertTask(contactDao, contactEntity!!)
    }

    fun update(contactEntity: ContactEntity?){
        UpdateContactAsyncTask(contactDao).execute(contactEntity)
    }

    fun delete(contactEntity: ContactEntity?){
        DeleteContactAsyncTask(contactDao).execute(contactEntity)
    }

    fun deleteAllContacts(){
        DeleteAllContactAsyncTask(contactDao).execute()
    }

//    fun getAllContact():LiveData<List<ContactEntity>>{
//        return allContacts
//    }

    private class CoroutineTask(val contactDao:ContactDao):RunInBackground{
        override fun runInBackground(contacts: ContactEntity) {
            CoroutineScope(IO).launch {
                contactDao.insert(contacts)
            }
        }


    }

    private class CoroutineTask2(){

        companion object{
            operator fun invoke(contactDao:ContactDao, contacts: ContactEntity){
                CoroutineScope(IO).launch {
                    contactDao.insert(contacts)
                }
            }
        }


    }

    private class InsertContactAsyncTask(val contactDao:ContactDao): AsyncTask<ContactEntity, Void, Void>(){
            override fun doInBackground(vararg contacts: ContactEntity): Void? {
                contactDao.insert(contacts[0])
                return null
            }

        }
    private class UpdateContactAsyncTask(val contactDao:ContactDao): AsyncTask<ContactEntity, Void, Void>(){
            override fun doInBackground(vararg contacts: ContactEntity): Void? {
                contactDao.update(contacts[0])
                return null
            }

        }
    private class DeleteContactAsyncTask(val contactDao:ContactDao): AsyncTask<ContactEntity, Void, Void>(){
            override fun doInBackground(vararg contacts: ContactEntity): Void? {
                contactDao.delete(contacts[0])
                return null
            }

        }
    private class DeleteAllContactAsyncTask(val contactDao:ContactDao): AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg void: Void): Void? {
                contactDao.deleteAllContacts()
                return null
            }

        }

    private val database = ContactDatabase.getInstance(application)
    private val contactDao:ContactDao =database!!.getContactDao()
    var allContacts =contactDao.allContacts







}

//internal object OuterClass {
//    private const val msg="GeeksForGeeks"
//
//    // Static nested class
//    class NestedStaticClass {
//        // Only static members of Outer class is directly accessible in nested
//// static class
//        fun printMessage() { // Try making 'message' a non-static variable, there will be
//// compiler error
//            println("Message from nested static class: $msg")
//        }
//    }
//
//    // non-static nested class - also called Inner class
//    inner class InnerClass {
//        // Both static and non-static members of Outer class are accessible in
//// this Inner class
//        fun display() {
//            println("Message from non-static nested class: $msg")
//        }
//    }
//}