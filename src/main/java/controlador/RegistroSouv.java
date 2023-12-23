package controlador;

import dao.SouvDAO;
import modelo.Souv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registroSouv")
public class RegistroSouv extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener datos del formulario
        String tipo = request.getParameter("tipo");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        // Crear un objeto Souvenir con los datos
        Souv souvenirs = new Souv();
        souvenirs.setTipo(tipo);
        souvenirs.setNombre(nombre);
        souvenirs.setDescripcion(descripcion);

        // Agregar el souvenir a la base de datos
        SouvDAO souvDAO = new SouvDAO();
        souvDAO.agregarSouv(souvenirs);

        // Redireccionar a la página de visualización de souvenirs
        response.sendRedirect(request.getContextPath() + "/vistas/verSouvenirs.jsp");
    }
}

