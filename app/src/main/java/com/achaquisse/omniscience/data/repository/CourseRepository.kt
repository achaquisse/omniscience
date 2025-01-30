package com.achaquisse.omniscience.data.repository

import com.achaquisse.omniscience.data.model.Course

object CourseRepository {
    fun listCourses(): List<Course> {
        return listOf(
            Course(id = 1, name = "Essential English Course"),
            Course(id = 2, name = "Computing Fundamentals"),
            Course(id = 3, name = "Admission Exam - Mathematics"),
            Course(id = 4, name = "Secondary School Explanation")
        )
    }

    fun listClasses(courseId: Int) {

    }
}