package engine;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Wrapper{
    private final Dialog dialog;
    private final List<MarkerImage> markerList;
    private final ImageProject imageProject;
    private boolean active;
    private final Pane parentPane;

    Wrapper(ImageView imageView, Pane TotalPane) {
        this.parentPane = (Pane) imageView.getParent();
        this.dialog = new Dialog(TotalPane,imageView);
        this.imageProject =  new ImageProject(imageView);
        this.active = false;
        this.markerList = new ArrayList<>();
    }

    /*
    *
    * if mouse click start animation
    *
    * */
    public boolean setOnMouseClicked(double mouseX, double mouseY){
        if(!contains(mouseX,mouseY))
            return false;
        ImageView imageView = imageProject.getImageView();
        mouseX -= imageView.getLayoutX();
        mouseY -= imageView.getLayoutY();
        if(!active) {
            Color color = UtilityFunctions.getPixelColor(imageView,mouseX ,mouseY);

            // color is null or not
            if(UtilityFunctions.TrueColor(color)) {

                // admin add new marker if admin click mouse
                if(Engine.status == Status.ADMIN) {

                    // add marker
                    markerList.add(new MarkerImage(
                            this.parentPane,
                            UserPath.CollegeOne,
                            mouseX + imageView.getLayoutX(),
                            mouseY + imageView.getLayoutY()));
                }
                // user start animation
                if(Engine.status == Status.USER) {
                    on();
                }
                return true;
            }
        }else{
            // user start end animation
            if(Engine.status == Status.USER) {
                off();
            }
            return true;
        }
        return false;

    }

    /*
    * start on animations
    * */
    public void on(){
        dialog.getAnimation().on();
        imageProject.getAnimation().on();
        for(MarkerImage markerImage : markerList){
            markerImage.getAnimation().on();
        }
        active = true;
    }

    /*
    * start off animations
    * */
    public void off(){
        dialog.getAnimation().off();
        imageProject.getAnimation().off();
        for(MarkerImage markerImage : markerList){
            markerImage.getAnimation().off();
        }
        active = false;

    }

    /*
    * update all objects in the wrapper
    * */
    public void update(){
        dialog.update();
        imageProject.update();
    }

    public boolean isActive(){
        return active;
    }

    /*
    * contains point or not in subject
    * */
    public boolean contains(double x, double y){
        ImageView imageView = imageProject.getImageView();

        double width = imageView.getFitWidth();
        double height = imageView.getFitHeight();
        if(height == 0){
            height = width * imageProject.getCoefficient();
        }else{
            width = height / imageProject.getCoefficient();
        }
        double x0 = imageView.getLayoutX();
        double y0 = imageView.getLayoutY();
        if((x < x0 + width) && (x >= x0)){
            return (y < y0 + height) && (y >= y0);
        }
        return false;

    }
}

