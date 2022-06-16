package com.example.gazprom;

import engine.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class PleaseProvideControllerClassName implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Yamal_Nenezkiy"
    private ImageView Yamal_Nenezkiy; // Value injected by FXMLLoader

    @FXML
    private AnchorPane Pane;

    @FXML
    private ImageView Krasnor_kray;

    @FXML
    private ImageView Yakutia;

    @FXML
    private ImageView Chukotskyy;

    @FXML
    private ImageView Camchatka;

    @FXML
    private ImageView Magadan;

    @FXML
    private ImageView Habarovsk;

    @FXML
    private ImageView Cahalin;

    @FXML
    private ImageView Primorsky;

    @FXML
    private ImageView Evreyskii;

    @FXML
    private ImageView Amurskaya;

    @FXML
    private ImageView Zabaykal;

    @FXML
    private ImageView Buratya;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pane.setScaleX(2);
        Pane.setScaleY(2);
        new Engine(
                Pane,
                Yamal_Nenezkiy,
                Krasnor_kray,
                Yakutia,
                Chukotskyy,
                Camchatka,
                Magadan,
                Habarovsk,
                Cahalin,
                Primorsky,
                Evreyskii,
                Amurskaya,
                Zabaykal,
                Buratya
                );
    }
}
