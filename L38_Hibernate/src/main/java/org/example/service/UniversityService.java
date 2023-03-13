package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.component.Course;
import org.example.component.Student;
import org.example.component.Teacher;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityService extends AbstractDaoService {

    private List<Course> courses;
    private List<Student> students;

    public void saveTeacherToDB(Teacher teacher) {
        if (teacher.getId() == null) {
            Session session = getSession();

            session.save(teacher);

            close(session);
        }
    }

    public void saveCourseToDB(Course course) {
        if (course.getId() == null) {
            Session session = getSession();

            session.save(course);

            close(session);
        }
    }

    public void saveStudentToDB(Student student) {
        if (student.getId() == null) {
            Session session = getSession();

            session.save(student);

            close(session);
        }
    }

    public void addCourseForTeacherToDB(Teacher teacher, Course course) {
        if (teacher.getId() != null || course.getId() != null) {
            Session session = getSession();

            Teacher teacherToDB = session.get(Teacher.class, teacher.getId());
            Course courseToDB = session.get(Course.class, course.getId());

            if (teacherToDB.getCourses() == null) {
                courses = new ArrayList<>();
            } else {
                courses = teacherToDB.getCourses();
            }
            courseToDB.setTeacher(teacherToDB);
            courses.add(course);
            teacherToDB.setCourses(courses);
            session.save(teacherToDB);
            session.save(courseToDB);

            close(session);
        }
    }

    public void addStudentForCourse(Student student, Course course) {
        if (student.getId() != null || course.getId() != null) {
            Session session = getSession();

            Course courseToDB = session.get(Course.class, course.getId());

            if (courseToDB.getStudents() == null) {
                students = new ArrayList<>();
            } else {
                students = courseToDB.getStudents();
            }
            students.add(student);
            courseToDB.setStudents(students);
            session.save(courseToDB);

            close(session);
        }
    }

    public void deleteStudent(Student student, Course course) {
        if (!(student.getId() == null && course.getId() == null)) {
            Session session = getSession();

//            Student studentId = session.get(Student.class, student.getId());
            Course courseId = session.get(Course.class, course.getId());
//            courseId.getStudents().remove(studentId);

            List<Student> studentsDB = courseId.getStudents();
            for (Student studentDB : studentsDB) {
                if (studentDB.getId().equals(student.getId())) {
                    studentsDB.remove(studentDB);
                    break;
                }
            }

            close(session);
        }
    }


    public Teacher getTeacherById(Integer id) {
        Session session = getSession();

        Teacher teacher = session.find(Teacher.class, id);
        System.out.println("PRINTING teacher: " + teacher);
        List<Course> courses = teacher.getCourses();
        for (Course course : courses) {
            System.out.println(course);
            List<Student> students = course.getStudents();
            for (Student student : students) {
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
