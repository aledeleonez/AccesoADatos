import org.hibernate.Session;

public class Main {
    public static void main(String[] args){

        Usuario usuario1 = new Usuario(null, "Alejandro", "1234", "aledeleonez", "ale@gmail.com");
        agregarUsuario(usuario1);
        //eliminarUsuario(usuario1);

    }

    private static void agregarUsuario(Usuario usr){
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(usr);
        session.getTransaction().commit();
        session.close();
    }

    private static void eliminarUsuario(Usuario usr){
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.delete(usr);
        session.getTransaction().commit();
        session.close();
    }
}
