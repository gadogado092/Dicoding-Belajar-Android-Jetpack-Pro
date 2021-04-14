package com.example.belajarandroidjetpackpro.ui.bookmark

import com.example.belajarandroidjetpackpro.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
