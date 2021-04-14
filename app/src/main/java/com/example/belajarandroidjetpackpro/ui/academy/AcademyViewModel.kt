package com.example.belajarandroidjetpackpro.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.source.local.entity.CourseEntity
import com.example.belajarandroidjetpackpro.data.AcademyRepository
import com.example.belajarandroidjetpackpro.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourses(): LiveData<Resource<List<CourseEntity>>> = academyRepository.getAllCourses()
}