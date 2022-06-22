package engine;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import javafx.util.Pair;

public class Marker {
    private final Circle circle;
    private final Circle innerCircle;
    private final Polygon polygon;
    private final Group group;
    private Point2D startPos;
    private Point2D endPos;
    private Point2D posDownCenter;
    private Timeline timeLineOn;
    private Timeline timeLineOff;
    private final double startScaleX = 0.07;
    private final double startScaleY = 0.07;
    private final double endScaleX = 0.1;
    private final double endScaleY = 0.1;
    private final double RAD = 50;
    public Marker(Pane pane){

        this.circle = new Circle(RAD,Color.RED);
        this.innerCircle = new Circle(RAD/2, Color.WHITE);
        this.polygon = new Polygon();
        this.group = new Group(circle,polygon,innerCircle);
        pane.getChildren().add(group);


        // add triangle
        this.posDownCenter = new Point2D(circle.getLayoutX(),circle.getLayoutY() + circle.getRadius() * 3);
        Pair<Point2D,Point2D> points = UtilityFunctions.getPointCircleLine(circle,posDownCenter);
        Point2D one = points.getKey();
        Point2D two = points.getValue();
        polygon.getPoints().addAll(one.getX(), one.getY(),two.getX(),two.getY(),posDownCenter.getX(),posDownCenter.getY());
        polygon.setFill(Color.RED);
        group.setScaleX(startScaleX);
        group.setScaleY(startScaleY);


    }

    private void updateValues(){
        group.setScaleX(startScaleX);
        group.setScaleY(startScaleY);
        this.startPos = new Point2D(group.getLayoutX(),group.getLayoutY());
        this.posDownCenter = new Point2D( (group.getBoundsInParent().getMinX() +
                group.getBoundsInParent().getMaxX())/2,group.getBoundsInParent().getMaxY());

        group.setScaleX(endScaleX);
        group.setScaleY(endScaleY);
        this.endPos =  new Point2D(startPos.getX(),startPos.getY() - (group.getBoundsInParent().getMaxY() - posDownCenter.getY()));
        System.out.println(posDownCenter);

        group.setScaleX(startScaleX);
        group.setScaleY(startScaleY);
    }

    private void setTimeLineOn(){
        this.timeLineOn = setTimeline(endPos, endScaleY, endScaleX);
    }

    private void setTimeLineOff(){
        this.timeLineOff = setTimeline(startPos, startScaleY, startScaleX);
    }


    private Timeline setTimeline(Point2D endPos, double endScaleY, double endScaleX) {
        KeyValue rad = new KeyValue(group.layoutYProperty(), endPos.getY(), Interpolator.LINEAR);
        KeyValue sizeY = new KeyValue(group.scaleYProperty(), endScaleY, Interpolator.LINEAR);
        KeyValue sizeX = new KeyValue(group.scaleXProperty(), endScaleX, Interpolator.LINEAR);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(200),rad,sizeX,sizeY);
        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(keyFrame);
        return timeLine;
    }

    public void setPosition(double x, double y){
        group.setLayoutX(x);
        group.setLayoutY(y - group.getBoundsInParent().getMaxY());
        updateValues();
        setTimeLineOn();
        setTimeLineOff();
    }

    public Group getGroup() {
        return group;
    }
}
