package CatalogoBibliotecario.Catalogo;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "cataloghi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column( nullable = false,  length = 50)
    private String titolo;

    @Column(nullable = false,  length = 50)
    private int annoPubblicazione;

    @Column(nullable = false, length = 50)
    private int numeroPagine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public Catalogo() {
    }
    public Catalogo(Long id, String titolo, int annoPubblicazione, int numeroPagine) {
        this.id = id;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }
}
