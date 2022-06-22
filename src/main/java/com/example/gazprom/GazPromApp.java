package com.example.gazprom;

import engine.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class GazPromApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // settings
        stage.setFullScreen(true);
        stage.initStyle(StageStyle.UTILITY);
        FXMLLoader fxmlLoader = new FXMLLoader(GazPromApp.class.getResource("Map3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        PleaseProvideControllerClassName controllerClassName = fxmlLoader.getController();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, t -> {
            if(t.getCode()== KeyCode.ESCAPE)
            {
                stage.close();
            }
            if(t.getCode() == KeyCode.F11){
                Engine.status = Status.ADMIN;
            }
            if(t.getCode() == KeyCode.F10){
                Engine.status = Status.USER;
            }
        });

        stage.show();
        controllerClassName.Update();



    }

    public static void main(String[] args) {
        launch();
    }
}