package CatalogoBibliotecario.Catalogo.Rivista;

import CatalogoBibliotecario.Catalogo.Catalogo;
import jakarta.persistence.*;

@Entity
@Table(name = "riviste")

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

    public Rivista(Long id,String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}