import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static void buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Usuario.class);

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static void openSession() {
        session = sessionFactory.openSession();
    }

    public static Session getCurrentSession() {

        if ((session == null) || (!session.isOpen()))
            openSession();

        return session;
    }

    public static void closeSessionFactory() {

        if (session != null)
            session.close();

        if (sessionFactory != null)
            sessionFactory.close();
    }
}
