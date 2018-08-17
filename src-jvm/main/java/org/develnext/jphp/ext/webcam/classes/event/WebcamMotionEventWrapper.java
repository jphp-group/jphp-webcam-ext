package org.develnext.jphp.ext.webcam.classes.event;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionEvent;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.develnext.jphp.ext.webcam.WebcamExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.memory.ArrayMemory;
import php.runtime.reflection.ClassEntity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Reflection.Name("WebcamMotionEvent")
@Reflection.Namespace(WebcamExtension.NS+"\\event")
@Reflection.Abstract
public class WebcamMotionEventWrapper extends BaseWrapper<WebcamMotionEvent> {
    public WebcamMotionEventWrapper(Environment env, WebcamMotionEvent wrappedObject) {
        super(env, wrappedObject);
    }
    public WebcamMotionEventWrapper(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    interface WrappedInterface{
        @Reflection.Getter Webcam getWebcam();
        @Reflection.Getter double getArea();
    }

    @Reflection.Getter
    public Memory getCog(){
        Point cog = getWrappedObject().getCog();

        ArrayMemory res = new ArrayMemory();

        res.add(cog.getX());
        res.add(cog.getY());

        return res;
    }

    @Reflection.Getter
    public Memory getPoints(){
        ArrayMemory result = new ArrayMemory();

        ArrayList<Point> pointList = getWrappedObject().getPoints();
        if(pointList == null){
            return result;
        }
        for(Point point : pointList){
            ArrayMemory pointInfo = new ArrayMemory();

            pointInfo.add(point.getX());
            pointInfo.add(point.getY());

            result.add(pointInfo);
        }
        return result;
    }

    @Reflection.Getter
    public Image getCurrentImage(){
        BufferedImage bufferedImage = getWrappedObject().getCurrentImage();

        return bufferedImage == null ? null : SwingFXUtils.toFXImage(bufferedImage, null);
    }
    @Reflection.Getter
    public Image getPreviousImage(){
        BufferedImage bufferedImage = getWrappedObject().getPreviousImage();

        return bufferedImage == null ? null : SwingFXUtils.toFXImage(bufferedImage, null);
    }

}