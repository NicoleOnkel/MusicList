package com.example.musiclist

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addonlist = findViewById<Button>(R.id.addtolist)
        val textbox = findViewById<EditText>(R.id.inputbox)
        val saveItems = findViewById<Button>(R.id.saveitem)



        //Arrays
        val TheSongTitle = mutableListOf<String>()
        val TheArtistName = mutableListOf<String>()
        val TheRating = mutableListOf<Int>()
        val UserComments = mutableListOf<String>()

        addonlist.setOnClickListener {
            if (addonlist.isEnabled == true)
                textbox.visibility = View.VISIBLE
            saveItems.visibility = View.VISIBLE




        }

        saveItems.setOnClickListener {

            var frominputbox =textbox.text.toString()
            if(frominputbox.isNotEmpty())
                TheSongTitle.add(frominputbox)
                    textbox.text.clear()//clear text


        }







    }
}