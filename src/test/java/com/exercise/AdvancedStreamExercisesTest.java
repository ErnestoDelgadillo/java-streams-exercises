package com.exercise;

import com.exercise.data.DataMock;
import com.exercise.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ============================================================================
 * NIVEL AVANZADO: TÉCNICAS EXPERTAS Y OPTIMIZACIÓN (50 EJERCICIOS)
 * ============================================================================
 * En este nivel dominarás los conceptos más avanzados de Java Streams:
 * - Collectors.teeing (Java 12+)
 * - takeWhile y dropWhile (Java 9+)
 * - Stream.iterate con predicado y generación de secuencias infinitas/finitas
 * - Custom Collectors personalizados usando Collector.of()
 * - Collectors.flatMapping y filtering downstream (Java 9+)
 * - Multi-level Grouping (agrupaciones jerárquicas y multinivel)
 * - Optional.stream()
 * - Algoritmos: Top-K elementos, Anagramas, Conteo cruzado, Chunks / Paginación dinámica
 * - Transposición de matrices y producto cartesiano
 * - Streams paralelos y thread-safety
 *
 * INSTRUCCIONES:
 * Reemplaza el valor por defecto en cada ejercicio con la solución correcta.
 */
public class AdvancedStreamExercisesTest {

    // Record auxiliar para el ejercicio 01
    public record MinMaxSalary(double min, double max) {}

    @Test
    @DisplayName("01 - Collectors.teeing: Obtener simultáneamente salario mínimo y máximo")
    void test01_teeingMinMaxSalary() {
        // Enunciado: Usando Collectors.teeing (Java 12+), obtén en un único pase el salario mínimo y máximo de los empleados.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando Collectors.teeing(minBy(...), maxBy(...), (min, max) -> new MinMaxSalary(...))
        MinMaxSalary minMax = null;

        assertNotNull(minMax);
        assertEquals(48000.0, minMax.min());
        assertEquals(110000.0, minMax.max());
    }

    @Test
    @DisplayName("02 - Collectors.teeing: Promedio y total combinado")
    void test02_teeingTotalAndAverage() {
        // Record auxiliar para resultado compuesto
        record Summary(long count, double sum, double average) {}

        List<Integer> numbers = List.of(10, 20, 30, 40, 50);

        // TODO: Usa teeing para calcular el resultado combinado
        Summary summary = null;

        assertNotNull(summary);
        assertEquals(5, summary.count());
        assertEquals(150.0, summary.sum());
        assertEquals(30.0, summary.average());
    }

    @Test
    @DisplayName("03 - takeWhile: Tomar números mientras sean menores a 30 en una lista ordenada")
    void test03_takeWhileLessThanThirty() {
        // Enunciado: A partir de la lista ordenada, toma elementos solo mientras sean estrictamente menores a 30 (Java 9+).
        List<Integer> sortedNumbers = List.of(2, 5, 12, 18, 25, 29, 30, 35, 42, 50);

        // TODO: Tu solución aquí usando takeWhile
        List<Integer> result = null;

        assertEquals(List.of(2, 5, 12, 18, 25, 29), result);
    }

    @Test
    @DisplayName("04 - dropWhile: Descartar números menores a 30 y procesar el resto")
    void test04_dropWhileLessThanThirty() {
        // Enunciado: Descarta los números mientras sean menores a 30 y recolecta todos los restantes.
        List<Integer> sortedNumbers = List.of(2, 5, 12, 18, 25, 29, 30, 35, 42, 50);

        // TODO: Tu solución aquí usando dropWhile
        List<Integer> result = null;

        assertEquals(List.of(30, 35, 42, 50), result);
    }

    @Test
    @DisplayName("05 - Stream.iterate: Generar potencias de 2 menores a 1000")
    void test05_iteratePowersOfTwo() {
        // Enunciado: Genera la secuencia 1, 2, 4, 8, 16... mientras sea estrictamente menor a 1000 con Stream.iterate(seed, hasNext, next).
        // TODO: Tu solución aquí
        List<Integer> powers = null;

        assertEquals(List.of(1, 2, 4, 8, 16, 32, 64, 128, 256, 512), powers);
    }

    @Test
    @DisplayName("06 - Stream.iterate: Primeros 10 números de Fibonacci")
    void test06_fibonacciSequence() {
        // Enunciado: Genera los primeros 10 números de Fibonacci [0, 1, 1, 2, 3, 5, 8, 13, 21, 34] usando Stream.iterate con arrays int[]{a, b}.
        // TODO: Tu solución aquí
        List<Integer> fibonacci = null;

        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), fibonacci);
    }

    @Test
    @DisplayName("07 - Custom Collector: Invertir el orden de una lista")
    void test07_customCollectorReverseList() {
        // Enunciado: Crea un Collector personalizado usando Collector.of(...) que acumule elementos en una lista y al finalizar la devuelva invertida.
        List<String> original = List.of("A", "B", "C", "D");

        // TODO: Crea el collector con Collector.of(...)
        Collector<String, List<String>, List<String>> reverseCollector = null;

        List<String> reversed = original.stream().collect(reverseCollector);
        assertEquals(List.of("D", "C", "B", "A"), reversed);
    }

    @Test
    @DisplayName("08 - Custom Collector: Construir un mapa de frecuencias manual con Collector.of")
    void test08_customFrequencyCollector() {
        // Enunciado: Implementa un Collector personalizado usando Collector.of(...) que construya un Map<T, Integer> con la frecuencia de cada elemento.
        List<String> items = List.of("manzana", "pera", "manzana", "naranja", "pera", "manzana");

        // TODO: Define el collector de frecuencia usando Collector.of
        Collector<String, Map<String, Integer>, Map<String, Integer>> frequencyCollector = null;

        Map<String, Integer> freq = items.stream().collect(frequencyCollector);
        assertEquals(3, freq.get("manzana"));
        assertEquals(2, freq.get("pera"));
        assertEquals(1, freq.get("naranja"));
    }

    @Test
    @DisplayName("09 - Collectors.flatMapping: Agrupar por dpto y reunir todas las skills en un Set")
    void test09_groupingByAndFlatMappingSkills() {
        // Enunciado: Agrupa los empleados por departamento y reúne el conjunto (Set) de todas sus habilidades usando Collectors.flatMapping (Java 9+).
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando groupingBy y flatMapping(emp -> emp.skills().stream(), toSet())
        Map<String, Set<String>> skillsByDept = null;

        assertNotNull(skillsByDept);
        assertTrue(skillsByDept.get("HR").containsAll(Set.of("Recruiting", "Communication", "Payroll")));
        assertTrue(skillsByDept.get("Finance").containsAll(Set.of("Excel", "Accounting", "Analysis", "Taxation", "Auditing")));
    }

    @Test
    @DisplayName("10 - Collectors.filtering: Agrupar productos caros (> 100) por categoría")
    void test10_groupingByAndFilteringExpensiveProducts() {
        // Enunciado: Agrupa todos los productos por categoría, pero incluye en las listas únicamente productos con precio > 100 usando Collectors.filtering.
        // Nota: Si una categoría no tiene productos > 100, la lista debe quedar vacía en el mapa, no omitirse la clave.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí
        Map<String, List<Product>> expensiveByCategory = null;

        assertNotNull(expensiveByCategory);
        assertEquals(3, expensiveByCategory.get("Electronics").size()); // Laptop (1200), Monitor (350), Teclado (85 no)
        assertEquals(2, expensiveByCategory.get("Furniture").size());   // Silla (220), Escritorio (450)
        assertEquals(1, expensiveByCategory.get("Clothing").size());    // Zapatillas (110)
        assertEquals(1, expensiveByCategory.get("Appliances").size());  // Cafetera (150)
    }

    @Test
    @DisplayName("11 - Agrupación multinivel: Transacciones por Moneda y luego por Tipo")
    void test11_multiLevelGrouping() {
        // Enunciado: Agrupa las transacciones primero por su moneda ("USD", "EUR") y secundariamente por su TransactionType.
        List<Transaction> transactions = DataMock.getTransactions();

        // TODO: Tu solución aquí usando groupingBy anidado
        Map<String, Map<TransactionType, List<Transaction>>> multiGroup = null;

        assertNotNull(multiGroup);
        assertEquals(2, multiGroup.get("USD").get(TransactionType.DEPOSIT).size());
        assertEquals(1, multiGroup.get("EUR").get(TransactionType.DEPOSIT).size());
        assertEquals(2, multiGroup.get("EUR").get(TransactionType.TRANSFER).size());
    }

    @Test
    @DisplayName("12 - Agrupación multinivel con agregación: Monto total por Moneda y Tipo")
    void test12_multiLevelGroupingWithSum() {
        // Enunciado: Calcula el monto total acumulado de transacciones agrupadas por moneda y por tipo: Map<String, Map<TransactionType, Double>>.
        List<Transaction> transactions = DataMock.getTransactions();

        // TODO: Tu solución aquí
        Map<String, Map<TransactionType, Double>> totalAmounts = null;

        assertNotNull(totalAmounts);
        assertEquals(4600.0, totalAmounts.get("USD").get(TransactionType.DEPOSIT), 0.01);
        assertEquals(2400.0, totalAmounts.get("EUR").get(TransactionType.DEPOSIT), 0.01);
        assertEquals(1150.0, totalAmounts.get("EUR").get(TransactionType.TRANSFER), 0.01);
    }

    @Test
    @DisplayName("13 - Top K elementos más frecuentes")
    void test13_topKFrequentElements() {
        // Enunciado: Encuentra las 2 palabras que más se repiten en la lista, ordenadas de mayor a menor frecuencia.
        List<String> words = List.of("java", "docker", "spring", "java", "docker", "java", "kubernetes", "spring", "java");

        // TODO: Tu solución aquí
        List<String> top2 = null;

        assertEquals(List.of("java", "docker"), top2); // java: 4, docker: 2 (o docker/spring empate)
    }

    @Test
    @DisplayName("14 - Agrupación de Anagramas")
    void test14_groupAnagrams() {
        // Enunciado: Agrupa las palabras que son anagramas entre sí (mismas letras ordenadas).
        List<String> words = List.of("roma", "amor", "mora", "perro", "ramo", "gato");

        // TODO: Convierte cada palabra a clave canónica ordenada y agrupa con groupingBy
        Map<String, List<String>> anagramGroups = null;

        assertNotNull(anagramGroups);
        // Clave canónica de "roma", "amor", "mora", "ramo" es "amor"
        assertEquals(4, anagramGroups.get("amor").size());
        assertTrue(anagramGroups.get("amor").containsAll(List.of("roma", "amor", "mora", "ramo")));
    }

    @Test
    @DisplayName("15 - Transposición de una matriz (filas por columnas)")
    void test15_transposeMatrix() {
        // Enunciado: Transpón una matriz 2x3 en una matriz 3x2 utilizando Streams e IntStream.
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );

        // TODO: Transpón la matriz usando IntStream.range(0, cols)...
        List<List<Integer>> transposed = null;

        List<List<Integer>> expected = List.of(
                List.of(1, 4),
                List.of(2, 5),
                List.of(3, 6)
        );
        assertEquals(expected, transposed);
    }

    @Test
    @DisplayName("16 - Producto Cartesiano de dos listas")
    void test16_cartesianProduct() {
        // Enunciado: Genera todos los pares posibles (A x B) entre la lista de colores y la lista de tallas como pares "Color-Talla".
        List<String> colors = List.of("Rojo", "Azul");
        List<String> sizes = List.of("S", "M", "L");

        // TODO: Tu solución aquí usando flatMap
        List<String> cartesian = null;

        assertEquals(List.of("Rojo-S", "Rojo-M", "Rojo-L", "Azul-S", "Azul-M", "Azul-L"), cartesian);
    }

    @Test
    @DisplayName("17 - Identificar todos los elementos duplicados de una lista")
    void test17_findDuplicateElements() {
        // Enunciado: Extrae todos los números que aparecen más de una vez en la lista, sin repetir duplicados en el resultado.
        List<Integer> numbers = List.of(1, 2, 3, 2, 4, 5, 6, 3, 2, 7, 8, 1);
        Set<Integer> seen = new HashSet<>();

        // TODO: Filtra los que no puedan añadirse al set 'seen' y obtén los distintos
        Set<Integer> duplicates = null;

        assertEquals(Set.of(1, 2, 3), duplicates);
    }

    @Test
    @DisplayName("18 - Aplanar lista de Optionals usando Optional.stream (Java 9+)")
    void test18_flattenOptionalStream() {
        // Enunciado: A partir de una lista que contiene Optional<String>, extrae únicamente los valores presentes sin invocar get() manual.
        List<Optional<String>> optionals = List.of(
                Optional.of("Java"),
                Optional.empty(),
                Optional.of("Kotlin"),
                Optional.empty(),
                Optional.of("Scala")
        );

        // TODO: Tu solución aquí usando flatMap(Optional::stream)
        List<String> presentValues = null;

        assertEquals(List.of("Java", "Kotlin", "Scala"), presentValues);
    }

    @Test
    @DisplayName("19 - Empleado con salario más alto por cada departamento")
    void test19_highestPaidEmployeePerDepartment() {
        // Enunciado: Encuentra al empleado con el salario más alto por cada departamento, devolviendo un Map<String, Employee>.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando groupingBy y collectingAndThen con maxBy
        Map<String, Employee> topEarners = null;

        assertNotNull(topEarners);
        assertEquals("Ian Malcolm", topEarners.get("IT").name());
        assertEquals("Hannah Abbott", topEarners.get("HR").name());
        assertEquals("Fiona Gallagher", topEarners.get("Finance").name());
        assertEquals("Julia Roberts", topEarners.get("Marketing").name());
    }

    @Test
    @DisplayName("20 - Dividir una lista en fragmentos (chunks) de tamaño fijo")
    void test20_partitionIntoChunks() {
        // Enunciado: Divide una lista de 7 elementos en trozos (chunks) de a lo sumo 3 elementos usando IntStream.
        List<String> items = List.of("A", "B", "C", "D", "E", "F", "G");
        int chunkSize = 3;

        // TODO: Tu solución aquí usando IntStream.range
        List<List<String>> chunks = null;

        List<List<String>> expected = List.of(
                List.of("A", "B", "C"),
                List.of("D", "E", "F"),
                List.of("G")
        );
        assertEquals(expected, chunks);
    }

    @Test
    @DisplayName("21 - Calcular el producto punto (dot product) de dos vectores")
    void test21_dotProductOfTwoVectors() {
        // Enunciado: Dados dos vectores de la misma longitud, calcula su producto escalar: sum(A[i] * B[i]).
        int[] vectorA = {1, 3, -5};
        int[] vectorB = {4, -2, -1};

        // TODO: Tu solución aquí usando IntStream.range
        int dotProduct = 0;

        assertEquals(3, dotProduct); // (1*4) + (3*-2) + (-5*-1) = 4 - 6 + 5 = 3
    }

    @Test
    @DisplayName("22 - Obtener el segundo valor más alto de una lista")
    void test22_secondHighestNumber() {
        // Enunciado: Encuentra el segundo número más alto en una lista con posibles duplicados.
        List<Integer> numbers = List.of(14, 35, 78, 90, 90, 85, 23);

        // TODO: Tu solución aquí usando distinct, sorted(Comparator.reverseOrder()), skip(1) y findFirst
        Optional<Integer> secondHighest = Optional.empty();

        assertTrue(secondHighest.isPresent());
        assertEquals(85, secondHighest.get());
    }

    @Test
    @DisplayName("23 - Agrupación por rangos de edad (Bucketing)")
    void test23_ageBucketing() {
        // Enunciado: Agrupa a las personas en tres categorías de edad: "Joven" (< 25), "Adulto" (25-35), "Senior" (> 35).
        List<Person> persons = DataMock.getPersons();

        // TODO: Agrupa con groupingBy clasificando según la edad
        Map<String, List<Person>> byAgeBucket = null;

        assertNotNull(byAgeBucket);
        assertEquals(3, byAgeBucket.get("Joven").size());   // Luis (19), Javier (17), Lucia (22)
        assertEquals(5, byAgeBucket.get("Adulto").size());  // Carlos (28), Ana (34), Sofia (25), Mateo (31), Valeria (29)
        assertEquals(2, byAgeBucket.get("Senior").size());  // Elena (42), Gabriel (45)
    }

    @Test
    @DisplayName("24 - Conteo concurrente seguro con parallelStream y toConcurrentMap")
    void test24_parallelConcurrentMap() {
        // Enunciado: Procesa una lista grande de palabras en paralelo y cuenta sus ocurrencias de forma thread-safe usando Collectors.toConcurrentMap.
        List<String> words = List.of("java", "stream", "concurrency", "java", "parallel", "stream", "java");

        // TODO: Tu solución aquí usando words.parallelStream().collect(Collectors.toConcurrentMap(...))
        ConcurrentMap<String, Integer> counts = null;

        assertNotNull(counts);
        assertEquals(3, counts.get("java"));
        assertEquals(2, counts.get("stream"));
        assertEquals(1, counts.get("concurrency"));
    }

    @Test
    @DisplayName("25 - Encontrar pares de elementos adyacentes donde el segundo sea mayor al primero")
    void test25_adjacentPairsIncreasing() {
        // Enunciado: Dada una lista de números, encuentra todos los pares continuos donde el valor sube: "A -> B".
        List<Integer> series = List.of(10, 15, 12, 18, 22, 20, 25);

        // TODO: Usa IntStream.range(0, series.size() - 1) para comparar series.get(i) y series.get(i+1)
        List<String> increasingPairs = null;

        assertEquals(List.of("10->15", "12->18", "18->22", "20->25"), increasingPairs);
    }

    @Test
    @DisplayName("26 - Intersección de múltiples listas con reduce")
    void test26_intersectionOfMultipleLists() {
        // Enunciado: Encuentra los elementos que están presentes en TODAS las listas provistas.
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(2, 3, 4, 6),
                List.of(3, 4, 7, 8),
                List.of(0, 3, 4, 9)
        );

        // TODO: Usa stream().reduce((l1, l2) -> { ... }) con retainAll
        Set<Integer> intersection = null;

        assertEquals(Set.of(3, 4), intersection);
    }

    @Test
    @DisplayName("27 - Aplanar estructura de árbol recursiva")
    void test27_flattenTreeHierarchy() {
        // Estructura de categoría jerárquica
        record CategoryNode(String name, List<CategoryNode> subcategories) {}

        CategoryNode root = new CategoryNode("Root", List.of(
                new CategoryNode("Electronics", List.of(
                        new CategoryNode("Phones", List.of()),
                        new CategoryNode("Laptops", List.of())
                )),
                new CategoryNode("Home", List.of(
                        new CategoryNode("Furniture", List.of())
                ))
        ));

        // Enunciado: Aplana recursivamente todos los nombres de las categorías presentes en el árbol.
        // TODO: Crea una función que devuelva Stream<String> recorriendo recursivamente el nodo y sus subcategorías
        Function<CategoryNode, Stream<String>> flattenNode = null;

        List<String> allCategoryNames = flattenNode != null ? flattenNode.apply(root).toList() : List.of();
        assertEquals(List.of("Root", "Electronics", "Phones", "Laptops", "Home", "Furniture"), allCategoryNames);
    }

    @Test
    @DisplayName("28 - Valoración de inventario agrupado por categoría en orden descendente")
    void test28_inventoryValuationByCategoryDesc() {
        // Enunciado: Calcula el valor total del inventario (precio * stock) por categoría y ordénalo de mayor a menor valor en un LinkedHashMap.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí agrupando y luego ordenando las entradas
        Map<String, Double> sortedValuation = null;

        assertNotNull(sortedValuation);
        List<String> keys = new ArrayList<>(sortedValuation.keySet());
        assertEquals(List.of("Electronics", "Clothing", "Furniture", "Appliances"), keys);
        assertEquals(25300.0, sortedValuation.get("Electronics"), 0.01);
    }

    @Test
    @DisplayName("29 - Matriz de confusión / Conteo cruzado: Personas por Rango de Edad y Género")
    void test29_crossTabulation() {
        // Enunciado: Realiza un conteo cruzado de personas por Género y si son mayores o iguales a 30 años (Boolean).
        List<Person> persons = DataMock.getPersons();

        // TODO: groupingBy anidado contando con Collectors.counting()
        Map<Gender, Map<Boolean, Long>> crossTab = null;

        assertNotNull(crossTab);
        assertEquals(3L, crossTab.get(Gender.MALE).get(false));  // Carlos(28), Luis(19), Javier(17)
        assertEquals(2L, crossTab.get(Gender.MALE).get(true));   // Mateo(31), Gabriel(45)
        assertEquals(3L, crossTab.get(Gender.FEMALE).get(false)); // Sofia(25), Lucia(22), Valeria(29)
        assertEquals(2L, crossTab.get(Gender.FEMALE).get(true));  // Ana(34), Elena(42)
    }

    @Test
    @DisplayName("30 - Clientes frecuentes con gasto total superior a 1000 en órdenes entregadas")
    void test30_topDeliveredCustomersSpending() {
        // Enunciado: Encuentra a los clientes que tengan órdenes con estatus DELIVERED y cuyo gasto acumulado en esas órdenes sea superior a 1000.
        // Devuelve un Map<String, Double> con Cliente -> Monto total gastado.
        List<Order> orders = DataMock.getOrders();

        // TODO: Tu solución aquí filtrando status DELIVERED, agrupando por customerName y sumando totalAmount
        Map<String, Double> vipCustomers = null;

        assertNotNull(vipCustomers);
        assertEquals(2, vipCustomers.size());
        assertEquals(1250.0, vipCustomers.get("Carlos Gomez"), 0.01);
        assertEquals(1900.0, vipCustomers.get("Mateo Diaz"), 0.01);
    }

    // Record auxiliar para el ejercicio 35
    public record FirstLast<T>(T first, T last) {}

    @Test
    @DisplayName("31 - Stream.iterate infinito y takeWhile: Generar números primos menores a 30")
    void test31_primeNumbersWithTakeWhile() {
        // Enunciado: Genera números primos a partir de un flujo infinito usando Stream.iterate(2, n -> n + 1),
        // filtrando con un predicado de primalidad y acotando con takeWhile(p -> p < 30).
        Predicate<Integer> isPrime = n -> n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(d -> n % d == 0);

        // TODO: Tu solución aquí
        List<Integer> primes = null;

        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), primes);
    }

    @Test
    @DisplayName("32 - Custom Collector con Collector.of: Calcular la mediana de una lista impar")
    void test32_medianCustomCollector() {
        // Enunciado: Crea un Collector personalizado usando Collector.of(...) que acumule números enteros, los ordene y calcule la mediana exacta.
        List<Integer> numbers = List.of(7, 1, 3, 9, 5);

        // TODO: Define el collector de mediana
        Collector<Integer, List<Integer>, Double> medianCollector = null;

        Double median = numbers.stream().collect(medianCollector);
        assertNotNull(median);
        assertEquals(5.0, median, 0.01);
    }

    @Test
    @DisplayName("33 - Custom Collector con Collector.of: Ventana deslizante (Sliding Window) de pares")
    void test33_slidingWindowCollector() {
        // Enunciado: Implementa un collector con Collector.of(...) que agrupe elementos adyacentes de dos en dos en formato "A-B".
        List<String> tokens = List.of("A", "B", "C", "D");

        // TODO: Define el collector para ventana deslizante de tamaño 2
        Collector<String, List<String>, List<String>> windowCollector = null;

        List<String> windows = tokens.stream().collect(windowCollector);
        assertEquals(List.of("A-B", "B-C", "C-D"), windows);
    }

    @Test
    @DisplayName("34 - Collectors.teeing: Porcentaje de la masa salarial correspondiente a IT")
    void test34_salaryPercentageWithTeeing() {
        // Enunciado: Usando Collectors.teeing, calcula en un único pase el total de salarios de IT y el total general de la empresa,
        // devolviendo el porcentaje (itTotal / generalTotal) * 100.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando Collectors.teeing
        Double itPercentage = null;

        assertNotNull(itPercentage);
        assertEquals(49.22, itPercentage, 0.05); // 348000 / 707000 * 100 = 49.222%
    }

    @Test
    @DisplayName("35 - Collectors.teeing: Obtener primer y último elemento en un solo pase")
    void test35_firstAndLastWithTeeing() {
        // Enunciado: Obtén simultáneamente el primer y último elemento de una lista en un único recorrido usando teeing.
        List<String> elements = List.of("alpha", "beta", "gamma", "delta");

        // TODO: Tu solución aquí usando Collectors.teeing
        FirstLast<String> result = null;

        assertNotNull(result);
        assertEquals("alpha", result.first());
        assertEquals("delta", result.last());
    }

    @Test
    @DisplayName("36 - Tabla dinámica (Pivot Table): Masa salarial por Departamento y Año de Ingreso")
    void test36_pivotTableDepartmentAndYear() {
        // Enunciado: Construye una tabla pivote Map<String, Map<Integer, Double>> que acumule los salarios por departamento y año de ingreso.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí usando groupingBy anidado con summingDouble(Employee::salary)
        Map<String, Map<Integer, Double>> pivotTable = null;

        assertNotNull(pivotTable);
        assertEquals(75000.0, pivotTable.get("IT").get(2018), 0.01);
        assertEquals(110000.0, pivotTable.get("IT").get(2012), 0.01);
        assertEquals(50000.0, pivotTable.get("HR").get(2015), 0.01);
    }

    @Test
    @DisplayName("37 - Desduplicar por clave personalizada con Predicate con estado")
    void test37_distinctByKeyCustomPredicate() {
        // Enunciado: Filtra las personas conservando solo la primera ocurrencia de cada primera letra del nombre usando un predicado con estado.
        List<Person> persons = DataMock.getPersons();

        // Predicate factory útil:
        // Function<Function<? super T, ?>, Predicate<T>> distinctByKey = ...
        // TODO: Tu solución aquí
        List<String> uniqueFirstLetterNames = null;

        assertNotNull(uniqueFirstLetterNames);
        // Nombres esperados: Carlos ('C'), Ana ('A'), Luis ('L'), Elena ('E'), Sofia ('S'), Javier ('J'), Mateo ('M'), Lucia ('L' repetido se descarta), Gabriel ('G'), Valeria ('V')
        assertEquals(9, uniqueFirstLetterNames.size());
        assertTrue(uniqueFirstLetterNames.contains("Carlos Gomez"));
        assertFalse(uniqueFirstLetterNames.contains("Lucia Morales")); // Descarta 'L' porque ya estaba Luis
    }

    @Test
    @DisplayName("38 - Agrupación jerárquica por longitud de palabra y luego por inicial")
    void test38_hierarchicalGroupByLengthAndFirstChar() {
        // Enunciado: Agrupa las palabras primero por su cantidad de letras (Integer) y luego por su caracter inicial (Character).
        List<String> words = List.of("sol", "mar", "cielo", "nube", "sal", "suelo");

        // TODO: Tu solución aquí usando groupingBy anidado
        Map<Integer, Map<Character, List<String>>> hierarchical = null;

        assertNotNull(hierarchical);
        assertEquals(List.of("sol", "sal"), hierarchical.get(3).get('s'));
        assertEquals(List.of("mar"), hierarchical.get(3).get('m'));
        assertEquals(List.of("cielo"), hierarchical.get(5).get('c'));
        assertEquals(List.of("suelo"), hierarchical.get(5).get('s'));
    }

    @Test
    @DisplayName("39 - Stream.generate con Supplier de estado: Secuencia triangular")
    void test39_generateTriangularNumbers() {
        // Enunciado: Genera los primeros 8 números triangulares T_n = n*(n+1)/2 (1, 3, 6, 10, 15, 21, 28, 36)
        // utilizando Stream.generate y limit(8).
        // TODO: Tu solución aquí
        List<Integer> triangulars = null;

        assertEquals(List.of(1, 3, 6, 10, 15, 21, 28, 36), triangulars);
    }

    @Test
    @DisplayName("40 - Run-Length Encoding (RLE) con Streams")
    void test40_runLengthEncoding() {
        // Enunciado: Convierte la secuencia de caracteres continuos "AAABBBCCDA" en fragmentos comprimidos de conteo+letra ["3A", "3B", "2C", "1D", "1A"].
        String input = "AAABBBCCDA";

        // TODO: Tu solución aquí recorriendo con IntStream e identificando bloques continuos
        List<String> rleCompressed = null;

        assertEquals(List.of("3A", "3B", "2C", "1D", "1A"), rleCompressed);
    }

    @Test
    @DisplayName("41 - Desviación estándar poblacional con Streams")
    void test41_standardDeviation() {
        // Enunciado: Calcula la desviación estándar de las calificaciones de Daniel (95.0, 88.0, 92.0).
        List<Double> grades = List.of(95.0, 88.0, 92.0);

        // TODO: Calcula la media y luego la raíz cuadrada del promedio de las desviaciones al cuadrado
        double stdDev = 0.0;

        assertEquals(2.867, stdDev, 0.01);
    }

    @Test
    @DisplayName("42 - Conteo thread-safe con parallelStream y LongAdder")
    void test42_threadSafeParallelLongAdder() {
        // Enunciado: Recorre una lista de un millón de enteros en paralelo filtrando los pares y contabilizándolos usando un LongAdder.
        int totalElements = 1_000_000;
        LongAdder adder = new LongAdder();

        // TODO: IntStream.range(0, totalElements).parallel().filter(...).forEach(...)
        // adder.sum()...

        assertEquals(500_000L, adder.sum());
    }

    @Test
    @DisplayName("43 - Aplanar mapas con valores nulos seguros usando Stream.ofNullable")
    void test43_streamOfNullableFlattening() {
        // Enunciado: A partir de una lista de claves, busca en un mapa donde algunas claves tienen valor null y aplana todos los elementos no nulos.
        Map<String, List<String>> groups = new HashMap<>();
        groups.put("backend", List.of("Java", "Kotlin"));
        groups.put("frontend", null); // nulo explícito
        groups.put("devops", List.of("Docker", "K8s"));

        List<String> keys = List.of("backend", "frontend", "devops", "qa");

        // TODO: Tu solución aquí usando keys.stream().map(groups::get).flatMap(Stream::ofNullable).flatMap(List::stream)
        List<String> flattened = null;

        assertEquals(List.of("Java", "Kotlin", "Docker", "K8s"), flattened);
    }

    @Test
    @DisplayName("44 - Prefijo común más largo (Longest Common Prefix) con reduce")
    void test44_longestCommonPrefix() {
        // Enunciado: Encuentra el prefijo común más largo de una lista de cadenas utilizando reduce.
        List<String> strings = List.of("intermedio", "interesante", "internet");

        // TODO: Tu solución aquí reduciendo con lógica de prefijo común
        String lcp = null;

        assertEquals("inte", lcp);
    }

    @Test
    @DisplayName("45 - Subarreglo contiguo de suma máxima (Algoritmo de Kadane con reduce)")
    void test45_maxSubarraySumKadane() {
        // Enunciado: Encuentra la suma máxima de un subarreglo contiguo en la lista [-2, 1, -3, 4, -1, 2, 1, -5, 4] (suma máxima = 6 con [4, -1, 2, 1]).
        List<Integer> nums = List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4);

        // TODO: Tu solución aquí
        int maxSum = 0;

        assertEquals(6, maxSum);
    }

    @Test
    @DisplayName("46 - Balance contable neto por moneda (DEPOSIT - WITHDRAWAL)")
    void test46_netAccountingBalance() {
        // Enunciado: A partir de las transacciones, calcula el saldo neto de cada moneda sumando los DEPOSIT y restando los WITHDRAWAL (ignora TRANSFER).
        List<Transaction> transactions = DataMock.getTransactions();

        // TODO: Tu solución aquí agrupando por currency y calculando balance neto
        Map<String, Double> netBalance = null;

        assertNotNull(netBalance);
        assertEquals(4129.5, netBalance.get("USD"), 0.01); // 4600 - 470.5 = 4129.5
        assertEquals(2355.0, netBalance.get("EUR"), 0.01); // 2400 - 45 = 2355.0
    }

    @Test
    @DisplayName("47 - Aplanamiento de dependencias transitivas con Streams recursivos")
    void test47_transitiveDependencies() {
        // Grafo de módulos donde cada módulo depende de otros módulos
        Map<String, List<String>> dependencies = Map.of(
                "A", List.of("B", "C"),
                "B", List.of("D"),
                "C", List.of("E"),
                "D", List.of(),
                "E", List.of()
        );

        // Enunciado: Encuentra todas las dependencias transitivas alcanzables desde el módulo "A".
        // TODO: Tu solución aquí resolviendo dependencias de "A"
        Set<String> allDepsFromA = null;

        assertEquals(Set.of("B", "C", "D", "E"), allDepsFromA);
    }

    @Test
    @DisplayName("48 - Mayor racha de notas consecutivas aprobadas (>= 80)")
    void test48_longestPassingStreak() {
        // Enunciado: Encuentra la longitud de la racha más larga de calificaciones consecutivas mayores o iguales a 80.
        List<Integer> grades = List.of(75, 85, 90, 82, 60, 88, 92, 95, 89, 70);

        // TODO: Tu solución aquí
        int longestStreak = 0;

        assertEquals(4, longestStreak); // [88, 92, 95, 89] -> longitud 4
    }

    @Test
    @DisplayName("49 - Collector concurrente que recolecta a ConcurrentSkipListMap ordenado descendente")
    void test49_concurrentSkipListMapCollector() {
        // Enunciado: Crea un collector concurrente que acumule palabras agrupadas por su longitud en un ConcurrentSkipListMap ordenado de forma DESCENDENTE por longitud.
        List<String> words = List.of("sol", "estrella", "luz", "mariposa", "universo");

        // TODO: Tu solución aquí
        ConcurrentSkipListMap<Integer, List<String>> skipMap = null;

        assertNotNull(skipMap);
        assertEquals(8, skipMap.firstKey()); // "mariposa", "universo" tienen 8
        assertEquals(3, skipMap.lastKey());  // "sol", "luz" tienen 3
    }

    @Test
    @DisplayName("50 - Procesamiento asíncrono no bloqueante con CompletableFuture y Streams")
    void test50_asyncProcessingWithCompletableFuture() {
        // Enunciado: Procesa una lista de IDs de productos asíncronamente simulando una consulta remota que devuelva "Prod-ID", y recolecta todos con CompletableFuture.join().
        List<Integer> productIds = List.of(1, 2, 3, 4, 5);

        // TODO: Tu solución aquí mapeando a CompletableFuture.supplyAsync(...) y luego .map(CompletableFuture::join).toList()
        List<String> asyncResults = null;

        assertEquals(List.of("Prod-1", "Prod-2", "Prod-3", "Prod-4", "Prod-5"), asyncResults);
    }
}
