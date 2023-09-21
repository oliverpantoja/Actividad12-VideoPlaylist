package com.example.videoplaylist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class VideoActivity : AppCompatActivity() {
    lateinit var  ratingBar : RatingBar

    companion object{
        var rating = 0.0
        var position = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        if (intent != null){
            configUi()
        }
    }

    private fun configUi() {

        val song = intent.getStringExtra("SONG")
        val artist = intent.getStringExtra("ARTIST")
        val url = intent.getStringExtra("URL")
        val posicion = intent.getIntExtra("POSICION", -1)

        position = posicion

        val tvTitulo : TextView = findViewById(R.id.tvTitulo)
        tvTitulo.text = song

        val tvArtista : TextView = findViewById(R.id.tvArtista)
        tvArtista.text = artist

        val idImagen: Int = calcularIdImagen(position)
        val ivPortada: ImageView = findViewById(R.id.ivPortada)

        ivPortada.setImageResource(idImagen)

        val bVerVideo : Button = findViewById(R.id.bVerVideo)

        bVerVideo.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity( i )
        }
        ratingBar = findViewById(R.id.ratingBar)
    }

    override fun onPause() {
        super.onPause()

        rating = ratingBar.rating.toDouble()
    }

    private fun calcularIdImagen(posicion: Int): Int {
        return resources.getIdentifier("b_song$posicion", "drawable", packageName)
    }

}
