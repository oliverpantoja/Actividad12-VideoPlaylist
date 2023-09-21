package com.example.videoplaylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var adapter: VideoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvVideos : RecyclerView = findViewById(R.id.rvVideos)
        adapter = VideoAdapter(this)
        

        adapter.llenar( llenarListaVideos() )

        rvVideos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvVideos.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

        val rating = VideoActivity.rating
        val position = VideoActivity.position

        adapter.actualizarRating(position, rating)
    }

    fun llenarListaVideos() : ArrayList<Video>{
        val artists = resources.getStringArray(R.array.artists)
        val songs = resources.getStringArray(R.array.songs)
        val url = resources.getStringArray(R.array.urls)

        val lista : ArrayList<Video> = ArrayList()

        for(i in artists.indices){

            val video = Video()

            video.artist    = artists[i]
            video.song      = songs[i]
            video.url       = url[i]

            video.thumb     = calcularIdImagen( i )
            lista.add( video )
        }

        return lista
    }
    
    private fun calcularIdImagen(i: Int): Int {
        return resources.getIdentifier("t_song$i", "drawable", packageName)
    }
}