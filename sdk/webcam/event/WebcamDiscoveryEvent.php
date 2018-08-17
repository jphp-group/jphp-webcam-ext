<?php


namespace webcam\event;


class WebcamDiscoveryEvent{
    /**
     * @var Webcam
     */
    public $webcam;


    /**
     * @return bool
     */
    function isAdded(){}
    /**
     * @return bool
     */
    function isRemoved(){}
}