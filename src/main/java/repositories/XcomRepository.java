/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import domain.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Falki
 */
public class XcomRepository {

    private Connection con = null;

    public XcomRepository() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001", "SA", "");
        } catch (Exception e) {
            Logger.getLogger(XcomRepository.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//  public List<Product> getAllUsers() {
//        List<Product> list = new ArrayList<>();
//        try {
//            Statement stmt = con.createStatement();
//            String q = "Select * from USERS ";
//            ResultSet result = stmt.executeQuery(q);
//            while (result.next()) {
//                Product p = new Product();
//                p.setCategory("GeForce GTX 1050");
//                p.setHardDrive("HardDrive");
//                p.setMotherboard("MotherBoard");
//                p.setRam("RAM");
//                list.add(p);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(XcomRepository.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
}
