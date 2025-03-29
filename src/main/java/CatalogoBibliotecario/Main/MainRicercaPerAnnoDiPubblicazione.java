package CatalogoBibliotecario.Main;

import CatalogoBibliotecario.Catalogo.Libro.Libro;
import CatalogoBibliotecario.Catalogo.Libro.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MainRicercaPerAnnoDiPubblicazione {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);


            em.getTransaction().begin();

            int annoDaCercare = 1997;
            List<Libro> libriTrovati = libroDAO.findByAnnoPubblicazione(annoDaCercare);

            if (!libriTrovati.isEmpty()) {
                System.out.println("Libri trovati con anno di pubblicazione " + annoDaCercare + ":");
                for (Libro libro : libriTrovati) {
                    System.out.println("- " + libro.getTitolo());
                }
            } else {
                System.out.println("Nessun libro trovato con anno di pubblicazione " + annoDaCercare);
            }

            em.getTransaction().commit();

            em.close();
            emf.close();

    }
}