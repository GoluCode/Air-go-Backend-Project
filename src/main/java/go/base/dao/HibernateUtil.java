package go.base.dao;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
        	File file = new File("C:\\Shyam Sunder Roy\\Java Workspace\\Air-go-Backend-Project\\src\\main\\resources\\hibernate.cfg.xml");
            Configuration config = new Configuration();
            config.configure(file);
            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}