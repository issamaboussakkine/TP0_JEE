package ma.issam.listener;

// Issam : Import Hibernate Util
import ma.issam.util.HibernateUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Issam : Ecouteur de contexte pour initialiser et fermer Hibernate
 * TP JEE - Issam
 */
@WebListener
public class IssamHibernateListener implements ServletContextListener {

    /**
     * Issam : Initialisation de Hibernate au démarrage de l'application
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            HibernateUtil.getSessionFactory();
            System.out.println("Hibernate OK - Issam");
        } catch (Exception e) {
            System.err.println("Erreur Hibernate - Issam: " + e.getMessage());
        }
    }

    /**
     * Issam : Fermeture de Hibernate à l'arrêt de l'application
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            HibernateUtil.shutdown();
            System.out.println("Hibernate fermé - Issam");
        } catch (Exception e) {
            System.err.println("Erreur fermeture Hibernate - Issam: " + e.getMessage());
        }
    }
}