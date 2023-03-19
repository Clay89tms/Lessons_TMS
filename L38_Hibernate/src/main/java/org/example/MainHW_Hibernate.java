package org.example;

import org.example.component.Course;
import org.example.component.Property;
import org.example.component.Student;
import org.example.component.Teacher;
import org.example.domain.Position;
import org.example.service.UniversityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Random;

public class MainHW_Hibernate {
    public static void main(String[] args) {
        MainHW_Hibernate mainHW = new MainHW_Hibernate();

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        UniversityService service = context.getBean(UniversityService.class);

        System.out.println("---create_teacher---");
        Teacher teacherSergey = mainHW.createTeacher();
        service.saveTeacherToDB(teacherSergey);
        System.out.println("---end_create_teacher---");

        System.out.println("---create_courses---");
        Course spring = mainHW.createCourse("Spring", new Date(123, 6, 26));
        service.saveCourseToDB(spring);
        System.out.println("----------------");

        Course hibernate = mainHW.createCourse("Hibernate", new Date(123, 7, 27));
        service.saveCourseToDB(hibernate);
        System.out.println("----------------------");

        Course dataBase = mainHW.createCourse("DataBase", new Date(123, 8, 28));
        service.saveCourseToDB(dataBase);
        System.out.println("------end_create_courses------------------------");

        System.out.println("---add_course_for_teacher---");
        service.addCourseForTeacherToDB(teacherSergey, spring);
        service.addCourseForTeacherToDB(teacherSergey, hibernate);
        service.addCourseForTeacherToDB(teacherSergey, dataBase);
        service.addCourseForTeacherToDB(teacherSergey, spring);
        System.out.println("---end_add_course_for_teacher---");

        System.out.println("---add_students---");
        Student romanK = mainHW.createStudent("RomanK", 34);
        service.saveStudentToDB(romanK);

        Student danila = mainHW.createStudent("Danila", 27);
        service.saveStudentToDB(danila);

        Student sviatoslav = mainHW.createStudent("Sviatoslav", 35);
        service.saveStudentToDB(sviatoslav);
        System.out.println("---end_add_students---");

        System.out.println("---take_students_a_courses---");
        service.addStudentForCourse(romanK, spring);
        service.addStudentForCourse(romanK, hibernate);
        service.addStudentForCourse(romanK, dataBase);

        service.addStudentForCourse(danila, spring);
        service.addStudentForCourse(danila, hibernate);
        service.addStudentForCourse(danila, dataBase);

        service.addStudentForCourse(sviatoslav, spring);
        service.addStudentForCourse(sviatoslav, hibernate);
        System.out.println("---end_take_students_a_courses---");

        service.deleteStudentFromCourse(sviatoslav, spring);
        service.deleteStudentFromCourse(sviatoslav, hibernate);

        service.addStudentForCourse(sviatoslav, dataBase);
        service.addStudentForCourse(sviatoslav, spring);
        service.addStudentForCourse(sviatoslav, hibernate);

        System.out.println("__________print________________________");
        System.out.println(service.printAllByTeacherToId(teacherSergey.getId()));
        System.out.println("__________print________________________");

    }


    public Teacher createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setKeyRandomTeacher("key_T#" + new Random().nextInt());
        teacher.setName("Sergey");
        teacher.setDate(new Date(82, 04, 15));
        teacher.setPosition(Position.PROFESSOR);
        teacher.setIsMan(true);
        Property property = new Property("Porsche", "House", "Apple");
        teacher.setProperty(property);

        return teacher;
    }


    public Course createCourse(String nameCourse, Date date) {
        Course course = new Course();
        course.setName(nameCourse);
        course.setDate(date);
        course.setKeyRandomCourse("key_C#" + new Random().nextInt());
        return course;
    }

    public Student createStudent(String nameStudent, Integer age) {
        Student student = new Student();
        student.setName(nameStudent);
        student.setAge(age);

        return student;
    }


}