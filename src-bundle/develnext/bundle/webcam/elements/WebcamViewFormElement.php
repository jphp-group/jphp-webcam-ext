<?php


namespace develnext\bundle\webcam\elements;


use ide\formats\form\AbstractFormElement;
use php\gui\UXNode;
use php\gui\UXWebcamView;

class WebcamViewFormElement extends AbstractFormElement{

    public function getElementClass(){
        return UXWebcamView::class;
    }

    public function getName(){
        return 'Веб-камера';
    }
    public function getGroup(){
        return 'Дополнительно';
    }

    public function getIcon(){
        return 'develnext/bundle/webcam/webcam16.png';
    }
    public function getIdPattern(){
        return "webcamView%s";
    }
    /**
     * @return UXNode
     */
    public function createElement(){
        $view = new UXWebcamView();
        $view->placeholderColor = 'black';
        return $view;
    }
    public function getDefaultSize(){
        return [300, 200];
    }
    public function isOrigin($any){
        return get_class($any) == UXWebcamView::class;
    }
}