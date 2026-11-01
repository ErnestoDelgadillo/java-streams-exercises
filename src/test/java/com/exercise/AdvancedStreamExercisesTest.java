package com.exercise;

import com.exercise.data.DataMock;
import com.exercise.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ============================================================================
 * NIVEL AVANZADO: TÉCNICAS EXPERTAS Y OPTIMIZACIÓN (30 EJERCICIOS)
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
}
