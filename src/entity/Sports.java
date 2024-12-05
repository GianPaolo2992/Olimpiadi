package entity;

import java.util.ArrayList;
import java.util.List;

public class Sports {

    private int id;
    private String nome_sport;
    private List<Discipline> discipline = new ArrayList<>();

    public int getId(){
        return  id;
    }

    public void setId(int id){
        this.id = id;
    }
    public String  getNomeSport(){
        return nome_sport;
    }
    public void setNomeSport(String sport){
        this.nome_sport = sport;
    }

    public List<Discipline> getDiscipline() {
        return discipline;
    }

    public void addDisciplina(Discipline disciplina) {
        this.discipline.add(disciplina);
        disciplina.setSport(this);
        }

    public String toString(){
        return "ID = " + getId() + "/" + " Categoria Sport " + getNomeSport();
    }
}
