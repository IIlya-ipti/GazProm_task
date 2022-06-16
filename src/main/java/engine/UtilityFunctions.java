package engine;

import javafx.scene.image.*;
import javafx.scene.paint.Color;

public class UtilityFunctions {
    static final int delta = 30;

    public static void reColor(ImageView input){
        Image inputImage = input.getImage();

        int W = (int) inputImage.getWidth();
        int H = (int) inputImage.getHeight();
        WritableImage writableImage = new WritableImage(W,H);

        PixelReader pixelReader = inputImage.getPixelReader();
        PixelWriter pixelWriter = writableImage.getPixelWriter();

        //int nr = (int) newColor.getRed()    * 255;
        //int ng = (int) newColor.getGreen()  * 255;
        //int nb = (int) newColor.getBlue()   * 255;

        for(int j = 0;j < H;j++){
            for(int i = 0;i < W;i++){
                int argb = pixelReader.getArgb(i,j);
                int a = (argb >> 24) & 0xFF;
                int r = (argb >> 16) & 0xFF;
                int g = (argb >> 8)  & 0xFF;
                int b =  argb        & 0xFF;

                if(r + g + b < 255 * 3 - 10 && r + g + b > 0){
                    r -= delta;
                    g -= delta;
                    b -= delta;
                    //r = nr;
                    //g = ng;
                    //b = nb;
                }
                argb = (a << 24) | (r << 16) | (g << 8) | b;
                pixelWriter.setArgb(i,j,argb);
            }
        }

        input.setImage(writableImage);
    }
    public static Color getPixelColor(ImageView image, double localX, double localY) {
        Image originalImage = image.getImage();

        double oW = originalImage.getWidth();
        double oH = originalImage.getHeight();

        double nW = image.getFitWidth();
        double nH = image.getFitHeight();

        if(nH == 0) {
            double coefficientW = oW / nW;
            return originalImage.getPixelReader().getColor((int) (localX * coefficientW), (int) (localY * coefficientW));
        }
        else{
            double coefficientH = oH / nH;
            return originalImage.getPixelReader().getColor((int) (localX * coefficientH), (int) (localY * coefficientH));
        }
    }
    public static boolean TrueColor(Color color){
        int r = (int)(color.getRed()    * 255);
        int g = (int)(color.getGreen()  * 255);
        int b = (int)(color.getBlue()   * 255);
        return 100 < (r + g + b) && (r + g + b) < 255 * 3 - 40;
    }

}
