Паттерн Объектный пул - Object Pool
===================================
Объектный пул применяется для повышения производительности, когда создание 
объекта в начале работы и уничтожение его в конце приводит к большим затратам.
В Java считается устаревшей техникой для создания обычных объектов, т.к. порядок управления памяти в Java 
таков, что создание и уничтожение коротко-живущих объектов очень дешево, поэтому ручное создание
 объектов может быть более долгим и с большим кол-вом ошибок, чем new.
Сейчас используется для создания объектов, которые действительно дороги - 
пулы соединений с базой, сетевые подключения, потоки.

Если в пуле нет ни одного свободного объекта, возможна одна из трёх стратегий:
* Расширение пула.
* Отказ в создании объекта, аварийная остановка.
* В случае многозадачной системы можно подождать, пока один из объектов не освободится.

Центральная идея пула в том, чтобы не пересоздавать соединения\потоки, а использовать
уже существующие.
