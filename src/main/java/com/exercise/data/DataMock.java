package com.exercise.data;

import com.exercise.model.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Proveedor centralizado de datos de prueba para los ejercicios de Streams.
 */
public final class DataMock {

    private DataMock() {}

    public static List<Person> getPersons() {
        return List.of(
                new Person(1, "Carlos Gomez", 28, Gender.MALE, "carlos@example.com", List.of("Futbol", "Lectura")),
                new Person(2, "Ana Martinez", 34, Gender.FEMALE, "ana@example.com", List.of("Pintura", "Musica", "Senderismo")),
                new Person(3, "Luis Rodriguez", 19, Gender.MALE, "luis@example.com", List.of("Videojuegos", "Futbol")),
                new Person(4, "Elena Fernandez", 42, Gender.FEMALE, "elena@example.com", List.of("Jardineria", "Cocina")),
                new Person(5, "Sofia Lopez", 25, Gender.FEMALE, "sofia@example.com", List.of("Lectura", "Yoga")),
                new Person(6, "Javier Perez", 17, Gender.MALE, "javier@example.com", List.of("Natacion", "Videojuegos")),
                new Person(7, "Mateo Diaz", 31, Gender.MALE, "mateo@example.com", List.of("Fotografia", "Ciclismo")),
                new Person(8, "Lucia Morales", 22, Gender.FEMALE, "lucia@example.com", List.of("Musica", "Fotografia")),
                new Person(9, "Gabriel Sanchez", 45, Gender.MALE, "gabriel@example.com", List.of("Ajedrez", "Lectura")),
                new Person(10, "Valeria Torres", 29, Gender.FEMALE, "valeria@example.com", List.of("Pintura", "Yoga"))
        );
    }

    public static List<Employee> getEmployees() {
        return List.of(
                new Employee(101, "Alice Smith", "IT", 75000.0, 2018, List.of("Java", "Spring", "Docker")),
                new Employee(102, "Bob Johnson", "HR", 50000.0, 2015, List.of("Recruiting", "Communication")),
                new Employee(103, "Charlie Brown", "Finance", 62000.0, 2020, List.of("Excel", "Accounting", "Analysis")),
                new Employee(104, "Diana Prince", "IT", 95000.0, 2016, List.of("Java", "Kubernetes", "AWS", "Python")),
                new Employee(105, "Evan Wright", "Marketing", 48000.0, 2021, List.of("SEO", "Content", "Social Media")),
                new Employee(106, "Fiona Gallagher", "Finance", 80000.0, 2014, List.of("Taxation", "Auditing", "Excel")),
                new Employee(107, "George Clark", "IT", 68000.0, 2022, List.of("JavaScript", "React", "Node")),
                new Employee(108, "Hannah Abbott", "HR", 54000.0, 2019, List.of("Payroll", "Recruiting")),
                new Employee(109, "Ian Malcolm", "IT", 110000.0, 2012, List.of("Architecture", "Java", "Go", "Cloud")),
                new Employee(110, "Julia Roberts", "Marketing", 65000.0, 2017, List.of("Branding", "Campaigns", "SEO"))
        );
    }

    public static List<Product> getProducts() {
        return List.of(
                new Product(1, "Laptop Dell XPS", "Electronics", 1200.0, 15, List.of("computer", "tech", "work")),
                new Product(2, "Mouse Inalambrico Logitech", "Electronics", 25.0, 50, List.of("accessory", "peripherals")),
                new Product(3, "Teclado Mecanico RGB", "Electronics", 85.0, 30, List.of("gaming", "peripherals")),
                new Product(4, "Monitor 27 4K LG", "Electronics", 350.0, 10, List.of("display", "peripherals")),
                new Product(5, "Silla Ergonomica", "Furniture", 220.0, 8, List.of("office", "ergonomic")),
                new Product(6, "Escritorio Elevable", "Furniture", 450.0, 5, List.of("office", "desk")),
                new Product(7, "Lampara LED Escritorio", "Furniture", 35.0, 25, List.of("lighting", "office")),
                new Product(8, "Camiseta Deportiva", "Clothing", 20.0, 100, List.of("apparel", "sports")),
                new Product(9, "Pantalones Deportivos", "Clothing", 40.0, 60, List.of("apparel", "sports")),
                new Product(10, "Zapatillas Running Nike", "Clothing", 110.0, 20, List.of("footwear", "sports")),
                new Product(11, "Cafetera Espresso", "Appliances", 150.0, 12, List.of("kitchen", "coffee")),
                new Product(12, "Tostadora Acero Inox", "Appliances", 45.0, 18, List.of("kitchen", "breakfast"))
        );
    }

    public static List<Order> getOrders() {
        List<Product> products = getProducts();
        Product laptop = products.get(0);
        Product mouse = products.get(1);
        Product keyboard = products.get(2);
        Product monitor = products.get(3);
        Product chair = products.get(4);
        Product shoes = products.get(9);
        Product coffeeMaker = products.get(10);

        return List.of(
                new Order(1001, "Carlos Gomez", LocalDate.of(2025, 1, 10), OrderStatus.DELIVERED, List.of(
                        new OrderItem(laptop, 1, 1200.0),
                        new OrderItem(mouse, 2, 25.0)
                )),
                new Order(1002, "Ana Martinez", LocalDate.of(2025, 1, 15), OrderStatus.DELIVERED, List.of(
                        new OrderItem(keyboard, 1, 85.0),
                        new OrderItem(monitor, 1, 350.0),
                        new OrderItem(chair, 1, 220.0)
                )),
                new Order(1003, "Luis Rodriguez", LocalDate.of(2025, 2, 1), OrderStatus.SHIPPED, List.of(
                        new OrderItem(mouse, 1, 25.0)
                )),
                new Order(1004, "Elena Fernandez", LocalDate.of(2025, 2, 12), OrderStatus.PENDING, List.of(
                        new OrderItem(coffeeMaker, 1, 150.0),
                        new OrderItem(chair, 2, 220.0)
                )),
                new Order(1005, "Carlos Gomez", LocalDate.of(2025, 2, 20), OrderStatus.CANCELLED, List.of(
                        new OrderItem(shoes, 3, 110.0)
                )),
                new Order(1006, "Mateo Diaz", LocalDate.of(2025, 3, 5), OrderStatus.DELIVERED, List.of(
                        new OrderItem(monitor, 2, 350.0),
                        new OrderItem(laptop, 1, 1200.0)
                ))
        );
    }

    public static List<Transaction> getTransactions() {
        return List.of(
                new Transaction("TX01", LocalDate.of(2025, 1, 5), 1500.0, TransactionType.DEPOSIT, "USD"),
                new Transaction("TX02", LocalDate.of(2025, 1, 10), 200.5, TransactionType.WITHDRAWAL, "USD"),
                new Transaction("TX03", LocalDate.of(2025, 1, 15), 350.0, TransactionType.TRANSFER, "EUR"),
                new Transaction("TX04", LocalDate.of(2025, 2, 2), 2400.0, TransactionType.DEPOSIT, "EUR"),
                new Transaction("TX05", LocalDate.of(2025, 2, 14), 120.0, TransactionType.WITHDRAWAL, "USD"),
                new Transaction("TX06", LocalDate.of(2025, 2, 28), 950.0, TransactionType.TRANSFER, "USD"),
                new Transaction("TX07", LocalDate.of(2025, 3, 1), 3100.0, TransactionType.DEPOSIT, "USD"),
                new Transaction("TX08", LocalDate.of(2025, 3, 10), 45.0, TransactionType.WITHDRAWAL, "EUR"),
                new Transaction("TX09", LocalDate.of(2025, 3, 20), 800.0, TransactionType.TRANSFER, "EUR"),
                new Transaction("TX10", LocalDate.of(2025, 3, 25), 150.0, TransactionType.WITHDRAWAL, "USD")
        );
    }

    public static List<Student> getStudents() {
        return List.of(
                new Student(1, "Daniel", 10, Map.of("Math", 95.0, "Science", 88.0, "History", 92.0)),
                new Student(2, "Camila", 11, Map.of("Math", 70.0, "Science", 75.0, "History", 80.0)),
                new Student(3, "Roberto", 10, Map.of("Math", 60.0, "Science", 65.0, "History", 58.0)),
                new Student(4, "Mariana", 12, Map.of("Math", 99.0, "Science", 98.0, "History", 95.0)),
                new Student(5, "Lucas", 11, Map.of("Math", 85.0, "Science", 82.0, "History", 79.0)),
                new Student(6, "Valeria", 12, Map.of("Math", 89.0, "Science", 91.0, "History", 94.0))
        );
    }

    public static List<Integer> getNumbers() {
        return List.of(5, 12, 8, 21, 3, 18, 42, 9, 14, 27, 2, 8, 12, 33, 4);
    }

    public static List<String> getWords() {
        return List.of("java", "stream", "filter", "map", "reduce", "lambda", "collector", "java", "code", "programming");
    }

    public static List<Flight> getFlights() {
        return List.of(
                new Flight("FL101", "MEX", "MAD", LocalDateTime.of(2025, 6, 1, 14, 30), 630, 850.0, 12),
                new Flight("FL102", "MEX", "CUN", LocalDateTime.of(2025, 6, 1, 8, 0), 135, 120.0, 5),
                new Flight("FL103", "BOG", "MIA", LocalDateTime.of(2025, 6, 2, 10, 15), 240, 320.0, 0),
                new Flight("FL104", "MEX", "JFK", LocalDateTime.of(2025, 6, 2, 16, 0), 300, 410.0, 25),
                new Flight("FL105", "MAD", "BCN", LocalDateTime.of(2025, 6, 3, 9, 0), 75, 65.0, 50),
                new Flight("FL106", "MEX", "CUN", LocalDateTime.of(2025, 6, 3, 18, 0), 130, 95.0, 2),
                new Flight("FL107", "JFK", "LHR", LocalDateTime.of(2025, 6, 4, 22, 0), 420, 780.0, 8),
                new Flight("FL108", "BOG", "MEX", LocalDateTime.of(2025, 6, 5, 7, 30), 280, 290.0, 18)
        );
    }

    public static List<SensorReading> getSensorReadings() {
        return List.of(
                new SensorReading("S1", "Invernadero", 24.5, 65.0, Instant.parse("2025-06-01T10:00:00Z")),
                new SensorReading("S1", "Invernadero", 26.0, 62.0, Instant.parse("2025-06-01T11:00:00Z")),
                new SensorReading("S1", "Invernadero", 28.5, 58.0, Instant.parse("2025-06-01T12:00:00Z")),
                new SensorReading("S2", "Almacen Frio", 4.0, 80.0, Instant.parse("2025-06-01T10:00:00Z")),
                new SensorReading("S2", "Almacen Frio", 3.5, 82.0, Instant.parse("2025-06-01T11:00:00Z")),
                new SensorReading("S3", "Sala Servidores", 19.0, 45.0, Instant.parse("2025-06-01T10:00:00Z")),
                new SensorReading("S3", "Sala Servidores", 21.0, 48.0, Instant.parse("2025-06-01T11:00:00Z")),
                new SensorReading("S3", "Sala Servidores", 38.0, 50.0, Instant.parse("2025-06-01T12:00:00Z"))
        );
    }
}

