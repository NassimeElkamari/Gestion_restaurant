package com.example.gestion_restaurant3;

import com.example.gestion_restaurant3.application.Client;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RESTAUACCEUILCONTROLLER {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private MenuItem idmenuprofcrud;


    @FXML
    private TableColumn<Client, String> idclient;

    @FXML
    private TableColumn<Client, String> food;

    @FXML
    private TableColumn<Client, String> payement;



    @FXML
    private TableView<Client> table;


    @FXML
    private TextField txtid;

    @FXML
    private TextField txtfood;

    @FXML
    private TextField txtpayement;



    @FXML
    private Button updateButton;




    @FXML
    void Ajouter(ActionEvent event) {

        String sidclient, sfood, spayement;
        sidclient = txtid.getText();
        sfood = txtfood.getText();
        spayement = txtpayement.getText();


        try
        {


            //idprof,
            pst = con.prepareStatement("insert into client(idclient, food, payement )values(?,?,?)");
            pst.setString(1, sidclient);
            pst.setString(2, sfood);
            pst.setString(3, spayement);

            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Gestion des client FS-Tétouan");


            alert.setHeaderText("L'ajout du client");
            alert.setContentText("Client est ajouté avec Succès !");
            txtid.setText("");
            txtfood.setText("");
            txtpayement.setText("");
            alert.showAndWait();

            table();

            txtid.setText("");
            txtfood.setText("");
            txtpayement.setText("");

            //txtgrade.requestFocus();
        }
        catch (SQLException ex)
        {
            //FXMLDocument
            //Logger.getLogger(com.example.grhtd3.com.example.gestion_restaurant3.NULL.ProfController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Modifier(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();

        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
        String sidclient, sfood, spayement;
        sidclient = txtid.getText();
        sfood = txtfood.getText();
        spayement = txtpayement.getText();


        try
        {


            pst = con.prepareStatement("update client set idclient = ?, food = ?, payement = ? where idclient = ? ");

            pst.setString(1, sidclient);
            pst.setString(2, sfood);
            pst.setString(3, spayement);



            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Gestion des clients");


            alert.setHeaderText("Modification du client");
            alert.setContentText("client  modifié avec succès !");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            //Logger.getLogger(com.example.grhtd3.com.example.gestion_restaurant3.NULL.ProfController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Supprimer(ActionEvent event) {
        myIndex = table.getSelectionModel().getSelectedIndex();

        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));


        try
        {
            pst = con.prepareStatement("delete from client where idclient = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Gestion des clients  ");


            alert.setHeaderText("Suppression client");
            alert.setContentText("Client supprimé avec succès !");

            alert.showAndWait();
            table();
        }
        catch (SQLException ex)
        {
            // Logger.getLogger(com.example.grhtd3.com.example.gestion_restaurant3.NULL.ProfController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML


    Connection con;
    PreparedStatement pst, pst2, pst1;
    int myIndex;
    int id;
    String deplis[] = new String[10];


    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbrestau","root","Nassime2002#");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void table()
    {
//        txtdep.getItems().removeAll();
        Connect();
        ObservableList<Client> clients = FXCollections.observableArrayList();
        try
        {

            pst = con.prepareStatement("select * from client");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Client st = new Client();
                    st.setIdpr(rs.getString("idclient"));
                    st.setnom(rs.getString("food"));
                    st.setgenre(rs.getString("payement"));

                    clients.add(st);
                }
            }
            table.setItems(clients);
            idclient.setCellValueFactory(f -> f.getValue().idProperty());
            food.setCellValueFactory(f -> f.getValue().foodProperty());
            payement.setCellValueFactory(f -> f.getValue().payProperty());




        }

        catch (SQLException ex)
        {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table.setRowFactory( tv -> {
            TableRow<Client> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  table.getSelectionModel().getSelectedIndex();

                    id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                    txtfood.setText(table.getItems().get(myIndex).getnom());
                    txtpayement.setText(table.getItems().get(myIndex).getgenre());


                    //txtdep.setText(deplis[Integer.valueOf(table.getItems().get(myIndex).getdep())-1]);
                    //txtdep.setValue(String.valueOf(table.getItems().get(myIndex).getdep()));
                    //System.out.println("le département sélctionné : " + (deplis[Integer.valueOf(table.getItems().get(myIndex).getdep())-1]));
                    //listdep.setValue(deplis[Integer.valueOf(table.getItems().get(myIndex).getdep())-1]);

                }
            });
            return myRow;
        });


    }


    public void listedepart() {
        Connect();

    }


}



