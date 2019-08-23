/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BankCustomer;

/**
 *
 * @author Bruger
 */
public class CustomerDTO {
    private long customerID;
    private String fullName;
    private String accountNumber;
    private double balance;

    public CustomerDTO(BankCustomer bC) {
        this.customerID = bC.getId();
        this.fullName = bC.getFirstname() + bC.getLastname();
        this.accountNumber = bC.getAccountNumber();
        this.balance = bC.getBallance();
    }
    
    
    
}
