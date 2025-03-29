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

    public Libro findByIdNamedQuery(Long id) {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.findById", Libro.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    public List<Libro> findByAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.findByAnnoPubblicazione", Libro.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        return query.getResultList();
    }

    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.findByAutore", Libro.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Libro> findByTitoloParziale(String titolo) {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.findByTitolo", Libro.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

}
