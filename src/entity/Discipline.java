package entity;

import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private int id;
    private String disciplina;
    private Sports sport;
    private boolean team_sport;
    private List<Game> listaGame = new ArrayList<>();

    public List<Game> getListaGame() {
        return listaGame;
    }

    public void addListaGame(Game game) {
        if (!listaGame.contains(game)) {
            listaGame.add(game);
        }
    }

    public void removeGame(Game game) {
        listaGame.remove(game);
    }

    public int getIdSport() {
        return sport.getId();
    }

    public Sports getSport() {
        return sport;
    }

    public void setSport(Sports sport) {
        this.sport = sport;
    }

    public int getSportID() {
        return sport.getId();
    }

    public void setSportId(int id) {
        this.sport = new Sports();
        sport.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public boolean isTeam_sport() {
        return team_sport;
    }

    public void setTeam_sport(boolean team_sport) {
        this.team_sport = team_sport;
    }

    public void printAssignedGames() {
        if (listaGame.isEmpty()) {
            System.out.println("Nessuna gara assegnata a questo atleta.");
        } else {
            System.out.println("tutte le Gare per la disciplina " + disciplina + " " + sport.getNomeSport() + ":");
            for (Game game : listaGame) {
                System.out.println(game.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Discipline{id: " + id + " |disciplina: " + disciplina + " |sport: " + (sport != null ? sport.getNomeSport() : " null") +  " |team_sport " + team_sport;
    }


    }