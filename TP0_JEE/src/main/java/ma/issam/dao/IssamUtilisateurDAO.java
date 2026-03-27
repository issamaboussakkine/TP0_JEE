package ma.issam.dao;

import ma.issam.entities.IssamUtilisateur;
import ma.issam.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.Optional;

public class IssamUtilisateurDAO extends IssamGenericDAOImpl<IssamUtilisateur, Long> {

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