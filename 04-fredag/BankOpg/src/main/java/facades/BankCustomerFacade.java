package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankCustomerFacade {

    private static BankCustomerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private BankCustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankCustomerFacade getBankCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankCustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CustomerDTO getCustomerByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            BankCustomer bankCustomer = em.find(BankCustomer.class, id);
            CustomerDTO customerDTO = new CustomerDTO(bankCustomer);
            return customerDTO;
        } finally {
            em.close();
        }
    }

    public List<CustomerDTO> getCustomerByName(String name) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<CustomerDTO> query = em.createQuery("SELECT b FROM BankCustomer b WHERE b.firstname = :name", CustomerDTO.class)
                    .setParameter("name", name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public BankCustomer addCustomer(BankCustomer cust) {
        BankCustomer bankCustomer = new BankCustomer(cust.getFirstname(), cust.getLastname(), cust.getAccountNumber(),
                cust.getBallance(), cust.getCustomerRanking(), cust.getInternalInfo());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(bankCustomer);
            em.getTransaction().commit();
            return bankCustomer;
        } finally {
            em.close();
        }
    }

    public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = getEntityManager();
        try {
            List<BankCustomer> bankCustomers = em.createQuery("SELECT bankcustomer From BankCustomer bankcustomer").getResultList();
            return bankCustomers;
        } finally {
            em.close();
        }
    }
}
