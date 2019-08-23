package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BankCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String accountNumber;
    private double ballance;
    private int customerRanking;
    private String internalInfo;

    public BankCustomer(String firstname, String lastname, String accountNumber, double ballance, int customerRanking, String internalInfo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountNumber = accountNumber;
        this.ballance = ballance;
        this.customerRanking = customerRanking;
        this.internalInfo = internalInfo;
    }

    public BankCustomer() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBallance() {
        return ballance;
    }

    public void setBallance(double ballance) {
        this.ballance = ballance;
    }

    public int getCustomerRanking() {
        return customerRanking;
    }

    public void setCustomerRanking(int customerRanking) {
        this.customerRanking = customerRanking;
    }

    public String getInternalInfo() {
        return internalInfo;
    }

    public void setInternalInfo(String internalInfo) {
        this.internalInfo = internalInfo;
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
