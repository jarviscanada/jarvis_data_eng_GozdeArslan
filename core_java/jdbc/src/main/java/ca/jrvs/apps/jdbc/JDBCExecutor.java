package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {
    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");

        try {

            //Using a Driver
           /*1
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER"); */
           //using DAO pattern
        Connection connection =dcm.getConnection();
        CustomerDAO customerDAO = new CustomerDAO(connection);

        //CREATE
         /* Customer customer = new Customer();

            customer.setFirstName("Tom ");
            customer.setLastName("Smith");
            customer.setEmail("Tsmith@gmail.com");
            customer.setPhone("(555) 222-3334");
            customer.setAddress("21 court street");
            customer.setCity("New York");
            customer.setState("VA");
            customer.setZipCode("2NZ 4DW");

             customerDAO.create(customer);
            */
        //READ
          /*2 Customer customer = customerDAO.findById(1000);
            System.out.println(customer.getFirstName()+" "+customer.getLastName());
            */

        /*1
          while (resultSet.next()) {


                System.out.println(resultSet.getInt(1));
            }*/

           //UPDATE
          /*3  Customer customer = customerDAO.findById(1000);
            System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());
            customer.setEmail("vwoodsp0@blogtalkradio.com");
            customer =customerDAO.update(customer);
            System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());

           */

            //DELETE

           Customer customer = new Customer();

            customer.setFirstName("Mark ");
            customer.setLastName("James");
            customer.setEmail("Mjames@gmail.com");
            customer.setPhone("(555) 255-3388");
            customer.setAddress("565 court street");
            customer.setCity("Nevada");
            customer.setState("NA");
            customer.setZipCode("56789");
            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);

            dbCustomer =customerDAO.findById(customer.getId());
            System.out.println(dbCustomer);

            dbCustomer.setEmail("Mjames2@gmail.com");
            dbCustomer =customerDAO.update(dbCustomer);

            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
}
