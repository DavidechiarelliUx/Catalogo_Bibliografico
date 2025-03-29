package CatalogoBibliotecario.Main;

import CatalogoBibliotecario.Catalogo.Libro.Libro;
import CatalogoBibliotecario.Catalogo.Libro.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
public class MainRicercaPerTitolo {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();


        LibroDAO libroDAO = new LibroDAO(em);

            String titoloDaCercare = "Drag";

            List<Libro> libri = libroDAO.findByTitoloParziale(titoloDaCercare);

            if (!libri.isEmpty()) {
                System.out.println("Libri trovati con il titolo '" + titoloDaCercare + "':");
                for (Libro libro : libri) {
                    System.out.println("- " + libro.getTitolo());
                }
            } else {
                System.out.println("Nessun libro trovato con il titolo '" + titoloDaCercare + "'.");
            }

            em.close();
            emf.close();
    }
}
