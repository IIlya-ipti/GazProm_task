package engine;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.time.temporal.IsoFields;

public class ImageProject {
    private final ImageView imageView;
    private final double coefficient;
    private final Animation animation;

    ImageProject(ImageView imageView){
        this.imageView = imageView;
        this.coefficient = imageView.getImage().getHeight()/imageView.getImage().getWidth();
        this.animation = new AnimationImageProject(this);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Animation getAnimation() {
        return animation;
    }

    public double getCoefficient() {
        return coefficient;
    }
    public void update(){
        ;
    }
}
