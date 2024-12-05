package repository;

import config.DbConnection;
import entity.Sports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SportsRepository {


    public void create(Sports sport){

        try {
            Connection c = DbConnection .openConnection();
            System.out.println("Connessione Riuscita");
            String query = "INSERT INTO sports (nome_sport) VALUES (?)";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1,sport.getNomeSport());
            pstmt.executeUpdate();
            pstmt.close();

        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }

    public List<Sports> read() {
        List<Sports> listaSport = new ArrayList<>();
        try{
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "SELECT * FROM sports ORDER BY id ASC";
            PreparedStatement pstmt = c.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Sports sports = new Sports();
                sports.setId(rs.getInt("id"));
                sports.setNomeSport(rs.getString("nome_sport"));
                listaSport.add(sports);

            }
            pstmt.close();
        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaSport;
    }
    public void update(Sports sport){
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "UPDATE sports " +
                            "SET nome_sport = ? " +
                            "WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1, sport.getNomeSport());
            pstmt.setInt(2,sport.getId());
            pstmt.executeUpdate();
            pstmt.close();

        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }


    public void delete(Sports sport){
        try{
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "DELETE FROM sports WHERE id = ?";

            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setInt(1,sport.getId());
            pstmt.executeUpdate();
            pstmt.close();

        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }


}
