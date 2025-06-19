package com.example.musiclist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.text.clear
import kotlin.toString

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


        //buttons for adding
        val Songtitle = findViewById<Button>(R.id.Songtitle)
        val ArtistName = findViewById<Button>(R.id.artistNme)
        val Rating = findViewById<Button>(R.id.Rating)
        val Comments = findViewById<Button>(R.id.Comments)




        val addonlist = findViewById<Button>(R.id.addtolist)
        val textbox = findViewById<EditText>(R.id.inputbox)
        val ViewScreen = findViewById<Button>(R.id.nxtScreen)




        //Arrays
        val TheSongTitle = mutableListOf<String>()
        val TheArtistName = mutableListOf<String>()
        val TheRating = mutableListOf<Int>()
        val UserComments = mutableListOf<String>()





        //Buttons for adding titels, artist, rating, comments



        fun AddDetails(){
            if (addonlist.isEnabled == true)
                        textbox.visibility = View.VISIBLE
                    Songtitle.visibility = View.VISIBLE

            Songtitle.setOnClickListener {

                var frominputbox =textbox.text.toString()
                if(frominputbox.isNotEmpty())
                    TheSongTitle.add(frominputbox)
                textbox.text.clear()//clear text




                }

            ArtistName.setOnClickListener {

                var frominputbox =textbox.text.toString()
                if(frominputbox.isNotEmpty())
                    TheArtistName.add(frominputbox)
                textbox.text.clear()//clear text




            }

            Rating.setOnClickListener {
                var frominputbox =textbox.text.toString()
                if(frominputbox.isNotEmpty())
                    TheRating+
                textbox.text.clear()//clear text

            }


            Comments.setOnClickListener {
                var frominputbox =textbox.text.toString()
                if(frominputbox.isNotEmpty())
                    UserComments.add(frominputbox)
                textbox.text.clear()//clear text


            }


        }

        AddDetails()






        //Next Screen
        ViewScreen.setOnClickListener {
            val intent = Intent(this, Details::class.java)
            intent.putStringArrayListExtra("SongTitle", ArrayList(TheSongTitle))
            intent.putStringArrayListExtra("ArtistName", ArrayList(TheArtistName))
            intent.putIntegerArrayListExtra("Rating", ArrayList(TheRating))
            intent.putStringArrayListExtra("Comments", ArrayList(UserComments))
            startActivity(intent)
        }








    }
}