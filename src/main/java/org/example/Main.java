package org.example;

import com.training.entities.Account;
import com.training.entities.Customer;
import com.training.repositories.AccountDAO;
import com.training.repositories.CustomerDAO;
import com.training.util.DBConBank;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        int Id, accountNo;
        String name, email, address, phone, type;
        double balance, interestRate;
        System.out.println("Hello world!");
        try {
            DBConBank.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        CustomerDAO dao =new CustomerDAO();
        dao.getAll();
        System.out.println(dao.getAll());

        //using for each
        ArrayList<Customer> ct =dao.getAll();
        for (Customer  customer: ct){
            System.out.println(customer.toString());
        }

        //get by id
        System.out.println("Get by id: "+ dao.getById(11));

        //update by id
        Id = 14;
        name ="ram";
        email = "ram@gmail.com";
        address = "jsb road thane";
        phone = "8291571677";
        dao.updateById(Id, name, email, address, phone);

        Customer updateCus = dao.getById(Id);
        System.out.println("Updated customer details ");
        System.out.println(updateCus.getCustomerId()+"  "+ updateCus.getcName()+"  " +updateCus.getcEmail()+"  "+
                updateCus.getcAddress()+"  "+ updateCus.getCPhone());
        System.out.println(dao.getById(14));

        //delete by id - customer
        //dao.deleteById(12);

        // create by id
        Id = 19;
        name ="sam";
        email = "sam@gmail.com";
        address = "jsb road thane";
        phone = "2291578627";
        dao.create(Id,name,email,address,phone);
        System.out.println("new created customer: "+dao.getById(18));

        System.out.println();
        // Account = show

        AccountDAO dao1 =new AccountDAO();
        dao.getAll();
        System.out.println(dao.getAll());


        //using for each
        ArrayList<Account> ac =dao1.getAll();
        for (Account  account: ac) {
            System.out.println(account.toString());
        }

        //account - getbyid
        System.out.println("Get by id: "+ dao1.getById(11));

        //account - update
        Id = 17;
        accountNo = 89282920;
        type = "fixed";
        balance = 3.4322;
        interestRate = 0.6;
        dao1.updateById(Id, accountNo, type,balance,interestRate);

        Account updateAcc = dao1.getById(Id);
        System.out.println("Updated Account details ");
        System.out.println(updateAcc.getAccType()+ "\t"+ updateAcc.getBalance()+ "\t"+ updateAcc.getInterestRate());
        System.out.println(dao1.getById(14));

        // create by id - account
        dao1.create(15, 1001, "Savings", 5000, 4.5);

        //delete by id-account
        dao1.deleteById(12);

    }
}