package com.example.tp1_dev_mob1.controller;

import com.example.tp1_dev_mob1.model.Patient;

public class Controller {

    public static Controller instance;
    private static Patient patient;
    public void createPatient(int age,double valM1,boolean isFasting){
        patient = new Patient(age,valM1,isFasting);
    }
    private Controller(){
        super();
    }
    public String getConsultation(){
        return patient.getReponse();
    }
    public  static Controller getInstance(){
        if(instance == null){
            return instance = new Controller();
        }else {
            return instance;
        }
    }
}