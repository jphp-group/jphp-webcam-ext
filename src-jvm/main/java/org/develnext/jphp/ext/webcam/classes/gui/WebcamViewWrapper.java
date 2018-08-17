package org.develnext.jphp.ext.webcam.classes.gui;

import com.github.sarxos.webcam.Webcam;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.develnext.jphp.ext.javafx.classes.UXControl;
import org.develnext.jphp.ext.webcam.support.control.WebcamView;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXWebcamView")
@Reflection.Namespace("php\\gui")
public class WebcamViewWrapper extends UXControl<WebcamView> {
    public WebcamViewWrapper(Environment env, WebcamView wrappedObject) {
        super(env, wrappedObject);
    }
    public WebcamViewWrapper(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    interface WrappedInterface{
        void play();
        void stop();

        @Reflection.Property Webcam webcam();

        @Reflection.Property WebcamView.WebcamViewMode closeMode();
        @Reflection.Property WebcamView.WebcamViewMode openMode();
        @Reflection.Property boolean stopped();
        @Reflection.Property boolean stretch();
        @Reflection.Property boolean centered();
        @Reflection.Property boolean flipX();
        @Reflection.Property boolean flipY();
    }
    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new WebcamView();
    }
    @Reflection.Getter
    public Color getPlaceholderColor(){
        Paint paint = getWrappedObject().getPlaceholderFill();
        return (paint instanceof Color) ? (Color)paint : null;
    }
    @Reflection.Setter
    public void setPlaceholderColor(Color color){
        getWrappedObject().setPlaceholderFill(color);
    }
}
