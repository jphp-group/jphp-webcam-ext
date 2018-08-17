package org.develnext.jphp.ext.webcam.support.control;

import com.github.sarxos.webcam.Webcam;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.develnext.jphp.ext.webcam.support.skin.WebcamViewSkin;

public class WebcamView extends Control{

    public WebcamView(){
        webcamProperty.addListener((obs, o, n) -> {

            if(o != null){
                switch(getCloseMode()){
                    case SYNC:
                    case ASYNC:
                        o.close();
                }
            }
            if(n != null){
                switch(getOpenMode()){
                    case SYNC:
                        n.open(false);
                    break;
                    case ASYNC:
                        n.open(true);
                    break;
                }
            }
        });
    }

    public final void play(){
        stopped.set(false);
    }
    public final void stop(){
        stopped.set(true);
    }


    private final ObjectProperty<Webcam> webcamProperty = new SimpleObjectProperty<>();

    public final void setWebcam(Webcam webcam){
        webcamProperty.set(webcam);
    }
    public final Webcam getWebcam(){
        return webcamProperty.get();
    }
    public final ObjectProperty<Webcam> webcamProperty(){
        return webcamProperty;
    }


    private final ObjectProperty<Paint> placeholderFillProperty = new SimpleObjectProperty<>();

    public final void setPlaceholderFill(Paint paint){
        placeholderFillProperty.set(paint);
    }
    public final Paint getPlaceholderFill(){
        return placeholderFillProperty.get();
    }
    public final ObjectProperty<Paint> placeholderFillProperty(){
        return placeholderFillProperty;
    }


    private final ObjectProperty<WebcamViewMode> closeModeProperty = new SimpleObjectProperty<>(WebcamViewMode.NOT_USE);

    public final void setCloseMode(WebcamViewMode value){
        closeModeProperty.set(value);
    }
    public final WebcamViewMode getCloseMode(){
        return closeModeProperty.get();
    }
    public final ObjectProperty<WebcamViewMode> closeModeProperty(){
        return closeModeProperty;
    }


    private final ObjectProperty<WebcamViewMode> openModeProperty = new SimpleObjectProperty<>(WebcamViewMode.NOT_USE);

    public final void setOpenMode(WebcamViewMode value){
        openModeProperty.set(value);
    }
    public final WebcamViewMode getOpenMode(){
        return openModeProperty.get();
    }
    public final ObjectProperty<WebcamViewMode> openModeProperty(){
        return openModeProperty;
    }


    private final ReadOnlyBooleanWrapper stopped = new ReadOnlyBooleanWrapper(true);

    public final boolean isStopped(){
        return stopped.get();
    }
    public final ReadOnlyBooleanProperty stoppedProperty(){
        return stopped.getReadOnlyProperty();
    }


    private final BooleanProperty stretchProperty = new SimpleBooleanProperty(false);

    public final void setStretch(boolean value){
        stretchProperty.set(value);
    }
    public final boolean isStretch(){
        return stretchProperty.get();
    }
    public final BooleanProperty stretchProperty(){
        return stretchProperty;
    }


    private final BooleanProperty centeredProperty = new SimpleBooleanProperty(false);

    public final void setCentered(boolean value){
        centeredProperty.set(value);
    }
    public final boolean isCentered(){
        return centeredProperty.get();
    }
    public final BooleanProperty centeredProperty(){
        return centeredProperty;
    }

    private final BooleanProperty flipXProperty = new SimpleBooleanProperty(false);

    public final void setFlipX(boolean value){
        flipXProperty.set(value);
    }
    public final boolean isFlipX(){
        return flipXProperty.get();
    }
    public final BooleanProperty flipXProperty(){
        return flipXProperty;
    }

    private final BooleanProperty flipYProperty = new SimpleBooleanProperty(false);

    public final void setFlipY(boolean value){
        flipYProperty.set(value);
    }
    public final boolean isFlipY(){
        return flipYProperty.get();
    }
    public final BooleanProperty flipYProperty(){
        return flipYProperty;
    }


    @Override
    protected Skin<?> createDefaultSkin() {
        return new WebcamViewSkin(this);
    }


    public enum WebcamViewMode{
        SYNC,
        ASYNC,
        NOT_USE;
    }
}