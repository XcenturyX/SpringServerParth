package com.example.demo;

import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.*;

public class CheckUserData {

     JSONObject jsonObject;

     public ArrayList<String> logs=new ArrayList<>();



     @SneakyThrows
     public  CheckUserData(JSONObject jsonObject) throws SQLException {

         this.jsonObject=jsonObject;

         EnumSet.allOf(LocaleFields.class).forEach(field->{  //проверка заполненности всех полей после передачи

             checkNotNullField(String.valueOf(field));

         });
         if( CheckValueInDB.checkUniquenessValue(LocaleFields.email.name(),jsonObject.getString("email"))){

             logs.add("Почта "+jsonObject.getString("INN")+" уже занята");

         }

            //проверка уникального названия компаниии
        if( CheckValueInDB.checkUniquenessValue(LocaleFields.nameCompany.name(),jsonObject.getString("nameCompany"))){

            logs.add("Компания с названием "+jsonObject.getString("nameCompany")+" уже существует");
         }

         //проверка уникального инн компаниии
        if( CheckValueInDB.checkUniquenessValue(LocaleFields.INN.name(),jsonObject.getString("INN"))){

            logs.add("ИНН "+jsonObject.getString("INN")+" уже был зарегестрированн");

        }
         //проверка уникального огрн компаниии
         if( CheckValueInDB.checkUniquenessValue(LocaleFields.OGRN.name(),jsonObject.getString("OGRN"))){

             logs.add("ОГРН "+jsonObject.getString("OGRN")+" уже был зарегестрированн");

         }





     }



     public void checkNotNullField(String key){

        try{
            jsonObject.get(key);

        } catch (JSONException e){

            logs.add(  "Ошибка в поле: "+LocaleFields.valueOf(key).ruLocale+ " - поле пустое");


        }


    }









}
