//package CatalogoBibliotecario.Main;
//
//import CatalogoBibliotecario.Catalogo.Catalogo;
//import CatalogoBibliotecario.Prestito.PrestitoDAO;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import jakarta.persistence.TypedQuery;
//
//import java.util.List;
//
//public class MainRicercaLibriInPrestito {
//
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
//        EntityManager em = emf.createEntityManager();
//
//        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
//
//        try {
//            em.getTransaction().begin();
//
//            int numeroTesseraUtente = 12345343;
//
//            List<Catalogo> libriInPrestito = prestitoDAO.findElementiInPrestitoPerUtente(numeroTesseraUtente);
//
//            System.out.println("Libri in prestito per l'utente con tessera " + numeroTesseraUtente + ":");
//            if (libriInPrestito.isEmpty()) {
//                System.out.println("Nessun libro in prestito trovato.");
//            } else {
//                for (Catalogo libro : libriInPrestito) {
//                    System.out.println("- " + libro.getTitolo());
//                }
//            }
//
//            em.getTransaction().commit();
//
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            System.err.println("Errore: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }
//    }
//}