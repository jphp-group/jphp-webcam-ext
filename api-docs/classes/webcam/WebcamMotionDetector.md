# WebcamMotionDetector

- **class** `WebcamMotionDetector` (`webcam\WebcamMotionDetector`)
- **source** `webcam/WebcamMotionDetector.php`

---

#### Properties

- `->`[`interval`](#prop-interval) : `int`
- `->`[`maxMotionPoints`](#prop-maxmotionpoints) : `int`
- `->`[`pointRange`](#prop-pointrange) : `int`
- `->`[`motionArea`](#prop-motionarea) : `float`
- `->`[`motion`](#prop-motion) : `bool`
- `->`[`webcam`](#prop-webcam) : [`Webcam`](https://github.com/jphp-group/jphp-webcam-ext/api-docs/classes/webcam/Webcam.md)

---

#### Methods

- `->`[`__construct()`](#method-__construct)
- `->`[`start()`](#method-start)
- `->`[`stop()`](#method-stop)
- `->`[`setPixelThreshold()`](#method-setpixelthreshold)
- `->`[`setAreaThreshold()`](#method-setareathreshold)
- `->`[`setInertia()`](#method-setinertia)
- `->`[`clearInertia()`](#method-clearinertia)
- `->`[`addMotionListener()`](#method-addmotionlistener)
- `->`[`removeMotionListener()`](#method-removemotionlistener)

---
# Methods

<a name="method-__construct"></a>

### __construct()
```php
__construct(webcam\Webcam $webcam): void
```

---

<a name="method-start"></a>

### start()
```php
start(): void
```

---

<a name="method-stop"></a>

### stop()
```php
stop(): void
```

---

<a name="method-setpixelthreshold"></a>

### setPixelThreshold()
```php
setPixelThreshold(int $value): void
```

---

<a name="method-setareathreshold"></a>

### setAreaThreshold()
```php
setAreaThreshold(double $value): void
```

---

<a name="method-setinertia"></a>

### setInertia()
```php
setInertia(int $value): void
```

---

<a name="method-clearinertia"></a>

### clearInertia()
```php
clearInertia(): void
```

---

<a name="method-addmotionlistener"></a>

### addMotionListener()
```php
addMotionListener(callable $callable): Invoker
```

---

<a name="method-removemotionlistener"></a>

### removeMotionListener()
```php
removeMotionListener(php\lang\Invoker $invoker): void
```