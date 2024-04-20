package com.example.gestion_restaurant3.NULL;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client
{
    private final StringProperty idclient;
    private final StringProperty food;
    private final StringProperty payement;

    //public ObservableValue<String> nomProperty;

    public Client()
    {
        idclient = new SimpleStringProperty(this, "idclient");
        food = new SimpleStringProperty(this, "food");
        payement = new SimpleStringProperty(this, "payement");

    }

    public StringProperty idProperty() { return idclient; }
    public String getId() { return idclient.get(); }
    public void setIdpr(String newId) { idclient.set(newId); }

    public StringProperty foodProperty() { return food; }
    public String getnom() { return food.get(); }
    public void setnom(String newnom) { food.set(newnom); }

    public StringProperty payProperty() { return payement; }
    public String getgenre() { return payement.get(); }
    public void setgenre(String newgenre) { payement.set(newgenre); }





}
