package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.component.Course;
import org.example.component.Student;
import org.example.component.Teacher;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService extends AbstractDaoService {

    public void saveTeacher(Teacher teacher) {
        if (teacher.getId() == null) {
            Session session = getSession();

            session.save(teacher);

            close(session);
        } else {
            System.out.println(teacher.getName() + " has already been created");
        }
    }

    public void saveCourse(Course course) {
        if (course.getId() == null) {
            Session session = getSession();

            session.save(course);

            close(session);
        } else {
            System.out.println(course.getName() + " has already been created");
        }
    }

    public void saveStudent(Student student) {
        if (student.getId() == null) {
            Session session = getSession();

            session.save(student);

            close(session);
        } else {
            System.out.println(student.getName() + " has already been created");
        }
    }

    public void addCourseForTeacher(Teacher teacher, Course course) {
        if (!(teacher.getId() == null && course.getId() == null)) {
            Session session = getSession();

            List<Course> courses;
            boolean thereIs = true;

            if (teacher.getCourses() == null) {
                courses = new ArrayList<>();
            } else {
                courses = teacher.getCourses();

                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).equals(course)) {
                        thereIs = false;
                    }
                }

            }
            if (thereIs) {
                courses.add(course);
                teacher.setCourses(courses);
                course.setTeacher(teacher);
                session.saveOrUpdate(course);
            } else {
                System.out.println(teacher.getName() + " has already been added course: " + course.getName());
            }

            close(session);
        }
    }

    public void addStudentForCourse(Student student, Course course) {
        if (!(student.getId() == null && course.getId() == null)) {
            Session session = getSession();
            boolean thereIs = true;

            List<Student> students;
            if (course.getStudents() == null) {
                students = new ArrayList<>();
            } else {
                students = course.getStudents();

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).equals(student)) {
                        thereIs = false;
                    }
                }
            }
            List<Course> courses;


            if (student.getCourses() == null) {
                courses = new ArrayList<>();
            } else {
                courses = student.getCourses();

                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).equals(course)) {
                        thereIs = false;
                    }
                }
            }


            if (thereIs) {
                courses.add(course);
                students.add(student);

                course.setStudents(students);
                student.setCourses(courses);

                session.saveOrUpdate(student);
                session.saveOrUpdate(course);
            }


            close(session);
        }
    }

    public void deleteStudent(Student student, Course course) {
        if (!(student.getId() == null && course.getId() == null)) {
            Session session = getSession();

            Student studentId = session.get(Student.class, student.getId());
            Course courseId = session.get(Course.class, course.getId());
            courseId.getStudents().remove(studentId);

            List<Course> courses = student.getCourses();
            List<Student> students = course.getStudents();
            courses.remove(course);
            students.remove(student);
            course.setStudents(students);
            student.setCourses(courses);


            close(session);
        }
    }

    public Teacher getTeacher1(Teacher teacher){
        Session session = getSession();
        Teacher teacherId = session.get(Teacher.class, teacher.getId());
        System.out.println(teacherId);
        close(session);
        return teacherId;

    }

    public List<Teacher> getTeacher2(Teacher teacher){
        Session session = getSession();
        Teacher teacherId = session.get(Teacher.class, teacher.getId());

        Query query = session.createQuery("from Teacher as p where p.courses = :course ", Teacher.class);

        Criteria criteria = session.createCriteria(Teacher.class);
        List list = criteria.list();

        close(session);
        return list;
    }

    public Teacher getTeacher(Integer id) {
        Session session = getSession();

        Teacher teacher = session.find(Teacher.class, id);
        System.out.println("PRINTING teacher: " + teacher);
        List<Course> courses = teacher.getCourses();
        for (Course course: courses){
            System.out.println(course);
            List<Student> students = course.getStudents();
            for (Student student: students){
                System.out.println(student);
            }
        }

        close(session);
        return teacher;
    }

    public Course getCourse(Integer id) {
        Session session = getSession();

        Course course = session.find(Course.class, id);

        close(session);
        return course;
    }

    public void deleteTeacher(Integer id) {
        Session session = getSession();

        Teacher teacher = session.get(Teacher.class, id);
        Course course = session.get(Course.class, id);
        session.delete(course);
        session.delete(teacher);

        close(session);
    }

    public void deleteCourse(Integer id) {
        Session session = getSession();

        Course course = session.get(Course.class, id);
        session.delete(course);

        close(session);
    }
}
