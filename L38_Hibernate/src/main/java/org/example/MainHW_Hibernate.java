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
        service.saveTeacher(teacherSergey);
        System.out.println("---end_create_teacher---");

        System.out.println("---create_courses---");
        Course spring = mainHW.createCourse("Spring", new Date(123, 6, 26));
        service.saveCourse(spring);
        System.out.println("----------------");

        Course hibernate = mainHW.createCourse("Hibernate", new Date(123, 7, 27));
        service.saveCourse(hibernate);
        System.out.println("----------------------");

        Course dataBase = mainHW.createCourse("DataBase", new Date(123, 8, 28));
        service.saveCourse(dataBase);
        System.out.println("------end_create_courses------------------------");

        System.out.println("---add_course_for_teacher---");
        service.addCourseForTeacher(teacherSergey, spring);
        service.addCourseForTeacher(teacherSergey, hibernate);
        service.addCourseForTeacher(teacherSergey, dataBase);
        System.out.println("---end_add_course_for_teacher---");

        System.out.println("---add_students---");
        Student romanK = mainHW.createStudent("RomanK", 34);
        service.saveStudent(romanK);

        Student danila = mainHW.createStudent("Danila", 27);
        service.saveStudent(danila);

        Student sviatoslav = mainHW.createStudent("Sviatoslav", 35);
        service.saveStudent(sviatoslav);

        Student pavel = mainHW.createStudent("Pavel", 30);
        service.saveStudent(pavel);

        Student petr = mainHW.createStudent("Petr", 32);
        service.saveStudent(petr);
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

        service.addStudentForCourse(pavel, dataBase);

        service.addStudentForCourse(petr, spring);
        service.addStudentForCourse(petr, dataBase);
        System.out.println("---end_take_students_a_courses---");

        service.deleteStudent(sviatoslav, hibernate);
        service.deleteStudent(sviatoslav, spring);

        service.addStudentForCourse(sviatoslav, dataBase);
        service.addStudentForCourse(sviatoslav, spring);
        System.out.println("__________________________________");

        System.out.println("--------metod1-----");
        service.getTeacher(1);
        System.out.println("--------metod2-----");
        service.getTeacher1(teacherSergey);
        System.out.println("__________________________________");

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