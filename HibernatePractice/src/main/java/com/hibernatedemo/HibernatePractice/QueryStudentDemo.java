package com.hibernatedemo.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory fac = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();;
        Session session = fac.getCurrentSession();
        try {
        //create the student object
            int s = 2;
            System.out.println("Create a Student Object");
//            Student tempStudent = new Student("Daffy","Duck","daffy@gm.c");
//            Student tempStudent1 = new Student("son","gupta","gp@gm.c");
            //start a transaction
            session.beginTransaction();
            //save the Student Object
//            System.out.println("Saving the student...");
//            System.out.println(tempStudent);
//            session.save(tempStudent1);
//            session.save(tempStudent);
//            //commit transaction
//            session.getTransaction().commit();
//            session.close();
//            //My New Code
//            System.out.println("Saved Student. Generated id: "+tempStudent.getId());
//            //now get a new session and start transaction
//            session = fac.getCurrentSession();
//            session.beginTransaction();
            //retrieve the student based on the id: Primary key

            Student myStudent = session.get(Student.class, s);
            myStudent.setFirstName("Juui");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
        }
    }
}
