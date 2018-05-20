import Domain.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class MyMain {
    private static SessionFactory sessionFactory;

    static void initialize() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            System.out.println("Exceptie "+e);
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    static void close() {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    public static void main(String ... arg) {
        initialize();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            //session.save(new Employee("george123","mihaila",1500));
            //session.save(new Employee("alexandru1245","mihaila",2500));
            session.save(new Users("adminul","admin"));
            session.getTransaction().commit();
        }


        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List result = session.createQuery(" from Employee").list();
            for (Employee e : (List<Employee>) result) {
                System.out.println("Employee (" + e.getFirstName() + ") : " + e.getLastName());
            }
            session.getTransaction().commit();

            session.beginTransaction();
            List result2 = session.createQuery(" from Users").list();
            for (Users e : (List<Users>) result2) {
                System.out.println("Users (" + e.getUsername() + ") : " + e.getPassword());
            }
            session.getTransaction().commit();
        }

        close();
    }
}

