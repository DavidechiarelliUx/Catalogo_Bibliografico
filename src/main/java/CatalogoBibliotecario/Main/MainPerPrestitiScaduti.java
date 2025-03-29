//package CatalogoBibliotecario.Main;
//
//import CatalogoBibliotecario.Prestito.Prestito;
//import CatalogoBibliotecario.Prestito.PrestitoDAO;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//import java.util.List;
//
//public class MainPerPrestitiScaduti {
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
//        EntityManager em = emf.createEntityManager();
//        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
//        List<Prestito> prestitiScaduti = prestitoDAO.findPrestitiScadutiNonRestituiti();
//        for (Prestito prestito : prestitiScaduti) {
//            System.out.println("Prestito scaduto: " + prestito.getIdPrestito());
//        }
//    }
//}