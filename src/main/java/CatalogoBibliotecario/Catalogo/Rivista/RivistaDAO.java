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
}
