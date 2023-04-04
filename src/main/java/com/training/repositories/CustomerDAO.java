package com.training.repositories;

import com.training.entities.Customer;
import com.training.util.DBConBank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    Statement st;
    ResultSet rs;
    Customer c1;
    PreparedStatement ps;
    ArrayList<Customer> clist = new ArrayList<>();

    public ArrayList<Customer> getAll(){

        try {
            st = DBConBank.con.createStatement();
            rs = st.executeQuery("select * from customer");
            while (rs.next()){
                c1 = new Customer();
                c1.setCustomerId(rs.getInt(1));
                c1.setcName(rs.getString(2));
                c1.setcEmail(rs.getString(3));
                c1.setcAddress(rs.getString(4));
                c1.setCPhone(rs.getString(5));

                clist.add(c1);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return clist;
    }

    public Customer getById(int id){
        try {
            rs =st.executeQuery("select * from customer where cID = "+id);
            while (rs.next()){
                int ID  = rs.getInt(1);
                String name =rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);

                c1 = new Customer();
                c1.setCustomerId(ID);
                c1.setcName(name);
                c1.setcEmail(email);
                c1.setcAddress(address);
                c1.setCPhone(phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c1;
    }

    //updated by id
    public void updateById(int cid, String name, String email, String address,String phone ){
        try {
            String str = "update customer set cName= ?, cEmail = ?, cAddress=?, cPhone=? where cID = ?";
            ps =DBConBank.con.prepareStatement(str);
            ps.setInt(1, cid);
            ps.setString(2, name);
            ps.setString(3,email);
            ps.setString(4,address);
            ps.setString(5,phone);

            int rowsUpdated  =ps.executeUpdate();
            if (rowsUpdated > 0){
                System.out.println("updated successfully");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //delete by id
//    public void deleteByid(int id){
//        try {
//            ps =DBConBank.con.prepareStatement("delete from customer where cID = ?");
//            ps.setInt(1,id);
//            int deleteRows =ps.executeUpdate();
//            if(deleteRows == 0){
//                System.out.println("Customer record with id "+id+" not found");
//            }
//            else {
//                System.out.println("Cutomer record with id "+id+ "deleted successfully");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    //create
    public void create(int id, String name, String email, String address,String phone){
        try {
            ps =DBConBank.con.prepareStatement("insert into customer (cID, cName, cEmail, cAddress, cPhone) values (?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3,email);
            ps.setString(4,address);
            ps.setString(5,phone);
            int createRows = ps.executeUpdate();
            if(createRows == 0){
                System.out.println("student record creation failed");
            }else {
                System.out.println("Student record created successfully");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        try {
            ps = DBConBank.con.prepareStatement("delete from customer where cID = ?");
            ps.setInt(1, id);
            int deleteRows = ps.executeUpdate();
            if (deleteRows == 0) {
                System.out.println("Customer record with id " + id + " not found");
            } else {
                System.out.println("Customer record with id " + id + " deleted successfully");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



