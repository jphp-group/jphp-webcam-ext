package org.develnext.jphp.ext.webcam.classes;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import javafx.beans.value.ChangeListener;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.develnext.jphp.ext.javafx.JavaFXExtension;
import org.develnext.jphp.ext.webcam.WebcamExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.ext.core.classes.WrapInvoker;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.memory.ArrayMemory;
import php.runtime.reflection.ClassEntity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;


@Reflection.Name("Webcam")
@Reflection.Namespace(WebcamExtension.NS)
@Reflection.Abstract
public class WebcamWrapper extends BaseWrapper<Webcam> {
    public WebcamWrapper(Environment env, Webcam wrappedObject) {
        super(env, wrappedObject);
    }
    public WebcamWrapper(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }
    interface WrappedInterface{
        boolean open();
        boolean open(boolean async);
        boolean close();

        @Reflection.Getter("open") boolean isOpen();
        @Reflection.Getter boolean getName();
    }

    @Reflection.Getter
    public Memory getViewSize(){
        Dimension dimension = getWrappedObject().getViewSize();
        if(dimension == null){
            return Memory.NULL;
        }

        ArrayMemory res = new ArrayMemory();
        res.refOfIndex("width").assign(dimension.getWidth());
        res.refOfIndex("height").assign(dimension.getHeight());

        return res;
    }

    @Reflection.Signature
    public Image getImage(){
        BufferedImage bufferedImage = getWrappedObject().getImage();
        if(bufferedImage == null){
            return null;
        }

        return SwingFXUtils.toFXImage(bufferedImage, null);
    }


    @Reflection.Signature
    public static Webcam getDefault(){
        return Webcam.getDefault();
    }
    @Reflection.Signature
    public static Webcam getDefault(long timeout) throws TimeoutException{
        return Webcam.getDefault(timeout);
    }

    @Reflection.Signature
    public static List<Webcam> getWebcams(){
        return Webcam.getWebcams();
    }
    @Reflection.Signature
    public static List<Webcam> getWebcams(long timeout) throws TimeoutException {
        return Webcam.getWebcams(timeout);
    }

    private static final WebcamDiscoveryListener webcamDiscoveryListener = new WebcamDiscoveryListener(){
        @Override
        public void webcamFound(WebcamDiscoveryEvent event){
            for(Invoker invoker : webcamFoundInvokers){
                invoker.callAny(event);
            }
        }

        @Override
        public void webcamGone(WebcamDiscoveryEvent event){
            for(Invoker invoker : webcamGoneInvokers){
                invoker.callAny(event);
            }
        }
    };
    static{
        Webcam.addDiscoveryListener(webcamDiscoveryListener);
    }

    private static final List<Invoker> webcamFoundInvokers = new ArrayList<>();
    private static final List<Invoker> webcamGoneInvokers = new ArrayList<>();

    @Reflection.Signature
    public static WrapInvoker addWebcamFoundListener(Environment env, Invoker handler){
        webcamFoundInvokers.add(handler);
        return new WrapInvoker(env, handler);
    }
    @Reflection.Signature
    public static WrapInvoker addWebcamGoneListener(Environment env, Invoker handler){
        webcamGoneInvokers.add(handler);
        return new WrapInvoker(env, handler);
    }
    @Reflection.Signature
    public static boolean removeWebcamFoundListener(Invoker handler){
        return webcamFoundInvokers.remove(handler);
    }
    @Reflection.Signature
    public static boolean removeWebcamGoneListener(Invoker handler){
        return webcamGoneInvokers.remove(handler);
    }
}
