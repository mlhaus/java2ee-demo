package edu.kirkwood.ecommerce.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import static edu.kirkwood.shared.DB_Connect.getConnection;

public class VendorDAO {
    public static void main(String[] args) {
        Vendor vendor = new Vendor("0", "Test Vendor", new Address("123 Sample St", "Cedar Rapids", "IA", "55555", "USA"));
        addVendor(vendor);
    }

    // You should already have a getAllVendors method

    public static boolean addVendor(Vendor vendor) {
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{CALL sp_add_vendor_admin(?, ?, ?, ?, ?, ?, ?)}");
            statement.setString(1, vendor.getVend_id());
            statement.setString(2, vendor.getVend_name());
            statement.setString(3, vendor.getAddress().getAddress());
            statement.setString(4, vendor.getAddress().getCity());
            statement.setString(5, vendor.getAddress().getState());
            statement.setString(6, vendor.getAddress().getZip());
            statement.setString(7, vendor.getAddress().getCountry());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
