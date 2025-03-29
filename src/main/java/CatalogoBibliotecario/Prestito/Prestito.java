package CatalogoBibliotecario.Prestito;

import CatalogoBibliotecario.Utente.Utente;
import CatalogoBibliotecario.Catalogo.Catalogo;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
//@NamedQuery(name = "Prestito.findPrestitiPerUtente", query = "SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTesseraUtente AND p.dataRestituzioneEffettiva IS NULL")
//@NamedQuery(name = "Prestito.findPrestitiScadutiNonRestituiti", query = "SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL")
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestito;

    @ManyToOne
    @JoinColumn(name = "numero_tessera", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "catalogo_id", nullable = false)
    private Catalogo elementoPrestato;

    @Column(nullable = false)
    private LocalDate dataInizioPrestito;

    @Column(nullable = false)
    private LocalDate dataRestituzionePrevista;

    private LocalDate dataRestituzioneEffettiva;

    public Long getIdPrestito() {
        return idPrestito;
    }

    public void setIdPrestito(Long idPrestito) {
        this.idPrestito = idPrestito;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Catalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Prestito( Utente utente, Catalogo elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Prestito() {
    }
}