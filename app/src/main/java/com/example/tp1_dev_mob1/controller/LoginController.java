package com.example.tp1_dev_mob1.controller;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.tp1_dev_mob1.model.User;
public class LoginController {
    private static User user;

    private static LoginController instance = null;
    private static final String shared_Pref = "sharedPref";

    public LoginController() {
        super();
    }

    public static final LoginController getInstance(Context context) {
        if (LoginController.instance == null)

            instance = new LoginController();

        recapUser(context);

        return LoginController.instance;
    }
   private static void recapUser (Context context)
   {
       SharedPreferences sharedPreferences = context.getSharedPreferences(shared_Pref, Context.MODE_PRIVATE);
String UserName = sharedPreferences.getString("UserName","");
String Password = sharedPreferences.getString("password","");
user = new User(UserName, Password);

   }
    public void CreateUser(String UserName, String password, Context context) {
        //création de l'utilisateur
        user = new User(UserName, password);
        //persistance de données de l'utilisateur
        SharedPreferences sharedPreferences = context.getSharedPreferences(shared_Pref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user" , UserName);
        editor.putString("password" ,password);
        editor.apply();
        }


    public String getUserName() { return user.getUserName();  }

    public String getPassword() { return user.getPassword(); }
}

