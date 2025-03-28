package CatalogoBibliotecario.Catalogo.Libro;

import CatalogoBibliotecario.Catalogo.Catalogo;
import jakarta.persistence.*;

@Entity
@Table(name = "libri")
@NamedQueries({
        @NamedQuery(name = "Libro.findByIsbn", query = "SELECT l FROM Libro l WHERE l.codiceID = :isbn"),
        @NamedQuery(name = "Libro.findByAnnoPubblicazione", query = "SELECT l FROM Libro l WHERE l.annoPubblicazione = :anno"),
        @NamedQuery(name = "Libro.findByAutore", query = "SELECT l FROM Libro l WHERE l.autore = :autore"),
        @NamedQuery(name = "Libro.findByTitolo", query = "SELECT l FROM Libro l WHERE l.titolo LIKE :titolo")
})
public class Libro extends Catalogo {

    @Column(nullable = false, length = 50)
    private String autore;

    @Column(nullable = false, length = 50)
    private String genere;

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Libro() {
    }

    public Libro(Long id,String titolo, String annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}