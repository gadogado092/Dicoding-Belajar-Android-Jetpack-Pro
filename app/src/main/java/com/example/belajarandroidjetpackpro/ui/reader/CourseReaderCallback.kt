package com.example.belajarandroidjetpackpro.ui.reader

interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}