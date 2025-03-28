package CatalogoBibliotecario.Catalogo.Rivista;

import CatalogoBibliotecario.Catalogo.Libro.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RivistaDAO {

    private EntityManager em;

    public RivistaDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Rivista rivista) {
        em.getTransaction().begin();
        em.persist(rivista);
        em.getTransaction().commit();
    }
    public Rivista findById(long id) {
        return em.find(Rivista.class, id);
    }
    public void insert(Rivista rivista) {
        em.persist(rivista);
    }
    public void delete(Long id) {
        Rivista rivista = findById(id);
        em.remove(rivista);
    }

    // Ricerca per ISBN
    public Rivista findByIsbn(String isbn) {
        TypedQuery<Rivista> query = em.createNamedQuery("Rivista.findByIsbn", Rivista.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }

    // Ricerca per anno pubblicazione
    public List<Rivista> findByAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Rivista> query = em.createNamedQuery("Rivista.findByAnnoPubblicazione", Rivista.class);
        query.setParameter("anno", annoPubblicazione);
        return query.getResultList();
    }

    // Ricerca per titolo o parte di esso
    public List<Rivista> findByTitolo(String titolo) {
        TypedQuery<Rivista> query = em.createNamedQuery("Rivista.findByTitolo", Rivista.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }
}
