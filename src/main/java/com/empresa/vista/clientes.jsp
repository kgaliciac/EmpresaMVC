<%-- 
    Document   : clientes
    Created on : 18/09/2026, 6:21:52 p. m.
    Author     : kathy
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Clientes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css">
</head>
<body class="container">
    <h1>Lista de Clientes</h1>
    <form action="ClienteServlet" method="post" class="mb-3">
        <input type="text" name="nombre" placeholder="Nombre" class="form-control mb-2">
        <input type="email" name="email" placeholder="Email" class="form-control mb-2">
        <button type="submit" class="btn btn-primary">Agregar Cliente</button>
    </form>

    <table class="table table-striped">
        <tr><th>ID</th><th>Nombre</th><th>Email</th></tr>
        <c:forEach var="c" items="${listaClientes}">
            <tr>
                <td>${c.id}</td>
                <td>${c.nombre}</td>
                <td>${c.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
