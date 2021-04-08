package com.example.belajarandroidjetpackpro.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.CourseEntity
import com.example.belajarandroidjetpackpro.data.source.AcademyRepository
import com.example.belajarandroidjetpackpro.utils.DataDummy

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    fun getBookmarks(): LiveData<List<CourseEntity>> = academyRepository.getBookmarkedCourses()
}