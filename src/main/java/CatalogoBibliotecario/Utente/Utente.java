package CatalogoBibliotecario.Utente;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "utenti")
@NamedQuery(name = "Utente.findByNumeroTessera", query = "SELECT u FROM Utente u WHERE u.numeroTessera = :numeroTessera")
public class Utente {
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50)
    private String cognome;
    @Column
    private LocalDate dataNascita;

    @Id
    @Column(nullable = false)
    private int numeroDiTessera;

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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public int getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(int numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    public Utente(String nome, String cognome, LocalDate dataNascita, int numeroDiTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroDiTessera = numeroDiTessera;
    }
    public Utente(){}
}
