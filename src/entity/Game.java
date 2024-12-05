package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private int id;
    private int idAthlete;
    private int idDisciplina;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAthlete(){
        return  idAthlete;
    }
    public void setIdAthlete(int id){
        this.idAthlete = id;
    }
    public int getIdDisciplina(){
        return  idDisciplina;
    }

    public void setIdDisciplina(int id) {
        this.idDisciplina = id;
    }


   @Override public String toString() { return "Game{id=" + id + ", idAtleta=" + idAthlete + ", idDisciplina=" + idDisciplina + '}'; }
}