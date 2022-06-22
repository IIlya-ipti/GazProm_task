package engine;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

public class AnimationDialog implements Animation {
    private int startX ;
    private int startY;
    private int endX;
    private int endY ;
    private final Pane pane;
    private final ImageView imageView;
    private Timeline timelineActiveDialog;
    private Timeline timelineDeactivateDialog;

    AnimationDialog(Dialog dialog){
        update();
        this.pane =                     dialog.getPane();
        this.timelineActiveDialog =     setOnDialog();
        this.timelineDeactivateDialog = setOffDialog();
        this.imageView =                dialog.getImageView();
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
        this.timelineActiveDialog = setOnDialog();
        this.timelineDeactivateDialog = setOffDialog();
    }

    @Override
    public void on() {
        update();
        timelineActiveDialog.play();
    }

    @Override
    public void off() {
        timelineDeactivateDialog.play();
    }
}
