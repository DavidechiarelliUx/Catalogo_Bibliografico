package CatalogoBibliotecario.Main;

import CatalogoBibliotecario.Catalogo.Libro.Libro;
import CatalogoBibliotecario.Catalogo.Libro.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainRicercaPerAutore {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);

            String autoreDaCercare = "Akira Toriyama";

            List<Libro> libriTrovati = libroDAO.findByAutore(autoreDaCercare);

            if (!libriTrovati.isEmpty()) {
                System.out.println("Libri trovati per autore " + autoreDaCercare + ":");
                for (Libro libro : libriTrovati) {
                    System.out.println("- " + libro.getTitolo());
                }
            } else {
                System.out.println("Nessun libro trovato per autore " + autoreDaCercare);
            }

            em.close();
            emf.close();
    }
}
