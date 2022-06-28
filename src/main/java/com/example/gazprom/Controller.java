package com.example.gazprom;

import engine.*;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller implements Initializable {
    private Engine engine;
    private List<UserPath> userPathList;
    private int indexChild;

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
    private ListView<String> list;


    @FXML
    private HBox hbox;


    @FXML
    void ExitAction(ActionEvent event) {
        ((Stage)pane.getScene().getWindow()).close();

    }

    @FXML
    private Text text;

    @FXML
    private Pane Total;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        engine = new Engine(
                pane,
                Total,
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

    /*
    *  switching mode
    * */
    public void update(boolean admin){
        if(!admin) {
            hbox.setVisible(false);
            hbox.setDisable(true);
            text.setVisible(true);
        }else{
            hbox.setVisible(true);
            hbox.setDisable(false);
            text.setVisible(false);
            engine.activeOff();
        }
    }
    public void afterInit(){

        Scene scene = pane.getScene();

        double width = scene.getWidth();
        double height = scene.getHeight();
        double WIDTH_CONST  = width/30;

        // init hbox
        hbox.setSpacing(20);
        this.userPathList = List.of(
                UserPath.CollegeOne,
                UserPath.CollegeOne,
                UserPath.CollegeOne,
                UserPath.CollegeTwo,
                UserPath.CollegeTwo,
                UserPath.CollegeThree,
                UserPath.CollegeThree,
                UserPath.CollegeThree,
                UserPath.CollegeFour,
                UserPath.CollegeFive,
                UserPath.CollegeFive
                );
        for(UserPath userPath: userPathList){
            hbox.getChildren().add( UserPath.getImageViewSetWidthHeight(userPath,WIDTH_CONST,0,true));
        }
        hbox.setOnMouseClicked(mouseEvent -> {
            int index = (int) (mouseEvent.getX()/(hbox.getWidth()/(hbox.getWidth()/(WIDTH_CONST + 20))));
            if(index < hbox.getChildren().size()){
                Node node = hbox.getChildren().get(index);
                if(mouseEvent.getX() <= node.getBoundsInParent().getMaxX()){
                   updateHBoxChild(index);
                   if(indexChild != index) {
                       deleteHBoxChild(indexChild);
                       indexChild = index;
                   }
                }
            }
        });
        indexChild = 0;
        updateHBoxChild(0);
        hbox.setDisable(true);
        hbox.setVisible(false);
        text.setVisible(true);
        //


        // adapting to the screen
        double coeff = Math.min(width/pane.getWidth(),height/pane.getHeight());
        pane.setScaleX(coeff);
        pane.setScaleY(coeff);
        if(pane.getBoundsInParent().getMinX() != 0) {
            pane.setLayoutX((int) (-1 * pane.getBoundsInParent().getMinX()));
            pane.setLayoutY(-pane.getBoundsInParent().getMinY());
        }
        engine.update();
        setStyles();
    }
    private void updateHBoxChild(int index){
        if(index < hbox.getChildren().size()){
            Node node = hbox.getChildren().get(index);
            node.setEffect(new DropShadow(30,Color.DODGERBLUE));
            MarkerImage.actualUserPath = userPathList.get(index);
        }
    }
    private void deleteHBoxChild(int index){
        if(index < hbox.getChildren().size()){
            Node node = hbox.getChildren().get(index);
            node.setEffect(null);
        }
    }

    private void setStyles(){
        hbox.setStyle("-fx-background-color: white;" +
                "-fx-effect: dropshadow(gaussian, #788b98, " + 20 + ", 0, 0, 0);" +
                "-fx-background-insets: " + 5 + ";" +
                "-fx-background-radius: " + 20);

    }

}
