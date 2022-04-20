package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.demo.SpringServerParthApplication.connectionDB;
import static com.example.demo.SpringServerParthApplication.nameInfoTable;

abstract public class CheckValueInDB {



       static public boolean checkUniquenessValue(String type,String field) throws SQLException {


              Statement statement = connectionDB.createStatement();
              ResultSet resultSet=statement.executeQuery("select  u.\""+type+"\" from \"UserSignDataTable\" u; ");

              while(resultSet.next()){


                    if( resultSet.getString(type).equals(field)){return true;};
              }
              return false;


       }








}
