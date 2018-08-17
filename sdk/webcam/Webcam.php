<?php
namespace webcam;


use php\gui\UXImage;
use php\lang\Invoker;

class Webcam{
    /**
     * @var string
     */
    public $name;
    /**
     * @var bool
     */
    public $open;
    /**
     * @var array
     * [width, height]
     */
    public $viewSize;

    /*
     * @return bool
     */
    function open(bool $async = false){}

    /*
     * @return bool
     */
    function close(){}

    /**
     * @return UXImage
     */
    function getImage(){}

    /**
     * @return Webcam
     */
    public static function getDefault(int $timeout = null){}

    /**
     * @return Webcam[]
     */
    public static function getWebcams(int $timeout = null){}

    /**
     * @return Invoker
     */
    public static function addWebcamFoundListener(callable $callable){}
    /**
     * @return Invoker
     */
    public static function addWebcamGoneListener(callable $callable){}

    /*
     * @return bool
     */
    public static function removeWebcamFoundListener(Invoker $callable){}
    /*
     * @return bool
     */
    public static function removeWebcamGoneListener(Invoker $callable){}
}