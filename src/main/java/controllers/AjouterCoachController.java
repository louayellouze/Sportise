package controllers;
import entities.Academy;
import entities.Coach;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import services.ServiceAcademy;
import services.serviceCoach;
import java.awt.event.ActionEvent;


public class AjouterCoachController {

        @FXML
        private TextField tf_name;

        @FXML
        private TextField tf_email;

        @FXML
        private TextField tf_phone;

        @FXML
        private TextField tf_academy;

        @FXML
        private Button btn_add;

        @FXML
        void add2(javafx.event.ActionEvent event) {

            serviceCoach sc = new serviceCoach();
            if (tf_name.getText().isEmpty()){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                alertType.setHeaderText("Nom est vide.Ce champ est obligatoire. Veuillez le remplir");
                alertType.show();
                return;
            }

            if (tf_phone.getText().isEmpty()){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                alertType.setHeaderText("Phone est vide.Ce champ est obligatoire. Veuillez le remplir");
                alertType.show();
                return;
            }
            if (tf_email.getText().isEmpty()){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                alertType.setHeaderText("Email est vide.Ce champ est obligatoire. Veuillez le remplir");
                alertType.show();
                return;
            }

            if (tf_academy.getText().isEmpty()){
                Alert alertType=new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Error");
                alertType.setHeaderText("Le nom de l'académie est vide.Ce champ est obligatoire. Veuillez le remplir");
                alertType.show();
                return;
            }



            else {
                try {
                    Coach c = new Coach();
                    c.setName(tf_name.getText());
                    c.setEmail(tf_email.getText());
                    c.setPhone(tf_phone.getText());
                    c.setAcademyName(tf_academy.getText());

                    serviceCoach nc = new serviceCoach();
                    nc.addEntity2(c);

                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Succès");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Coach ajouté avec succès");
                    alert2.showAndWait();

                    // Vider les champs
                    tf_name.clear();
                    tf_phone.clear();
                    tf_email.clear();
                    tf_academy.clear();
                    //cbcategorie.getSelectionModel().clearSelection();

                }

                catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Une erreur s'est produite lors de l'ajout du coach");
                    alert.showAndWait();
                    ex.printStackTrace();
                }
            }    }


}



