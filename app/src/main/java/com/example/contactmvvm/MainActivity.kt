package com.example.contactmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var contactViewModel: ContactViewModel?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val contacts:ArrayList<ContactEntity>

//        val contacts = arrayOf(
//
//            ContactEntity("Tola", "Folawo", "M", "Atlantic View", "08060085192", R.drawable.femaleavatar),
//            ContactEntity("Aisha", "Monday", "M", "Atlantic View", "08060085192", R.drawable.femaleavatar),
//            ContactEntity("Darot", "Tosin", "M", "Atlantic View", "08060085192", R.drawable.maleavatar)
//        )
//
//        val arrayList: ArrayList<String> = ArrayList<String>(5)
//        var list: MutableList<ContactEntity> = mutableListOf<ContactEntity>()
//
//        list.add(ContactEntity("Tola", "Folawo", "M", "Atlantic View", "08060085192", R.drawable.femaleavatar))
//        list.add(ContactEntity("Aisha", "Monday", "M", "Atlantic View", "08060085192", R.drawable.femaleavatar))
//        list.add(ContactEntity("Darot", "Tosin", "M", "Atlantic View", "08060085192", R.drawable.maleavatar))
//
//        val contactList = ArrayList<ContactEntity>()
//
//        contactList.addAll(list)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val adapter = ContactAdapter()
        recyclerView.adapter = adapter




        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)
        contactViewModel!!.insert(ContactEntity("Coolman", "Tola", "M", "Atlantic View", "08060085192", R.drawable.maleavatar))
        contactViewModel!!.getAllContacts()?.observe(this, object:Observer<List<ContactEntity?>?>{
            override fun onChanged(contactEntity: List<ContactEntity?>?) {
                adapter.setContacts(contactEntity)
                Toast.makeText(applicationContext, "$contactEntity", Toast.LENGTH_LONG).show()
                Log.i("this class", "$contactEntity")
            }

        })
    }


}



//)
////        contacts?.add(ContactEntity("Darot", "Tosin", "M", "Atlantic View", "08060085192", R.drawable.maleavatar))
////        contacts?.add(ContactEntity("Tola", "Folawo", "M", "Atlantic View", "08060085192", R.drawable.femaleavatar))
////        contacts?.add(ContactEntity("Aisha", "Monday", "M", "Atlantic View", "08060085192", R.drawable.femaleavatar))