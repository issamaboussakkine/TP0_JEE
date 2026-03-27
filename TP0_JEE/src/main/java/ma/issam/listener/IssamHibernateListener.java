package ma.issam.listener;

import ma.issam.util.HibernateUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Ecouteur de contexte pour initialiser et fermer Hibernate.
 * Développé par Issam ABOUSSAKKINE pour le TP JEE.
 */
@WebListener
public class IssamHibernateListener implements ServletContextListener {

    /**
     * Méthode appelée au démarrage de l'application.
     * Initialise la SessionFactory Hibernate.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            HibernateUtil.getSessionFactory();
            System.out.println("Hibernate initialisé avec succès - Issam ABOUSSAKKINE");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'initialisation de Hibernate : " + e.getMessage());
        }
    }

    /**
     * Méthode appelée à l'arrêt de l'application.
     * Ferme proprement la SessionFactory Hibernate.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            HibernateUtil.shutdown();
            System.out.println("Hibernate fermé correctement - Issam ABOUSSAKKINE");
        } catch (Exception e) {
            System.err.println("Erreur lors de la fermeture de Hibernate : " + e.getMessage());
        }
    }
}