package service;

import entity.Sports;
import repository.SportsRepository;

import java.util.List;

public class SportsService {

    SportsRepository sportsRepository = new SportsRepository();
    Sports sports = new Sports();

    public void create(String nome_sport) {

        sports.setNomeSport(nome_sport);

        sportsRepository.create(sports);

    }

    public List<Sports> read(){

        return sportsRepository.read();
    }
    public void update(int id,String nome_sport){
        sports.setId(id);
        sports.setNomeSport(nome_sport);
        sportsRepository.update(sports);
    }



    public void delete(int id){
        sports.setId(id);

        sportsRepository.delete(sports);
    }
}
