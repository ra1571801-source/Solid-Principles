//Single Responsibility Principle (SRP) Example

class Book {
    private String title = "Harry Potter: Prisoner of Askaban";

    public String getTitle() {
        return title;
    }

    public void printTitle() {
        System.out.println("Title: " + title);
    }
}

class BookSaver {
    public void saveBook(Book book) {
        System.out.println("Saving book: " + book.getTitle());
        System.out.println("Book saved.");
    }
}

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.printTitle(); 

        BookSaver saver = new BookSaver();
        saver.saveBook(book); 
    }
}


//Open/Closed Principle (OCP) Example

interface Greeting {
    void sayHello();
}

class EnglishGreeting implements Greeting {
    public void sayHello() {
        System.out.println("Hello");
    }
}

class SpanishGreeting implements Greeting {
    public void sayHello() {
        System.out.println("Hola");
    }
}

class Greeter {
    void greet(Greeting g) {
        g.sayHello();
    }
}

public class Solid {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        Greeting english = new EnglishGreeting();
        Greeting spanish = new SpanishGreeting();

        greeter.greet(english);  
        greeter.greet(spanish);  
    }
}

//Liskov Substitution Principle (LSP) Example

class Vehicle {
    void startEngine() {
        System.out.println("Starting vehicle engine...");
    }
}

class Car extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Car engine started.");
    }
}

class Bike extends Vehicle {
    @Override
    void startEngine() {
        System.out.println("Bike engine started.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car();  
        Vehicle v2 = new Bike(); 

        v1.startEngine();  
v2.startEngine(); 
    }
}



//Interface Segregation Principle (ISP) Example

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class MultiFunctionPrinter implements Printer, Scanner, Fax {
    public void print() { System.out.println("Printing..."); }
    public void scan() { System.out.println("Scanning..."); }
    public void fax() { System.out.println("Faxing..."); }
}

class SimplePrinter implements Printer {
    public void print() { System.out.println("Simple printing only."); }
}

public class Solid {
    public static void main(String[] args) {
        Printer multi = new MultiFunctionPrinter();
        multi.print();

        Printer simple = new SimplePrinter();
        simple.print();
    }
}

//Dependency Inversion Principle (DIP) Example
 
interface Message {
    void send();
}

class Email implements Message {
    public void send() {
        System.out.println("Sending an email");
    }
}

class SMS implements Message {
    public void send() {
        System.out.println("Sending an SMS");
    }
}

class Notification {
    private Message message;

    public Notification(Message message) {
        this.message = message;
    }

    public void notifyUser() {
        message.send(); 
    }
}

public class Main {
    public static void main(String[] args) {
        Message email = new Email();  
        Message sms = new SMS();      

        Notification n1 = new Notification(email); 
        Notification n2 = new Notification(sms);   

        n1.notifyUser();
        n2.notifyUser(); 
    }
}

