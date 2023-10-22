# Домашнее задание 12
## Создайте пустой репозиторий с названием HW12
## Склонируйте этот проект
Скопируйте ссылку
![Screenshot from 2023-10-22 13-41-22](https://github.com/tallinn-learning-ilja/HW12/assets/144708902/d2051671-6381-4706-aef4-c6fba6f4152b)
В Intellij

![image](https://github.com/tallinn-learning-ilja/HW12/assets/144708902/e0e3f412-8178-48fd-824e-054a25bbfbce)
![image](https://github.com/tallinn-learning-ilja/HW12/assets/144708902/7f6bd326-cffc-41a8-b102-39a53e5f42b8)
И нажать на кнопку `Clone`
Далее открываем главное меню (значок с тремя полосками, который рядом с названием проекта) -> Git -> Manage Remotes (третье снизу)
![image](https://github.com/tallinn-learning-ilja/HW12/assets/144708902/220e8dbb-aa7f-4a16-98ae-5bbb7a4ac7b9)
Нажмите на origin и дальше на кнопку минус. Таким образом мы удаляем связь с этим репозиторием
Нажмите на плюс и добавьте ссылку на ВАШ РЕПОЗИТОРИЙ. В `name` поставьте `origin` 




## Реализовать методы в классах 
[CustomerService](src/main/java/org/coolorg/service/CustomerService.java),
[ProductService](src/main/java/org/coolorg/service/ProductService.java),
[OrderService](src/main/java/org/coolorg/service/ProductService.java).
Добавить свою валидацию, например в классе [OrderService](src/main/java/org/coolorg/service/ProductService.java),
когда нужно получить товары для клиента, то сначала проверьте, существует ли такой клиент.
При необходимости, можете добавлять свои методы.

## Напишите тесты
Напишите тесты для всех классов сервисов.
В классах репозиториях есть тестовые данные, они нужны просто для того,
чтобы было удобно запускать приложение в Application классе в Main методе, для тестов используйте `Mockito`

