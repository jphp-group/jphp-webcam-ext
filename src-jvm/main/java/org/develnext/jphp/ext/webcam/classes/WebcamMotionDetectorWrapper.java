package org.develnext.jphp.ext.webcam.classes;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionListener;
import org.develnext.jphp.ext.webcam.WebcamExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.ext.core.classes.WrapInvoker;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.memory.ArrayMemory;
import php.runtime.reflection.ClassEntity;

import java.awt.*;

@Reflection.Name("WebcamMotionDetector")
@Reflection.Namespace(WebcamExtension.NS)
public class WebcamMotionDetectorWrapper extends BaseWrapper<WebcamMotionDetector> {
    public WebcamMotionDetectorWrapper(Environment env, WebcamMotionDetector wrappedObject) {
        super(env, wrappedObject);
    }
    public WebcamMotionDetectorWrapper(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }
    interface WrappedInterface{
        void start();
        void stop();

        @Reflection.Getter int getInterval();
        @Reflection.Getter int getMaxMotionPoints();
        @Reflection.Getter int getPointRange();
        @Reflection.Getter double getMotionArea();
        @Reflection.Getter("motion") boolean isMotion();
        @Reflection.Getter Webcam getWebcam();

        @Reflection.Setter void setInterval(int value);

        @Reflection.Signature void setPixelThreshold(int value);
        @Reflection.Signature void setMaxMotionPoints(int value);
        @Reflection.Signature void setPointRange(int value);
        @Reflection.Signature void setInertia(int value);
        @Reflection.Signature void setAreaThreshold(double value);
    }

    @Reflection.Signature
    public void __construct(Webcam webcam){
        __wrappedObject = new WebcamMotionDetector(webcam);
    }
    @Reflection.Getter
    public ArrayMemory getMotionCog(){
        ArrayMemory result = new ArrayMemory();

        Point cog = getWrappedObject().getMotionCog();

        result.add(cog.getX());
        result.add(cog.getY());

        return result;
    }

    @Reflection.Signature
    public WrapInvoker addMotionListener(Environment env, Invoker invoker){
        WebcamMotionListener listener = (e) -> invoker.callAny(e);

        getWrappedObject().addMotionListener(listener);

        WrapInvoker wrapInvoker = new WrapInvoker(env, invoker);
        invoker.setUserData(listener);
        return wrapInvoker;
    }
    @Reflection.Signature
    public boolean removeMotionListener(Invoker invoker){
        if(invoker.getUserData() instanceof WebcamMotionListener){
            return getWrappedObject().removeMotionListener((WebcamMotionListener)invoker.getUserData());
        }
        return false;
    }
}
