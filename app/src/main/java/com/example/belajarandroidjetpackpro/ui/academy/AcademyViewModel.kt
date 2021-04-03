package com.example.belajarandroidjetpackpro.ui.academy

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.CourseEntity
import com.example.belajarandroidjetpackpro.utils.DataDummy

class AcademyViewModel : ViewModel() {

    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}