package engine;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class MarkerImage {
    private Point2D pos;
    private ImageView imageView;
    private Animation animation;

    public MarkerImage(Pane pane, double x, double y) {
        imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/marks/building.png"))));
        pane.getChildren().add(imageView);

        imageView.setScaleX(Interfaces.markerImageStart.getX());
        imageView.setScaleY(Interfaces.markerImageStart.getY());

        Point2D center = UtilityFunctions.getCenterObject(imageView);

        pos = new Point2D(
                x - center.getX(),
                y - center.getY()
        );
        imageView.setLayoutY(pos.getY());
        imageView.setLayoutX(pos.getX());
        this.animation = new AnimationMarkerImage(this);

    }

    public Point2D getCenter(){
        return pos;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Animation getAnimation() {
        return animation;
    }
}
