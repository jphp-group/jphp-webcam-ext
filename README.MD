# Webcam
Расширение для работы с веб-камерой
## Установка
```
jppm add jphp-webcam-ext
```
## Примеры
### Получить веб-камеру по умолчанию:
```php
$webcam = Webcam::getDefault();
```
### Получить список веб-камер:
```php
$webcamList = Webcam::getWebcams();
```
### Сделать снимок с веб-камеры:
```php
$webcam = Webcam::getDefault();
$webcam->open();
$image = $webcam->getImage();
$image->save('screenshot.png');
```
### Отобразить изображение с веб-камеры:
```php
$webcam = Webcam::getDefault();
$webcam->open();

$webcamView = new UXWebcamView();
$webcamView->webcam = $webcam;
$webcamView->size = [640, 480];
$form->add($webcamView);
$webcamView->play();
```
## Расширение для DevelNext
[Скачать](https://github.com/jphp-group/jphp-webcam-ext/releases/latest)

![](/screenshots/dn_view.png)

## Скриншоты

![](/screenshots/screenshot.png)

## Дополнительно

[Venity](https://vk.com/venity)

[DevelNext - extensions & manuals.](https://vk.com/dn_extension)

[Оригинальная библиотека](https://github.com/sarxos/webcam-capture)