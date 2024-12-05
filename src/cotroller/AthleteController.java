package cotroller;

import entity.Athlete;
import service.AthleteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AthleteController {
    Scanner scanner =new Scanner(System.in);
    AthleteService athleteService = new AthleteService();
    public void create(){
        System.out.println("inserisci il nome dell' atleta da inserire");
        String nome = scanner.nextLine();

        System.out.println("inserisci il cognome dell' atleta da inserire");
        String cognome = scanner.nextLine();
        System.out.println("inserisci l'età dell' atleta da inserire");
        int eta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("inserisci la data di nascita dell' atleta da inserire");
        String dataNascitaInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate data_nascita = LocalDate.parse(dataNascitaInput,formatter);

        System.out.println("inserisci l' altezza in cm dell' atleta da inserire");
        int altezza = scanner.nextInt();
        scanner.nextLine();

        athleteService.create(nome,cognome,eta,data_nascita,altezza);

    }

    public void read(){
        System.out.println("ecco una lista di atleti");
        List<Athlete> listAthlete = athleteService.read();
        for (Athlete a : listAthlete){
            System.out.println(a.toString());
        }
    }

    public void update(){
        read();
        System.out.println("inserisci l'id dell'atleta da aggiornare");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("didgita il nome dell'atleta da aggiornare");
        String nome = scanner.next();

        System.out.println("didgita il cognome dell'atleta da aggiornare");
        String cognome = scanner.next();

        System.out.println("inserisci l'età dell'atleta da aggiornare");
        int eta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("inserisci la data di nascita dell'atleta da aggiornare");
        String dataNascitaInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate data_nascita = LocalDate.parse(dataNascitaInput,formatter);

        System.out.println("inserisci l'altezza espressa in cm, dell'atleta da aggiornare");
        int altezza = scanner.nextInt();
        scanner.nextLine();

        athleteService.update(nome,cognome,eta,data_nascita,altezza,id);



    }

    public void delete(){
        read();
        System.out.println("scegli l'ID del atleta da eliminare");
        int id = scanner.nextInt();
        scanner.nextLine();

        athleteService.delete(id);
    }
}
