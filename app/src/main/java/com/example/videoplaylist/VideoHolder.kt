package com.example.videoplaylist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoHolder : RecyclerView.ViewHolder {
    lateinit var ivThumb    : ImageView
    lateinit var tvArtist   : TextView
    lateinit var tvSong     : TextView
    lateinit var tvRating : TextView
    lateinit var fila: View

    constructor(itemView: View) : super(itemView){
        ivThumb     = itemView.findViewById(R.id.ivThumb)
        tvArtist    = itemView.findViewById(R.id.tvArtist)
        tvSong      = itemView.findViewById(R.id.tvSong)
        tvRating    = itemView.findViewById(R.id.tvRating)

        fila = itemView
    }


}
