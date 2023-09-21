package com.example.videoplaylist

import android.content.Context
import android.content.Intent
import android.media.Rating
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter : RecyclerView.Adapter<VideoHolder> {
    lateinit var data : ArrayList<Video>
    lateinit var context: Context

    constructor(c : Context) : super(){
        data = ArrayList()

        context = c
    }

    fun llenar(lista : ArrayList <Video>){
       data = lista
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        val view : View = LayoutInflater.from( parent.context ).inflate(R.layout.video_fila, parent, false)

        return VideoHolder( view )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        var video = data.get( position )

        holder.tvSong.text = video.song
        holder.tvArtist.text = video.artist
        holder.tvRating.text = video.rating.toString()

        holder.ivThumb.setImageResource( video.thumb )


        holder.fila.setOnClickListener{
            val intent = Intent(context, VideoActivity::class.java)

            intent.putExtra("SONG", video.song)
            intent.putExtra("ARTIST", video.artist)
            intent.putExtra("URL", video.url)
            intent.putExtra("POSICION", position)

            context.startActivity(intent)
        }
 

    }
    fun actualizarRating(position: Int, rating: Double){
        val video = data.get(position)
        video.rating = rating
        data.set(position, video)
        notifyDataSetChanged()
    }
}