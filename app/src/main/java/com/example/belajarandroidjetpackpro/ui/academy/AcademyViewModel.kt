package com.example.belajarandroidjetpackpro.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.CourseEntity
import com.example.belajarandroidjetpackpro.data.source.AcademyRepository
import com.example.belajarandroidjetpackpro.utils.DataDummy

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourses(): LiveData<List<CourseEntity>> = academyRepository.getAllCourses()
}