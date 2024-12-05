package service;

import entity.Athlete;
import repository.AthleteRepository;

import java.time.LocalDate;
import java.util.List;

public class AthleteService {
    AthleteRepository athleteRepository = new AthleteRepository();
    Athlete athlete = new Athlete();
    public void create(String nome, String cognome, int eta, LocalDate data_nascita,int altezza) {

        athlete.setNome(nome);
        athlete.setCognome(cognome);
        athlete.setEta(eta);
        athlete.setDataNascita(data_nascita);
        athlete.setAltezza(altezza);
        athleteRepository.create(athlete);
    }

    public List<Athlete> read(){
        return athleteRepository.read();
    }
    public  void update(String nome, String cognome, int eta, LocalDate data_nascita, int altezza,int id){
        athlete.setNome(nome);
        athlete.setCognome(cognome);
        athlete.setEta(eta);
        athlete.setDataNascita(data_nascita);
        athlete.setAltezza(altezza);
        athlete.setId(id);

        athleteRepository.update(athlete);
    }

    public void delete ( int id){
        athlete.setId(id);
        athleteRepository.delete(athlete);
    }
}
