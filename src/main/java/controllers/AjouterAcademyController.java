package controllers;

import entities.Academy;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ServiceAcademy;

import java.awt.event.ActionEvent;

public class AjouterAcademyController {

    ServiceAcademy sa = new ServiceAcademy();

    @FXML
    private TextField tf_nomC;

    @FXML
    private TextField tf_cat;

    @FXML
    private TextField tf_user;

    @FXML
    private TextField tf_create;

    @FXML
    private Button btn_ajout;

    @FXML
    void add(javafx.event.ActionEvent event) {
        if (tf_nomC.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Nom est vide.Ce champ est obligatoire. Veuillez le remplir");
            alertType.show();
            return;
        }
        if (tf_cat.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("Categorie est vide.Ce champ est obligatoire. Veuillez le remplir");
            alertType.show();
            return;
        }

        if (tf_create.getText().isEmpty()){
            Alert alertType=new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Error");
            alertType.setHeaderText("CreatedBy est vide.Ce champ est obligatoire. Veuillez le remplir");
            alertType.show();
            return;
        }


        if (!tf_user.getText().matches("\\d+")||tf_user.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Le userID doit être un nombre entier positif non vide .");
            alert.showAndWait();
            return;
        }



        else {
            try {
                Academy e = new Academy();
                e.setName(tf_nomC.getText());
                e.setCategory(tf_cat.getText());
                e.setCreated_by(tf_create.getText());
                e.setUser_id(Integer.parseInt(tf_user.getText()));
                ServiceAcademy sc = new ServiceAcademy();
                sc.addEntity(e);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText(null);
                alert.setContentText("Academie ajouté avec succès");
                alert.showAndWait();

                // Vider les champs
                tf_nomC.clear();
                tf_cat.clear();
                tf_user.clear();
                tf_create.clear();
                //cbcategorie.getSelectionModel().clearSelection();

            }

            catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Une erreur s'est produite lors de l'ajout de l'académie");
                alert.showAndWait();
                ex.printStackTrace();
            }
        }    }


}



