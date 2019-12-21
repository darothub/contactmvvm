package com.example.contactmvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactViewModel(application: Application):AndroidViewModel(application) {
    var repository = ContactRepository(application)
    private var allContacts = repository.allContacts
    fun insert(contactEntity: ContactEntity){
        repository.insert(contactEntity)
    }

    fun update(contactEntity: ContactEntity){
        repository.update(contactEntity)
    }
    fun delete(contactEntity: ContactEntity){
        repository.delete(contactEntity)
    }
    fun deleteAllContacts(){
        repository.deleteAllContacts()
    }

    fun getAllContacts():LiveData<List<ContactEntity?>?>?{
        return allContacts
    }
}