package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.component.Course;
import org.example.component.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final SessionFactory factory;

    public void save(Teacher teacher) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(teacher);
        Course course = teacher.getCourse();
        course.setTeacher(teacher);

        session.save(course);

        transaction.commit();
        session.close();
    }

    public Teacher getTeacher(Integer id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Teacher teacher = session.find(Teacher.class, id);

        transaction.commit();
        session.close();
        return teacher;
    }
    public Course getCourse(Integer id){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.find(Course.class, id);

        transaction.commit();
        session.close();
        return course;
    }
    public void deleteTeacher(Integer id){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Teacher teacher = session.get(Teacher.class, id);
        Course course = session.get(Course.class, id);
        session.delete(course);
        session.delete(teacher);

        transaction.commit();
        session.close();
    }
    public void deleteCourse(Integer id){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, id);
        session.delete(course);

        transaction.commit();
        session.close();
    }
}
