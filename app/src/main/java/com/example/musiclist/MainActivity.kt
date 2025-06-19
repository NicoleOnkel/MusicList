package com.example.musiclist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
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
        val exit = findViewById<Button>(R.id.exit)





        //Arrays
        val TheSongTitle = mutableListOf<String>()
        val TheArtistName = mutableListOf<String>()
        val TheRating = mutableListOf<String>()
        val UserComments = mutableListOf<String>()







        //Buttons for adding titels, artist, rating, comments



        fun AddDetails(){


            textbox.visibility = View.VISIBLE
            Songtitle.visibility = View.VISIBLE
            ArtistName.visibility = View.VISIBLE
            Rating.visibility = View.VISIBLE
            Comments.visibility = View.VISIBLE





            Songtitle.setOnClickListener {

                var frominputbox =textbox.text.toString()
                if(frominputbox.isNotEmpty())
                    TheSongTitle.add(frominputbox)
                textbox.text.clear()//clear text

                if (frominputbox.isEmpty())
                    Toast.makeText(this@MainActivity, "The titles is empty.Try again.",Toast.LENGTH_SHORT).show()


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
                    TheRating.add(frominputbox)
                textbox.text.clear()//clear text

            }


            Comments.setOnClickListener {
                var frominputbox =textbox.text.toString()
                if(frominputbox.isNotEmpty())
                    UserComments.add(frominputbox)
                textbox.text.clear()//clear text


            }


        }


        ///Once button is clicked, user will enter details


        addonlist.setOnClickListener { AddDetails() }



        //Next Screen
        ViewScreen.setOnClickListener {
            val intent = Intent(this, Details::class.java)
            intent.putStringArrayListExtra("SongTitle", ArrayList(TheSongTitle))
            intent.putStringArrayListExtra("ArtistName", ArrayList(TheArtistName))
            intent.putStringArrayListExtra("Rating", ArrayList(TheRating))
            intent.putStringArrayListExtra("Comments", ArrayList(UserComments))
            startActivity(intent)
        }




        //Exit button
        exit.setOnClickListener {
            finishAffinity()
        }






    }
}