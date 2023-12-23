<%@page import="dao.SouvDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Souv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gestión de Stock</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Stock de Souvenires</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tipo</th>
                        <th>Nombre</th>
                        <th>Descripción</th>                        
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        SouvDAO souvDAO = new SouvDAO();
                        List<Souv> souvenirs = souvDAO.obtenerTodos();

                        if (souvenirs != null && !souvenirs.isEmpty()) {
                            for (Souv souv : souvenirs) {
                    %>
                    <tr>
                        <td><%= souv.getIdSouvenirs()%></td>
                        <td><%= souv.getTipo()%></td>
                        <td><%= souv.getNombre()%></td>
                        <td><%= souv.getDescripcion()%></td>
                        
                        <td>
                            <div class="d-flex">
                                
                                
                                
                                <!-- Formulario para actualizar -->
                                <form action="GestionSouvenServlet" method="post" class="mr-2">
                                    <input type="hidden" name="accion" value="actualizar">
                                    <input type="hidden" name="id" value="<%= souv.getIdSouvenirs()%>">
                                    <button type="submit" class="btn btn-warning btn-block">Actualizar</button>
                                </form>

                                <!-- Formulario para eliminar -->
                                <form action="GestionSouvenServlet" method="post">
                                    <input type="hidden" name="accion" value="eliminar">
                                    <input type="hidden" name="id" value="<%= souv.getIdSouvenirs()%>">
                                    <button type="submit" class="btn btn-danger btn-block">Eliminar</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="6">No hay souvenirs en stock.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>


