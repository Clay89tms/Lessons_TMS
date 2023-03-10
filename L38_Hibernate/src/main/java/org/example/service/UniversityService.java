package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.component.Course;
import org.example.component.Student;
import org.example.component.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService extends AbstractDaoService {

    public void saveTeacher(Teacher teacher) {
        if (teacher.getId() == null) {
            Session session = getOpening();

            session.save(teacher);

            close(session);
        } else {
            System.out.println(teacher.getName() + " has already been created");
        }
    }

    public void saveCourse(Course course) {
        if (course.getId() == null) {
            Session session = getOpening();

            session.save(course);

            close(session);
        } else {
            System.out.println(course.getName() + " has already been created");
        }
    }

    public void saveStudent(Student student){
        if (student.getId() == null){
            Session session = getOpening();

            session.save(student);

            close(session);
        } else {
            System.out.println(student.getName() + " has already been created");
        }
    }

    public void addCourseForTeacher(Teacher teacher, Course course) {
        if (!(teacher.getId() == null && course.getId() == null)) {
            Session session = getOpening();
            List<Course> courses;

            if (teacher.getCourses() == null) {
                courses = new ArrayList<>();
            } else {
                courses = teacher.getCourses();
            }
            courses.add(course);
            teacher.setCourses(courses);

            course.setTeacher(teacher);
//            session.save(course);
            session.saveOrUpdate(course);

            close(session);
        }
    }


    public void saveCourseForTeacher(Teacher teacher, Course course) {
        Session session = getOpening();
        if (teacher.getId() == null) {
            session.save(teacher);
        }
        List<Course> courses;

        if (teacher.getCourses() == null) {
            courses = new ArrayList<>();
        } else {
            courses = teacher.getCourses();
        }
        courses.add(course);
        teacher.setCourses(courses);

        course.setTeacher(teacher);
        session.save(course);

        close(session);

    }

    public Teacher getTeacher(Integer id) {
        Session session = getOpening();

        Teacher teacher = session.find(Teacher.class, id);

        close(session);
        return teacher;
    }

    public Course getCourse(Integer id) {
        Session session = getOpening();

        Course course = session.find(Course.class, id);

        close(session);
        return course;
    }

    public void deleteTeacher(Integer id) {
        Session session = getOpening();

        Teacher teacher = session.get(Teacher.class, id);
        Course course = session.get(Course.class, id);
        session.delete(course);
        session.delete(teacher);

        close(session);
    }

    public void deleteCourse(Integer id) {
        Session session = getOpening();

        Course course = session.get(Course.class, id);
        session.delete(course);

        close(session);
    }
}
