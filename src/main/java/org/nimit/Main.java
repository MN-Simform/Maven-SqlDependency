package org.nimit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    static final String DB_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_nimit_db";
    static final String USERNAME = "freedb_nimit";
    static final String PASSWORD = "q!94?2M5d!%233p";

    static int id;
    static String name;
    static int age;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID : ");
        id = scanner.nextInt();
        System.out.print("Enter Name : ");
        name = scanner.next();
        System.out.print("Enter Age : " );
        age = scanner.nextInt();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO Student VALUES("+id+",'"+name+"',"+age+")";
            String sql2 = "DELETE FROM Student";
            if(stmt.executeUpdate(sql) > 0){
                System.out.println("Success");
            }
            else{
                System.out.println("Unsuccessful");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}