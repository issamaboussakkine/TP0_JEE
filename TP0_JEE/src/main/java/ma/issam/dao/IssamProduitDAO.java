package ma.issam.dao;

import ma.issam.entities.IssamProduit;
import ma.issam.util.HibernateUtil;
import ma.issam.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class IssamProduitDAO extends IssamGenericDAOImpl<IssamProduit, Long> {

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