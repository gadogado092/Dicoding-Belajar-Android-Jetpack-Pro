package com.example.belajarandroidjetpackpro.ui.bookmark

import com.example.belajarandroidjetpackpro.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
