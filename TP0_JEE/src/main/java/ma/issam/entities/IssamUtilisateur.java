package ma.issam.entities;

// Issam : Imports JPA pour la persistance
import jakarta.persistence.*;
import java.util.Date;

/**
 * Issam : Entité Utilisateur - Gestion des utilisateurs
 * Table : utilisateurs_issam
 */
@Entity
@Table(name = "utilisateurs_issam")
public class IssamUtilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 60)
    private String motDePasse;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation")
    private Date dateCreation;

    // Issam : Constructeur par défaut
    public IssamUtilisateur() {
        this.dateCreation = new Date();
    }

    // Issam : Constructeur avec paramètres
    public IssamUtilisateur(String prenom, String nom, String email, String motDePasse) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateCreation = new Date();
    }

    // Issam : Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    // Issam : toString personnalisé
    @Override
    public String toString() {
        return "IssamUtilisateur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + "]";
    }
}