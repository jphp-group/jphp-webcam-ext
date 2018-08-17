package org.develnext.jphp.ext.webcam;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import org.develnext.jphp.ext.webcam.classes.WebcamMotionDetectorWrapper;
import org.develnext.jphp.ext.webcam.classes.event.WebcamDiscoveryEventWrapper;
import org.develnext.jphp.ext.webcam.classes.event.WebcamMotionEventWrapper;
import org.develnext.jphp.ext.webcam.classes.gui.WebcamViewWrapper;
import org.develnext.jphp.ext.webcam.classes.WebcamWrapper;
import org.develnext.jphp.ext.webcam.support.control.WebcamView;
import org.develnext.jphp.ext.webcam.support.memory.WebcamViewModeMemoryOperation;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;
import php.runtime.memory.support.MemoryOperation;

public class WebcamExtension extends Extension {
    public static final String NS = "webcam";
    
    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }
    
    @Override
    public void onRegister(CompileScope scope) {
        registerWrapperClass(scope, WebcamView.class, WebcamViewWrapper.class);
        MemoryOperation.register(new WebcamViewModeMemoryOperation());


        registerWrapperClass(scope, Webcam.class, WebcamWrapper.class);
        registerWrapperClass(scope, WebcamMotionDetector.class, WebcamMotionDetectorWrapper.class);

        registerWrapperClass(scope, WebcamDiscoveryEvent.class, WebcamDiscoveryEventWrapper.class);
        registerWrapperClass(scope, WebcamMotionEvent.class, WebcamMotionEventWrapper.class);
    }
}