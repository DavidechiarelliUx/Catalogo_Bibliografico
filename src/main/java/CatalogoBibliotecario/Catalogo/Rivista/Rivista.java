package CatalogoBibliotecario.Catalogo.Rivista;

import CatalogoBibliotecario.Catalogo.Catalogo;
import jakarta.persistence.*;

@Entity
@Table(name = "riviste")
@NamedQueries({
        @NamedQuery(name = "Rivista.findByIsbn", query = "SELECT r FROM Rivista r WHERE r.codiceID = :isbn"),
        @NamedQuery(name = "Rivista.findByAnnoPubblicazione", query = "SELECT r FROM Rivista r WHERE r.annoPubblicazione = :anno"),
        @NamedQuery(name = "Rivista.findByTitolo", query = "SELECT r FROM Rivista r WHERE r.titolo LIKE :titolo")
})
public class Rivista extends Catalogo {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public Rivista() {
    }

    public Rivista(Long id,String titolo, String annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}