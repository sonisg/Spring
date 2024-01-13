package com.hibernatedemo.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateQuery {

    public static void main(String[] args) {

        SessionFactory fac = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = fac.getCurrentSession();
        try {

            session.beginTransaction();

            //query
            List<Student> students = session.createQuery("from Student").getResultList();

            //display
//            System.out.println("The Students");;
//            displayStudents(students);
//
//            students = session.createQuery("from Student s where s.lastName ='gupta'").getResultList();
//            System.out.println("Last NAME");
//            displayStudents(students);
//
//            students = session.createQuery("from Student s where s.lastName ='gupta' or s.firstName = 'Daffy'").getResultList();
//            System.out.println("OR query");
//            displayStudents(students);
//
//            students = session.createQuery("from Student s where s.email LIKE '%gm.c'").getResultList();
//            System.out.println("Like query");
//            displayStudents(students);

            session.createQuery("update Student s set s.email = 'foo@g.c'").executeUpdate();
            //commit
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student theStudent : theStudents) {
            System.out.println(theStudent);
        }
    }
}
