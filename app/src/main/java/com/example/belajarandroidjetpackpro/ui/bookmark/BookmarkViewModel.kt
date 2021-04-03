package com.example.belajarandroidjetpackpro.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.CourseEntity
import com.example.belajarandroidjetpackpro.utils.DataDummy

class BookmarkViewModel : ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}