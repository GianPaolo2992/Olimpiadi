package entity;

public class Discipline {
    private int id;
    private String disciplina;
    private Sports sport;
    private boolean team_sport;

    public int getIdSport() {
        return sport.getId();
    }

    public Sports getSport() {
        return sport;
    }
    public void setSport( Sports sport){
        this.sport = sport;
    }
    public int getSportID(){
        return sport.getId();
    }
    public void setSportId(int id){
        this.sport = new Sports();
        sport.setId(id);
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina(){
        return  disciplina;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    public boolean isTeam_sport() {
        return team_sport;
    }

    public void setTeam_sport(boolean team_sport) {
        this.team_sport = team_sport;
    }

    @Override
    public String toString(){
        return "id = " + getId() + " / " +
                " disciplina " + getDisciplina() + " / " +
                " id sport " + getSportID() + " / " +
                "sport di squadra " + isTeam_sport();

    }


}