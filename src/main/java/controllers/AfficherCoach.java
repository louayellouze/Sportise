package controllers;

import entities.Academy;
import entities.Coach;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import services.ServiceAcademy;
import services.serviceCoach;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AfficherCoach implements Initializable {

    @FXML
    private VBox vbox2;

    @FXML
    private ScrollPane scroll2;

    @FXML
    private GridPane grid2;

    private List<Coach> coaches;
    int rows=3;
    int columns=0;



    public void resetRowsColumns()
    {
        rows=3;
        rows=0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        serviceCoach sc=new serviceCoach();
        coaches=sc.display();
        try {

            for (Coach c :coaches) {
                System.out.println(c);
                FXMLLoader fxmlLoader = new FXMLLoader ();
                fxmlLoader.setLocation(getClass().getResource("/CardCoach.fxml"));
                AnchorPane cardBox = fxmlLoader.load ();
                cardBox.setOpacity(10); // Définit un espacement de 10 pixels entre les éléments enfants du HBox

                CardC card = fxmlLoader.getController();
                card.setData(c);
                if(columns==1)
                {
                    columns=0;
                    rows++;
                }
                grid2.add(cardBox,columns++,rows);
                GridPane.setMargin(cardBox,new Insets(10));
            }

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

}

