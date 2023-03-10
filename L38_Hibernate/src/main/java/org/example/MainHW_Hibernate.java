package org.example;

import lombok.Builder;
import org.example.component.Course;
import org.example.component.Property;
import org.example.component.Student;
import org.example.component.Teacher;
import org.example.domain.Position;
import org.example.service.UniversityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainHW_Hibernate {
    public static void main(String[] args) {
        MainHW_Hibernate mainHW = new MainHW_Hibernate();

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        UniversityService service = context.getBean(UniversityService.class);

        Teacher teacherSergey = mainHW.createTeacher();
        service.saveTeacher(teacherSergey);

        Course spring = mainHW.createCourse("Spring", new Date(123, 6, 26));
        service.saveCourse(spring);
        System.out.println("----------------");

        Course hibernate = mainHW.createCourse("Hibernate", new Date(123, 7, 27));
        service.saveCourse(hibernate);
        System.out.println("----------------------");

        Course dataBase = mainHW.createCourse("DataBase", new Date(123, 8, 28));
        service.saveCourse(dataBase);
        System.out.println("------------------------------");


        service.addCourseForTeacher(teacherSergey, spring);
        service.addCourseForTeacher(teacherSergey, hibernate);
        service.addCourseForTeacher(teacherSergey, dataBase);

        Student romanK = mainHW.createStudent("RomanK", 34);
        System.out.println("---save_student(" + romanK.getName() + ")---");
        service.saveStudent(romanK);
        System.out.println("---save_student(" + romanK.getName() + ")---");


        System.out.println("__________________________________");


        Teacher teacher = service.getTeacher(1);
        System.out.println(teacher);
        System.out.println("__________________________________");

        Course course = service.getCourse(3);
        System.out.println(course);
        System.out.println("__________________________________");

//        service.deleteTeacher(1);
        System.out.println();
        System.out.println("__________________________________");

//        service.deleteCourse(2);
        System.out.println();
        System.out.println("__________________________________");

        System.out.println();
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
