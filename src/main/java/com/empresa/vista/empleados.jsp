<%-- 
    Document   : empleados
    Created on : 18/09/2026, 6:23:23 p. m.
    Author     : kathy
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Empleados</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h1 class="mb-3">Gestión de Empleados</h1>

    <!-- Formulario para agregar empleado -->
    <form action="EmpleadoServlet" method="post" class="mb-4">
        <input type="text" name="nombre" placeholder="Nombre" class="form-control mb-2" required>
        <input type="text" name="apellidos" placeholder="Apellidos" class="form-control mb-2" required>
        <input type="text" name="puesto" placeholder="Puesto" class="form-control mb-2" required>
        <input type="date" name="fechaContratacion" class="form-control mb-2" required>
        <button type="submit" class="btn btn-primary">Agregar Empleado</button>
    </form>

    <!-- Tabla de empleados -->
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Puesto</th><th>Fecha Contratación</th></tr>
        </thead>
        <tbody>
            <c:forEach var="e" items="${listaEmpleados}">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.nombre}</td>
                    <td>${e.apellidos}</td>
                    <td>${e.puesto}</td>
                    <td>${e.fechaContratacion}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
