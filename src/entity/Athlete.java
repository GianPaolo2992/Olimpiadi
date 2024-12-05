package entity;

import java.time.LocalDate;

public class Athlete {
    private int id;
    private String nome;
    private String cognome;
    private int eta;
    private LocalDate data_nascita;
    private int altezza;

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
