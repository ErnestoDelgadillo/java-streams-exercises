package com.exercise;

import com.exercise.data.DataMock;
import com.exercise.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ============================================================================
 * NIVEL INTERMEDIO: COLECTORES AVANZADOS Y TRANSFORMACIONES (50 EJERCICIOS)
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

    @Test
    @DisplayName("31 - Estadísticas resumidas de salarios con Collectors.summarizingDouble")
    void test31_summarizingDoubleSalary() {
        // Enunciado: Obtén las estadísticas completas de salarios de todos los empleados usando Collectors.summarizingDouble.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        DoubleSummaryStatistics stats = null;

        assertNotNull(stats);
        assertEquals(10L, stats.getCount());
        assertEquals(707000.0, stats.getSum(), 0.01);
        assertEquals(70700.0, stats.getAverage(), 0.01);
        assertEquals(48000.0, stats.getMin(), 0.01);
        assertEquals(110000.0, stats.getMax(), 0.01);
    }

    @Test
    @DisplayName("32 - Recolectar a lista inmodificable con Collectors.collectingAndThen")
    void test32_collectToUnmodifiableList() {
        // Enunciado: Recolecta los nombres de las personas en una lista no modificable usando Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList).
        List<Person> persons = DataMock.getPersons();

        // TODO: Tu solución aquí
        List<String> unmodifiableNames = null;

        assertNotNull(unmodifiableNames);
        assertEquals(10, unmodifiableNames.size());
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableNames.add("Nuevo Nombre"));
    }

    @Test
    @DisplayName("33 - Agrupar nombres de empleados por departamento en un Set")
    void test33_groupingByWithSet() {
        // Enunciado: Agrupa los nombres de los empleados por departamento, pero almacenándolos dentro de un Set en vez de List.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando groupingBy y mapping con Collectors.toSet()
        Map<String, Set<String>> namesByDeptSet = null;

        assertNotNull(namesByDeptSet);
        assertEquals(Set.of("Bob Johnson", "Hannah Abbott"), namesByDeptSet.get("HR"));
    }

    @Test
    @DisplayName("34 - Agrupar empleados en un TreeMap ordenado alfabéticamente por clave")
    void test34_groupingByWithTreeMap() {
        // Enunciado: Agrupa los empleados por departamento usando un TreeMap para que las claves se ordenen alfabéticamente en orden natural.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando groupingBy(Employee::department, TreeMap::new, toList())
        Map<String, List<Employee>> sortedDeptMap = null;

        assertNotNull(sortedDeptMap);
        assertInstanceOf(TreeMap.class, sortedDeptMap);
        assertEquals(List.of("Finance", "HR", "IT", "Marketing"), new ArrayList<>(sortedDeptMap.keySet()));
    }

    @Test
    @DisplayName("35 - Particionar empleados por salario > 70000 y contar la cantidad en cada grupo")
    void test35_partitioningByWithCounting() {
        // Enunciado: Particiona a los empleados según si su salario es > 70000 y cuenta cuántos pertenecen a cada partición.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando partitioningBy(e -> e.salary() > 70000.0, counting())
        Map<Boolean, Long> countPartition = null;

        assertNotNull(countPartition);
        assertEquals(4L, countPartition.get(true));  // Alice, Diana, Fiona, Ian
        assertEquals(6L, countPartition.get(false));
    }

    @Test
    @DisplayName("36 - Particionar productos por precio > 100 y obtener el precio promedio en cada partición")
    void test36_partitioningByWithAverage() {
        // Enunciado: Particiona los productos en caros (> 100) y accesibles (<= 100) calculando el precio promedio de cada grupo.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí usando partitioningBy y averagingDouble(Product::price)
        Map<Boolean, Double> avgPricePartition = null;

        assertNotNull(avgPricePartition);
        assertEquals(413.33, avgPricePartition.get(true), 0.01);
        assertEquals(41.67, avgPricePartition.get(false), 0.01);
    }

    @Test
    @DisplayName("37 - Agrupar por departamento y unir nombres con comas")
    void test37_mappingWithJoiningByDepartment() {
        // Enunciado: Agrupa por departamento y une los nombres de los empleados en un único String separado por comas ", ".
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando groupingBy y mapping(Employee::name, joining(", "))
        Map<String, String> namesSeparatedByComma = null;

        assertNotNull(namesSeparatedByComma);
        assertEquals("Bob Johnson, Hannah Abbott", namesSeparatedByComma.get("HR"));
    }

    @Test
    @DisplayName("38 - Convertir a LinkedHashMap preservando el orden exacto de inserción")
    void test38_toMapPreservingOrder() {
        // Enunciado: Convierte los primeros 3 productos a un mapa Nombre -> Precio asegurando que sea un LinkedHashMap.
        List<Product> products = DataMock.getProducts().subList(0, 3);

        // TODO: Tu solución aquí usando toMap(..., ..., (a,b)->a, LinkedHashMap::new)
        Map<String, Double> orderedMap = null;

        assertNotNull(orderedMap);
        assertInstanceOf(LinkedHashMap.class, orderedMap);
        assertEquals(List.of("Laptop Dell XPS", "Mouse Inalambrico Logitech", "Teclado Mecanico RGB"), new ArrayList<>(orderedMap.keySet()));
    }

    @Test
    @DisplayName("39 - Aplanar todos los valores de un Map<String, List<String>> en una lista ordenada")
    void test39_flatMapMapValues() {
        // Enunciado: Toma un mapa con listas como valores, extrae todos los valores individuales y ordénalos en una sola lista plana.
        Map<String, List<String>> dict = Map.of(
                "A", List.of("x", "y"),
                "B", List.of("z", "w")
        );

        // TODO: Tu solución aquí usando dict.values().stream().flatMap(...)
        List<String> flatSorted = null;

        assertEquals(List.of("w", "x", "y", "z"), flatSorted);
    }

    @Test
    @DisplayName("40 - Contar vocales en una cadena usando chars()")
    void test40_countVowelsUsingChars() {
        // Enunciado: Cuenta la cantidad total de vocales (a, e, i, o, u sin distinguir mayúsculas) en la frase provista usando text.chars().
        String text = "Java Streams son poderosos";

        // TODO: Tu solución aquí filtrando chars
        long vowelCount = 0;

        assertEquals(9L, vowelCount);
    }

    @Test
    @DisplayName("41 - Calcular el factorial de un número con LongStream.rangeClosed")
    void test41_longStreamFactorial() {
        // Enunciado: Calcula 6 factorial (6! = 1 * 2 * 3 * 4 * 5 * 6 = 720) usando LongStream.rangeClosed y reduce.
        int n = 6;

        // TODO: Tu solución aquí
        long factorial = 0;

        assertEquals(720L, factorial);
    }

    @Test
    @DisplayName("42 - Ordenar con valores nulos posicionados al principio con nullsFirst")
    void test42_sortWithNullsFirst() {
        // Enunciado: Ordena una lista que contiene strings y valores nulos, posicionando los nulos AL PRINCIPIO.
        List<String> listWithNulls = Arrays.asList("Z", null, "A", null, "M");

        // TODO: Tu solución aquí usando Comparator.nullsFirst(Comparator.naturalOrder())
        List<String> sorted = null;

        assertEquals(Arrays.asList(null, null, "A", "M", "Z"), sorted);
    }

    @Test
    @DisplayName("43 - Ordenar transacciones por fecha ascendente y ante empate por monto descendente")
    void test43_thenComparingDoubleTransactions() {
        // Enunciado: Crea transacciones de prueba y ordénalas por fecha (ascendente) y ante igual fecha por monto (descendente).
        List<Transaction> txs = List.of(
                new Transaction("T1", LocalDate.of(2025, 1, 10), 100.0, TransactionType.DEPOSIT, "USD"),
                new Transaction("T2", LocalDate.of(2025, 1, 10), 500.0, TransactionType.DEPOSIT, "USD"),
                new Transaction("T3", LocalDate.of(2025, 1, 5), 200.0, TransactionType.DEPOSIT, "USD")
        );

        // TODO: Tu solución aquí usando Comparator.comparing(Transaction::date).thenComparing(Comparator.comparingDouble(Transaction::amount).reversed())
        List<Transaction> sortedTxs = null;

        assertNotNull(sortedTxs);
        assertEquals("T3", sortedTxs.get(0).id()); // 5 de enero
        assertEquals("T2", sortedTxs.get(1).id()); // 10 de enero (500.0)
        assertEquals("T1", sortedTxs.get(2).id()); // 10 de enero (100.0)
    }

    @Test
    @DisplayName("44 - Construir un Stream programáticamente con Stream.builder()")
    void test44_streamBuilder() {
        // Enunciado: Usa Stream.<String>builder() para agregar "uno", "dos", "tres" y construir el Stream resultante en una lista.
        // TODO: Tu solución aquí
        List<String> builtList = null;

        assertEquals(List.of("uno", "dos", "tres"), builtList);
    }

    @Test
    @DisplayName("45 - Filtrar órdenes DELIVERED en un rango de fechas")
    void test45_ordersDeliveredDateRange() {
        // Enunciado: Obtén las órdenes con estado DELIVERED que se realizaron en enero de 2025 (entre 2025-01-01 y 2025-01-31 inclusive).
        List<Order> orders = DataMock.getOrders();
        LocalDate start = LocalDate.of(2025, 1, 1);
        LocalDate end = LocalDate.of(2025, 1, 31);

        // TODO: Tu solución aquí
        List<Order> janOrders = null;

        assertNotNull(janOrders);
        assertEquals(2, janOrders.size());
        assertEquals(List.of(1001, 1002), janOrders.stream().map(Order::id).toList());
    }

    @Test
    @DisplayName("46 - Monto total acumulado de compras por cliente")
    void test46_totalSalesByCustomer() {
        // Enunciado: Agrupa por customerName y calcula la sumatoria de totalAmount de todas sus órdenes (independientemente del estatus).
        List<Order> orders = DataMock.getOrders();

        // TODO: Tu solución aquí usando groupingBy y summingDouble(Order::getTotalAmount)
        Map<String, Double> salesByCustomer = null;

        assertNotNull(salesByCustomer);
        assertEquals(1580.0, salesByCustomer.get("Carlos Gomez"), 0.01); // 1250 + 330
        assertEquals(655.0, salesByCustomer.get("Ana Martinez"), 0.01);
        assertEquals(1900.0, salesByCustomer.get("Mateo Diaz"), 0.01);
    }

    @Test
    @DisplayName("47 - Encontrar el producto más caro por categoría")
    void test47_maxByProductPerCategory() {
        // Enunciado: Encuentra el producto de mayor precio dentro de cada categoría: Map<String, Optional<Product>>.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí usando groupingBy(Product::category, Collectors.maxBy(Comparator.comparingDouble(Product::price)))
        Map<String, Optional<Product>> maxByCategory = null;

        assertNotNull(maxByCategory);
        assertEquals("Laptop Dell XPS", maxByCategory.get("Electronics").get().name());
        assertEquals("Cafetera Espresso", maxByCategory.get("Appliances").get().name());
    }

    @Test
    @DisplayName("48 - Encontrar el producto con menor stock por categoría")
    void test48_minByProductStockPerCategory() {
        // Enunciado: Encuentra el producto con menor inventario (stock) en cada categoría: Map<String, Optional<Product>>.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí usando groupingBy(Product::category, Collectors.minBy(Comparator.comparingInt(Product::stock)))
        Map<String, Optional<Product>> minStockByCategory = null;

        assertNotNull(minStockByCategory);
        assertEquals("Monitor 27 4K LG", minStockByCategory.get("Electronics").get().name()); // stock 10
        assertEquals("Escritorio Elevable", minStockByCategory.get("Furniture").get().name());  // stock 5
    }

    @Test
    @DisplayName("49 - Transformar claves y valores de un Map mediante Streams")
    void test49_mapKeysAndValuesTransform() {
        // Enunciado: Toma un Map<Integer, String> y transforma las claves sumándoles 100 y los valores a mayúsculas en un nuevo Map.
        Map<Integer, String> input = Map.of(1, "uno", 2, "dos");

        // TODO: Tu solución aquí usando input.entrySet().stream().collect(Collectors.toMap(e -> e.getKey() + 100, e -> e.getValue().toUpperCase()))
        Map<Integer, String> transformedMap = null;

        assertNotNull(transformedMap);
        assertEquals("UNO", transformedMap.get(101));
        assertEquals("DOS", transformedMap.get(102));
    }

    @Test
    @DisplayName("50 - Filtrar empleados de IT y recolectar a ConcurrentMap")
    void test50_filterAndCollectToConcurrentMap() {
        // Enunciado: Filtra los empleados de "IT" y crea un ConcurrentMap con Nombre -> Salario usando Collectors.toConcurrentMap.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        ConcurrentMap<String, Double> itSalaries = null;

        assertNotNull(itSalaries);
        assertEquals(4, itSalaries.size());
        assertEquals(110000.0, itSalaries.get("Ian Malcolm"));
    }
}
