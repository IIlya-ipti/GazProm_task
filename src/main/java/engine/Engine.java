package engine;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Engine {
    public static Status status = Status.USER;
    List<Wrapper> wrapperList = new ArrayList<>();


    public Engine(Parent parent,Pane totalPane, ImageView... imageViews){
        for(ImageView view : imageViews){
            wrapperList.add(new Wrapper(view, totalPane));
        }
        parent.setOnMouseClicked(mouseEvent -> {
            System.out.println(mouseEvent.getX());
            boolean start = false;
            for(Wrapper wrapper : wrapperList){
                if(wrapper.isActive()){
                    wrapper.off();
                }else {
                    if(!start) {
                        start = wrapper.setOnMouseClicked(mouseEvent.getX(), mouseEvent.getY());
                    }
                }
            }
        });
    }
    public void update(){
        for(Wrapper wrapper : wrapperList){
            wrapper.update();
        }
    }
}
