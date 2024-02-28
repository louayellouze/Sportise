package controllers;

import entities.Academy;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import services.ServiceAcademy;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AfficherAcademy implements Initializable {

    @FXML
    private VBox vbox;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Academy> academies;
    int rows=3;
    int columns=0;



    public void resetRowsColumns()
    {
        rows=3;
        rows=0;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ServiceAcademy sc=new ServiceAcademy();
        academies=sc.display();
        try {

            for (Academy a :academies) {
                System.out.println(a);
                FXMLLoader fxmlLoader = new FXMLLoader ();
                fxmlLoader.setLocation(getClass().getResource("/CardAcademy.fxml"));
                AnchorPane cardBox = fxmlLoader.load ();
                cardBox.setOpacity(10); // Définit un espacement de 10 pixels entre les éléments enfants du HBox

                CardA card = fxmlLoader.getController();
                card.setData(a);
                if(columns==1)
                {
                    columns=0;
                    rows++;
                }
                grid.add(cardBox,columns++,rows);
                GridPane.setMargin(cardBox,new Insets(10));
            }

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }


























































}

