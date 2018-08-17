<?php
namespace php\gui;

use php\gui\paint\UXColor;
use webcam\Webcam;

class UXWebcamView extends UXControl{
    /**
     * @var Webcam
     */
    public $webcam;
    /**
     * @var UXColor
     */
    public $placeholderColor;
    /**
     * @var string
     * NOT_USE, SYNC, ASYNC
     */
    public $openMode;
    /**
     * @var string
     * NOT_USE, SYNC, ASYNC
     */
    public $closeMode;
    /**
     * @var bool
     */
    public $stretch;
    /**
     * @var bool
     */
    public $centered;
    /**
     * @var bool
     */
    public $stopped;
    /**
     * @var bool
     */
    public $flipX;
    /**
     * @var bool
     */
    public $flipY;

    function play(){}

    function stop(){}
}