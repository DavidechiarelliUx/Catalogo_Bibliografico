package CatalogoBibliotecario.Utente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UtenteDAO {

    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public Utente findById(int numeroTessera) {
        return em.find(Utente.class, numeroTessera);
    }

    public void save(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
    }

    public void insert(Utente utente) {
        em.persist(utente);
    }

    public void delete(Utente utente) {
        em.remove(utente);
    }
    // Ricerca utente per numero di tessera
    public Utente findByNumeroTessera(int numeroTessera) {
        TypedQuery<Utente> query = em.createNamedQuery("Utente.findByNumeroTessera", Utente.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getSingleResult();
    }
}