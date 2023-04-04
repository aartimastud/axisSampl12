package com.training.repositories;

import com.training.entities.Account;
import com.training.entities.Customer;
import com.training.util.DBConBank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDAO {
    Statement st;
    ResultSet rs;
    Account a1;
    PreparedStatement ps;
    ArrayList<Account> alist = new ArrayList<>();

    public ArrayList<Account> getAll(){

        try {
            st = DBConBank.con.createStatement();
            rs = st.executeQuery("select * from account");
            while (rs.next()){

                a1 = new Account();
                a1.setCID(rs.getInt(5));
                a1.setAccountId(rs.getInt(1));
                a1.setAccType(rs.getString(2));
                a1.setBalance(rs.getDouble(3));
                a1.setInterestRate(rs.getDouble(4));
                alist.add(a1);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return alist;
    }

    public Account getById(int id){
        try {
            rs =st.executeQuery("select * from account where customer_ID = "+id);
            while (rs.next()){

                a1 = new Account();
                a1.setCID(rs.getInt(5));
                a1.setAccountId(rs.getInt(1));
                a1.setAccType(rs.getString(2));
                a1.setBalance(rs.getDouble(3));
                a1.setInterestRate(rs.getDouble(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a1;
    }

    //update- account

    public void updateById(int CID, int AccountNo, String AccType, double balance,double interestRate ){
        try {
            String str = "update account set account_no = ?, type = ?, balance = ?, interestRate=? where customer_ID = ?";
            ps =DBConBank.con.prepareStatement(str);
            ps.setInt(1, CID);
            ps.setInt(2, AccountNo);
            ps.setString(3,AccType);
            ps.setDouble(4,balance);
            ps.setDouble(5,interestRate);

            int rowsUpdated  =ps.executeUpdate();
            if (rowsUpdated > 0){
                System.out.println("updated successfully");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //create - account
    public void create(int CID, int AccountNo, String AccType, double balance,double interestRate){
        try {
            ps =DBConBank.con.prepareStatement("insert into account (customer_ID, account_no, type, balance, interestRate) values (?,?,?,?,?)");
            ps.setInt(1, CID);
            ps.setInt(2, AccountNo);
            ps.setString(3,AccType);
            ps.setDouble(4,balance);
            ps.setDouble(5,interestRate);
            int createRows = ps.executeUpdate();
            if(createRows == 0){
                System.out.println("Account record creation failed");
            }else {
                System.out.println("Account record created successfully");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    //delete by id
    public void deleteById(int id){
        try {
            String str = "delete from account where account_no = ?";
            ps =DBConBank.con.prepareStatement(str);
            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0){
                System.out.println("Account record deleted successfully");
            } else {
                System.out.println("Account record with ID " + id + " not found");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
