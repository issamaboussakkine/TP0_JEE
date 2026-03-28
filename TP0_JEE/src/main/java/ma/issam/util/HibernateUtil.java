package ma.issam.util;

// Issam : Import Hibernate
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // Issam : SessionFactory unique pour l'application
    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Issam : Construction de la SessionFactory
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Erreur SessionFactory - Issam: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Issam : Getter pour la SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Issam : Fermeture de la SessionFactory
    public static void shutdown() {
        getSessionFactory().close();
    }
}