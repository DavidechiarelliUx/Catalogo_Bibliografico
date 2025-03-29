package CatalogoBibliotecario.Prestito;

import CatalogoBibliotecario.Catalogo.Catalogo;
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
   // public List<Catalogo> findElementiInPrestitoPerUtente(int numeroTesseraUtente) {
    //        TypedQuery<Prestito> query = em.createNamedQuery("Prestito.findPrestitiPerUtente", Prestito.class);
    //        query.setParameter("numeroTesseraUtente", numeroTesseraUtente);
    //        List<Prestito> prestiti = query.getResultList();
    //
    //        List<Catalogo> elementiPrestati = prestiti.stream()
    //                .map(Prestito::getElementoPrestato)
    //                .toList();
    //
    //        return elementiPrestati;
    //    }
    //    public List<Prestito> findPrestitiScadutiNonRestituiti() {
    //        LocalDate oggi = LocalDate.now();
    //        TypedQuery<Prestito> query = em.createNamedQuery("Prestito.findPrestitiScadutiNonRestituiti", Prestito.class);
    //        query.setParameter("oggi", oggi);
    //        return query.getResultList();
    //    }
}
