package engine;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.util.Duration;

public class AnimationMarkerImage implements Animation{
    private final MarkerImage markerImage;
    private final Point2D startPos;
    private final Point2D endPos;
    private Timeline timeLineOn;
    private Timeline timeLineOff;


    public AnimationMarkerImage(MarkerImage markerImage){

        this.markerImage = markerImage;
        this.startPos = markerImage.getCenter();
        this.endPos = startPos;


        setTimeLineOn();
        setTimeLineOff();
    }

    private void setTimeLineOn(){
        this.timeLineOn = setTimeline(endPos,
                Interfaces.markerImageEnd.getY(),
                Interfaces.markerImageEnd.getX()
        );
    }

    private void setTimeLineOff(){
        this.timeLineOff = setTimeline(startPos,
                Interfaces.markerImageStart.getY(),
                Interfaces.markerImageStart.getX()
        );
    }


    private Timeline setTimeline(Point2D endPos, double endScaleY, double endScaleX) {
        KeyValue rad = new KeyValue(markerImage.getImageView().layoutYProperty(), endPos.getY(), Interpolator.LINEAR);
        KeyValue sizeY = new KeyValue(markerImage.getImageView().scaleYProperty(), endScaleY, Interpolator.LINEAR);
        KeyValue sizeX = new KeyValue(markerImage.getImageView().scaleXProperty(), endScaleX, Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(200),rad,sizeX,sizeY);
        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(keyFrame);
        return timeLine;
    }

    @Override
    public void on() {
        markerImage.getImageView().toFront();
        timeLineOn.play();
    }

    @Override
    public void off() {
        timeLineOff.play();
    }

    @Override
    public void update() {
        ;
    }
}
