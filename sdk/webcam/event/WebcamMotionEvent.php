<?php


namespace webcam\event;


use php\gui\UXImage;
use webcam\Webcam;

class WebcamMotionEvent{
    /**
     * @var Webcam
     */
    public $webcam;
    /**
     * @var float
     */
    public $area;
    /**
     * @var array
     * [x, y]
     */
    public $cog;
    /**
     * @var array[]
     */
    public $points;
    /**
     * @var UXImage
     */
    public $currentImage;
    /**
     * @var UXImage
     */
    public $previousImage;
}