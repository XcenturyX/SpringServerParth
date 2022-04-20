package com.example.demo;


import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.demo.SpringServerParthApplication.connectionDB;


public class UserRegistration {


    JSONObject jsonObject;


        public UserRegistration(JSONObject jsonObject) throws SQLException {

            this.jsonObject=jsonObject;
            getUserRegistration();

        }

       public void getUserRegistration() throws SQLException {


        CheckUserData checkUserData = new CheckUserData(jsonObject);

        if(checkUserData.logs!=null){//отправlяем в клиент ошибкт, если они есть

            checkUserData.logs.forEach(System.out::println);


            //return;

        }





           //  SQLQueries.createNewUser(jsonObject);





        //отправка на сервер информации, если нету ошибок


      }










    }




