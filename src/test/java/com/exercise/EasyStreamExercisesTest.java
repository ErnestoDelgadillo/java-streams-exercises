package com.exercise;

import com.exercise.data.DataMock;
import com.exercise.model.Employee;
import com.exercise.model.Person;
import com.exercise.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ============================================================================
 * NIVEL FÁCIL: FUNDAMENTOS DE JAVA STREAMS (30 EJERCICIOS)
 * ============================================================================
 * En este nivel practicarás los métodos esenciales de la API Stream:
 * - filter
 * - map
 * - distinct
 * - sorted
 * - limit / skip
 * - count
 * - findFirst / findAny
 * - anyMatch / allMatch / noneMatch
 * - reduce básico
 * - IntStream básico
 * - toList / toSet / joining básico
 *
 * INSTRUCCIONES:
 * Reemplaza el valor por defecto (normalmente null, 0, false, etc.) en cada
 * ejercicio con tu flujo de Stream correspondiente y ejecuta los tests.
 */
public class EasyStreamExercisesTest {

    @Test
    @DisplayName("01 - Filtrar números pares")
    void test01_filterEvenNumbers() {
        // Enunciado: A partir de la lista de números, filtra únicamente aquellos que sean pares.
        List<Integer> numbers = DataMock.getNumbers();

        // TODO: Tu solución aquí utilizando numbers.stream()...
        List<Integer> evens = null;

        assertEquals(List.of(12, 8, 18, 42, 14, 2, 8, 12, 4), evens);
    }

    @Test
    @DisplayName("02 - Filtrar palabras de longitud mayor a 5")
    void test02_filterWordsLongerThanFive() {
        // Enunciado: Filtra las palabras que tengan estrictamente más de 5 caracteres.
        List<String> words = DataMock.getWords();

        // TODO: Tu solución aquí
        List<String> result = null;

        assertEquals(List.of("stream", "filter", "reduce", "lambda", "collector", "programming"), result);
    }

    @Test
    @DisplayName("03 - Filtrar personas mayores o iguales a 30 años")
    void test03_filterPersonsAgeThirtyOrOlder() {
        // Enunciado: Obtén la lista de personas cuya edad sea mayor o igual a 30 años.
        List<Person> persons = DataMock.getPersons();

        // TODO: Tu solución aquí
        List<Person> result = null;

        assertEquals(4, result != null ? result.size() : 0);
        List<String> names = result != null ? result.stream().map(Person::name).toList() : List.of();
        assertEquals(List.of("Ana Martinez", "Elena Fernandez", "Mateo Diaz", "Gabriel Sanchez"), names);
    }

    @Test
    @DisplayName("04 - Filtrar empleados de IT")
    void test04_filterEmployeesByDepartment() {
        // Enunciado: Filtra a los empleados que pertenezcan al departamento "IT".
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        List<Employee> itEmployees = null;

        assertEquals(4, itEmployees != null ? itEmployees.size() : 0);
        List<String> names = itEmployees != null ? itEmployees.stream().map(Employee::name).toList() : List.of();
        assertEquals(List.of("Alice Smith", "Diana Prince", "George Clark", "Ian Malcolm"), names);
    }

    @Test
    @DisplayName("05 - Filtrar productos con stock bajo (< 15)")
    void test05_filterLowStockProducts() {
        // Enunciado: Filtra los productos cuyo inventario (stock) sea menor a 15 unidades.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí
        List<Product> lowStock = null;

        List<String> productNames = lowStock != null ? lowStock.stream().map(Product::name).toList() : List.of();
        assertEquals(List.of("Monitor 27 4K LG", "Silla Ergonomica", "Escritorio Elevable", "Cafetera Espresso"), productNames);
    }

    @Test
    @DisplayName("06 - Filtrar palabras que comiencen con 'j' o 'J'")
    void test06_filterWordsStartingWithJ() {
        // Enunciado: Filtra las palabras que empiezan con 'j' (sin distinguir mayúsculas de minúsculas).
        List<String> words = DataMock.getWords();

        // TODO: Tu solución aquí
        List<String> result = null;

        assertEquals(List.of("java", "java"), result);
    }

    @Test
    @DisplayName("07 - Transformar palabras a MAYÚSCULAS")
    void test07_mapToUpperCase() {
        // Enunciado: Convierte todas las palabras de la lista a mayúsculas.
        List<String> words = List.of("java", "spring", "stream", "docker");

        // TODO: Tu solución aquí
        List<String> upper = null;

        assertEquals(List.of("JAVA", "SPRING", "STREAM", "DOCKER"), upper);
    }

    @Test
    @DisplayName("08 - Extraer nombres de personas")
    void test08_mapPersonToName() {
        // Enunciado: Transforma la lista de personas para obtener únicamente sus nombres.
        List<Person> persons = DataMock.getPersons();

        // TODO: Tu solución aquí
        List<String> names = null;

        assertNotNull(names);
        assertEquals(10, names.size());
        assertEquals("Carlos Gomez", names.get(0));
        assertEquals("Valeria Torres", names.get(9));
    }

    @Test
    @DisplayName("09 - Obtener longitud de cada palabra")
    void test09_mapWordLengths() {
        // Enunciado: Transforma cada palabra en su longitud (número de caracteres).
        List<String> words = List.of("sol", "luna", "estrella");

        // TODO: Tu solución aquí
        List<Integer> lengths = null;

        assertEquals(List.of(3, 4, 8), lengths);
    }

    @Test
    @DisplayName("10 - Calcular el cuadrado de cada número")
    void test10_mapSquares() {
        // Enunciado: Eleva al cuadrado cada número de la lista provista.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // TODO: Tu solución aquí
        List<Integer> squares = null;

        assertEquals(List.of(1, 4, 9, 16, 25), squares);
    }

    @Test
    @DisplayName("11 - Obtener correos electrónicos de personas")
    void test11_extractEmails() {
        // Enunciado: Extrae todos los emails de la lista de personas.
        List<Person> persons = DataMock.getPersons();

        // TODO: Tu solución aquí
        List<String> emails = null;

        assertNotNull(emails);
        assertTrue(emails.contains("carlos@example.com"));
        assertTrue(emails.contains("valeria@example.com"));
    }

    @Test
    @DisplayName("12 - Eliminar números duplicados")
    void test12_distinctNumbers() {
        // Enunciado: Elimina todos los elementos repetidos de la lista de números.
        List<Integer> numbersWithDuplicates = List.of(1, 2, 2, 3, 4, 4, 4, 5, 1);

        // TODO: Tu solución aquí
        List<Integer> distincts = null;

        assertEquals(List.of(1, 2, 3, 4, 5), distincts);
    }

    @Test
    @DisplayName("13 - Obtener categorías únicas de productos")
    void test13_distinctProductCategories() {
        // Enunciado: Obtén una lista con las categorías únicas presentes en la lista de productos.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí
        List<String> categories = null;

        assertEquals(List.of("Electronics", "Furniture", "Clothing", "Appliances"), categories);
    }

    @Test
    @DisplayName("14 - Ordenar palabras en orden alfabético natural")
    void test14_sortedWordsAlphabetical() {
        // Enunciado: Ordena la lista de palabras en orden alfabético ascendente (A-Z).
        List<String> fruits = List.of("pera", "manzana", "platano", "kiwi", "uva");

        // TODO: Tu solución aquí
        List<String> sortedFruits = null;

        assertEquals(List.of("kiwi", "manzana", "pera", "platano", "uva"), sortedFruits);
    }

    @Test
    @DisplayName("15 - Ordenar números de menor a mayor")
    void test15_sortedNumbersAscending() {
        // Enunciado: Ordena la siguiente lista de números enteros de menor a mayor.
        List<Integer> numbers = List.of(45, 12, 89, 3, 27);

        // TODO: Tu solución aquí
        List<Integer> sortedNumbers = null;

        assertEquals(List.of(3, 12, 27, 45, 89), sortedNumbers);
    }

    @Test
    @DisplayName("16 - Ordenar números de mayor a menor")
    void test16_sortedNumbersDescending() {
        // Enunciado: Ordena los números de forma descendente (usando Comparator.reverseOrder()).
        List<Integer> numbers = List.of(45, 12, 89, 3, 27);

        // TODO: Tu solución aquí
        List<Integer> descNumbers = null;

        assertEquals(List.of(89, 45, 27, 12, 3), descNumbers);
    }

    @Test
    @DisplayName("17 - Ordenar personas por edad de menor a mayor")
    void test17_sortedPersonsByAge() {
        // Enunciado: Ordena la lista de personas por edad de forma ascendente.
        List<Person> persons = DataMock.getPersons();

        // TODO: Tu solución aquí
        List<Person> sortedPersons = null;

        assertNotNull(sortedPersons);
        assertEquals(17, sortedPersons.get(0).age()); // Javier Perez (17)
        assertEquals(45, sortedPersons.get(sortedPersons.size() - 1).age()); // Gabriel Sanchez (45)
    }

    @Test
    @DisplayName("18 - Tomar los primeros 3 elementos (limit)")
    void test18_limitElements() {
        // Enunciado: Toma únicamente los primeros 3 números de la lista.
        List<Integer> numbers = DataMock.getNumbers();

        // TODO: Tu solución aquí
        List<Integer> firstThree = null;

        assertEquals(List.of(5, 12, 8), firstThree);
    }

    @Test
    @DisplayName("19 - Omitir los primeros 12 elementos (skip)")
    void test19_skipElements() {
        // Enunciado: Salta los primeros 12 elementos de la lista de números y recolecta el resto.
        List<Integer> numbers = DataMock.getNumbers(); // total 15 elementos

        // TODO: Tu solución aquí
        List<Integer> remaining = null;

        assertEquals(List.of(12, 33, 4), remaining);
    }

    @Test
    @DisplayName("20 - Paginación simple: página 2 con tamaño 3")
    void test20_pagination() {
        // Enunciado: Simula una paginación: omite la primera página (3 elementos) y toma los siguientes 3 (página 2).
        List<String> items = List.of("A", "B", "C", "D", "E", "F", "G");

        // TODO: Tu solución aquí
        List<String> page2 = null;

        assertEquals(List.of("D", "E", "F"), page2);
    }

    @Test
    @DisplayName("21 - Contar empleados con salario superior a 70,000")
    void test21_countEmployeesHighSalary() {
        // Enunciado: Cuenta cuántos empleados ganan estrictamente más de 70,000.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        long count = 0;

        assertEquals(4L, count); // Alice (75k), Diana (95k), Fiona (80k), Ian (110k)
    }

    @Test
    @DisplayName("22 - Contar palabras que contienen la letra 'a'")
    void test22_countWordsContainingLetter() {
        // Enunciado: Cuenta cuántas palabras de la lista contienen el caracter 'a'.
        List<String> words = DataMock.getWords();

        // TODO: Tu solución aquí
        long count = 0;

        assertEquals(6L, count); // java, stream, lambda, collector, java, programming
    }

    @Test
    @DisplayName("23 - Encontrar el primer producto con precio mayor a 1,000")
    void test23_findFirstExpensiveProduct() {
        // Enunciado: Encuentra el primer producto cuyo precio sea mayor a 1,000.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí (debe devolver un Optional<Product>)
        Optional<Product> expensiveProduct = Optional.empty();

        assertTrue(expensiveProduct.isPresent());
        assertEquals("Laptop Dell XPS", expensiveProduct.get().name());
    }

    @Test
    @DisplayName("24 - Encontrar cualquier empleado del departamento 'Finance'")
    void test24_findAnyFinanceEmployee() {
        // Enunciado: Encuentra cualquier empleado del departamento "Finance".
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        Optional<Employee> financeEmp = Optional.empty();

        assertTrue(financeEmp.isPresent());
        assertEquals("Finance", financeEmp.get().department());
    }

    @Test
    @DisplayName("25 - Verificar si hay alguna persona menor de edad (anyMatch)")
    void test25_anyMatchMinor() {
        // Enunciado: Verifica si existe al menos una persona con edad menor a 18 años.
        List<Person> persons = DataMock.getPersons();

        // TODO: Tu solución aquí
        boolean hasMinors = false;

        assertTrue(hasMinors);
    }

    @Test
    @DisplayName("26 - Verificar si todos los productos tienen stock (allMatch)")
    void test26_allMatchPositiveStock() {
        // Enunciado: Comprueba si TODOS los productos tienen un stock mayor a 0.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí
        boolean allInStock = false;

        assertTrue(allInStock);
    }

    @Test
    @DisplayName("27 - Verificar que ningún empleado tenga salario negativo (noneMatch)")
    void test27_noneMatchNegativeSalary() {
        // Enunciado: Comprueba que NINGÚN empleado tenga un salario menor a 0.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        boolean noneNegative = false;

        assertTrue(noneNegative);
    }

    @Test
    @DisplayName("28 - Sumar todos los números usando reduce")
    void test28_sumWithReduce() {
        // Enunciado: Calcula la suma de todos los números en la lista usando el operador reduce.
        List<Integer> numbers = List.of(10, 20, 30, 40);

        // TODO: Tu solución aquí (usando reduce)
        int sum = 0;

        assertEquals(100, sum);
    }

    @Test
    @DisplayName("29 - Concatenar palabras separadas por coma usando joining")
    void test29_joinWordsWithComma() {
        // Enunciado: Une las palabras en un único String separadas por una coma y un espacio ", ".
        List<String> tech = List.of("Java", "Kotlin", "Scala");

        // TODO: Tu solución aquí usando Collectors.joining(", ")
        String joined = null;

        assertEquals("Java, Kotlin, Scala", joined);
    }

    @Test
    @DisplayName("30 - Sumar números del 1 al 100 usando IntStream")
    void test30_sumWithIntStreamRange() {
        // Enunciado: Usa IntStream.rangeClosed(1, 100) para calcular la sumatoria de 1 a 100.
        // TODO: Tu solución aquí
        int sum = 0;

        assertEquals(5050, sum);
    }
}

