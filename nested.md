
1.На какие две группы разделяются классы, объявленные внутри другого класса?
Как они называются на инглише?  
**Ответ.**  
1.``Non-static nested classes`` — нестатические вложенные классы. По-другому их еще называют ``inner classes`` — внутренние классы.  
2.``Static nested classes`` — статические вложенные классы.  
**Источник.** https://javarush.ru/groups/posts/2181-vlozhennihe-vnutrennie-klassih

2.Для каких целей они используются?  
**Ответ.**   
1.Это способ логической группировки классов, которые используются только в одном месте  
2.Это увеличивает инкапсуляцию  
**Источник.**  https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

3.Какие уровни доступа применяются к таким классам?
**Ответ.** Внутренний класс можно обозначить стандартными модификаторами доступа — ``public``, ``private``, ``protected`` и ``package`` ``private``.  
**Источник.** https://javarush.ru/groups/posts/2181-vlozhennihe-vnutrennie-klassih

4.Какие существуют варианты внутренних классов?  
**Ответ.**   
Вложенные внутренние классы – нестатические классы внутри внешнего класса.    
Вложенные статические классы – статические классы внутри внешнего класса.  
Локальные классы Java – классы внутри методов.  
Анонимные Java классы – классы, которые создаются на ходу.    
**Источник.** https://javarush.ru/groups/posts/vidy-vlozhennyh-klassov

5.Пусть объявлен класс ``Outer``, а внутри него публичный вложенный класс ``NestedPublic`` и публичный внутренний класс ``InnerPublic``.  
Создайте экземпляры каждого класса:  
а) внутри класса ``Outer``,  
б) извне класса ``Outer``?  
**Ответ.**  
а)
```java
class Other {
    public static class NestedPublic {

    }

    public class InnerClass {

    }

    public static void main(String[] args) {
        Other other = new Other();
        Other.InnerClass innerClass = other.new InnerClass();
        NestedPublic nestedPublic = new NestedPublic();
    }
}
```
б)
```java
public class Main {
public static void main(String[] args) {
Other other = new Other();
Other.InnerClass innerClass = other.new InnerClass();
Other.NestedPublic nestedPublic = new Other.NestedPublic();
}
}
```
**Источник.**

6.Пусть объявлен класс ``Outer``, а внутри него приватный вложенный класс ``NestedPrivate`` и приватный внутренний класс ``InnerPrivate``.  
Создайте экземпляры каждого класса:  
а) внутри класса ``Outer``,  
б) извне класса ``Outer``?  
**Ответ.**  
а)
```java
class Other {
private static class NestedPublic {

    }

    private class InnerClass {

    }

    public static void main(String[] args) {
        Other other = new Other();
        Other.InnerClass innerClass = other.new InnerClass();
        NestedPublic nestedPublic = new NestedPublic();
    }

}
```
б)Если же мы объявим внутренний класс как ``private``, доступ к созданию объектов у нас будет только внутри «внешнего» класса.  
**Источник.** https://javarush.ru/groups/posts/2181-vlozhennihe-vnutrennie-klassih

7.Пусть объявлен класс ``Outer``, а внутри него внутренний класс Inner. Как обратиться внутри класса ``Inner``:  
а) к экземпляру класса ``Inner``,  
б) к объемлющему экземпляру класса ``Outer``?   
**Ответ.**  
а)``Outer.Inner.this``    
б) ``Outer.this``    
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  

8.Пусть объявлен класс ``Outer``, а внутри него вложенный класс ``Nested``.
Как обратиться внутри класса ``Nested``:  
а) к экземпляру класса ``Nested``,  
б) к объемлющему экземпляру класса ``Outer``?  
**Ответ.**  
а)``this``  
б)  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

9.Можно ли из вложенного класса обратиться к членам внешнего класса?
Если да, то приведите пример.    
**Ответ.**  
Из вложенного статического класса мы не имеем доступа к внешней не статической переменной внешнего класса. Но мы имеем доступ к приватным статическим полям внешнего класса из вложенного статичного класса.   
```java
public class Outer3 {
private static int prStOuterVar;
public Outer3(){}

          static class Nested3	  // Nested
			{ 
				 int getStaticOuterVar()
						{
						  return Outer3.prStOuterVar; //  ok
						}
				 void setStaticOuterVariable(int var)
						{
						   Outer3.prStOuterVar = var; // ok
						}
			}
       public static void main(String[] args) {
       Outer3.Nested3 nestedObj = new Outer3.Nested3(); // экземпляр класса внутренний
        
         
         Outer3.prStOuterVar = 19;
         
         System.out.println("nestedObj.getStaticOuterVar() = "+nestedObj.getStaticOuterVar());//статическая переменная внешнего класса из экземпляра внутреннего
        
         // устанавливаем через экземпляр внутреннего класса
        nestedObj.setStaticOuterVariable(77);
        System.out.println("Outer3.prStOuterVar = "+ Outer3.prStOuterVar);
       }
}
```
**Источник.** https://habr.com/ru/post/439648/

10.Можно ли из внутреннего класса обратиться к экземпляру внешнего класса?
Если да, то приведите пример.  
**Ответ.**  
Для получения доступа из внутреннего класса к экземпляру его внешнего класса необходимо в ссылке указать имя класса и ключевое слово ``this``.  
```java
class OuterClass {
int count = 0;

class InnerClass {
int count = 10000;

    public void display() {
      System.out.println("Outer: " + OuterClass.this.count);
      System.out.println("Inner: " + count);
    }
}
}
```
**Источник.** https://javatutor.net/articles/inner-classes-in-java#:~:text=Для%20получения%20доступа%20из%20внутреннего,или%20переменную%20с%20одинаковыми%20именами

11.Можно ли определить экземпляр вложенного класса, не определяя экземпляры внешнего класса?  
Если да, то приведите пример.  
**Ответ.**  
**Источник.**  

12.Есть ли ограничения на объявление локальных переменных в локальных внутренних классах?
Есть ли да, то какие?  
**Ответ.**  
1.Он имеет доступ только к финальным полям и аргументам обрамляющего метода, а также ко всем полям обрамляющего класса, в том числе приватным и статическим;  
2.локальный класс виден и может создаваться только в блоке, в котором описан;  
3.у локального класса не ставится модификатор доступа;  
4.не может иметь статических полей, методов, классов (за исключением финальных);  
локальный класс, объявленный в статическом блоке может обращаться только к статическим полям внешнего класса.  
Начиная с Java8 мы можем обращаться в локальных классах к не финальным локальным переменным, если они не были изменены до момента инициализации класса. Также теперь стало возможным обращение к не финальным параметрам метода.
**Источник.** https://javarush.ru/groups/posts/1553-urovenjh-24-otvetih-na-voprosih-k-sobesedovaniju-po-teme-urovnja

13.Можно ли наследовать вложенные классы?
Если да, то приведите пример.  
**Ответ.**  
Можно  
```java
public class Boeing737 {

private int manufactureYear;
private static int maxPassengersCount = 300;

public Boeing737(int manufactureYear) {
this.manufactureYear = manufactureYear;
}

public int getManufactureYear() {
return manufactureYear;
}

public static class Drawing {

}

public static class Boeing737Drawing extends Drawing {

       public static int getMaxPassengersCount() {

           return maxPassengersCount;
       }
}
}
```
**Источник.** https://javarush.ru/groups/posts/2199-primerih-nasledovanija-vnutrennikh-klassov

14.Можно ли из подкласса обратиться к методу вложенного суперкласса?
Если да, то приведите пример.  
**Ответ.**  
Подкласс вложенного класса не способен унаследовать возможность доступа к членам внешнего класса, которыми наделен его суперкласс, если он не является вложенным классом своего суперкласса.  
**Источник.** http://pr0java.blogspot.com/2015/08/2.html

15.Какие существуют варианты внутренних интерфейсов?  
**Ответ.**  
Внутренние интерфейсы, объявленные в другом классе, являются статическими, но они могут иметь спецификаторы доступа, которые могут ограничивать, где они могут быть реализованы.  
**Источник.** https://javascopes.com/java-inner-interfaces-084b96fa/

16.Можно ли объявить класс внутри интерфейса?
Если да, то есть ли ограничения? Приведите пример.  
**Ответ.**  
Можно. Единственное ограничение на внутренний класс, определенный внутри интерфейса или любого другого класса, в том, что вам нужно получить к ним доступ, используя имя входящего члена.
```java
public interface A {
class B {
}
}
```
**Источник.** https://de-vraag.com/ru/56681287

17.Можно ли создать экземпляр анонимного класса на основе:  
а) абстрактного класса?  
б) интерфейса?  
в) неабстрактного класса?  
г) финального класса?  
Если да, то приведите пример.  
**Ответ.**  
**Источник.**

18.Дан следующий ``java``-файл.
```java
//-------------- begin --------------
class Runner {
public static void main(String[] args){
Something something = new Something();
something.doSomething(...);		//1
}
}
interface Smthable {
void doSmth();
}
class Something {
void doSomething(...) {			//2
smth.doSmth();
}
}
//--------------- end ---------------
```
1. Замените многоточия в строках 1 и 2 на такой код, чтобы приложение после запуска с помощью экземпляра анонимного класса, порожденного от интерфейса ``Smthable``, вывело на консоль текст ``Hello``, ``World``.
2. Получите тот же результат, переместив:
   а) интерфейс ``Smthable`` внутрь класса ``Something``,
   б) класс Something внутрь интерфейса ``Smthable``.  
   **Ответ.**  
   **Источник.**   
   

19.Дан следующий ``java-файл``.
```java
//-------------- begin --------------
abstract class AbstractRunner {
abstract int getYear();
abstract class AbstarctInner {
abstract int getYear();
}
public static void main(String[] args) {
... //1
... //2
... //3
}
}
//--------------- end ---------------
```
Создайте в строке 1 ссылку runner на экземпляр подкласса класса ``AbstractRunner``.
Создайте в строке 2 ссылку inner на экземпляр подкласса класса ``AbstractInner``.
Выведите на консоль в строке 3 текст 2010;2015, используя данные ссылки.  
**Ответ.**  
**Источник.**  

20.Дан следующий ``java``-файл.
```java
//-------------- begin --------------
class Runner {
public static void main(String[] args) {
... 	//1
}
}
class Outer {
class Inner {
void go() {
System.out.println("Gone!");
}
}
}
//--------------- end ---------------
```
1. С помощью функционала классов ``Outer`` и ``Inner`` выведите на консоль в строке 1 текст ``Gone!``.  
2. Переместив класс ``Outer`` внутрь класса Runner, получите тот же результат:  
   а) не изменяя строку 1.  
   б) изменяя строку 1,  
   **Ответ.**    
   **Источник.**

21.Что представляют собой элементы перечисления?
Подсказка. Откомпилируйте фабричный класс из задачи ``inheritance1`` и посмотрите, какие получились .``class``-файлы  
**Ответ.**   
Являются вложенными классами.   
**Источник.** https://translated.turbopages.org/proxy_u/en-ru.ru.d2f8ba73-634aed92-9b13cdc9-74722d776562/https/stackoverflow.com/questions/50787474/enums-defined-in-a-class-is-a-static-nested-class

22.Как образуются имена вложенных и внутренних.``class``-файлов после компиляции?
Приведите примеры.  
**Ответ.**   
"имя внешнего класса" + $ + "внутреннего/вложенного класса". Пример: ``OuterClassName$NestedClassName.class``.    
**Источник.** https://javascopes.com/java-class-file-naming-4f6af92e/

23.Может ли вложенный класс быть раннер-классом?  
Если да, то приведите пример, иначе поясните, почему нет.  
**Ответ.**  
Может.
```java
public class Main {
static class Nested{
public static void main(String[] args) {
System.out.println("Can");
    }
  }
 }
```
**Источник.**

24.Может ли внутренний класс быть раннер-классом?
Если да, то приведите пример, иначе поясните, почему нет.  
**Ответ.**   
Не может.    
```java
public class Main {
class Inner{
public static void main(String[] args) {
System.out.println("Сan"); // Static declarations in inner classes are not supported at language
   }
  }
 }
```
**Источник.**

25.Может ли интерфейс иметь раннер-класс?  
Если да, то приведите пример, иначе поясните, почему нет.  
**Ответ.**  
Может. 
```java
public interface Main {
class Inner{
public static void main(String[] args) {

        }
    }
}
```
**Источник.**
