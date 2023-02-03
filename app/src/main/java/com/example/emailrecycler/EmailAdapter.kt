package com.example.emailrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val emailSender :TextView
        val emailSub :TextView
        val emailSum : TextView

        init{
            emailSender = itemView.findViewById(R.id.emailSender)
            emailSub = itemView.findViewById(R.id.emailSubject)
            emailSum = itemView.findViewById(R.id.emailSummary)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflator = LayoutInflater.from(context)

        val contactView = inflator.inflate(R.layout.email_item, parent,false)

        return  ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails.get(position)

        holder.emailSender.text = email.sender
        holder.emailSub.text = email.title
        holder.emailSum.text = email.summary
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}