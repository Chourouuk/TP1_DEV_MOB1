package com.example.tp1_dev_mob1.model;

public class Patient {
    private int age;
    private double valeurMesuree;
    private boolean isFasting ;
    private String reponse ;

    public Patient(int age, double valeurMesuree, boolean isFasting)
    {
        this.age=age;
        this.valeurMesuree=valeurMesuree;
        this.isFasting= isFasting;
        calculer();
    }
    private void calculer()
    { if (isFasting) {
        if (age >= 13 && (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)) {
            reponse="niveau de glycémie est normale 1";
        } else if ((age >= 6 && age <= 12) && (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)) {
            reponse="niveau de glycémie est normale 2";
        } else if (age < 6 && (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)) {
            reponse="niveau de glycémie est normale 3";
        } else {
            if (valeurMesuree< 5.0) {
                reponse="niveau de glycémie est trop bas";
            } else {
               reponse="niveau de glycémie est trop elevée";
            }
        }
    } else {
        if (age >= 13 && valeurMesuree < 10.5) {
            reponse="niveau de glycemie est normale";
        } else {
            reponse="niveau de glycémie est trop elevée";
        }
    } }
    //modify model-->controller

    public int getAge() {
        return age;
    }

    public double getValeurMesuree() {
        return valeurMesuree;
    }

    public boolean isFasting() {
        return isFasting;
    }

    public String getReponse() {
        return reponse;
    }

}
