package com.example.emailrecycler

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails: List<Email>
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailRV = findViewById<RecyclerView>(R.id.emailRV)
        emails = EmailFetcher.getEmails()
        var adapter = EmailAdapter(emails)
        emailRV.adapter = adapter
        emailRV.layoutManager = LinearLayoutManager(this)

        val loadButton = findViewById<Button>(R.id.loadButton)

        loadButton.setOnClickListener{
            val newEmails = EmailFetcher.getNext5Emails()
            (emails as MutableList<Email>).addAll(newEmails)
            adapter.notifyDataSetChanged()
//            for (i in newEmails){
//                (emails as MutableList<Email>).add(i)
//                adapter = EmailAdapter(emails)
//                emailRV.adapter =adapter
//                emailRV.layoutManager = LinearLayoutManager(this)
//            }

        }

    }
}