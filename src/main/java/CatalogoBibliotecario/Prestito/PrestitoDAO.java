package CatalogoBibliotecario.Prestito;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Prestito prestito) {
        em.getTransaction().begin();
        em.persist(prestito);
        em.getTransaction().commit();
    }
    public Prestito findById(long id) {
        return em.find(Prestito.class, id);
    }
    public void insert(Prestito prestito) {
        em.persist(prestito);
    }
    public void delete(Prestito prestito) {
        em.remove(prestito);
    }
    // Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
    public List<Prestito> findByNumeroTessera(int numeroTessera) {
        TypedQuery<Prestito> query = em.createNamedQuery("Prestito.findByNumeroTessera", Prestito.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    // Ricerca di tutti i prestiti scaduti e non ancora restituiti
    public List<Prestito> findPrestitiScadutiNonRestituiti(LocalDate dataCorrente) {
        TypedQuery<Prestito> query = em.createNamedQuery("Prestito.findPrestitiScadutiNonRestituiti", Prestito.class);
        query.setParameter("dataCorrente", dataCorrente);
        return query.getResultList();
    }
}
