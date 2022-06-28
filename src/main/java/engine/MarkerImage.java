package engine;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class MarkerImage {
    private final Point2D pos;
    private final ImageView imageView;
    private final Animation animation;
    public static UserPath actualUserPath = null;

    public MarkerImage(Pane pane, UserPath userPath,double x, double y) {
        imageView = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                actualUserPath.path))));
        pane.getChildren().add(imageView);

        imageView.setScaleX(actualUserPath.startScale.getX());
        imageView.setScaleY(actualUserPath.startScale.getY());

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

    public static UserPath getActualUserPath() {
        return actualUserPath;
    }
}
