package engine;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Engine {
    List<Wrapper> wrapperList = new ArrayList<>();
    public Engine(Parent parent,ImageView... imageViews){
        for(ImageView view : imageViews){
            wrapperList.add(new Wrapper(view));
        }
        parent.setOnMouseClicked(mouseEvent -> {
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
}
