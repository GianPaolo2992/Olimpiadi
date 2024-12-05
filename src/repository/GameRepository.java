package repository;

import config.DbConnection;
import entity.Athlete;
import entity.Discipline;
import entity.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    public void create_AssociaGaraAtleta(Athlete athlete, Discipline discipline){
        try{
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "INSERT INTO game (athlete_id , discipline_id) VALUES(?,?)";

            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setInt(1,athlete.getId());
            pstmt.setInt(2,discipline.getId());
            pstmt.executeUpdate();
            pstmt.close();
        }catch (ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public List<Game>  readGare(){
        List<Game> listaGame = new ArrayList<>();

        try{
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione Riuscita");
            String query = "SELECT * FROM game ORDER BY id ASC";
            PreparedStatement pstmt = c.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setIdAthlete(rs.getInt("athlete_id"));
                game.setIdDisciplina((rs.getInt("discipline_id")));

                listaGame.add(game);
            }
        }catch (ClassNotFoundException |SQLException e ){
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaGame;
    }
    public List<Game> findByAthleteId(int athlete_id) {
        List<Game> games = new ArrayList<>();


            try {
                Connection c = DbConnection.openConnection();
                String query = "SELECT * FROM game WHERE athlete_id = ?";
                PreparedStatement pstmt = c.prepareStatement(query);
                pstmt.setInt(1, athlete_id);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {

                    Game game = new Game();
                    game.setId(rs.getInt("id"));
                    game.setIdAthlete(rs.getInt("athlete_id"));
                    game.setIdDisciplina(rs.getInt("discipline_id"));
                    games.add(game);
                }
                pstmt.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return games;
    }


    public void updateGame(Athlete athlete, Discipline discipline, Game game) {
        try (Connection c = DbConnection.openConnection()) {
            System.out.println("Connessione Riuscita");
            String query = "UPDATE game SET athlete_id = ?, discipline_id = ? WHERE id = ?";
            try (PreparedStatement pstmt = c.prepareStatement(query)) {
                pstmt.setInt(1, athlete.getId());
                pstmt.setInt(2, discipline.getId());
                pstmt.setInt(3, game.getId());
                pstmt.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }




    public void deleteGame(Game game) {
        try (Connection c = DbConnection.openConnection()) {
            System.out.println("Connessione Riuscita");
            String query = "DELETE FROM game WHERE id = ?";
            try (PreparedStatement pstmt = c.prepareStatement(query)) {
                pstmt.setInt(1, game.getId());
                pstmt.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

}

