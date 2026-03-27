package ma.issam.controller;

import ma.issam.dao.IssamProduitDAO;
import ma.issam.entities.IssamProduit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/issam-creer-produit")
public class IssamProductCreateServlet extends HttpServlet {
    private IssamProduitDAO issamProduitDAO;

    public void init() {
        issamProduitDAO = new IssamProduitDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String sku = request.getParameter("sku");

        IssamProduit nouveauProduit = new IssamProduit(nom, description, prix, quantite, sku);
        issamProduitDAO.save(nouveauProduit);

        response.sendRedirect("issam-produits");
    }
}