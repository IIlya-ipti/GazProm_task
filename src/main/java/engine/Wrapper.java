package engine;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Wrapper{
    private final Image oldColor;
    private final ImageView imageView;
    private final double coefficient;
    private final Dialog dialog;
    private final List<Marker> markerList;
    private Image newColor;
    private boolean active;
    private Animations animation;
    private Pane parentPane;

    Wrapper(ImageView imageView, Pane TotalPane) {
        this.parentPane = (Pane) imageView.getParent();
        this.dialog = new Dialog(TotalPane,imageView);
        this.oldColor = imageView.getImage();
        this.newColor = null;
        this.imageView = imageView;
        this.active = false;
        this.coefficient = imageView.getImage().getHeight()/imageView.getImage().getWidth();
        this.markerList = new ArrayList<>();

    }


    public boolean setOnMouseClicked(double mouseX, double mouseY){
        if(!contains(mouseX,mouseY))
            return false;
        mouseX -= imageView.getLayoutX();
        mouseY -= imageView.getLayoutY();
        if(!active) {
            Color color = UtilityFunctions.getPixelColor(imageView,mouseX ,mouseY);
            if(UtilityFunctions.TrueColor(color)) {
                if(Engine.status == Status.ADMIN) {
                    Marker marker = new Marker(this.parentPane);
                    marker.setPosition(mouseX + imageView.getLayoutX(), mouseY + imageView.getLayoutY());
                    markerList.add(marker);
                }
                if(Engine.status == Status.USER) {
                    on();
                }
                return true;
            }
        }else{
            if(Engine.status == Status.USER) {
                off();
            }
            return true;
        }
        return false;

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

    public Dialog getDialog() {
        return dialog;
    }

    public Animations getAnimation() {
        return animation;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public List<Marker> getMarkerList() {
        return markerList;
    }

    public Pane getParentPane() {
        return parentPane;
    }

    public void update(){
        dialog.update();
        this.animation = new Animations(imageView,dialog,markerList);
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

