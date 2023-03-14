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
    private List<Student> studentList;

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

            Course courseFromDB = session.get(Course.class, course.getId());
            courseFromDB.setTeacher(teacher);
            session.save(courseFromDB);

            close(session);
        }
    }

    public void addStudentForCourse(Student student, Course course) {
        if (student.getId() != null || course.getId() != null) {
            Session session = getSession();

            Course courseFromDB = session.get(Course.class, course.getId());
            Student studentFromDB = session.get(Student.class, student.getId());
            if (courseFromDB.getStudents() == null) {
                studentList = new ArrayList<>();
            } else {
                studentList = courseFromDB.getStudents();
            }
            boolean addOrNo = true;
            for (Student studentFind : studentList) {
                if (studentFind.equals(studentFromDB)) {
                    addOrNo = false;
                }
            }
            if (addOrNo) {
                studentList.add(student);
                courseFromDB.setStudents(studentList);
                session.save(courseFromDB);
            }
            close(session);
        }
    }

    public void deleteStudentFromCourse(Student student, Course course) {
        if (!(student.getId() == null && course.getId() == null)) {
            Session session = getSession();

            Course courseFromDB = session.get(Course.class, course.getId());

            if (courseFromDB.getStudents().isEmpty()) {
                throw new RuntimeException("this Course dont have a students");
            } else {
                studentList = courseFromDB.getStudents();
                for (Student studentFromDB : studentList) {
                    if (studentFromDB.getId().equals(student.getId())) {
                        studentList.remove(studentFromDB);
                        break;
                    }
                }
            }
            close(session);
        }
    }


    public String printAllByTeacherToId(Integer id) {
        Session session = getSession();
        String printResult = "";

        Teacher teacher = session.find(Teacher.class, id);
        printResult = "PRINTING teacher: " + teacher;
        courses = teacher.getCourses();
        for (Course course : courses) {
            printResult += "\n" + course;
            studentList = course.getStudents();
            for (Student student : studentList) {
                printResult += " { " + student + " } ";
            }
        }
        close(session);
        return printResult;
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
