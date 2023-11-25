package com.example.tp1_dev_mob1.controller;

import com.example.tp1_dev_mob1.model.Patient;

public class Controller {
    private static Patient patient;
   //user_action:view-->controller
    public Controller() //user action
    { super();}
    public void createPatient(int age, float valeurMesuree, boolean isFasting)
            //update:controller-->model
    {
        patient =new Patient(age,valeurMesuree,isFasting);
    }

    public String getReponse() //notify controller -->view
    {
        return patient.getReponse(); // notify model-->controller
    }

}