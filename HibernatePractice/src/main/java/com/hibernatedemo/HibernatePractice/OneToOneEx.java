package com.hibernatedemo.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOneEx {

    public static void main(String[] args) {

        SessionFactory fac = new Configuration().configure().addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();
        Session session = fac.getCurrentSession();
        try {

            /**One to One Mapping Uni-directional**/
            /**saving an object**/
            //create object
//            Instructor ins1 = new Instructor("Riya", "Raina", "riyaraina@gmail.com");
//            InstructorDetail ins2 = new InstructorDetail("riyaraina.youTube", "guitar");
//
//            //associate object
//            ins1.setInstructor_id(ins2);
//
//            session.beginTransaction();
//
//            session.save(ins1);

            /**Delete an entity**/
//            int id = 1;
//            session.beginTransaction();
//
//            Instructor tem1 = session.get(Instructor.class, id);
//
//            if(tem1 != null){
//                session.delete(tem1);
//                System.out.println("Deleted");
//            }

            /**One to One Bidirectional**/

//            session.beginTransaction();
//
//            try {
//                int i = 88;
//                InstructorDetail ins1 = session.get(InstructorDetail.class, i);
//
//                //print
//                System.out.println("InstructorDetail" + ins1);
//
//                System.out.println("Instructor: " + ins1.getInstructor());
//
//                //commit
//                session.getTransaction().commit();
//
//                System.out.println("Done!");
//            }
//            catch(RuntimeException e){
//                e.printStackTrace();
//            }

            session.beginTransaction();

            int i =3;
            InstructorDetail ins1 = session.get(InstructorDetail.class, i);
            //ins1.getInstructor().setInstructor_id(null);

            session.delete(ins1);

            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
