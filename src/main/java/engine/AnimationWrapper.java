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

import java.util.List;

public class AnimationWrapper implements Animation{
    private final ImageView imageView;
    private final DropShadow dropShadow2;
    private final Timeline timelineActiveOnMouseClick;
    private final Timeline timelineDeactivateOnMouseClick;
    private final Timeline timelineActiveDialog;
    private final Timeline timelineDeactivateDialog;
    private final List<Marker> markerList;
    private final Dialog dialog;

    AnimationWrapper(Wrapper wrapper){
        this.imageView =    wrapper.getImageView();
        this.markerList =   wrapper.getMarkerList();
        this.dialog =       wrapper.getDialog();
        this.dropShadow2 = new DropShadow();
        dropShadow2.setOffsetY(0);
        dropShadow2.setOffsetX(0);
        dropShadow2.setRadius(0);

        imageView.setEffect(dropShadow2);
        timelineActiveOnMouseClick =        new Timeline();
        timelineDeactivateOnMouseClick =    new Timeline();

        setActiveTimelineOnMouseClick();
        setDeactivateTimelineOnMouseClick();
        timelineActiveDialog =              dialog.setOnDialog();
        timelineDeactivateDialog =          dialog.setOffDialog();
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
        for(Marker marker: markerList){
            marker.getGroup().toFront();
            marker.getTimeLineOn().play();
        }
        timelineActiveOnMouseClick.play();
        timelineActiveDialog.play();
    }

    @Override
    public void off() {
        for(Marker marker: markerList){
            marker.getTimeLineOff().play();
        }
        timelineDeactivateOnMouseClick.play();
        timelineDeactivateDialog.play();
    }
}
