package ma.issam.entities;

// Issam : Imports JPA pour la persistance
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Issam : Entité Produit - Gestion des produits de l'inventaire
 * Table : produits_issam
 */
@Entity
@Table(name = "produits_issam")
public class IssamProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prix;

    @Column(name = "quantite_stock", nullable = false)
    private Integer quantiteStock;

    @Column(name = "reference", unique = true, length = 50)
    private String reference;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation")
    private Date dateCreation;

    // Issam : Constructeur par défaut
    public IssamProduit() {
        this.dateCreation = new Date();
    }

    // Issam : Constructeur avec paramètres
    public IssamProduit(String nom, String description, BigDecimal prix, Integer quantiteStock, String reference) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.reference = reference;
        this.dateCreation = new Date();
    }

    // Issam : Constructeur avec double (pour compatibilité)
    public IssamProduit(String nom, String description, double prix, int quantite, String sku) {
    }

    // Issam : Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrix() { return prix; }
    public void setPrix(BigDecimal prix) { this.prix = prix; }
    public Integer getQuantiteStock() { return quantiteStock; }
    public void setQuantiteStock(Integer quantiteStock) { this.quantiteStock = quantiteStock; }
    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    // Issam : toString personnalisé
    @Override
    public String toString() {
        return "IssamProduit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", reference=" + reference + "]";
    }

    // Issam : Méthodes utilitaires (pour compatibilité)
    public void setQuantite(int quantite) {
    }

    public void setSku(String sku) {
    }
}