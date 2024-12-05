package service;

import com.sun.org.glassfish.gmbal.GmbalException;
import entity.Athlete;
import entity.Discipline;
import entity.Game;
import repository.GameRepository;

import java.util.List;

public class GameService {
    GameRepository gameRepository = new GameRepository();
    Athlete athlete = new Athlete();
    Discipline discipline = new Discipline();
    Game game = new Game();

    public void create_associaGaraAtleta(int athlete_id, int discipline_id) {
        athlete.setId(athlete_id);
        discipline.setId(discipline_id);

        Game game = new Game();
        game.setIdAthlete(athlete_id);
        game.setIdDisciplina(discipline_id);


        athlete.addListaGame(game);
        discipline.addListaGame(game);
        gameRepository.create_AssociaGaraAtleta(athlete, discipline);
    }

    public List<Game> readGame() {
        return gameRepository.readGare();
    }

    public void updateGame(int athlete_id, int discipline_id, int id) {

        Athlete athlete = new Athlete();
        athlete.setId(athlete_id);

        Discipline discipline = new Discipline();
        discipline.setId(discipline_id);

        Game game = new Game();
        game.setId(id);

        List<Game> oldGames = gameRepository.findByAthleteId(athlete_id);
        for (Game oldGame : oldGames) {
            if (oldGame.getId() == id) {
                Athlete oldAthlete = new Athlete();
                oldAthlete.setId(oldGame.getIdAthlete());
                oldAthlete.removeGame(oldGame);

                Discipline oldDiscipline = new Discipline();
                oldDiscipline.setId(oldGame.getIdDisciplina());
                oldDiscipline.removeGame(oldGame);

                break;
            }
        }


        athlete.addListaGame(game);
        discipline.addListaGame(game);


        gameRepository.updateGame(athlete, discipline, game);
    }

        public Athlete getAthleteWithGames(int athleteId) {
            Athlete athlete = new Athlete();
            athlete.setId(athleteId);

            List<Game> listaGame = gameRepository.findByAthleteId(athleteId);
            for (Game game : listaGame) {
                athlete.addListaGame(game);
            }

            return athlete;
        }





    public void deleteGame(int id) {
        // Trova il game esistente
        Game game = new Game();
        game.setId(id);

        // Recupera le vecchie relazioni
        List<Game> oldGames = gameRepository.findByAthleteId(game.getIdAthlete());
        for (Game oldGame : oldGames) {
            if (oldGame.getId() == id) {
                // Rimuove il game dalle liste degli oggetti Athlete e Discipline
                Athlete athlete = new Athlete();
                athlete.setId(oldGame.getIdAthlete());
                athlete.removeGame(oldGame);

                Discipline discipline = new Discipline();
                discipline.setId(oldGame.getIdDisciplina());
                discipline.removeGame(oldGame);

                break;
            }
        }

        // Elimina il game dal database
        gameRepository.deleteGame(game);
    }

}
