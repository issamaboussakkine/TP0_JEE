package ma.issam.dao;

// Issam : Imports
import ma.issam.entities.IssamUtilisateur;
import ma.issam.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.Optional;

/**
 * Issam : DAO pour l'entité IssamUtilisateur
 * Hérite des méthodes CRUD génériques
 */
public class IssamUtilisateurDAO extends IssamGenericDAOImpl<IssamUtilisateur, Long> {

    /**
     * Issam : Rechercher un utilisateur par son email (unique)
     * @param email L'email de l'utilisateur
     * @return Optional contenant l'utilisateur s'il existe
     */
    public Optional<IssamUtilisateur> findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<IssamUtilisateur> query = session.createQuery(
                    "from IssamUtilisateur where email = :email", IssamUtilisateur.class);
            query.setParameter("email", email);
            return Optional.ofNullable(query.uniqueResult());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}