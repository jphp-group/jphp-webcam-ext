# Webcam

- **class** `Webcam` (`webcam\Webcam`)
- **source** `webcam/Webcam.php`

---

#### Properties

- `->`[`name`](#prop-name) : `string`
- `->`[`open`](#prop-open) : `bool`
- `->`[`viewSize`](#prop-viewsize) : `array`

---

#### Static Methods

- `Webcam ::`[`getDefault()`](#method-getdefault)
- `Webcam ::`[`getWebcams()`](#method-getwebcams)
- `Webcam ::`[`addWebcamFoundListener()`](#method-addwebcamfoundlistener)
- `Webcam ::`[`addWebcamGoneListener()`](#method-addwebcamgonelistener)
- `Webcam ::`[`removeWebcamFoundListener()`](#method-removewebcamfoundlistener)
- `Webcam ::`[`removeWebcamGoneListener()`](#method-removewebcamgonelistener)

---

#### Methods

- `->`[`open()`](#method-open)
- `->`[`close()`](#method-close)
- `->`[`getImage()`](#method-getimage)

---
# Static Methods

<a name="method-getdefault"></a>

### getDefault()
```php
Webcam::getDefault(int $timeout): Webcam
```

---

<a name="method-getwebcams"></a>

### getWebcams()
```php
Webcam::getWebcams(int $timeout): Webcam[]
```

---

<a name="method-addwebcamfoundlistener"></a>

### addWebcamFoundListener()
```php
Webcam::addWebcamFoundListener(callable $callable): Invoker
```

---

<a name="method-addwebcamgonelistener"></a>

### addWebcamGoneListener()
```php
Webcam::addWebcamGoneListener(callable $callable): Invoker
```

---

<a name="method-removewebcamfoundlistener"></a>

### removeWebcamFoundListener()
```php
Webcam::removeWebcamFoundListener(php\lang\Invoker $callable): void
```

---

<a name="method-removewebcamgonelistener"></a>

### removeWebcamGoneListener()
```php
Webcam::removeWebcamGoneListener(php\lang\Invoker $callable): void
```

---
# Methods

<a name="method-open"></a>

### open()
```php
open(boolean $async): void
```

---

<a name="method-close"></a>

### close()
```php
close(): void
```

---

<a name="method-getimage"></a>

### getImage()
```php
getImage(): UXImage
```