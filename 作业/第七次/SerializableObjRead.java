import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.*;

class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String biography;

    public Person() {

    }

    public Person(String name, String gender, String biography, int year, int month, int day) {
        this.name = name;
        this.gender = gender;
        this.biography = biography;
        this.birthday = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "name: " + name + " , gender: " + gender + " , birthday: " + birthday
                + " , biography: " + biography;
    }

}



class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Person author;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book() {

    }

    public Book(String name, Person author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + name + "\nauthor: " + author + "\nprice: " + price;
    }

}


public class SerializableObjRead {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (Scanner scanner = new Scanner(System.in);
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("dict.dic"));) {
            int n = scanner.nextInt() - 1;
            while (n-- != 0) {
                in.readObject();
            }
            System.out.println((Book) in.readObject());
        }
    }

}

