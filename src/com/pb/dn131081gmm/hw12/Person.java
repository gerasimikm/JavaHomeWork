package com.pb.dn131081gmm.hw12;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Person {
        final private  String lastName;
        final private  String firstName;
        final private  String patronymic;
        private String address;
        private String timeEdition;
        private List<String> fonesNumber= new ArrayList<>();
        final private LocalDate dateOfBirth;
        private SimpleDateFormat dateAndTimeEditing = new SimpleDateFormat("yyyy-MM-dd в HH:mm:ss X");
        Person(){
            this.lastName = getLastName();
            this.firstName = getFirstName();
            this.patronymic = getPatronymic();
            this.dateOfBirth = getDateOfBirth();
            this.address = getAddress();
            this.fonesNumber = getFonesNumber();
            this.timeEdition = getTimeEdition();

        }
        private Person(PersonBuild buildPerson ){
                this.lastName =buildPerson.getLastName();
                this.firstName = buildPerson.getFirstName();
                this.patronymic = buildPerson.getPatronymic();
                this.dateOfBirth = buildPerson.getDateOfBirth();
                this.address = buildPerson.getAddress();
                this.fonesNumber = buildPerson.getFonesNumber();
                this.timeEdition = buildPerson.getTimeEdition();
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public String getAddress() {
            return address;
        }

        public String getTimeEdition() {
            return timeEdition;
        }

        public List<String> getFonesNumber() {
            return fonesNumber;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public void setAddress(String address) {
            this.address = address;
            timeEdition = dateAndTimeEditing.format(new Date());
        }

        public void addFonesNumber(List<String> fonesNumber) {
            this.fonesNumber.addAll(fonesNumber);
            timeEdition = dateAndTimeEditing.format(new Date());
        }
        public void addFonesNumber(String foneNumber) {
            this.fonesNumber.add(foneNumber);
            timeEdition = dateAndTimeEditing.format(new Date());
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(patronymic, person.patronymic) && Objects.equals(address, person.address) && Objects.equals(timeEdition, person.timeEdition) && Objects.equals(fonesNumber, person.fonesNumber) && Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, address, timeEdition, fonesNumber, dateOfBirth);
    }

    @Override
        public String toString() {
            return "\nЧитатель {" + '\n' +
                    "ФИО:           " + lastName + " " + firstName + " " + patronymic + '\n' +
                    "Дата рождения: " + dateOfBirth.toString() + '\n' +
                    "Телефон(ы):    " + fonesNumber.toString() + '\n' +
                    "Адрес:         " + address + '\n' +
                    "Изменен:       " + timeEdition + "\n}";
        }

        //Метод поиска по ФИО

 /*   @Override
    public int compareTo(Person person) {
            if(this.firstName == person.getFirstName() &&
                    this.lastName == person.getLastName() &&
                    this.patronymic == person.getPatronymic() &&
                    this.dateOfBirth == person.getDateOfBirth())
        return 0;
            else
                return -1;
    }*/

    //Сроитель класса Person
    public static class PersonBuild{
    private  String lastName;
    private  String firstName;
    private  String patronymic;
    private String address;
    private String timeEdition;
    private List<String> fonesNumber= new ArrayList<>();
    private LocalDate dateOfBirth; // = new DateBirth.BilderDate().build();
    private SimpleDateFormat dateAndTimeEditing = new SimpleDateFormat("yyyy-MM-dd в HH:mm:ss X");

    PersonBuild(String lastName, String firstName, String patronymic, LocalDate dateBirth){
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateBirth;
    }
    public PersonBuild setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuild setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuild setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public PersonBuild setAddress(String address) {
        this.address = address;
        return this;
    }

    public void setTimeEdition() {
        this.timeEdition = dateAndTimeEditing.format(new Date());
    }

    public PersonBuild setFoneNumber(List<String> fonesNumber) {
        this.fonesNumber.addAll(fonesNumber);
        return this;
    }
    public PersonBuild setFoneNumber(String foneNumber) {
        this.fonesNumber.add(foneNumber);
        return this;
    }
        public PersonBuild setFoneNumber(String foneNumber1, String foneNumber2 ) {
            this.fonesNumber.add(foneNumber1);
            this.fonesNumber.add(foneNumber2);
            return this;
        }

    public PersonBuild setDateOfBirth(int yyyy, int mouth, int dd) {
        this.dateOfBirth = LocalDate.of(yyyy, mouth, dd);//new DateBirth(yyyy, mouth, dd);
        return this;

    }

            public String getLastName() {
                return lastName;
            }

            public String getFirstName() {
                return firstName;
            }

            public String getPatronymic() {
                return patronymic;
            }

            public String getAddress() {
                return address;
            }

            public String getTimeEdition() {
                return timeEdition;
            }

            public List<String> getFonesNumber() {
                this.timeEdition = dateAndTimeEditing.format(new Date());
                return fonesNumber;
            }

            public LocalDate getDateOfBirth() {
                return dateOfBirth;
            }

            public Person build(){
        return new Person(this);
    }
}
    }
