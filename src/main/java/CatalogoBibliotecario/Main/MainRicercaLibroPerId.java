package CatalogoBibliotecario.Main;

import CatalogoBibliotecario.Catalogo.Libro.Libro;
import CatalogoBibliotecario.Catalogo.Libro.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRicercaLibroPerId {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);

            Long idLibroDaCercare = 4L;

            Libro libroTrovato = libroDAO.findByIdNamedQuery(idLibroDaCercare);

            if (libroTrovato != null) {
                System.out.println("Libro trovato con ID " + idLibroDaCercare + ": " + libroTrovato.getTitolo());
            } else {
                System.out.println("Libro con ID " + idLibroDaCercare + " non trovato.");
            }

            em.close();
            emf.close();

    }
}