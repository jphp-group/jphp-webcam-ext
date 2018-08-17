package org.develnext.jphp.ext.webcam.support.memory;

import org.develnext.jphp.ext.webcam.support.control.WebcamView;
import php.runtime.Memory;
import php.runtime.env.Environment;
import php.runtime.env.TraceInfo;
import php.runtime.memory.StringMemory;
import php.runtime.memory.support.MemoryOperation;

public class WebcamViewModeMemoryOperation extends MemoryOperation<WebcamView.WebcamViewMode> {
    @Override
    public Class<?>[] getOperationClasses() {
        return new Class[]{WebcamView.WebcamViewMode.class};
    }

    @Override
    public WebcamView.WebcamViewMode convert(Environment environment, TraceInfo traceInfo, Memory memory) throws Throwable {
        return WebcamView.WebcamViewMode.valueOf(memory.toString());
    }

    @Override
    public Memory unconvert(Environment environment, TraceInfo traceInfo, WebcamView.WebcamViewMode mode) throws Throwable {
        return new StringMemory(mode.toString());
    }
}
