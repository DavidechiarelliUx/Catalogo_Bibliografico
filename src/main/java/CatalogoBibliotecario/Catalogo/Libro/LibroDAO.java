package CatalogoBibliotecario.Catalogo.Libro;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LibroDAO {

    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }
    public Libro findById(long id) {
        return em.find(Libro.class, id);
    }
    public void insert(Libro libro) {
        em.persist(libro);
    }

    public void delete(Long id) {
        Libro libro = findById(id);
        em.remove(libro);
    }

    //ricerca per isbn
    public Libro findByIsbn(String isbn) {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.findByIsbn", Libro.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }

    // Ricerca per anno pubblicazione
    public List<Libro> findByAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.findByAnnoPubblicazione", Libro.class);
        query.setParameter("anno", annoPubblicazione);
        return query.getResultList();
    }

    // Ricerca per autore
    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.findByAutore", Libro.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    // Ricerca per titolo o parte di esso
    public List<Libro> findByTitolo(String titolo) {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.findByTitolo", Libro.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

}
