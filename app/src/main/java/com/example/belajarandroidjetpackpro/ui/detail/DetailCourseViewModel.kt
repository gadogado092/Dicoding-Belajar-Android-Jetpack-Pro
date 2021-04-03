package com.example.belajarandroidjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.example.belajarandroidjetpackpro.data.CourseEntity
import com.example.belajarandroidjetpackpro.data.ModuleEntity
import com.example.belajarandroidjetpackpro.utils.DataDummy

class DetailCourseViewModel : ViewModel() {

    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseId)

    fun getCourse(): CourseEntity? {
        var course: CourseEntity? = null
        for (courseEntity in DataDummy.generateDummyCourses()) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }
        return course
    }
}