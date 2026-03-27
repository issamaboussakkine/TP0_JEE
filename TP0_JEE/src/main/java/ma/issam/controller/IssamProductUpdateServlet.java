package ma.issam.controller;

import ma.issam.dao.IssamProduitDAO;
import ma.issam.entities.IssamProduit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

@WebServlet("/issam-modifier-produit")
public class IssamProductUpdateServlet extends HttpServlet {
    private IssamProduitDAO issamProduitDAO;

    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String sku = request.getParameter("sku");

        Optional<IssamProduit> optionalProduit = issamProduitDAO.findById((long) id);
        if (optionalProduit.isPresent()) {
            IssamProduit produit = optionalProduit.get();
            produit.setNom(nom);
            produit.setDescription(description);
            produit.setPrix(BigDecimal.valueOf(prix));
            produit.setQuantite(quantite);
            produit.setSku(sku);
            issamProduitDAO.update(produit);
        }

        response.sendRedirect("issam-produits");
    }
}