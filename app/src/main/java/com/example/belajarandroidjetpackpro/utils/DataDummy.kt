package com.example.belajarandroidjetpackpro.utils

import com.example.belajarandroidjetpackpro.R
import com.example.belajarandroidjetpackpro.data.MovieEntity

object DataDummy {
    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                "1",
                "Alita: Battle Angel",
                "14/02/2019",
                R.drawable.poster_a_start_is_born,
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
            )
        )
        movies.add(
            MovieEntity(
                "2",
                "Serenity",
                "25/01/2019",
                R.drawable.poster_serenity,
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
            )
        )
        return movies
    }
}