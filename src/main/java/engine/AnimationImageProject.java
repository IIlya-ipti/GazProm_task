package engine;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimationImageProject implements Animation{
    private final Image oldColor;
    private Image newColor;
    private final ImageView imageView;
    private final DropShadow dropShadow2;
    private final Timeline timelineActiveOnMouseClick;
    private final Timeline timelineDeactivateOnMouseClick;

    AnimationImageProject(ImageProject imageProject){

        this.imageView =   imageProject.getImageView();
        this.oldColor = imageView.getImage();
        this.newColor = null;
        this.dropShadow2 = new DropShadow();
        dropShadow2.setOffsetY(0);
        dropShadow2.setOffsetX(0);
        dropShadow2.setRadius(0);

        imageView.setEffect(dropShadow2);
        timelineActiveOnMouseClick =        new Timeline();
        timelineDeactivateOnMouseClick =    new Timeline();

        setActiveTimelineOnMouseClick();
        setDeactivateTimelineOnMouseClick();
    }

    private void setActiveTimelineOnMouseClick(){
        KeyValue rad = new KeyValue(dropShadow2.radiusProperty(),20, Interpolator.LINEAR);
        KeyValue offX = new KeyValue(dropShadow2.offsetXProperty(),10,Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(200),rad,offX);
        timelineActiveOnMouseClick.getKeyFrames().add(keyFrame);
    }

    private void setDeactivateTimelineOnMouseClick(){
        KeyValue rad = new KeyValue(dropShadow2.radiusProperty(),0, Interpolator.LINEAR);
        KeyValue offX = new KeyValue(dropShadow2.offsetXProperty(),0,Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(200),rad,offX);
        timelineDeactivateOnMouseClick.getKeyFrames().add(keyFrame);
        timelineDeactivateOnMouseClick.setOnFinished(actionEvent -> {
            imageView.toBack();
        });
    }

    @Override
    public void on() {
        imageView.toFront();
        UtilityFunctions.reColor(imageView);
        if (this.newColor == null) {
            this.newColor = imageView.getImage();
        }
        timelineActiveOnMouseClick.play();
    }

    @Override
    public void off() {
        imageView.setImage(oldColor);
        timelineDeactivateOnMouseClick.play();
    }

    @Override
    public void update() {
        ;
    }
}
