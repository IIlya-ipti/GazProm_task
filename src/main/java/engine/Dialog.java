package engine;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

public class Dialog {
    private int startX ;
    private int startY;
    private int endX;
    private int endY ;
    private Pane pane;
    private TextFlow textFlow;
    private ImageView imageView;
    Dialog(Pane TotalPane, ImageView imageView){
        this.imageView = imageView;
        this.pane = new Pane();
        TotalPane.getChildren().add(pane);

        // style for pane
        pane.setStyle("-fx-background-color: white;" +
                "-fx-effect: dropshadow(gaussian, dodgerblue, " + 20 + ", 0, 0, 0);" +
                "-fx-background-insets: " + 20 + ";" +
                "-fx-background-radius: " + 20);



        Text text = new Text("Сила сибири\n");
        text.setFont(Font.font("Roboto", 29));
        Text textOne = new Text("""
                ...
                2023 - 100
                2024 - 200
                2024 - 200
                """);
        text.setFont(Font.font("Roboto", 15));
        textFlow = new TextFlow(text,textOne);
        pane.getChildren().add(textFlow);

    }
    void setOn(){
        pane.setVisible(true);
    }
    void setOff(){
        pane.setVisible(false);
    }
    Pane getPane(){
        return pane;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Timeline setOnDialog(){
        Timeline timeline = new Timeline();
        KeyValue offX = new KeyValue(pane.layoutXProperty(),this.endX, Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(400),offX);
        timeline.getKeyFrames().add(keyFrame);
        return timeline;
    }
    public Timeline setOffDialog(){
        Timeline timeline = new Timeline();
        KeyValue offX = new KeyValue(pane.layoutXProperty(),this.startX,Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(700),offX);
        timeline.getKeyFrames().add(keyFrame);
        return timeline;
    }

    public void update(){
        double ValX = pane.getScene().getWindow().getWidth();
        double ValY = pane.getScene().getWindow().getHeight();
        startX = (int) (-ValX * 0.23);
        endX =   (int) (ValX * 0.002);
        startY = (int) (ValY * 0.1);


        pane.setPrefHeight(ValX* 0.4);
        pane.setPrefWidth(ValY * 0.4);
        pane.setLayoutY(startY);
        pane.setLayoutX(startX);
        pane.setVisible(true);

        if(imageView.getLayoutX() < endX + pane.getPrefWidth()){
            startX = (int) (imageView.getScene().getWidth() - startX);
            pane.setLayoutX(startX);
            endX =   (int) (imageView.getScene().getWidth() - endX - pane.getPrefWidth()) ;
        }


        textFlow.setPrefWidth(pane.getPrefWidth() * 0.8);
        textFlow.setPrefHeight(pane.getPrefHeight() * (1 - 0.1));
        textFlow.setLayoutX(pane.getPrefWidth() * 0.1);
        textFlow.setLayoutY(pane.getPrefHeight() * 0.05);
    }
}
