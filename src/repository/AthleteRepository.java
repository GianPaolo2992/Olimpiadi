package repository;

import config.DbConnection;
import entity.Athlete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AthleteRepository {

    public void create(Athlete athlete){

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "INSERT INTO athlete (nome,cognome,eta,data_nascita,altezza) " +
                    " VALUES(?,?,?,?,?) ";
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setString(1,athlete.getNome());
            pstmt.setString(2,athlete.getCognome());
            pstmt.setInt(3,athlete.getEta());
            pstmt.setDate(4,java.sql.Date.valueOf(athlete.getDataNascita()));
            pstmt.setInt(5,athlete.getAltezza());
            pstmt.executeUpdate();
            pstmt.close();

        }catch (ClassNotFoundException| SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }
    public List<Athlete> read(){
        List<Athlete> listAthlete = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "SELECT * FROM athlete a ORDER BY a.id ASC";
            PreparedStatement pstmt = c.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
            Athlete athlete = new Athlete();
            athlete.setId(rs.getInt("id"));
            athlete.setNome(rs.getString("nome"));
            athlete.setCognome(rs.getString("cognome"));
            athlete.setEta(rs.getInt("eta"));
            athlete.setDataNascita(rs.getDate("data_nascita").toLocalDate());
            athlete.setAltezza(rs.getInt("altezza"));
            listAthlete.add(athlete);
            }



        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return  listAthlete;
    }

    public void update(Athlete athlete){
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "UPDATE athlete " +
                           "SET nome = ?,cognome=?,eta=?,data_nascita = ?, altezza = ? " +
                           "WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1,athlete.getNome());
            pstmt.setString(2,athlete.getCognome());
            pstmt.setInt(3,athlete.getEta());
            pstmt.setDate(4,java.sql.Date.valueOf(athlete.getDataNascita()));
            pstmt.setInt(5,athlete.getAltezza());
            pstmt.setInt(6,athlete.getId());
            pstmt.executeUpdate();
            pstmt.close();

        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public void delete(Athlete athlete){
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("connessione Riuscita");
            String query = "DELETE FROM athlete WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setInt(1,athlete.getId());
            pstmt.executeUpdate();
            pstmt.close();

        }catch (ClassNotFoundException|SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
