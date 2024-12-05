package cotroller;

import entity.Athlete;
import entity.Discipline;
import entity.Game;
import service.GameService;

import java.util.List;
import java.util.Scanner;

public class GameController {
    Scanner scanner = new Scanner(System.in);
    GameService gameService = new GameService();
    DisciplineController disciplineController = new DisciplineController();
    AthleteController athleteController = new AthleteController();

    public void create_asscociaGaraAtleta() {
        athleteController.read();
        System.out.println("scegli un id di un atleta ");

        int id_athlete = scanner.nextInt();
        scanner.nextLine();

        disciplineController.read();
        System.out.println("scegli un id della gara a cui associare l' atleta appena scelto ");
        int id_discipline = scanner.nextInt();
        scanner.nextLine();


        gameService.create_associaGaraAtleta(id_athlete, id_discipline);

    }

    public void readGame() {
        List<Game> listaGame = gameService.readGame();
        System.out.println("ecco una lista di gare");
        for (Game game : listaGame) {
            System.out.println(game.toString());
        }

    }

    public void updateGame() {
        // Visualizza le gare esistenti
        readGame();
        System.out.println("Scegli l'ID della gara da aggiornare");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Visualizza gli atleti esistenti
        athleteController.read();
        System.out.println("Scegli l'ID del nuovo atleta da associare alla gara");
        int athlete_id = scanner.nextInt();
        scanner.nextLine();

        // Visualizza le discipline esistenti
        disciplineController.read();
        System.out.println("Scegli l'ID della nuova disciplina da associare alla gara");
        int discipline_id = scanner.nextInt();
        scanner.nextLine();

        // Chiama il metodo di aggiornamento nel service
        gameService.updateGame(athlete_id, discipline_id, id);
    }


    public void printGamesForAthlete() {
        System.out.println("Inserisci l'ID dell'atleta per visualizzare le gare assegnate:");
        int athleteId = scanner.nextInt();
        scanner.nextLine();
        Athlete athlete = gameService.getAthleteWithGames(athleteId);
        athlete.printAssignedGames();
    }

    public void deleteGame() {

        readGame();
        System.out.println("Scegli l'ID della gara da eliminare");
        int id = scanner.nextInt();
        scanner.nextLine();


        gameService.deleteGame(id);
    }


}
