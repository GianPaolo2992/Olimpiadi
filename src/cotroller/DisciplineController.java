package cotroller;


import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import entity.Discipline;
import service.DisciplineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisciplineController {
    Scanner scanner = new Scanner(System.in);
    DisciplineService disciplineService = new DisciplineService();
    SportsController sportsController = new SportsController();
    public void create(){

        System.out.println("digita il nome della disciplina da inserire");
        String disciplina = scanner.nextLine();

        System.out.println("scegli lo sport di apparteneza");
        sportsController.read();


        System.out.println("inserisci id corrispondente allo sport");
        int id_sport = scanner.nextInt();
        scanner.nextLine();

        System.out.println("è uno sport di squadra?");
        System.out.println("1. vero");
        System.out.println("2. falso");
        boolean team_sport = false;
        boolean isValid = false;
        while(!isValid){
            int scelta = scanner.nextInt();
            scanner.nextLine();
            if (scelta == 1){
                team_sport = true;
                isValid = true;
            } else if (scelta == 2) {
                isValid = true;
            }
        }

        disciplineService.create(disciplina,id_sport,team_sport);


    }

    public void read(){
        List<Discipline> listaDiscipline = disciplineService.read();
        System.out.println("ecco una lista delle discipline");
        for(Discipline d : listaDiscipline) {
            System.out.println(d.toString());
        }
        disciplineService.read();
    }

    public void update(){
        read();
        System.out.print("inserisci l'ID corrispondente alla disciplina da aggiornate");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("inserisci il nome della disciplina");
        String disciplina = scanner.nextLine();

        sportsController.read();

        System.out.println("inserisci l'ID della categoria sport da associare a disciplina");
        int id_sport = scanner.nextInt();
        scanner.nextLine();

        System.out.println("è uno sport di squadra?");
        System.out.println("1. vero");
        System.out.println("2. falso");

        boolean team_sport = false;
        boolean isValid = false;
        while(!isValid){
            int scelta = scanner.nextInt();
            scanner.nextLine();
            if (scelta == 1){
                team_sport = true;
                isValid = true;
            } else if (scelta == 2) {
                isValid = true;
            }
        }
        disciplineService.update(id,disciplina,id_sport,team_sport);


    }

    public void delete(){
        read();
        System.out.println("inserisci id per eliminare la disciplina corrispondente");
        int id = scanner.nextInt();
        scanner.nextLine();
        disciplineService.delete(id);
    }

}