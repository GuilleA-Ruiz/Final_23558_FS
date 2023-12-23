package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Souv;
import util.ConexionDB;

public class SouvDAO {
    public void agregarSouv(Souv souvenir) {
        String sql = "INSERT INTO Souvenirs (tipo, nombre, descripcion) VALUES (?, ?, ?)";
        //bloque try-with-resources
        //asegura que los recursos abiertos en su declaración (dentro de los paréntesis) se cierren automáticamente al final del bloque try 
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, souvenir.getTipo());
            pstmt.setString(2, souvenir.getNombre());
            pstmt.setString(3, souvenir.getDescripcion());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Souv obtenerPorId(int id) {
        String sql = "SELECT * FROM souvenirs WHERE id_souvenirs = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Souv souvenirs = new Souv();
                souvenirs.setIdSouvenirs(rs.getInt("id_souvenirs"));
                souvenirs.setTipo(rs.getString("tipo"));
                souvenirs.setNombre(rs.getString("nombre"));
                souvenirs.setDescripcion(rs.getString("descripcion"));
                
                return souvenirs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Souv> obtenerTodos() {
        List<Souv> souvenirs = new ArrayList<>();
        String sql = "select * from Souvenirs";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Souv Souv = new Souv();
                Souv.setIdSouvenirs(rs.getInt("id_souvenirs"));
                Souv.setTipo(rs.getString("tipo"));
                Souv.setNombre(rs.getString("nombre"));
                Souv.setDescripcion(rs.getString("descripcion"));
                
                souvenirs.add(Souv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souvenirs;
    }

    
    
        
    public void actualizarSouvenirs(Souv souvenirs) {
        String sql = "UPDATE souvenirs SET tipo = ?, nombre = ?, descripcion = ? WHERE id_souvenirs = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, souvenirs.getTipo());
            pstmt.setString(2, souvenirs.getNombre());
            pstmt.setString(3, souvenirs.getDescripcion());
            
            pstmt.setInt(5, souvenirs.getIdSouvenirs());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarSouvenir(int id) {
        String sql = "DELETE FROM souvenirs WHERE id_souvenirs = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
   