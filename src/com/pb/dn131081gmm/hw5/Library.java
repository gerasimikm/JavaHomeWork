package com.pb.dn131081gmm.hw5;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("Приключения", "Иванов И. И.", 2000);
        books[1] = new Book("Словарь", "Сидоров А. В", 1980);
        books[2] = new Book("Энциклопедия", "Гусев К. В.", 2010);
        Reader n789 = new Reader();
        Reader[] allReaders = new Reader[3];
        n789.setCallNumber("0993652683");
        n789.setDateOfBirth("09.09.1980");
        n789.setFullName("Петров В. В.");
        n789.setFaculty("Математический");
        n789.setNumberLibraryCard("789");
        allReaders[0] = n789;
        allReaders[1] = new Reader();
        allReaders[2] = new Reader();
        allReaders[1].setFullName("Лисенко С. В.");
        allReaders[2].setFullName("Рудь П. И.");

        System.out.println("\"________Все читатели: - ниже____________________");
        for (int i = 0; i < allReaders.length; i++)
            System.out.println(allReaders[i].toString());

        System.out.println("________Все книги: - ниже_________________________");
        for (int i = 0; i < books.length; i++)
            System.out.println(books[i].toString());

        System.out.println("\n________takeBook(int num) - ниже._______________");
        n789.takeBook(3);
        //System.out.println(books.toString());

        System.out.println("\n________takeBook(String ... ars) - ниже.________");
        n789.takeBook("Приключения", "Словарь", "Энциклопедия");

        System.out.println("\n________takeBook(Book ... books) - ниже.________");
        n789.takeBook(books);

        System.out.println("\n________returnBook(int num) - ниже._____________");
        n789.returnBook(1);

        System.out.println("\n________returnBook(String ... ars) - ниже.______");
        n789.returnBook("Приключения", "Словарь", "Энциклопедия");

        System.out.println("\n________returnBook(Book ... books) - ниже.______");
        n789.returnBook(books);
    }
}
