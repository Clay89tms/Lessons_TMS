package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.component.Course;
import org.example.component.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService extends AbstractDaoService {

    private final SessionFactory factory;

    public void saveCourse(Course course) {
        Session session = getOpening();

        session.save(course);

    }

    public void save(Teacher teacher) {
        Session session = getOpening();
        session.save(teacher);
        List<Course> courses = teacher.getCourses();
        courses.forEach(course -> course.setTeacher(teacher));
        System.out.println();
//        Course course = teacher.getCourse();
//        course.setTeacher(teacher);

//        session.save(course);

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
