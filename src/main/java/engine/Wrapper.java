package engine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Wrapper{
    private final Image oldColor;
    private final ImageView imageView;
    private final Animations animation;
    private final double coefficient;
    private Image newColor;
    private boolean active;

    Wrapper(ImageView imageView) {
        this.oldColor = imageView.getImage();
        this.newColor = null;
        this.imageView = imageView;
        this.active = false;
        this.animation = new Animations(imageView);
        this.coefficient = imageView.getImage().getHeight()/imageView.getImage().getWidth();
    }


    public void setOnMouseClicked(double mouseX, double mouseY){
        if(!contains(mouseX,mouseY))
            return;
        mouseX -= imageView.getLayoutX();
        mouseY -= imageView.getLayoutY();
        if(!active) {
            Color color = UtilityFunctions.getPixelColor(imageView,mouseX,mouseY);
            System.out.println(color);
            if(UtilityFunctions.TrueColor(color)) {
                on();
            }
        }else{
            off();
        }

    }

    public void on(){
        imageView.toFront();
        UtilityFunctions.reColor(imageView);
        if (this.newColor == null) {
            this.newColor = imageView.getImage();
        }
        animation.on();
        active = true;
    }

    public void off(){
        imageView.setImage(oldColor);
        animation.off();
        active = false;

    }

    public Image getNewColor() {
        return newColor;
    }

    public Image getOldColor() {
        return oldColor;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public boolean isActive(){
        return active;
    }

    public boolean contains(double x, double y){
        double width = imageView.getFitWidth();
        double height = imageView.getFitHeight();
        if(height == 0){
            height = width * coefficient;
        }else{
            width = height/coefficient;
        }
        double x0 = imageView.getLayoutX();
        double y0 = imageView.getLayoutY();
        if((x < x0 + width) && (x >= x0)){
            return (y < y0 + height) && (y >= y0);
        }
        return false;

    }
}

