package CatalogoBibliotecario.Catalogo.Libro;

import CatalogoBibliotecario.Catalogo.Catalogo;
import jakarta.persistence.*;

@Entity
@Table(name = "libri")
@NamedQuery(name = "Libro.findById", query = "SELECT l FROM Libro l WHERE l.id = :id")
@NamedQuery(name = "Libro.findByAnnoPubblicazione", query = "SELECT l FROM Libro l WHERE l.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "Libro.findByAutore", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
@NamedQuery(name = "Libro.findByTitolo", query = "SELECT l FROM Libro l WHERE l.titolo LIKE :titolo")
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

    public Libro(Long id,String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(id, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}