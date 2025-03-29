package CatalogoBibliotecario.Main;

import CatalogoBibliotecario.Catalogo.Libro.Libro;
import CatalogoBibliotecario.Catalogo.Libro.LibroDAO;
import CatalogoBibliotecario.Catalogo.Rivista.Periodicita;
import CatalogoBibliotecario.Catalogo.Rivista.Rivista;
import CatalogoBibliotecario.Catalogo.Rivista.RivistaDAO;
import CatalogoBibliotecario.Prestito.Prestito;
import CatalogoBibliotecario.Prestito.PrestitoDAO;
import CatalogoBibliotecario.Utente.Utente;
import CatalogoBibliotecario.Utente.UtenteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class MainEsercizi {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);
        RivistaDAO rivistaDAO = new RivistaDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        em.getTransaction().begin();

        Libro libro1 = new Libro(null,"Dragonball z", 1997, 200, "Akira Toriyama", "Fantasy");
        Libro libro2 = new Libro(null, "Dragonball GT", 1998, 300, "Akira Toriyama", "Fantasy");
        Libro libro3 = new Libro(null,"Dragonball Super", 1999, 400, "Akira Toriyama", "Fantasy");
        Libro libro4 = new Libro(null, "Naruto", 2000, 500, "Akira Toriyama", "Fantasy");
        Libro libro5 = new Libro(null, "Bleach", 2001, 600, "Akira Toriyama", "Fantasy");


        Rivista rivista1 = new Rivista(null,"Anime Weekly", 2000, 200, Periodicita.SETTIMANALE);
        Rivista rivista2 = new Rivista(null, "Anime Monthly", 2001, 300, Periodicita.MENSILE);
        Rivista rivista3 = new Rivista(null,"Anime Quarterly", 2002, 400, Periodicita.SEMESTRALE);
        Rivista rivista4 = new Rivista(null, "Anime Super", 2003, 500, Periodicita.SETTIMANALE);
        Rivista rivista5 = new Rivista(null, "Anime Top", 2004, 600, Periodicita.MENSILE);
        Rivista rivista6 = new Rivista(null, "Anime Best", 2005, 700, Periodicita.SEMESTRALE);


        Utente utente1 = new Utente("Davide", "Chiarelli", LocalDate.of(1999, 12, 31), 12345343);
        Utente utente2 = new Utente("Mario", "Rossi", LocalDate.of(1990, 1, 11), 76271111);
        Utente utente3 = new Utente("Luigi", "Bianchi", LocalDate.of(2000, 5, 20), 16271113);



        libroDAO.insert(libro1);
        libroDAO.insert(libro2);
        libroDAO.insert(libro3);
        libroDAO.insert(libro4);
        libroDAO.insert(libro5);


        rivistaDAO.insert(rivista1);
        rivistaDAO.insert(rivista2);
        rivistaDAO.insert(rivista3);
        rivistaDAO.insert(rivista4);
        rivistaDAO.insert(rivista5);
        rivistaDAO.insert(rivista6);


        utenteDAO.insert(utente1);
        utenteDAO.insert(utente2);
        utenteDAO.insert(utente3);

        libroDAO.delete(5L);
        System.out.println("Libro con ID 1 eliminato");

        Utente utentePrestito1 = utenteDAO.findById(12345343);

        if(utentePrestito1 == null) {
            System.out.println("Utente con Numero Tessera 12345343 non trovato");
            em.getTransaction().rollback();
            return;
        }

        Libro libroPerPrestito =  libroDAO.findById(2L);


        if(libroPerPrestito == null) {
            System.out.println("Libro con ID 2 non trovato");
            em.getTransaction().rollback();
            return;
        }



        LocalDate dataInizioPrestito = LocalDate.now();
        LocalDate dataRestituzionePrestito = dataInizioPrestito.plusDays(30);

        Prestito prestito = new Prestito(utentePrestito1, libroPerPrestito, dataInizioPrestito, dataRestituzionePrestito, LocalDate.of(2025, 04,22));

        prestitoDAO.insert(prestito);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}