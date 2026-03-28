package ma.issam.dao;

// Issam : Imports pour les collections
import java.util.List;
import java.util.Optional;

/**
 * Issam : Interface générique DAO pour les opérations CRUD
 * @param <T> Type de l'entité
 * @param <ID> Type de l'identifiant
 */
public interface IssamGenericDAO<T, ID> {

    // Issam : Créer ou sauvegarder une entité
    void save(T entity);

    // Issam : Mettre à jour une entité existante
    void update(T entity);

    // Issam : Trouver une entité par son identifiant
    Optional<T> findById(ID id);

    // Issam : Récupérer toutes les entités
    List<T> findAll();

    // Issam : Supprimer une entité par son identifiant
    void delete(ID id);

    // Issam : Supprimer une entité directement
    void deleteEntity(T entity);
}