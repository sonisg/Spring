package com.hibernatedemo.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyUnidirecEX {

    public static void main(String[] args) {

        SessionFactory fac = new Configuration().configure().
                addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                buildSessionFactory();
        Session session = fac.getCurrentSession();
        try {

            session.beginTransaction();

            Course course = new Course("French");

            Review r1 = new Review("Boring");
            Review r2 = new Review("traditional");

            course.addReview(r1);
            course.addReview(r2);

            session.save(course);

            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
