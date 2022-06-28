package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.*;

public class JpaTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("banque-jpa-tp");
        EntityManager em = emf.createEntityManager();

        // Création client
        Client newClient = new Client();
        newClient.setNom("Tremblay");
        newClient.setPrenom("Pierre");

        Client newClient2 = new Client();
        newClient2.setNom("Picquet");
        newClient2.setPrenom("Julien");

        // Association du client avec une banque
        Banque newBanque = new Banque();
        newBanque.setNom("Credit mutuel");
        newClient.setBanque(newBanque);
        newClient2.setBanque(newBanque);

        em.getTransaction().begin();
        em.persist(newBanque);
        em.getTransaction().commit();

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1995, 10, 13);
        newClient.setDateNaissance(dateOfBirth.getTime());

        Calendar dateOfBirth2 = Calendar.getInstance();
        dateOfBirth.set(1990, 5, 9);
        newClient2.setDateNaissance(dateOfBirth.getTime());

        Adresse newAdresse = new Adresse();
        newAdresse.setRue("Rue one piece");
        newAdresse.setVille("Toulouse");
        newAdresse.setNumero(10);
        newAdresse.setCodePostal(31000);
        newClient.setAdresse(newAdresse);
        newClient2.setAdresse(newAdresse);

        // création d'un nouveau compte avec le nouveau client
        Set<Compte> allClientComptes = new HashSet<>();
        Set<Compte> allClientComptes2 = new HashSet<>();

        Compte newCompte = new Compte();
        newCompte.setNumero("4654654354657");
        newCompte.setSolde(1_250.59);
        allClientComptes.add(newCompte);
        allClientComptes2.add(newCompte);

        AssuranceVie newCompte2 = new AssuranceVie();
        newCompte2.setSolde(152.0);
        newCompte2.setNumero("164641646341");
        newCompte2.setTaux((double) 5);
        newCompte2.setDateFin(LocalDate.now().plusYears(25));
        allClientComptes.add(newCompte2);

        LivretA newCompte3 = new LivretA();
        newCompte3.setNumero("1647364646");
        newCompte3.setTaux(1.5);
        newCompte3.setSolde(19_756.98);
        allClientComptes.add(newCompte3);

        newClient.setComptes(allClientComptes);
        newClient2.setComptes(allClientComptes2);

        // Ajout du nouveau compte lié au nouveau client dans la base de donnée
        em.getTransaction().begin();
        em.persist(newCompte);
        em.persist(newCompte2);
        em.persist(newCompte3);
        em.getTransaction().commit();

        Operation newOpe = new Operation();
        newOpe.setDate(LocalDate.now());
        newOpe.setMotif("Paie");
        newOpe.setMontant(896.50);
        newOpe.setCompte(newCompte);

        Virement newVirement = new Virement();
        newVirement.setBeneficiaire("Pierre Tremblay");
        newVirement.setDate(LocalDate.now());
        newVirement.setMontant(360.85);
        newVirement.setMotif("Remboursement BK");
        newVirement.setCompte(newCompte);

        // Ajout de la nouvelle operation dans la base de donnée
        em.getTransaction().begin();
        em.persist(newOpe);
        em.persist(newVirement);
        em.getTransaction().commit();

        // Ajout base de donnée
        em.getTransaction().begin();
        em.persist(newClient);
        em.persist(newClient2);
        em.getTransaction().commit();
    }
}
