<%@page import="modelo.Souv"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Actualizar Souvenir</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Actualizar Souvenir</h2>
            <form action="GestionSouvenServlet" method="post">
                <input type="hidden" name="accion" value="confirmarActualizacion">
                <input type="hidden" name="id" value="${souv.idSouvenirs}">

                <div class="form-group">
                    <label for="nombre">Tipo:</label>
                    <input type="text" class="form-control" id="tipo" name="tipo" value="${souv.tipo}" required>
                </div>

                <div class="form-group">
                    <label for="apellido">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="${souv.nombre}" required>
                </div>

                <div class="form-group">
                    <label for="tema">Descripción</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" value="${souv.descripcion}" required>
                </div>

               
                <button type="submit" class="btn btn-primary">Actualizar</button>
                <a href="gestionSouven.jsp" class="btn btn-success">Volver</a>

            </form>
        </div>
    </body>
</html>