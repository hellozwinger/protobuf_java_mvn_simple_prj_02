package com.zwg.myprj;

import com.zwg.proto.MyCompany.Company;
import com.zwg.proto.MyCompany.Department;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;


public class CompanyManagement {

    public static boolean addDepart (String filepath, String name, int id) {
           Company.Builder company = Company.newBuilder();
           try {
              company.mergeFrom(new FileInputStream(filepath));
           }  catch (Exception e) {
              System.out.println(filepath + ": File not found. Creating a new file.");
           }

           try {
              company.addDept( Department.newBuilder()
                                           .setName(name)
                                           .setId(id)
                                           .build() );
              FileOutputStream output = new FileOutputStream(filepath);
              company.build().writeTo(output);
              output.close();
           } catch (Exception e) {
              System.out.println("Exception: " + e.toString());
              return false;
           }

           return true;
    }

    public static boolean listAll(String filepath) {
           try {
               Company company = Company.parseFrom(new FileInputStream(filepath));
               for (Department dept:company.getDeptList()) {
                   System.out.println("====> Name: " + dept.getName() + ", ID: " + dept.getId());
               }
           } catch (Exception e) {
              System.out.println("Exception: " + e.toString());
              return false;
           }

           return true;
    }
}

