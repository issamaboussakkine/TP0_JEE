<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion Stock - Issam ABOUSSAKKINE</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        .navbar-issam {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        }
        .footer-issam {
            background: linear-gradient(135deg, #2d3748 0%, #1a202c 100%);
        }
        h1, h2 {
            color: #5a67d8;
        }
        .btn-issam {
            background-color: #5a67d8;
            border-color: #5a67d8;
        }
        .btn-issam:hover {
            background-color: #4c51bf;
        }
    </style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark navbar-issam">
            <div class="container">
                <a class="navbar-brand" href="<%= request.getContextPath() %>/issam-index.jsp">
                    <strong>ISSAM INVENTORY v1.0</strong>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"></button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                                Utilisateurs
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<%= request.getContextPath() %>/issam-utilisateurs">Liste des Utilisateurs</a>
                                <a class="dropdown-item" href="<%= request.getContextPath() %>/issam-utilisateur-form">Ajouter Utilisateur</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                                Produits
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<%= request.getContextPath() %>/issam-produits">Catalogue Produits</a>
                                <a class="dropdown-item" href="<%= request.getContextPath() %>/issam-produit-form">Nouveau Produit</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="container mt-5">