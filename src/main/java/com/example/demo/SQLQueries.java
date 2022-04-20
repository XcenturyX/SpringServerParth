package com.example.demo;

import lombok.SneakyThrows;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.demo.SpringServerParthApplication.connectionDB;
import static com.example.demo.SpringServerParthApplication.nameInfoTable;

public class SQLQueries {



    @SneakyThrows
    static public void createNewUser(JSONObject jsonObject) throws SQLException {


        String signDataQuery ="insert into \"UserSignDataTable\" "+" (" +
                "\"FCsGenDirector\"," +
                "\"INN\"," +
                "\"KPP\"," +
                "\"OGRN\"," +
                "\"dateOfRegistration\"," +
                "\"email\"," +
                "\"isCustomer\"," +
                "\"isSeller\"," +
                "\"legalAddress\"," +
                "\"nameCompany\"," +
                "\"phoneNumber\")"+
                " values (?,?,?,?,?,?,?,?,?,?,?)";


        String authDataQuery ="insert into \"UserAuthData\" "+" (" +
                "\"email\"," +
                "\"password\")" +
                " values (?,?)";

        PreparedStatement preparedStatementSign=connectionDB.prepareStatement(signDataQuery);

        preparedStatementSign.setString(1,jsonObject.getString("FCsGenDirector"));
        preparedStatementSign.setString(2,jsonObject.getString("INN"));
        preparedStatementSign.setString(3,jsonObject.getString("KPP"));
        preparedStatementSign.setString(4,jsonObject.getString("OGRN"));
        preparedStatementSign.setString(5,jsonObject.getString("dateOfRegistration"));
        preparedStatementSign.setString(6,jsonObject.getString("email"));
        preparedStatementSign.setBoolean(7,jsonObject.getBoolean("isCustomer"));
        preparedStatementSign.setBoolean(8,jsonObject.getBoolean("isSeller"));
        preparedStatementSign.setString(9,jsonObject.getString("legalAddress"));
        preparedStatementSign.setString(10,jsonObject.getString("nameCompany"));
        preparedStatementSign.setString(11,jsonObject.getString("phoneNumber"));

        int rowS = preparedStatementSign.executeUpdate();

        System.out.println(rowS);


        PreparedStatement preparedStatementAuth=connectionDB.prepareStatement(authDataQuery);


        preparedStatementAuth.setString(1,jsonObject.getString("email"));
        preparedStatementAuth.setString(2,jsonObject.getString("password"));


        int rowA = preparedStatementAuth.executeUpdate();
        System.out.println(rowA);



    }

    public void deleteUser(){}



    public void changeUserStatus(){}


    public void updateData(){}







}
