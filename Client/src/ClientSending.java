import com.example.demo.LocaleFields;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class ClientSending {

    static  Socket connection;

    public static void main(String[] args) throws IOException {

        connection= new Socket("127.0.0.1",27015);
        BufferedWriter send = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));

        JSONObject jsonobject =new JSONObject()  {};

        try {
            jsonobject.put(LocaleFields.nameCompany.name(),"QWERTY");jsonobject.put(LocaleFields.isCustomer.name(),0);
            jsonobject.put(LocaleFields.isSeller.name(), 1);
            jsonobject.put(LocaleFields.INN.name(), "21321314");
            jsonobject.put(LocaleFields.OGRN.name(), "214");
            jsonobject.put(LocaleFields.FCsGenDirector.name(), "21321314");
            jsonobject.put(LocaleFields.email.name(), "qwerty@cringe.pzdc");
            jsonobject.put(LocaleFields.legalAddress.name(), "qw er t io");
            jsonobject.put(LocaleFields.KPP.name(), "iop");
            jsonobject.put(LocaleFields.phoneNumber.name(), 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //send.;
        send.flush();

        BufferedReader get = new BufferedReader(new InputStreamReader( connection.getInputStream()));

        String send_from_server = get.readLine();

        System.out.println("message from server: "+send_from_server);

        send.close();
        get.close();
        connection.close();

    }



}
