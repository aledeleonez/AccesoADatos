import org.hibernate.Session;

public class Main {
    public static void main(String[] args){

        HibernateUtil hibernateUtil = new HibernateUtil();

        Usuario usuario1 = new Usuario(null, "Alejandro", "1234", "aledeleonez", "ale@gmail.com");

        hibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(usuario1);
        session.getTransaction().commit();
        session.close();

    }
}
