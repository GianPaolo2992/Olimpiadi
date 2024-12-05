package service;

import entity.Discipline;
import repository.DisciplineRepository;

import java.util.List;

public class DisciplineService {
    DisciplineRepository disciplineRepository = new DisciplineRepository();
    Discipline discipline = new Discipline();
    public void create( String disciplina, int id_sport,boolean team_sport){
        discipline.setDisciplina(disciplina);
        discipline.setSportId(id_sport);
        discipline.setTeam_sport(team_sport);

        disciplineRepository.create(discipline);

    }

    public List<Discipline> read(){
        return disciplineRepository.read();

    }
    public void update(int id,String disciplina, int id_sport, boolean team_sport){
        discipline.setId(id);
       discipline.setDisciplina(disciplina);
       discipline.setSportId(id_sport);
       discipline.setTeam_sport(team_sport);
       disciplineRepository.update(discipline);
    }
    public void delete (int id){
        discipline.setId(id);
        disciplineRepository.delete(discipline);
    }
}
