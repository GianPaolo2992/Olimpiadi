package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private int id;
    private List<Discipline> listaGameIdDiscipline = new ArrayList<>();
    private List<Athlete> listaGameIdAthlete = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Athlete> getGameIdAthlete() {
        return listaGameIdAthlete;
    }



    public void addAthlete(Athlete athlete) {
        if (!listaGameIdAthlete.contains(athlete)) {
            listaGameIdAthlete.add(athlete);
        }
    }

    public List<Discipline> getGameIdDiscipline() {
        return listaGameIdDiscipline;
    }

    public void addDoscipline(Discipline discipline) {
        if (!listaGameIdDiscipline.contains(discipline)) {

            listaGameIdDiscipline.add(discipline);
        }
    }
}