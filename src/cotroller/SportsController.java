package cotroller;

import entity.Sports;
import service.SportsService;

import java.util.List;
import java.util.Scanner;

public class SportsController {
    Scanner scanner = new Scanner(System.in);
    SportsService sportsService = new SportsService();
    Sports sports = new Sports();
    public void  create(){
        System.out.println("inserisciil nome della categoria dello sport");
        String nome_sport = scanner.nextLine();

        sportsService.create(nome_sport);

    }

    public void read(){

        List<Sports> listaSport = sportsService.read();

        System.out.println("ecco una lista di sport");

        for(Sports s : listaSport){

            System.out.println(s.toString());
        }
        sportsService.read();
    }
    public void update(){
        read();
        System.out.println("inserisci l'ID dello sport da aggiornate");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("digita il nome della categoria dello sport da aggiornate");
        String nome_sport = scanner.nextLine();

        sportsService.update(id,nome_sport);


    }

    public void delete(){
       read();
        System.out.println("inserisdìci l'ID corrispondente allo sport da eliminare");
        int id = scanner.nextInt();
        scanner.nextLine();

        sportsService.delete(id);
    }
}
