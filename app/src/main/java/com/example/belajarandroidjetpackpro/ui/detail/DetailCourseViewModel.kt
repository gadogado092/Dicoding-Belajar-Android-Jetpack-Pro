package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.CourseEntity
import com.example.belajarandroidjetpackpro.data.ModuleEntity
import com.example.belajarandroidjetpackpro.data.source.AcademyRepository
import com.example.belajarandroidjetpackpro.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModules(courseId)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)

//    fun getCourse(): CourseEntity? {
//        var course: CourseEntity? = null
//        for (courseEntity in DataDummy.generateDummyCourses()) {
//            if (courseEntity.courseId == courseId) {
//                course = courseEntity
//            }
//        }
//        return course
//    }
}