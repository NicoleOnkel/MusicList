package com.example.musiclist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Details : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val songs = intent.getStringArrayListExtra("SongTitle")
        val artists = intent.getStringArrayListExtra("ArtistName")
        val rating = intent.getIntExtra("Rating", 0)
        val comments = intent.getStringArrayListExtra("Comments")

        val allsongs = findViewById<TextView>(R.id.Songlist)
        val allartists = findViewById<TextView>(R.id.Artistlist)
        val allratings = findViewById<TextView>(R.id.Ratinglist)
        val allComments = findViewById<TextView>(R.id.Commentslist)

        //displaying Details on Screen

        val viewbutton = findViewById<Button>(R.id.ViewSongdetails)


        fun displayScreen(){

            allsongs.text = "Click View Button to see playlist"

            if (viewbutton.isEnabled){
                allsongs.text = "Song Title: $songs".toString()
                allartists.text = "The Artist: $artists".toString()
                allratings.text = "The Rating: $rating".toString()
                allComments.text = "The Comment: $comments".toString()

            }
        }

        displayScreen()











        val BacktomainScreen= findViewById<Button>(R.id.bcktoMain)


        BacktomainScreen.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}