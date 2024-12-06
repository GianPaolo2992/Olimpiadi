package repository;

import config.DbConnection;
import entity.Athlete;
import entity.Discipline;
import entity.Sports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplineRepository {
    Discipline discipline = new Discipline();

    public void create(Discipline discipline) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = " INSERT INTO discipline (disciplina,id_sport,team_sport ) VALUES(?,?,?)";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1, discipline.getDisciplina());
            pstmt.setInt(2,discipline.getIdSport());
            pstmt.setBoolean(3,discipline.isTeam_sport());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (ClassNotFoundException | SQLException e ){
            System.err.println(e.getMessage());
            System.exit(0);
        }


    }

    public List<Discipline> rea() {
        List<Discipline> listaDiscipline = new ArrayList<>();
        String query = "SELECT d.* FROM discipline d " +
                " ORDER BY id ASC";
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery())//try-with-resouces chiude automaticamente le risorse tra le parentesi alla fine del blocco try
        {

            System.out.println("Connessione Riuscita");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDisciplina(rs.getString("disciplina"));
                discipline.setSportId(rs.getInt("id_sport"));
                discipline.setTeam_sport(rs.getBoolean("team_sport"));


                listaDiscipline.add(discipline);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return listaDiscipline;
    }


    public List<Discipline> read() {
        List<Discipline> listaDiscipline = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "SELECT d.*, s.nome_sport FROM discipline d " +
                    "JOIN sports s ON s.id = d.id_sport " +
                    " ORDER BY d.id ASC" ;
            PreparedStatement pstmt = c.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDisciplina(rs.getString("disciplina"));
                discipline.setSportId(rs.getInt("id_sport"));
                discipline.setTeam_sport(rs.getBoolean("team_sport"));
                Sports sports = new  Sports();
                sports.setId(rs.getInt("id"));
                sports.setNomeSport(rs.getString("nome_sport"));
                discipline.setSport(sports);

                listaDiscipline.add(discipline);
            }
            pstmt.close();


        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);

        }
        return listaDiscipline;
    }

    public void update(Discipline discipline){
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "UPDATE discipline " +
                           "SET disciplina = ? , id_sport = ? , team_sport = ? " +
                           "WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1,discipline.getDisciplina());
            pstmt.setInt(2,discipline.getIdSport());
            pstmt.setBoolean(3,discipline.isTeam_sport());
            pstmt.setInt(4,discipline.getId());

            pstmt.executeUpdate();
            pstmt.close();


        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void delete(Discipline discipline) {
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("connessione Riuscita");
            String query = "DELETE FROM discipline WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setInt(1, discipline.getId());
            pstmt.executeUpdate();
            pstmt.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);


        }

    }

    public Discipline findById(int discipline_id){
        Discipline discipline = new Discipline();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("connessione Riuscita");
            String query = "SELECT d.*,s.nome_sport FROM discipline d " +
                    "JOIN sports s ON d.id_sport = s.id " +
                    "WHERE d.id = ? ";
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setInt(1, discipline_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                discipline.setId(rs.getInt("id"));
                discipline.setDisciplina(rs.getString("disciplina"));
                discipline.setSportId(rs.getInt("id_sport"));
                discipline.setTeam_sport(rs.getBoolean("team_sport"));
                Sports sports = new Sports();
                sports.setId(rs.getInt("id"));
                sports.setNomeSport(rs.getString("nome_sport"));
                discipline.setSport(sports);


            }
            pstmt.close();
        }catch (ClassNotFoundException|SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return discipline;
    }
}
