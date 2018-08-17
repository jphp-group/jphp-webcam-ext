package org.develnext.jphp.ext.webcam.classes.event;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;

import com.github.sarxos.webcam.WebcamDiscoveryListener;
import org.develnext.jphp.ext.webcam.WebcamExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("WebcamDiscoveryEvent")
@Reflection.Namespace(WebcamExtension.NS+"\\event")
@Reflection.Abstract
public class WebcamDiscoveryEventWrapper extends BaseWrapper<WebcamDiscoveryEvent> {
    public WebcamDiscoveryEventWrapper(Environment env, WebcamDiscoveryEvent wrappedObject) {
        super(env, wrappedObject);
    }
    public WebcamDiscoveryEventWrapper(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    interface WrappedInterface{
        @Reflection.Getter Webcam getWebcam();
    }

    @Reflection.Signature
    public boolean isAdded(){
        return getWrappedObject().getType() == WebcamDiscoveryEvent.ADDED;
    }
    @Reflection.Signature
    public boolean isRemoved(){
        return getWrappedObject().getType() == WebcamDiscoveryEvent.REMOVED;
    }
}
