package task1710;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CRUD - Create, Read, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-r id
-u id name sex bd
-d id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-r - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -r:
Миронов м 15-Apr-1990

Если программа запущена с параметрами, то они попадают в массив args (аргумент метода main - String[] args).
Например, при запуске программы c параметрами:
-c name sex bd
получим в методе main
args[0] = "-c"
args[1] = "name"
args[2] = "sex"
args[3] = "bd"
Для запуска кода с параметрами в IDE IntellijIDEA нужно их прописать в поле Program arguments в меню Run -> Edit Configurations.


Requirements:
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople,
и выводить id (index) на экран.
4. При запуске программы с параметром -r программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
5. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
6. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился id=1
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {

                case "-c":
                    if (args[2].equals("м")) {
                        try {
                            Person person = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        } catch (ParseException e) {
                            System.out.println("Введен неправильный формат даты");
                        }
                    } else if (args[2].equals("ж")) {
                        try {
                            Person person = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        } catch (ParseException e) {
                            System.out.println("Введен неправильный формат даты");
                        }
                    }
                    break;
                case "-u":
                    Person person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(args[2]);
                    if (args[3].equals("м")) {
                        person.setSex(Sex.MALE);
                    } else if (args[3].equals("ж")) {
                        person.setSex(Sex.FEMALE);
                    }
                    try {
                        person.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
                    } catch (ParseException e) {
                        java.lang.System.out.println("Введен неправильный формат даты");
                    }
                    break;
                case "-d":
                    allPeople.set(Integer.parseInt(args[1]), null);
                    break;
                case "-i":
                    Person person1 = allPeople.get(Integer.parseInt(args[1]));

                    java.lang.System.out.println(person1.getName() + " ");

                    if (person1.getSex().equals(Sex.MALE)) {
                        java.lang.System.out.println("м ");
                    }
                    else{
                        java.lang.System.out.println("ж ");
                    }
                    java.lang.System.out.println(new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH).format(person1.getBirthDate()));

                    break;
            }
        }
    }
}
