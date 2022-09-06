package com.hibernatedemo.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyBiDEx {

    public static void main(String[] args) {

        SessionFactory fac = new Configuration().configure().addAnnotatedClass(Instructor.class).
                addAnnotatedClass(Course.class).
                buildSessionFactory();
        Session session = fac.getCurrentSession();
        try {

            session.beginTransaction();

            /** Saving values
            //get instructor
            int i = 3;
            Instructor ins1 = session.get(Instructor.class, i);

            //add course
            Course tc1 = new Course("Sanskrit");
            Course tc2 = new Course("English");

            //add course to instructor
            ins1.add(tc1);
            ins1.add(tc2);

            //save course
            session.save(tc1);
            session.save(tc2);
             **/

            int i = 10;
            Course c1 = session.get(Course.class, i);

            session.delete(c1);

            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
