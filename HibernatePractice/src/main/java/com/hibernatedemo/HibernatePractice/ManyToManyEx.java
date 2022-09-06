package com.hibernatedemo.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyEx {

    public static void main(String[] args) {

        SessionFactory fac = new Configuration().configure().
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(Student.class).addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                buildSessionFactory();
        Session session = fac.getCurrentSession();
        try {

            session.beginTransaction();

            /** adding students a course
            //create a course
            Course course = new Course("Badminton");
            session.save(course);

            //add students
            Student s1 = new Student("harry", "prakash", "hpr@gil.c");
            Student s2 = new Student("ruby", "punia", "hry@g.c");

            course.addStudent(s1);
            course.addStudent(s2);

            session.save(s1);
            session.save(s2);
             **/


            /**
            int i = 2;
            Student s1 = session.get(Student.class, i);

            Course c1 = new Course("party");
            Course c2 = new Course("halloween");

            c1.addStudent(s1);
            c2.addStudent(s1);

            session.save(c1);
            session.save(c2);
             **/

            int i = 2;
            Student s1 = session.get(Student.class, i);
            session.delete(s1);


            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
