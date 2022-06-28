package engine;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Pair;

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

                Color color = pixelReader.getColor(i,j);

                if(r + g + b < 255 * 3 - 10 && r + g + b > 0){
                    r -= delta;
                    g -= delta;
                    b -= delta;
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

    /*
    * This function for class Marker (draw marker)
    * */
    public static Pair<Point2D,Point2D> getPointCircleLine(Circle circle, Point2D point){
        double xc = circle.getLayoutX();
        double yc = circle.getLayoutY();
        double rad = circle.getRadius();
        double a4 = -2*xc;
        double a5 = 2*yc;
        double a6 = xc*xc + yc*yc - rad * rad;
        double xV = point.getX();
        double yV = point.getY();
        double a = (-a4/(2*yV) - xV/yV)/(1 + a5/(2*yV));
        double b = (-a5/2 - (xV * a4)/(yV * 2) - a6/yV)/(1 + a5/(2*yV));
        double A = -1 - a*a;
        double B = 2*xc - 2*a*b;
        double C = rad*rad - b*b - xc*xc;
        double D_val = Math.sqrt(B*B - 4*A*C);
        double x1 = (-B + D_val)/(2*A);
        double x2 = (-B - D_val)/(2*A);
        double y1 = Math.sqrt(rad*rad - (x1 - xc)*(x1 - xc)) + yc;
        double y2 = Math.sqrt(rad*rad - (x2 - xc)*(x2 - xc)) + yc;
        return new Pair<>(new Point2D(x1,y1),new Point2D(x2,y2));
    }

    public static Point2D getCenterObject(Node node){
        double radX = ( - node.getBoundsInParent().getMinX() + node.getBoundsInParent().getMaxX())/2;
        double radY = ( - node.getBoundsInParent().getMinY() + node.getBoundsInParent().getMaxY())/2;
        return new Point2D(
                node.getBoundsInParent().getMinX() + radX,
                node.getBoundsInParent().getMinY() + radY
        );
    }
}
