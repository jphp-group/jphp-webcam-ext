package org.develnext.jphp.ext.webcam.support.skin;

import com.github.sarxos.webcam.Webcam;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.SkinBase;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.develnext.jphp.ext.webcam.support.control.WebcamView;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WebcamViewSkin extends SkinBase<WebcamView> {
    private final Canvas canvas;
    private final GraphicsContext gc;
    private final AnimationTimer timer;

    public WebcamViewSkin(WebcamView view) {
        super(view);
        canvas = new Canvas();
        gc = canvas.getGraphicsContext2D();
        view.widthProperty().addListener((obs, o, n) -> {
            canvas.setWidth(n.doubleValue());
        });
        view.heightProperty().addListener((obs, o, n) -> {
            canvas.setHeight(n.doubleValue());
        });


        timer = new AnimationTimer(){
            @Override
            public void handle(long now){
                if(view.isStopped()){
                    fillPlaceholder();
                    return;
                }

                Webcam webcam = view.webcamProperty().get();

                if(webcam == null){
                    fillPlaceholder();
                    return;
                }

                BufferedImage bufferedImage = webcam.getImage();
                if(bufferedImage == null){
                    fillPlaceholder();
                    return;
                }
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                Bounds bounds = calculateBounds(image.getWidth(), image.getHeight());

                double w1 = bounds.getWidth();
                double h1 = bounds.getHeight();

                double x1 = bounds.getMinX();
                double y1 = bounds.getMinY();

                gc.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), x1, y1, w1, h1);
            }
        };
        timer.start();

        getChildren().add(canvas);
    }
    private Bounds calculateBounds(double sw, double sh){
        return calculateBounds(sw, sh, false);
    }
    private Bounds calculateBounds(double sw, double sh, boolean forPlaceholder){
        WebcamView view = getSkinnable();


        double w = sw;
        double h = sh;
        double x = 0;
        double y = 0;

        if(view.isStretch()){
            w = canvas.getWidth();
            h = canvas.getHeight();
        }
        if(!forPlaceholder){
            if(view.isFlipX()){
                x = w;
                w = -w;
            }
            if(view.isFlipY()){
                y = h;
                h = -h;
            }
        }
        if(view.isCentered()){
            x = (canvas.getWidth() - w) / 2;
            y = (canvas.getHeight() - h) / 2;
        }

        return new BoundingBox(x, y, w, h);
    }
    private void fillPlaceholder(){
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Paint paint = getSkinnable().getPlaceholderFill();
        if(paint != null){
            double sw;
            double sh;

            Dimension dimension = getSkinnable().getWebcam() == null ? null : getSkinnable().getWebcam().getViewSize();
            if(dimension != null){
                sw = dimension.getWidth();
                sh = dimension.getHeight();
            }
            else{
                sw = canvas.getWidth();
                sh = canvas.getHeight();
            }

            Bounds bounds = calculateBounds(sw, sh, true);
            gc.setFill(paint);
            gc.fillRect(bounds.getMinX(), bounds.getMinY(), bounds.getWidth(), bounds.getHeight());
        }
    }
}
