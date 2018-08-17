<?php


namespace develnext\bundle\webcam\tags;


use ide\formats\form\AbstractFormElement;
use ide\formats\form\AbstractFormElementTag;
use php\gui\UXWebcamView;
use php\xml\DomElement;

class WebcamViewFormElementTag extends AbstractFormElementTag{
    public function getTagName(){
        return 'org.develnext.jphp.ext.webcam.support.control.WebcamView';
    }
    public function getElementClass(){
        return UXWebcamView::class;
    }
    public function writeAttributes($node, DomElement $element){
        /** @var UXWebcamView $node */
        $element->setAttribute('openMode', $node->openMode);
        $element->setAttribute('closeMode', $node->closeMode);
        $element->setAttribute('stretch', $node->stretch ? 'true' : 'false');
        $element->setAttribute('centered', $node->centered ? 'true' : 'false');
        $element->setAttribute('flipX', $node->flipX ? 'true' : 'false');
        $element->setAttribute('flipY', $node->flipY ? 'true' : 'false');
        if($node->placeholderColor){
            $element->setAttribute('placeholderFill', $node->placeholderColor->getWebValue());
        }
    }
}