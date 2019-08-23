package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private EmployeeFacade() {
    }

    /**
     *
     * @param emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory emf) {
        if (instance == null) {
            emf = emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Employee getEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Employee employee = em.find(Employee.class, id);
            return employee;
        } finally {
            em.close();
        }
    }

    public Employee getEmployeeByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Employee employee = em.find(Employee.class, name);
            return employee;
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = getEntityManager();
        try {
            List<Employee> employees = em.createQuery("SELECT b From Employee b").getResultList();
            return employees;
        } finally {
            em.close();
        }
    }

    public Employee getEmployeesWithHighestSalary() {

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Double> query = em.createQuery("Select MAX(e.salary) from Employee e", Double.class);
            for (Employee empl : getAllEmployees()) {
                if (empl.getSalary() == query.getSingleResult()) {
                    return empl;
                }
            }
            return null;
        } finally {
            em.close();
        }
    }

    public Employee createEmployee(String name, String address, double salary) {
        Employee employee = new Employee(name, address, salary);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } finally {
            em.close();
        }
    }

}
