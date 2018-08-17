<?php
namespace develnext\bundle\webcam;

use develnext\bundle\webcam\elements\WebcamViewFormElement;
use ide\bundle\AbstractBundle;
use ide\bundle\AbstractJarBundle;
use ide\formats\GuiFormFormat;
use ide\Ide;
use ide\library\IdeLibraryBundleResource;
use ide\project\Project;
use php\io\File;
use php\desktop\Runtime;
use php\lib\fs;
use php\lib\str;
use php\lib\arr;

class WebcamBundle extends AbstractJarBundle{
    function onAdd(Project $project, AbstractBundle $owner = null){
        parent::onAdd($project, $owner);
        /** @var GuiFormFormat $format */
        $format = Ide::get()->getRegisteredFormat(GuiFormFormat::class);
        if($format){
            $format->registerInternalList('.dn/bundle/webcam/formComponents');
        }
    }
    function onRemove(Project $project, AbstractBundle $owner = null){
        parent::onRemove($project, $owner);
        /** @var GuiFormFormat $format */
        $format = Ide::get()->getRegisteredFormat(GuiFormFormat::class);
        if($format){
            $format->unregisterInternalList('.dn/bundle/webcam/formComponents');
        }
    }
    public function onRegister(IdeLibraryBundleResource $resource)
    {
        parent::onRegister($resource);
        
        $jars = ['bridj', 'slf4j-api', 'webcam-capture', 'jphp-webcam-ext'];
        $files = fs::scan($resource->getPath(), null);
        $filesToAdd = [];
        foreach($files as $j => $file){
            if(str::startsWith($file->getName(), 'dn-')){
                continue;
            }
            foreach($jars as $i => $jar){
                if(str::contains($file->getName(), $jar)){
                    $filesToAdd[$i] = $file;
                    unset($jars[$i]);
                    unset($files[$j]);
                    break;
                }
            }
        }
        $filesToAdd = arr::sortByKeys($filesToAdd);
        
        
        try{
            foreach($filesToAdd as $file){
                Runtime::addJar($file);
            }
        }
        catch(\Throwable $e){
            file_put_contents('c:/users/broelik/desktop/result.txt', $e->getMessage());
        }
    }
}