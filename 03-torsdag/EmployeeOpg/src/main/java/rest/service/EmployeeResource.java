package rest.service;

import com.google.gson.Gson;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employee")
public class EmployeeResource {

    private EntityManagerFactory emf;
    private EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emf);
    private static Gson gson = new Gson();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCustomers() {
        List<Employee> employee = facade.getAllEmployees();
        return gson.toJson(employee);
    }
    @Path("highestPaidEmp")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getHighestPaidEmployee() {
        return gson.toJson(facade.getEmployeesWithHighestSalary());
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeeById(Employee entity, @PathParam("id") int id) {
        return gson.toJson(facade.getEmployeeById(id));
    }
    
    @GET
    @Path("/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeeById(Employee entity, @PathParam("name") String name) {
        return gson.toJson(facade.getEmployeeByName(name));
    }
}