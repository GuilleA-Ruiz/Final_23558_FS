
package controlador;

import dao.SouvDAO;
import modelo.Souv;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/vistas/GestionSouvenServlet")
public class GestionSouvenServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        SouvDAO souvDAO = new SouvDAO();

        // Inicializar idSouvenirs antes del switch para que esté disponible en todos los casos
        int idSouvenirs = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            //case "agregar":
             //   response.sendRedirect("RegistroSouv.java");
                
              //  break;
            case "actualizar":
                Souv souv = souvDAO.obtenerPorId(idSouvenirs);
                request.setAttribute("souvenir", souv); //Esto permite pasar datos del servlet a una vista (como un archivo JSP) o a otro servlet al que se redirige o se reenvía la solicitud
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "confirmarActualizacion":
                Souv souvActualizado = new Souv();
                souvActualizado.setIdSouvenirs(idSouvenirs);
                souvActualizado.setTipo(request.getParameter("tipo"));
                souvActualizado.setNombre(request.getParameter("nombre"));
                souvActualizado.setDescripcion(request.getParameter("descripción"));
                // Asume que el método setFechaAlta acepta un java.sql.Date

                souvDAO.actualizarSouvenirs(souvActualizado);
                response.sendRedirect("gestionSouven.jsp");
                break;
            case "eliminar":
                souvDAO.eliminarSouvenir(idSouvenirs);
                response.sendRedirect("gestionSouven.jsp");
                break;
            default:
                response.sendRedirect("gestionSouven.jsp");
                break;
        }
    }
}

