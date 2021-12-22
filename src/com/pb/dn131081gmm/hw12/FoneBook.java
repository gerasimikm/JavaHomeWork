package com.pb.dn131081gmm.hw12;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FoneBook {
    public static void main(String[] args) throws Exception {

        List<Person> foneBook = new ArrayList<>();
        Person person1 = new Person.PersonBuild("Герасимик", "Михаил", "Михайлович", LocalDate.of(1990, 11, 30))
                .setAddress("г. Днепр, пр. Мира 23/10")
                .setFoneNumber("099 365 2684").build();
        Person person2 = new Person.PersonBuild("Люх", "Владимир", "Петрович", LocalDate.of(1990, 11, 20))
                .setAddress("г. Днепр, ул. Березинская 43/16")
                .setFoneNumber("099 365 2687").build();
        Person person3 = new Person.PersonBuild("Рудь", "Иван", "Романович", LocalDate.of(1980, 6, 7))
                .setAddress("г. Днепр, пр. Правда 53/98")
                .setFoneNumber("067 065 5684", "050 398 0222").build();
        Person person4 = new Person.PersonBuild("Клось", "Сергей", "Радионович", LocalDate.of(2000, 7, 1))
                .setAddress("г. Днепр, ул. Усенка 15/24")
                .setFoneNumber("067 115 2007").build();
        //Добавление елеметов в список

        foneBook.add(person1);
        foneBook.add(person4);
        foneBook.add(person2);
        foneBook.add(person3);
        foneBook.add(person4);
        foneBook.add(person4);
        //отбор вывод неповторяющихся персон с помощью stream
        System.out.println("вывыд елементов телефонной книги без дубликатов");
        System.out.println(foneBook.stream().distinct().collect(Collectors.toList()));

        //Сортировка списка обьектво по полях
        foneBook.sort(Comparator.comparing(person -> person.getLastName()));
        System.out.println("Вивод после сортировки  по фамилии\n " + foneBook);
        foneBook.sort(Comparator.comparing(person -> person.getDateOfBirth() ));
        System.out.println("Вивод после сортировки  по дате рождения\n " + foneBook);


        //Поиск по списку персон у которых совпадают ФИО и год рождения описание лямда выражения и использование
        System.out.println("Поистк по списку персон у которых совпадают ФИО и год рождения\n");
        Comparator<Person> compLight = (p1, p2) -> {
            if(p1.getFirstName().equals(p2.getFirstName()) &&
                    p1.getLastName().equals(p2.getLastName()) &&
                    p1.getPatronymic().equals(p2.getPatronymic())  &&
                    p1.getDateOfBirth() == p2.getDateOfBirth())
                return 0;
            else
                return -1;
        };
        for (int i = 0; i < foneBook.size(); i++) {
            if (compLight.compare(person4, foneBook.get(i)) == 0) { //Использование ссылки на Лямбда выражение
                System.out.println("\nПозиция в списке [" + i + "]");
                System.out.println(foneBook.get(i));
            }
        }


       //Удаление совпадающего обьекта определение лямбда выражения
        Comparator<Person> compFull = (p1, p2) -> {
            if(compLight.compare(p1, p2) == 0 &&
                    p1.getFonesNumber().size() == p2.getFonesNumber().size()&&
                    p1.getFonesNumber().containsAll(p2.getFonesNumber()))
                return 0;
            else
                return -1;
        };
        System.out.println("Удаление из списка персоны person4 \n");
        ListIterator<Person> perIterator = foneBook.listIterator();  //создаем итератор
        while (perIterator.hasNext()) {                       //до тех пор, пока в списке есть элементы

            Person nextPerson = perIterator.next();            //получаем следующий элемент
            if (compFull.compare(nextPerson, person4) == 0) {
                perIterator.remove();                       //удаляем искомую персону
            }
        }
        System.out.println("Перечень персон после удаления\n" + foneBook);

        FoneBook fBook = new FoneBook();

        System.out.println("Поиск людей в списке по фамилии или имени или отчеству");
         Consumer<String> peoplesSearch = (str) -> {
            for (Person p : foneBook) {
                if ((str.equals(p.getLastName()) || str.equals(p.getPatronymic()) || str.equals(p.getFirstName()))) {
                    System.out.println(p);
                }
            }
        };
        peoplesSearch.accept("Михаил");

        //Поиск людей в списке  по фамилии или имени или отчеству и с конктреной датой рождения
       /* System.out.println("Поиск людей в списке по фамилии или имени или отчеству и по дате рождения" );
        fBook.searchPerson("Рудь", 1980, foneBook);*/
        System.out.println("Поиск людей в списке по фамилии или имени или отчеству и по дате рождения" );
        foneBook.stream().filter(person -> person.getDateOfBirth().getYear() == 1980)
                         .filter(person -> person.getLastName().equals("Рудь")
                                 || person.getFirstName().equals("Рудь")
                                 || person.getPatronymic().equals("Рудь"))
                         .forEach(System.out::println);

        //Поля Фамилия() Имя, Отчество() и дата рождения() не редактируются
        //Для демонстрации ретактированя обьекта добавляем дополнительный номер телефона("099 368 6868") обьекту person2
        System.out.println("Редактируем объект списка. Добавляем дополнительный номер телефона(\"099 368 6868\") обьекту person2");
        for (Person p : foneBook) {
            if (compFull.compare(p, person2) == 0) { //Использование ссылки на Лямбда выражение
                p.addFonesNumber("099 368 6868");
                System.out.println(p);
            }
        }
        //Код для реализации списка обьетков в формате jackson
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule modul = new SimpleModule();//учим Json работатать с LocalDate c1
        modul.addSerializer(LocalDate.class, new LocalDateSerializer());         //c2 LocalDateSerializer() реализовать самим
        modul.addDeserializer(LocalDate.class, new LocalDateDeserializer());     //c3 LocalDate Deserializer реализовать самим
        mapper.registerModule(modul);

        String personJson = mapper.writeValueAsString(foneBook); //запись в строку списка объектов в формате jackson
        System.out.println(personJson);
        List<Person> fb2 = mapper.readValue(personJson, new TypeReference<List<Person>>() {
        }); //Возврат из строки данных в  в формате jackson в список
        System.out.println("fb2 \n" + fb2);
        //Запись данных в формате  jackson в файл "jS.txt"
        String nameJsonFile = "jS.txt";
        fBook.createJsonFile(nameJsonFile);//вызов функции которая создает файл с именем "jS.txt"
        //Записываем информацию в файл jS.txt  в json формате
        FileWriter writer = null;
        try {
            writer = new FileWriter(nameJsonFile);//обьект класса FileWriter
            writer.write(personJson);
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        //Читаем данные из файла "jS.txt" и записываем их в строку.
        String rezalt = null;
        BufferedReader br = null;
        FileReader fR = null;
        try {
            fR = new FileReader(nameJsonFile);
            br = new BufferedReader(fR);
            StringBuilder sb = new StringBuilder();
            String line = br.readLine(); //пеменная типа строка для хранения считаных строк объектом BufferedReader методом readLine()
            //while ((line = br.readLine()) != null)
            while (line != null) {//цикл пробегает по всему фалу считывает по строке и создатет общую строку обьектом StringBuilder()
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            rezalt = sb.toString();
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println("Error " + e);
            }
        }
        System.out.println("Результат" + rezalt);


   /*     CompeaDate myComp = (a , b) -> {
                                            if((a.compareTo(b)) == 0)
                                                System.out.println("Даты равны");
                                            else
                                                System.out.println("Даты Неравны");
                                        };
        myComp.vidid(dateBirth, dateBirth1);
        System.out.println(dateBirth);
*/
    }

    public void searchPerson(String a, List<Person> people) {
        for (Person p : people) {
            if (a.equals(p.getLastName()) || a.equals(p.getPatronymic()) || a.equals(p.getFirstName())) {
                System.out.println(p);
            }

        }
    }

    public void searchPerson(String name1, int yyyy, List<Person> people) {
        for (Person p : people) {
            if ((name1.equals(p.getLastName()) || name1.equals(p.getPatronymic()) || name1.equals(p.getFirstName())) && yyyy == p.getDateOfBirth().getYear()) {
                System.out.println(p);
            }

        }
    }

    public void createJsonFile(String name) throws IOException {
        File jSonFile = new File(name);
        if (jSonFile.exists()) {
            if (jSonFile.delete()) {                                                                 //Удаляем файл numbers.txt
                System.out.println("Файл " + name + " был удален с корневой папки проекта");
            } else System.out.println("Файл " + name + " не доступен к удалению");
            if (jSonFile.createNewFile()) {
                System.out.println(name + " создан в корне JavaHomeWork");
            } else {
                System.out.println("В корне JavaHomeWork уже существует файл с названием  " + name);
            }
        } else {
            if (jSonFile.createNewFile()) {
                System.out.println(name + " создан в корне JavaHomeWork");
            } else {
                System.out.println("файл " + name + " не удалось создать");
            }
        }
    }
}


