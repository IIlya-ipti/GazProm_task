package com.example.gazprom;

import engine.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PleaseProvideControllerClassName implements Initializable {

    @FXML
    private ImageView Adugaia;

    @FXML
    private ImageView Alanya;

    @FXML
    private ImageView Altay;

    @FXML
    private ImageView Altayskii;

    @FXML
    private ImageView Amurskaya;

    @FXML
    private ImageView Archangelsk;

    @FXML
    private ImageView Astrahanskaya;

    @FXML
    private ImageView Bashkortostan;

    @FXML
    private ImageView Belgorodskaya;

    @FXML
    private ImageView Branskaya;

    @FXML
    private ImageView Buratya;

    @FXML
    private ImageView Cabardin;

    @FXML
    private ImageView Cahalin;

    @FXML
    private ImageView Calushskaya;

    @FXML
    private ImageView Camchatka;

    @FXML
    private ImageView Chechenskaya;

    @FXML
    private ImageView Chelubinsk;

    @FXML
    private ImageView Cherkesia;

    @FXML
    private ImageView Chukotskyy;

    @FXML
    private ImageView Chuvachskaya;

    @FXML
    private ImageView Comi;

    @FXML
    private ImageView Dagestan;

    @FXML
    private ImageView Evreyskii;

    @FXML
    private ImageView Habarovsk;

    @FXML
    private ImageView Hakasya;

    @FXML
    private ImageView Hantu;

    @FXML
    private ImageView Ingushatya;

    @FXML
    private ImageView Irkutsk;

    @FXML
    private ImageView Ivanovskaya;

    @FXML
    private ImageView Kaliningradskaya;

    @FXML
    private ImageView Kalmukuya;

    @FXML
    private ImageView Karelya;

    @FXML
    private ImageView Kemerovskaya;

    @FXML
    private ImageView Kirovskaya;

    @FXML
    private ImageView Kostromskaya;

    @FXML
    private ImageView Krasnodarskyy;

    @FXML
    private ImageView Krasnor_kray;

    @FXML
    private ImageView Krum;

    @FXML
    private ImageView Kurganskaya;

    @FXML
    private ImageView Kurskaya;

    @FXML
    private ImageView Leningradskaya;

    @FXML
    private ImageView Lipetsk;

    @FXML
    private ImageView Magadan;

    @FXML
    private ImageView MariiAl;

    @FXML
    private ImageView Mordoviya;

    @FXML
    private ImageView Moscow;

    @FXML
    private ImageView Moskovskaya_obl;

    @FXML
    private ImageView Murmansk;

    @FXML
    private ImageView Nenetskyy;

    @FXML
    private ImageView NishiyGorod;

    @FXML
    private ImageView Novgorod;

    @FXML
    private ImageView Novosibirsk;

    @FXML
    private ImageView Omskaya;

    @FXML
    private ImageView Orenburg;

    @FXML
    private ImageView Orlovskaya;

    @FXML
    private ImageView Pensenskaya;

    @FXML
    private ImageView Permskii;

    @FXML
    private ImageView Primorsky;

    @FXML
    private ImageView Pscov;

    @FXML
    private ImageView Razanskaya;

    @FXML
    private ImageView Rostov;

    @FXML
    private ImageView Samarskaya;

    @FXML
    private ImageView Saratovskaya;

    @FXML
    private ImageView Smolenskaya;

    @FXML
    private ImageView Stavropol;

    @FXML
    private ImageView Sverdlovskaya;

    @FXML
    private ImageView Tambov;

    @FXML
    private ImageView Tatarstan;

    @FXML
    private ImageView Tomskaya;

    @FXML
    private ImageView Tulskaya;

    @FXML
    private ImageView Tumenskaya;

    @FXML
    private ImageView Tuva;

    @FXML
    private ImageView Tverskaya;

    @FXML
    private ImageView Udmurtinskaya;

    @FXML
    private ImageView Vladimiskaya;

    @FXML
    private ImageView Volgogradskaya;

    @FXML
    private ImageView Vologorodskaya;

    @FXML
    private ImageView Voroneg;

    @FXML
    private ImageView Yakutia;

    @FXML
    private ImageView Yamal_Nenezkiy;

    @FXML
    private ImageView Yaroslavskaya;

    @FXML
    private ImageView Ylyanovsk;

    @FXML
    private ImageView Zabaykal;

    @FXML
    private ImageView Sainkt_petersburg;

    @FXML
    private Pane pane;

    @FXML
    private Button Exit;

    @FXML
    void ExitAction(ActionEvent event) {
        ((Stage)pane.getScene().getWindow()).close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Engine(
                pane,
                Sainkt_petersburg,
                Adugaia,
                Chechenskaya,
                Bashkortostan,
                Altayskii,
                Volgogradskaya,
                Astrahanskaya,
                Alanya,
                Archangelsk,
                Altay,
                Ivanovskaya,
                Branskaya,
                Belgorodskaya,
                Cherkesia,
                Cabardin,
                Calushskaya,
                Chelubinsk,
                Hakasya,
                Vladimiskaya,
                Chuvachskaya,
                Comi,
                Krum,
                Dagestan,
                Hantu,
                Ingushatya,
                Kaliningradskaya,
                Moskovskaya_obl,
                Kalmukuya,
                Kemerovskaya,
                Karelya,
                Udmurtinskaya,
                Kirovskaya,
                Kurskaya,
                Kostromskaya,
                Krasnodarskyy,
                Leningradskaya,
                Lipetsk,
                Tverskaya,
                Kurganskaya,
                MariiAl,
                Mordoviya,
                NishiyGorod,
                Nenetskyy,
                Moscow,
                Murmansk,
                Tumenskaya,
                Novgorod,
                Novosibirsk,
                Omskaya,
                Tulskaya,
                Orenburg,
                Orlovskaya,
                Pensenskaya,
                Permskii,
                Razanskaya,
                Pscov,
                Tomskaya,
                Tatarstan,
                Tambov,
                Rostov,
                Sverdlovskaya,
                Samarskaya,
                Stavropol,
                Smolenskaya,
                Saratovskaya,
                Yamal_Nenezkiy,
                Ylyanovsk,
                Krasnor_kray,
                Yaroslavskaya,
                Yakutia,
                Chukotskyy,
                Voroneg,
                Camchatka,
                Magadan,
                Habarovsk,
                Cahalin,
                Primorsky,
                Vologorodskaya,
                Evreyskii,
                Amurskaya,
                Zabaykal,
                Buratya,
                Irkutsk,
                Tuva
                );
    }
    public void Update(){
        Scene scene = pane.getScene();
        double coeff = Math.min(scene.getWidth()/pane.getWidth(),scene.getHeight()/pane.getHeight());
        pane.setScaleX(coeff);
        pane.setScaleY(coeff);
        pane.setLayoutX(-pane.getBoundsInParent().getMinX());
        pane.setLayoutY(-pane.getBoundsInParent().getMinY());
    }
}
