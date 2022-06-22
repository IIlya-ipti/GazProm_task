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
    private final Pane pane;
    private final TextFlow textFlow;
    private final ImageView imageView;
    private final Animation animation;

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
        this.animation = new AnimationDialog(this);

    }
    public void update(){
        animation.update();
        textFlow.setPrefWidth(pane.getPrefWidth() * 0.8);
        textFlow.setPrefHeight(pane.getPrefHeight() * (1 - 0.1));
        textFlow.setLayoutX(pane.getPrefWidth() * 0.1);
        textFlow.setLayoutY(pane.getPrefHeight() * 0.05);
    }
    Pane getPane(){
        return pane;
    }
    public ImageView getImageView() {
        return imageView;
    }
    public Animation getAnimation() {
        return animation;
    }
}
