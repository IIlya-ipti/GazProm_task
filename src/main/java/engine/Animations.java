package engine;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Animations {
    private final DropShadow dropShadow2;
    private final Light lighting;
    private final Timeline timelineActiveOnMouseClick;
    private final Timeline timelineDeactivateOnMouseClick;

    Animations(ImageView imageView){
        this.dropShadow2 = new DropShadow();
        dropShadow2.setOffsetY(0);
        dropShadow2.setOffsetX(0);
        dropShadow2.setRadius(0);
        lighting = new Light.Point();

        imageView.setEffect(dropShadow2);
        timelineActiveOnMouseClick = new Timeline();
        timelineDeactivateOnMouseClick = new Timeline();

        setActiveTimelineOnMouseClick();
        setDeactivateTimelineOnMouseClick();
    }
    private void setActiveTimelineOnMouseClick(){
        KeyValue rad = new KeyValue(dropShadow2.radiusProperty(),20, Interpolator.LINEAR);
        KeyValue offX = new KeyValue(dropShadow2.offsetXProperty(),10,Interpolator.LINEAR);
        KeyValue Light = new KeyValue(lighting.colorProperty(), Color.BLUEVIOLET,Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(200),rad,offX,Light);
        timelineActiveOnMouseClick.getKeyFrames().add(keyFrame);
    }
    private void setDeactivateTimelineOnMouseClick(){
        KeyValue rad = new KeyValue(dropShadow2.radiusProperty(),0, Interpolator.LINEAR);
        KeyValue offX = new KeyValue(dropShadow2.offsetXProperty(),0,Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(200),rad,offX);
        timelineDeactivateOnMouseClick.getKeyFrames().add(keyFrame);
    }
    public void on(){
        timelineActiveOnMouseClick.play();
    }
    public void off(){
        timelineDeactivateOnMouseClick.play();
    }

}
