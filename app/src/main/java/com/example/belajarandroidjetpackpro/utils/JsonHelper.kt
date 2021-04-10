package com.example.belajarandroidjetpackpro.utils

import android.content.Context
import com.example.belajarandroidjetpackpro.data.source.remote.response.MovieResponse
import com.example.belajarandroidjetpackpro.data.source.remote.response.TvResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val dateRelease = movie.getString("dateRelease")
                val pathImage = movie.getString("imageDrawable")
                val description = movie.getString("description")

                val movieResponse = MovieResponse(id, title, dateRelease, pathImage, description)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTv(): List<TvResponse> {
        val list = ArrayList<TvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvResponses.json").toString())
            val listArray = responseObject.getJSONArray("tv")
            for (i in 0 until listArray.length()) {
                val tv = listArray.getJSONObject(i)

                val id = tv.getString("id")
                val title = tv.getString("title")
                val dateRelease = tv.getString("dateRelease")
                val pathImage = tv.getString("imageDrawable")
                val description = tv.getString("description")

                val tvResponse = TvResponse(id, title, dateRelease, pathImage, description)
                list.add(tvResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailMovie(idMovie: String): MovieResponse {
        var data: MovieResponse? = null
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                if (idMovie == id) {
                    val title = movie.getString("title")
                    val dateRelease = movie.getString("dateRelease")
                    val pathImage = movie.getString("imageDrawable")
                    val description = movie.getString("description")

                    data = MovieResponse(id, title, dateRelease, pathImage, description)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return data as MovieResponse
    }

    fun loadDetailTv(idTv: String): TvResponse {
        var data: TvResponse? = null
        try {
            val responseObject = JSONObject(parsingFileToString("TvResponses.json").toString())
            val listArray = responseObject.getJSONArray("tv")
            for (i in 0 until listArray.length()) {
                val tv = listArray.getJSONObject(i)

                val id = tv.getString("id")
                if (idTv == id) {
                    val title = tv.getString("title")
                    val dateRelease = tv.getString("dateRelease")
                    val pathImage = tv.getString("imageDrawable")
                    val description = tv.getString("description")

                    data = TvResponse(id, title, dateRelease, pathImage, description)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return data as TvResponse
    }
}