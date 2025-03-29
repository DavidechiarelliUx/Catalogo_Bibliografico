package CatalogoBibliotecario.Main;

import CatalogoBibliotecario.Catalogo.Libro.Libro;
import CatalogoBibliotecario.Catalogo.Rivista.Periodicita;
import CatalogoBibliotecario.Catalogo.Rivista.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Libro libro = new Libro(1L,"Harry Potter", 1998, 300, "J.K. Rowling", "Fantasy");
        em.persist(libro);

        Rivista rivista = new Rivista(2L, "National Geographic", 2022, 100, Periodicita.MENSILE);
        em.persist(rivista);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
