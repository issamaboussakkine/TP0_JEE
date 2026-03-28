package ma.issam.dao;

// Issam : Imports
import ma.issam.entities.IssamProduit;
import ma.issam.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

/**
 * Issam : DAO pour l'entité IssamProduit
 * Hérite des méthodes CRUD génériques
 */
public class IssamProduitDAO extends IssamGenericDAOImpl<IssamProduit, Long> {

    /**
     * Issam : Rechercher un produit par sa référence (unique)
     * @param reference La référence du produit
     * @return Optional contenant le produit s'il existe
     */
    public Optional<IssamProduit> findByReference(String reference) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<IssamProduit> query = session.createQuery(
                    "from IssamProduit where reference = :ref", IssamProduit.class);
            query.setParameter("ref", reference);
            return Optional.ofNullable(query.uniqueResult());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * Issam : Rechercher des produits par mot-clé (dans nom ou description)
     * @param motCle Le mot-clé à rechercher
     * @return Liste des produits correspondants
     */
    public List<IssamProduit> findByNomContaining(String motCle) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<IssamProduit> query = session.createQuery(
                    "from IssamProduit where lower(nom) like lower(:mot) or lower(description) like lower(:mot)",
                    IssamProduit.class);
            query.setParameter("mot", "%" + motCle + "%");
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}