<?php


namespace webcam;


use php\lang\Invoker;

class WebcamMotionDetector{
    /**
     * @var int
     */
    public $interval;
    /**
     * @var int
     */
    public $maxMotionPoints;
    /**
     * @var int
     */
    public $pointRange;
    /**
     * @var float
     */
    public $motionArea;
    /**
     * @var bool
     */
    public $motion;
    /**
     * @var Webcam
     */
    public $webcam;

    function __construct(Webcam $webcam){}

    function start(){}
    function stop(){}

    function setPixelThreshold(int $value){}
    function setAreaThreshold(float $value){}

    function setInertia(int $value){}
    function clearInertia(){}
    /**
     * @return Invoker
     */
    public function addMotionListener(callable $callable){}
    /*
     * @return bool
     */
    public function removeMotionListener(Invoker $invoker){}
}