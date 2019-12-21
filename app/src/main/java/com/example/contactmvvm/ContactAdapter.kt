package com.example.contactmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter:RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    private var contacts:List<ContactEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_list, parent, false)
        return ContactHolder(itemView)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    fun setContacts(contacts: List<ContactEntity?>?){
        this.contacts =contacts as List<ContactEntity>
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val currentContact = contacts.get(position)
        holder.firstName.setText(currentContact.firstName)
        holder.lastName.setText(currentContact.lastName)
        holder.phoneNumber.setText(currentContact.phone)
        holder.picture.setImageResource(currentContact.image)
//        if(currentContact.sex == "M"){
//            holder.picture.setImageResource(R.drawable.maleavatar)
//        }
//        else if(currentContact.sex == "F"){
//            holder.picture.setImageResource(R.drawable.femaleavatar)
//        }
//        else{
//            holder.picture.setImageResource(position)
//        }
    }
    class ContactHolder(view:View) : RecyclerView.ViewHolder(view){
        var firstName = view.findViewById<TextView>(R.id.firstName)
        var lastName = view.findViewById<TextView>(R.id.lastName)
        var phoneNumber = view.findViewById<TextView>(R.id.phoneNumber)
        var picture = view.findViewById<ImageView>(R.id.profileImage)
    }


}