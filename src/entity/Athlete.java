package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Athlete {
    private int id;
    private String nome;
    private String cognome;
    private int eta;
    private LocalDate data_nascita;
    private int altezza;
    private List<Game> listaGame = new ArrayList<>();

    public List<Game> getListaGame(){
        return listaGame;
    }
    public void addListaGame(Game game){
        if (!listaGame.contains(game)){
            listaGame.add(game);
        }
    }
    public void printAssignedGames() {
        if (listaGame.isEmpty()) {
            System.out.println("Nessuna gara assegnata a questo atleta.");
        } else {
            System.out.println("Gare assegnate all'atleta " + nome + " " + cognome + ":");
            for (Game game : listaGame) {
                System.out.println(game.toString());
            }
        }
    }
    public void removeGame(Game game){
        listaGame.remove(game);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public LocalDate getDataNascita() {
        return data_nascita;
    }

    public void setDataNascita(LocalDate data) {
        this.data_nascita = data;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }


    @Override
    public String toString() {
        return "Athlete{id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", data_nascita=" + data_nascita +
                ", altezza=" + altezza + " cm}";
    }
}
