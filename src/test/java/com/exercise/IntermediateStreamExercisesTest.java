package com.exercise;

import com.exercise.data.DataMock;
import com.exercise.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ============================================================================
 * NIVEL INTERMEDIO: COLECTORES AVANZADOS Y TRANSFORMACIONES (30 EJERCICIOS)
 * ============================================================================
 * En este nivel trabajarás con técnicas intermedias comunes en aplicaciones reales:
 * - flatMap para aplanar colecciones multidimensionales
 * - Collectors.groupingBy (simple y con downstream collectors)
 * - Collectors.partitioningBy
 * - Collectors.toMap con y sin resolución de colisiones
 * - Comparadores compuestos (thenComparing, reversed, nullsLast)
 * - Primitivos numéricos (IntStream, DoubleStream, mapToInt, summaryStatistics)
 * - Operaciones con fechas y filtros compuestos
 * - Collectors.collectingAndThen
 *
 * INSTRUCCIONES:
 * Reemplaza el valor por defecto en cada ejercicio con la solución correcta.
 */
public class IntermediateStreamExercisesTest {

    @Test
    @DisplayName("01 - Aplanar una lista de listas de enteros")
    void test01_flatMapListOfLists() {
        // Enunciado: Convierte una lista anidada List<List<Integer>> en una única lista plana List<Integer>.
        List<List<Integer>> nestedList = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );

        // TODO: Tu solución aquí usando flatMap
        List<Integer> flatList = null;

        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), flatList);
    }

    @Test
    @DisplayName("02 - Obtener todos los hobbies únicos de las personas ordenados alfabéticamente")
    void test02_distinctHobbiesAlphabetical() {
        // Enunciado: Extrae todos los hobbies de todas las personas, elimina duplicados y ordénalos alfabéticamente.
        List<Person> persons = DataMock.getPersons();

        // TODO: Tu solución aquí
        List<String> hobbies = null;

        assertNotNull(hobbies);
        assertEquals(13, hobbies.size());
        assertEquals("Ajedrez", hobbies.get(0));
        assertEquals("Yoga", hobbies.get(hobbies.size() - 1));
    }

    @Test
    @DisplayName("03 - Extraer todas las habilidades (skills) únicas de los empleados")
    void test03_uniqueSkillsFromEmployees() {
        // Enunciado: Obtén el conjunto (Set) de todas las habilidades tecnológicas de los empleados de IT.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Filtra solo empleados de "IT", extrae sus skills y recolecta en un Set
        Set<String> itSkills = null;

        assertNotNull(itSkills);
        assertTrue(itSkills.containsAll(Set.of("Java", "Spring", "Docker", "Kubernetes", "AWS", "Python", "JavaScript", "React", "Node", "Architecture", "Go", "Cloud")));
        assertEquals(12, itSkills.size());
    }

    @Test
    @DisplayName("04 - Obtener lista de todos los nombres de productos comprados en todas las órdenes")
    void test04_flatMapOrderItemsProductNames() {
        // Enunciado: A partir de todas las órdenes, extrae los nombres únicos de los productos que han sido comprados.
        List<Order> orders = DataMock.getOrders();

        // TODO: Tu solución aquí
        List<String> purchasedProducts = null;

        assertNotNull(purchasedProducts);
        assertTrue(purchasedProducts.containsAll(List.of("Laptop Dell XPS", "Mouse Inalambrico Logitech", "Teclado Mecanico RGB", "Monitor 27 4K LG", "Silla Ergonomica", "Cafetera Espresso", "Zapatillas Running Nike")));
    }

    @Test
    @DisplayName("05 - Contar palabras únicas a partir de oraciones")
    void test05_countUniqueWordsFromSentences() {
        // Enunciado: Divide cada frase en palabras (separadas por espacio), conviértelas a minúsculas y cuenta cuántas palabras únicas hay.
        List<String> sentences = List.of(
                "Java Stream API es genial",
                "Java es robusto y moderno",
                "Stream permite programar funcional"
        );

        // TODO: Tu solución aquí
        long uniqueCount = 0;

        assertEquals(11L, uniqueCount);
    }

    @Test
    @DisplayName("06 - Agrupar empleados por departamento")
    void test06_groupEmployeesByDepartment() {
        // Enunciado: Agrupa los empleados por su departamento en un Map<String, List<Employee>>.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando Collectors.groupingBy
        Map<String, List<Employee>> byDept = null;

        assertNotNull(byDept);
        assertEquals(4, byDept.size());
        assertEquals(4, byDept.get("IT").size());
        assertEquals(2, byDept.get("HR").size());
        assertEquals(2, byDept.get("Finance").size());
        assertEquals(2, byDept.get("Marketing").size());
    }

    @Test
    @DisplayName("07 - Agrupar productos por categoría")
    void test07_groupProductsByCategory() {
        // Enunciado: Agrupa los productos por su categoría.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí
        Map<String, List<Product>> byCategory = null;

        assertNotNull(byCategory);
        assertEquals(4, byCategory.get("Electronics").size());
        assertEquals(3, byCategory.get("Furniture").size());
        assertEquals(3, byCategory.get("Clothing").size());
        assertEquals(2, byCategory.get("Appliances").size());
    }

    @Test
    @DisplayName("08 - Contar cantidad de empleados por departamento")
    void test08_countEmployeesPerDepartment() {
        // Enunciado: Obtén un mapa indicando la cantidad de empleados por departamento: Map<String, Long>.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando groupingBy y Collectors.counting()
        Map<String, Long> countByDept = null;

        assertNotNull(countByDept);
        assertEquals(4L, countByDept.get("IT"));
        assertEquals(2L, countByDept.get("HR"));
        assertEquals(2L, countByDept.get("Finance"));
        assertEquals(2L, countByDept.get("Marketing"));
    }

    @Test
    @DisplayName("09 - Salario promedio por departamento")
    void test09_averageSalaryPerDepartment() {
        // Enunciado: Calcula el salario promedio de cada departamento: Map<String, Double>.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando groupingBy y Collectors.averagingDouble
        Map<String, Double> avgSalaryByDept = null;

        assertNotNull(avgSalaryByDept);
        assertEquals(87000.0, avgSalaryByDept.get("IT"), 0.01);
        assertEquals(52000.0, avgSalaryByDept.get("HR"), 0.01);
        assertEquals(71000.0, avgSalaryByDept.get("Finance"), 0.01);
        assertEquals(56500.0, avgSalaryByDept.get("Marketing"), 0.01);
    }

    @Test
    @DisplayName("10 - Nombres de empleados por departamento")
    void test10_employeeNamesByDepartment() {
        // Enunciado: Agrupa únicamente los nombres de los empleados por departamento: Map<String, List<String>>.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando groupingBy y Collectors.mapping
        Map<String, List<String>> namesByDept = null;

        assertNotNull(namesByDept);
        assertEquals(List.of("Bob Johnson", "Hannah Abbott"), namesByDept.get("HR"));
        assertEquals(List.of("Charlie Brown", "Fiona Gallagher"), namesByDept.get("Finance"));
    }

    @Test
    @DisplayName("11 - Particionar números en pares e impares")
    void test11_partitionEvenOddNumbers() {
        // Enunciado: Separa los números entre pares (true) e impares (false) en un Map<Boolean, List<Integer>>.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO: Tu solución aquí usando Collectors.partitioningBy
        Map<Boolean, List<Integer>> partitioned = null;

        assertNotNull(partitioned);
        assertEquals(List.of(2, 4, 6, 8, 10), partitioned.get(true));
        assertEquals(List.of(1, 3, 5, 7, 9), partitioned.get(false));
    }

    @Test
    @DisplayName("12 - Particionar empleados por salario mayor a 65,000")
    void test12_partitionEmployeesBySalary() {
        // Enunciado: Particiona a los empleados según si ganan más de 65,000.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        Map<Boolean, List<Employee>> highEarnersPartition = null;

        assertNotNull(highEarnersPartition);
        assertEquals(5, highEarnersPartition.get(true).size()); // Alice, Diana, Fiona, George, Ian
        assertEquals(5, highEarnersPartition.get(false).size());
    }

    @Test
    @DisplayName("13 - Crear mapa de producto por ID")
    void test13_productsMapById() {
        // Enunciado: Convierte la lista de productos en un Map<Integer, Product> donde la clave sea el id del producto.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí usando Collectors.toMap
        Map<Integer, Product> productMap = null;

        assertNotNull(productMap);
        assertEquals(12, productMap.size());
        assertEquals("Laptop Dell XPS", productMap.get(1).name());
        assertEquals(150.0, productMap.get(11).price());
    }

    @Test
    @DisplayName("14 - Stock total acumulado por categoría resolviendo colisiones")
    void test14_stockSumByCategoryWithToMap() {
        // Enunciado: Crea un Map<String, Integer> de Categoría -> Stock total, usando toMap con función merge.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí usando Collectors.toMap(Product::category, Product::stock, Integer::sum)
        Map<String, Integer> stockByCategory = null;

        assertNotNull(stockByCategory);
        assertEquals(105, stockByCategory.get("Electronics")); // 15 + 50 + 30 + 10
        assertEquals(38, stockByCategory.get("Furniture"));    // 8 + 5 + 25
        assertEquals(180, stockByCategory.get("Clothing"));   // 100 + 60 + 20
        assertEquals(30, stockByCategory.get("Appliances"));   // 12 + 18
    }

    @Test
    @DisplayName("15 - Mapa de nombre de empleado a su salario")
    void test15_employeeNameToSalaryMap() {
        // Enunciado: Convierte la lista de empleados a un Map<String, Double> (Nombre -> Salario).
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        Map<String, Double> salaryMap = null;

        assertNotNull(salaryMap);
        assertEquals(75000.0, salaryMap.get("Alice Smith"));
        assertEquals(110000.0, salaryMap.get("Ian Malcolm"));
    }

    @Test
    @DisplayName("16 - Ordenar empleados por departamento y luego por salario descendente")
    void test16_sortEmployeesByDeptAndSalaryDesc() {
        // Enunciado: Ordena la lista de empleados primero por departamento ascendente, y para el mismo departamento por salario descendente.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando Comparator.comparing y thenComparing
        List<Employee> sorted = null;

        assertNotNull(sorted);
        // Primer departamento alfabéticamente: "Finance", mayor salario de Finance primero: Fiona (80000), luego Charlie (62000)
        assertEquals("Finance", sorted.get(0).department());
        assertEquals("Fiona Gallagher", sorted.get(0).name());
        assertEquals("Charlie Brown", sorted.get(1).name());
    }

    @Test
    @DisplayName("17 - Ordenar productos por precio ascendente y ante empate por nombre")
    void test17_sortProductsByPriceThenName() {
        // Enunciado: Crea productos de prueba y ordénalos por precio y luego alfabéticamente por nombre.
        List<Product> items = List.of(
                new Product(1, "Zapatos", "Fashion", 50.0, 10, List.of()),
                new Product(2, "Botas", "Fashion", 50.0, 5, List.of()),
                new Product(3, "Camisa", "Fashion", 30.0, 20, List.of())
        );

        // TODO: Tu solución aquí
        List<Product> sorted = null;

        assertNotNull(sorted);
        assertEquals("Camisa", sorted.get(0).name());
        assertEquals("Botas", sorted.get(1).name());  // Botas antes que Zapatos por precio 50
        assertEquals("Zapatos", sorted.get(2).name());
    }

    @Test
    @DisplayName("18 - Calcular el valor total del inventario (precio * stock)")
    void test18_calculateTotalInventoryValue() {
        // Enunciado: Calcula la suma de (precio * stock) de todos los productos en stock.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí usando mapToDouble o map y reduce/sum
        double totalValue = 0.0;

        assertEquals(39395.0, totalValue, 0.01);
    }

    @Test
    @DisplayName("19 - Calcular la edad promedio de las personas")
    void test19_averageAgeOfPersons() {
        // Enunciado: Calcula la edad promedio de todas las personas registradas.
        List<Person> persons = DataMock.getPersons();

        // TODO: Tu solución aquí usando mapToInt y average()
        double averageAge = 0.0;

        assertEquals(29.2, averageAge, 0.01);
    }

    @Test
    @DisplayName("20 - Obtener estadísticas resumen de números (IntSummaryStatistics)")
    void test20_summaryStatistics() {
        // Enunciado: Obtén las estadísticas resumen (min, max, promedio, suma, cantidad) de la lista de números.
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);

        // TODO: Tu solución aquí usando mapToInt y summaryStatistics()
        IntSummaryStatistics stats = null;

        assertNotNull(stats);
        assertEquals(10, stats.getMin());
        assertEquals(50, stats.getMax());
        assertEquals(150, stats.getSum());
        assertEquals(30.0, stats.getAverage());
        assertEquals(5, stats.getCount());
    }

    @Test
    @DisplayName("21 - Encontrar el producto más caro")
    void test21_mostExpensiveProduct() {
        // Enunciado: Encuentra el producto de mayor precio.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí usando max(Comparator.comparingDouble(Product::price))
        Optional<Product> topProduct = Optional.empty();

        assertTrue(topProduct.isPresent());
        assertEquals("Laptop Dell XPS", topProduct.get().name());
        assertEquals(1200.0, topProduct.get().price());
    }

    @Test
    @DisplayName("22 - Encontrar al empleado más veterano (menor joiningYear)")
    void test22_oldestEmployeeByYear() {
        // Enunciado: Encuentra al empleado que lleva más tiempo en la empresa (menor año de ingreso).
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        Optional<Employee> veteran = Optional.empty();

        assertTrue(veteran.isPresent());
        assertEquals("Ian Malcolm", veteran.get().name());
        assertEquals(2012, veteran.get().joiningYear());
    }

    @Test
    @DisplayName("23 - Formatear nombres de departamentos con prefijo y sufijo")
    void test23_joiningWithPrefixAndSuffix() {
        // Enunciado: Une las categorías únicas de productos separadas por " | " e iniciadas con "[" y terminadas con "]".
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí usando Collectors.joining(" | ", "[", "]")
        String result = null;

        assertEquals("[Electronics | Furniture | Clothing | Appliances]", result);
    }

    @Test
    @DisplayName("24 - Filtrar transacciones en USD con monto mayor a 500 y tipo DEPOSIT")
    void test24_compoundFilterTransactions() {
        // Enunciado: Filtra las transacciones que cumplan: Moneda == USD, Monto > 500 y Tipo == DEPOSIT.
        List<Transaction> transactions = DataMock.getTransactions();

        // TODO: Tu solución aquí combinando condiciones en filter
        List<Transaction> filtered = null;

        assertNotNull(filtered);
        assertEquals(2, filtered.size());
        assertEquals(List.of("TX01", "TX07"), filtered.stream().map(Transaction::id).toList());
    }

    @Test
    @DisplayName("25 - Filtrar transacciones ocurridas en el mes de Febrero de 2025")
    void test25_filterTransactionsByMonth() {
        // Enunciado: Obtén las transacciones que ocurrieron en febrero del año 2025.
        List<Transaction> transactions = DataMock.getTransactions();

        // TODO: Tu solución aquí comparando getYear() == 2025 y getMonth() == Month.FEBRUARY
        List<Transaction> febTransactions = null;

        assertNotNull(febTransactions);
        assertEquals(3, febTransactions.size());
        assertEquals(List.of("TX04", "TX05", "TX06"), febTransactions.stream().map(Transaction::id).toList());
    }

    @Test
    @DisplayName("26 - Ordenar lista con valores nulos colocándolos al final (nullsLast)")
    void test26_sortWithNullsLast() {
        // Enunciado: Ordena una lista que contiene strings y valores nulos, posicionando los nulos al final.
        List<String> listWithNulls = Arrays.asList("Zebra", null, "Apple", "Mango", null, "Banana");

        // TODO: Tu solución aquí usando Comparator.nullsLast(Comparator.naturalOrder())
        List<String> sorted = null;

        assertEquals(Arrays.asList("Apple", "Banana", "Mango", "Zebra", null, null), sorted);
    }

    @Test
    @DisplayName("27 - Utilizar peek para acumular logs de elementos filtrados")
    void test27_peekForDebugging() {
        // Enunciado: Filtra los números pares de la lista y utiliza .peek() para añadir cada número par a una lista de log 'inspected'.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> inspected = new ArrayList<>();

        // TODO: Tu solución aquí con .filter(...).peek(inspected::add).map(n -> n * 2).toList()
        List<Integer> doubledEvens = null;

        assertEquals(List.of(4, 8, 12), doubledEvens);
        assertEquals(List.of(2, 4, 6), inspected);
    }

    @Test
    @DisplayName("28 - Obtener directamente el nombre del empleado mejor pagado")
    void test28_nameOfHighestPaidEmployee() {
        // Enunciado: Encuentra al empleado con el salario más alto y extrae directamente su nombre mediante Collectors.collectingAndThen.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando Collectors.collectingAndThen
        String topEarnerName = null;

        assertEquals("Ian Malcolm", topEarnerName);
    }

    @Test
    @DisplayName("29 - Monto total acumulado por tipo de transacción")
    void test29_sumAmountByTransactionType() {
        // Enunciado: Agrupa las transacciones por TransactionType y suma el total de montos para cada tipo.
        List<Transaction> transactions = DataMock.getTransactions();

        // TODO: Tu solución aquí usando groupingBy y Collectors.summingDouble(Transaction::amount)
        Map<TransactionType, Double> totalsByType = null;

        assertNotNull(totalsByType);
        assertEquals(7000.0, totalsByType.get(TransactionType.DEPOSIT), 0.01);
        assertEquals(515.5, totalsByType.get(TransactionType.WITHDRAWAL), 0.01);
        assertEquals(2100.0, totalsByType.get(TransactionType.TRANSFER), 0.01);
    }

    @Test
    @DisplayName("30 - Estudiantes con promedio >= 85 ordenados de mayor a menor promedio")
    void test30_topStudentsByAverageGrade() {
        // Enunciado: Filtra los estudiantes cuyo promedio sea mayor o igual a 85.0 y ordénalos en forma descendente según su promedio.
        List<Student> students = DataMock.getStudents();

        // TODO: Tu solución aquí
        List<String> topStudentNames = null;

        assertEquals(List.of("Mariana", "Daniel", "Valeria"), topStudentNames);
    }
}
