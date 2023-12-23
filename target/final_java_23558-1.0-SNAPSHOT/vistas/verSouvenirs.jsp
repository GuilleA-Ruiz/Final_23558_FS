

<%@page import="dao.SouvDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Souv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Souvenirs</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Lista de Souvenirs</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tipo</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                    </tr>
                </thead>
                <tbody> 
                    <%
                        // Crear una instancia de SouvDAO para acceder a la base de datos
                        SouvDAO souvDAO = new SouvDAO();

                        // Obtener la lista de souvenires desde la base de datos
                        List<Souv> souvenirs = souvDAO.obtenerTodos();

                        if (souvenirs != null && !souvenirs.isEmpty()) {
                            // Iterar sobre la lista de souvenirs y mostrar sus datos en la tabla
                            for (Souv souv : souvenirs) {
                    %>
                    <tr>
                        <td><%= souv.getIdSouvenirs()%></td>
                        <td><%= souv.getTipo()%></td>
                        <td><%= souv.getNombre()%></td>
                        <td><%= souv.getDescripcion()%></td>
                        
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="5">No hay souvenirs en stock.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <!-- Botón para volver al índice -->
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>


