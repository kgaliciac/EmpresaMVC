<%-- 
    Document   : productos
    Created on : 18/09/2026, 6:22:54 p. m.
    Author     : kathy
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Productos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h1 class="mb-3">Gestión de Productos</h1>

    <!-- Formulario para agregar producto -->
    <form action="ProductoServlet" method="post" class="mb-4">
        <input type="text" name="nombre" placeholder="Nombre" class="form-control mb-2" required>
        <input type="number" step="0.01" name="precio" placeholder="Precio" class="form-control mb-2" required>
        <input type="number" name="stock" placeholder="Stock" class="form-control mb-2" required>
        <input type="text" name="marca" placeholder="Marca" class="form-control mb-2" required>
        <button type="submit" class="btn btn-success">Agregar Producto</button>
    </form>

    <!-- Tabla de productos -->
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Stock</th><th>Marca</th></tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${listaProductos}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.nombre}</td>
                    <td>${p.precio}</td>
                    <td>${p.stock}</td>
                    <td>${p.marca}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
