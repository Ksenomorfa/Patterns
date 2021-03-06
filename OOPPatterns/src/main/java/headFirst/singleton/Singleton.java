package singleton;

class Singleton {
    //статическая переменнная с volatile, чтобы параллельные потоки правильно работали с переменной.
    // Если переменная объявлена как volatile, это означает, что она может изменяться разными потоками.
    //Модификатор volatile накладывает некоторые дополнительные условия на чтение/запись переменной:
    //Операции чтения/записи volatile переменной являются атомарными.
    //Результат операции записи значения в volatile переменную одним потоком, становится виден всем другим потокам, которые используют эту переменную для чтения из нее значения.
    private volatile static Singleton uniqueInstance;

    // приватный конструктор
    private Singleton() {
        System.out.println("Это я, и я один.");
    }

    //метод создания объекта, проверяющего есть ли уже такой объект, так называемая условная блокировка
    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            //этот кусок кода синхронизируется только если экземпляра не существует + двойной чек
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
