package com.exercise;

import com.exercise.data.DataMock;
import com.exercise.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ============================================================================
 * EXAMEN INTEGRAL DE MAESTRÍA EN JAVA STREAMS (30 EJERCICIOS)
 * ============================================================================
 * Este examen evalúa y consolida todos los aspectos esenciales y avanzados
 * de la API Stream de Java (desde Java 8 hasta Java 17+):
 *
 * 1.  Filtrado compuesto, transformaciones y proyecciones.
 * 2.  Ordenación multinivel y paginación (limit / skip).
 * 3.  Cuantificadores booleanos (allMatch, anyMatch, noneMatch).
 * 4.  Aplanamiento multidimensional con flatMap.
 * 5.  Agrupaciones simples y multinivel (groupingBy a 2 y 3 niveles).
 * 6.  Colectores downstream complejos (counting, averaging, mapping, toSet, maxBy).
 * 7.  Particionamiento con agregaciones (partitioningBy).
 * 8.  Construcción de mapas con resolución de conflictos (toMap con merge).
 * 9.  Streams de primitivos (IntStream, DoubleStream, summaryStatistics).
 * 10. Reducciones avanzadas (reduce con acumuladores personalizados).
 * 11. Bifurcación simultánea con Collectors.teeing (Java 12+).
 * 12. Flujos condicionales e infinitos (takeWhile, dropWhile, Stream.iterate).
 * 13. Creación de Custom Collectors con Collector.of(...).
 * 14. Detección de valores atípicos (outliers) y algoritmos Top-K.
 * 15. Operaciones matriciales (traza de matriz con IntStream).
 * 16. Manejo seguro de nulos y Optionals (Optional.stream, Stream.ofNullable).
 * 17. Concurrencia y paralelismo seguro (parallelStream).
 * 18. Ventanas de diferencias consecutivas (i y i+1).
 * 19. Procesamiento asíncrono no bloqueante con CompletableFuture y Streams.
 * 20. Gran Reporte Ejecutivo Multidimensional de Auditoría.
 *
 * INSTRUCCIONES:
 * Reemplaza el valor por defecto en cada ejercicio con tu solución y
 * ejecuta los tests para comprobar tu puntuación.
 */
public class StreamExamTest {

    @Test
    @DisplayName("Pregunta 01 - Vuelos directos con asientos disponibles entre dos ciudades")
    void test01_availableDirectFlights() {
        // Enunciado: Filtra los vuelos que salgan de "MEX", tengan destino "CUN" y cuenten con asientos disponibles (> 0).
        // Devuelve únicamente sus códigos de vuelo (flightNumber).
        List<Flight> flights = DataMock.getFlights();

        // TODO: Tu solución aquí
        List<String> availableFlightNumbers = null;

        assertEquals(List.of("FL102", "FL106"), availableFlightNumbers);
    }

    @Test
    @DisplayName("Pregunta 02 - Formateo de resumen de vuelos económicos (< $150)")
    void test02_flightSummaryFormat() {
        // Enunciado: Obtén los vuelos con precio estrictamente menor a 150.0 y formatéalos como:
        // "CODIGO: ORIGEN->DESTINO ($PRECIO)" -> Ej: "FL102: MEX->CUN ($120.0)"
        List<Flight> flights = DataMock.getFlights();

        // TODO: Tu solución aquí
        List<String> cheapFlightSummaries = null;

        assertEquals(List.of(
                "FL102: MEX->CUN ($120.0)",
                "FL105: MAD->BCN ($65.0)",
                "FL106: MEX->CUN ($95.0)"
        ), cheapFlightSummaries);
    }

    @Test
    @DisplayName("Pregunta 03 - Paginación y ordenación: Los 3 vuelos más económicos")
    void test03_top3CheapestFlights() {
        // Enunciado: Encuentra los 3 vuelos más baratos, ordenados por precio ascendente y ante igual precio por menor duración.
        // Devuelve sus códigos de vuelo.
        List<Flight> flights = DataMock.getFlights();

        // TODO: Tu solución aquí ordenando con Comparator.comparingDouble(Flight::price).thenComparingInt(Flight::durationMinutes) y limit(3)
        List<String> top3Cheapest = null;

        assertEquals(List.of("FL105", "FL106", "FL102"), top3Cheapest);
    }

    @Test
    @DisplayName("Pregunta 04 - Verificación de seguridad térmica en sensores con allMatch")
    void test04_verifySafeTemperatures() {
        // Enunciado: Verifica que TODAS las lecturas de sensores registren temperaturas en el rango seguro: 0.0 <= temp <= 50.0.
        List<SensorReading> readings = DataMock.getSensorReadings();

        // TODO: Tu solución aquí con allMatch
        boolean allSafe = false;

        assertTrue(allSafe);
    }

    @Test
    @DisplayName("Pregunta 05 - Empleados con habilidades simultáneas en Java y Docker con flatMap")
    void test05_employeesWithJavaAndDocker() {
        // Enunciado: Encuentra los nombres de los empleados que tengan TANTO "Java" COMO "Docker" entre sus habilidades (skills).
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí
        List<String> qualifiedEmployees = null;

        assertEquals(List.of("Alice Smith"), qualifiedEmployees);
    }

    @Test
    @DisplayName("Pregunta 06 - Agrupación de vuelos por ciudad de origen")
    void test06_groupFlightsByOrigin() {
        // Enunciado: Agrupa los vuelos por su ciudad de origen en un Map<String, List<Flight>>.
        List<Flight> flights = DataMock.getFlights();

        // TODO: Tu solución aquí usando Collectors.groupingBy
        Map<String, List<Flight>> flightsByOrigin = null;

        assertNotNull(flightsByOrigin);
        assertEquals(4, flightsByOrigin.get("MEX").size());
        assertEquals(2, flightsByOrigin.get("BOG").size());
    }

    @Test
    @DisplayName("Pregunta 07 - Conteo de vuelos por ciudad de origen")
    void test07_countFlightsPerOrigin() {
        // Enunciado: Obtén la cantidad total de vuelos que parten desde cada ciudad de origen: Map<String, Long>.
        List<Flight> flights = DataMock.getFlights();

        // TODO: Tu solución aquí usando groupingBy y Collectors.counting()
        Map<String, Long> countByOrigin = null;

        assertNotNull(countByOrigin);
        assertEquals(4L, countByOrigin.get("MEX"));
        assertEquals(2L, countByOrigin.get("BOG"));
        assertEquals(1L, countByOrigin.get("MAD"));
        assertEquals(1L, countByOrigin.get("JFK"));
    }

    @Test
    @DisplayName("Pregunta 08 - Temperatura promedio por sensor")
    void test08_averageTemperaturePerSensor() {
        // Enunciado: Calcula la temperatura media registrada por cada sensor: Map<String, Double>.
        List<SensorReading> readings = DataMock.getSensorReadings();

        // TODO: Tu solución aquí usando groupingBy y averagingDouble(SensorReading::temperature)
        Map<String, Double> avgTempBySensor = null;

        assertNotNull(avgTempBySensor);
        assertEquals(26.33, avgTempBySensor.get("S1"), 0.05);
        assertEquals(3.75, avgTempBySensor.get("S2"), 0.05);
        assertEquals(26.0, avgTempBySensor.get("S3"), 0.05);
    }

    @Test
    @DisplayName("Pregunta 09 - Destinos únicos alcanzables por origen")
    void test09_uniqueDestinationsFromOrigin() {
        // Enunciado: Obtén el conjunto de destinos únicos a los que se puede volar desde cada ciudad de origen: Map<String, Set<String>>.
        List<Flight> flights = DataMock.getFlights();

        // TODO: Tu solución aquí usando groupingBy y mapping(Flight::destination, toSet())
        Map<String, Set<String>> destinationsByOrigin = null;

        assertNotNull(destinationsByOrigin);
        assertEquals(Set.of("MAD", "CUN", "JFK"), destinationsByOrigin.get("MEX"));
        assertEquals(Set.of("MIA", "MEX"), destinationsByOrigin.get("BOG"));
    }

    @Test
    @DisplayName("Pregunta 10 - Partición de estudiantes aprobados/reprobados extrayendo solo nombres")
    void test10_partitionStudentsPassedFailed() {
        // Enunciado: Particiona a los estudiantes según si su promedio es >= 70.0 (aprobado = true, reprobado = false),
        // pero almacenando únicamente la lista de sus nombres en cada partición.
        List<Student> students = DataMock.getStudents();

        // TODO: Tu solución aquí usando partitioningBy(..., mapping(Student::name, toList()))
        Map<Boolean, List<String>> passFailPartition = null;

        assertNotNull(passFailPartition);
        assertEquals(5, passFailPartition.get(true).size());
        assertTrue(passFailPartition.get(true).containsAll(List.of("Daniel", "Camila", "Mariana", "Lucas", "Valeria")));
        assertEquals(List.of("Roberto"), passFailPartition.get(false));
    }

    @Test
    @DisplayName("Pregunta 11 - Producto más costoso por categoría usando toMap con binary merge")
    void test11_mostExpensiveProductPerCategoryWithToMap() {
        // Enunciado: Mediante Collectors.toMap con función merge binaria, obtén el producto de precio más elevado por cada categoría: Map<String, Product>.
        List<Product> products = DataMock.getProducts();

        // TODO: Tu solución aquí usando toMap(Product::category, Function.identity(), BinaryOperator.maxBy(...))
        Map<String, Product> maxProductByCategory = null;

        assertNotNull(maxProductByCategory);
        assertEquals("Laptop Dell XPS", maxProductByCategory.get("Electronics").name());
        assertEquals("Escritorio Elevable", maxProductByCategory.get("Furniture").name());
        assertEquals("Zapatillas Running Nike", maxProductByCategory.get("Clothing").name());
        assertEquals("Cafetera Espresso", maxProductByCategory.get("Appliances").name());
    }

    @Test
    @DisplayName("Pregunta 12 - Duración total acumulada de vuelos en horas decimales con IntStream")
    void test12_totalFlightDurationInHours() {
        // Enunciado: Suma los minutos de duración de todos los vuelos usando mapToInt(Flight::durationMinutes)
        // y convierte el resultado a horas en punto flotante (minutosTotales / 60.0).
        List<Flight> flights = DataMock.getFlights();

        // TODO: Tu solución aquí
        double totalHours = 0.0;

        assertEquals(36.83, totalHours, 0.05); // 2210 minutos / 60.0 = 36.833 horas
    }

    @Test
    @DisplayName("Pregunta 13 - Estadísticas completas de temperatura con summaryStatistics")
    void test13_sensorTemperatureStatistics() {
        // Enunciado: Obtén las estadísticas numéricas resumen (conteo, suma, min, max, promedio) de las temperaturas de los sensores.
        List<SensorReading> readings = DataMock.getSensorReadings();

        // TODO: Tu solución aquí usando mapToDouble(SensorReading::temperature).summaryStatistics()
        DoubleSummaryStatistics stats = null;

        assertNotNull(stats);
        assertEquals(8L, stats.getCount());
        assertEquals(164.5, stats.getSum(), 0.01);
        assertEquals(3.5, stats.getMin(), 0.01);
        assertEquals(38.0, stats.getMax(), 0.01);
        assertEquals(20.56, stats.getAverage(), 0.05);
    }

    @Test
    @DisplayName("Pregunta 14 - Formateo con reduce: Nombres de empleados de Finance")
    void test14_reduceFormattedString() {
        // Enunciado: Filtra los empleados de "Finance", extrae sus nombres y únelos en un formato "[Nombre1 & Nombre2]" usando reduce.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí con filter, map y reduce((a, b) -> a + " & " + b)
        String formattedFinance = null;

        assertEquals("[Charlie Brown & Fiona Gallagher]", formattedFinance);
    }

    // Record auxiliar para pregunta 15
    public record TempExtremes(double min, double max) {}

    @Test
    @DisplayName("Pregunta 15 - Collectors.teeing: Temperaturas extrema mínima y máxima simultáneas")
    void test15_teeingMinMaxTemperature() {
        // Enunciado: Utiliza Collectors.teeing para obtener en una sola pasada sobre las lecturas la temperatura mínima y la máxima.
        List<SensorReading> readings = DataMock.getSensorReadings();

        // TODO: Tu solución aquí usando Collectors.teeing
        TempExtremes extremes = null;

        assertNotNull(extremes);
        assertEquals(3.5, extremes.min(), 0.01);
        assertEquals(38.0, extremes.max(), 0.01);
    }

    @Test
    @DisplayName("Pregunta 16 - Collectors.teeing: Precio promedio ponderado por asiento disponible en vuelos de MEX")
    void test16_teeingRevenuePotentialRatio() {
        // Enunciado: Para los vuelos que parten de "MEX", calcula el precio promedio ponderado por asiento:
        // sumatoria(precio * availableSeats) / sumatoria(availableSeats) usando Collectors.teeing.
        List<Flight> mexFlights = DataMock.getFlights().stream()
                .filter(f -> "MEX".equals(f.origin()))
                .toList();

        // TODO: Tu solución aquí con teeing
        Double weightedAveragePrice = null;

        assertNotNull(weightedAveragePrice);
        assertEquals(482.73, weightedAveragePrice, 0.05); // 21240.0 / 44 asientos = 482.727
    }

    @Test
    @DisplayName("Pregunta 17 - takeWhile: Monitoreo de sensor S3 hasta detectar anomalía")
    void test17_takeWhileBelowAnomalyThreshold() {
        // Enunciado: A partir de las lecturas del sensor "S3", toma los registros cronológicamente
        // SOLO HASTA que aparezca la primera lectura con temperatura >= 30.0 (inclusive no se toma) usando takeWhile.
        List<SensorReading> s3Readings = DataMock.getSensorReadings().stream()
                .filter(r -> "S3".equals(r.sensorId()))
                .toList();

        // TODO: Tu solución aquí usando takeWhile
        List<Double> normalTemps = null;

        assertEquals(List.of(19.0, 21.0), normalTemps);
    }

    @Test
    @DisplayName("Pregunta 18 - Stream.iterate infinito: Fechas consecutivas de salida")
    void test18_infiniteDateSequence() {
        // Enunciado: Genera una lista con 5 fechas consecutivas partiendo desde el 1 de Junio de 2025 usando Stream.iterate.
        LocalDate start = LocalDate.of(2025, 6, 1);

        // TODO: Tu solución aquí con Stream.iterate(start, d -> d.plusDays(1)).limit(5)
        List<LocalDate> next5Days = null;

        assertEquals(List.of(
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2025, 6, 2),
                LocalDate.of(2025, 6, 3),
                LocalDate.of(2025, 6, 4),
                LocalDate.of(2025, 6, 5)
        ), next5Days);
    }

    @Test
    @DisplayName("Pregunta 19 - Collectors.collectingAndThen: Vuelo de mayor duración formateado")
    void test19_collectingAndThenLongestFlight() {
        // Enunciado: Encuentra el vuelo con mayor duración (durationMinutes) y transforma directamente el resultado
        // a una cadena "CODIGO con MINUTOS min" (ej: "FL101 con 630 min") mediante Collectors.collectingAndThen.
        List<Flight> flights = DataMock.getFlights();

        // TODO: Tu solución aquí
        String longestFlightSummary = null;

        assertEquals("FL101 con 630 min", longestFlightSummary);
    }

    @Test
    @DisplayName("Pregunta 20 - Agrupación multinivel a 2 niveles: Órdenes por Año y por Estatus")
    void test20_multiLevelGroupingOrders() {
        // Enunciado: Agrupa las órdenes primero por año (Integer) y secundariamente por estatus (OrderStatus),
        // conteniendo en el nivel más interno la lista de IDs de las órdenes correspondientes.
        List<Order> orders = DataMock.getOrders();

        // TODO: Tu solución aquí usando groupingBy anidado con mapping(Order::id, toList())
        Map<Integer, Map<OrderStatus, List<Integer>>> ordersByYearAndStatus = null;

        assertNotNull(ordersByYearAndStatus);
        assertEquals(List.of(1001, 1002, 1006), ordersByYearAndStatus.get(2025).get(OrderStatus.DELIVERED));
        assertEquals(List.of(1003), ordersByYearAndStatus.get(2025).get(OrderStatus.SHIPPED));
        assertEquals(List.of(1004), ordersByYearAndStatus.get(2025).get(OrderStatus.PENDING));
        assertEquals(List.of(1005), ordersByYearAndStatus.get(2025).get(OrderStatus.CANCELLED));
    }

    // Record auxiliar para pregunta 21
    public record WeightedItem(double value, double weight) {}

    @Test
    @DisplayName("Pregunta 21 - Custom Collector con Collector.of: Cálculo de Media Ponderada")
    void test21_customWeightedAverageCollector() {
        // Enunciado: Implementa un Collector personalizado usando Collector.of(...) que calcule la media ponderada
        // sum(value * weight) / sum(weight) de una lista de elementos WeightedItem.
        List<WeightedItem> items = List.of(
                new WeightedItem(90.0, 2.0),
                new WeightedItem(80.0, 3.0),
                new WeightedItem(100.0, 5.0)
        );

        // TODO: Define el Collector personalizado aquí
        Collector<WeightedItem, double[], Double> weightedAverageCollector = null;

        Double result = items.stream().collect(weightedAverageCollector);
        assertNotNull(result);
        assertEquals(92.0, result, 0.01);
    }

    @Test
    @DisplayName("Pregunta 22 - Custom Collector con Collector.of: Frecuencia normalizada de palabras")
    void test22_customWordFrequencyNormalizer() {
        // Enunciado: Implementa un Collector personalizado con Collector.of(...) que reciba palabras,
        // las normalice a minúsculas y construya un Map<String, Integer> de frecuencias.
        List<String> rawWords = List.of("Java", "STREAM", "java", "Stream", "JAVA", "code");

        // TODO: Define el Collector de frecuencia normalizada aquí
        Collector<String, Map<String, Integer>, Map<String, Integer>> normalizedFrequencyCollector = null;

        Map<String, Integer> freqs = rawWords.stream().collect(normalizedFrequencyCollector);
        assertNotNull(freqs);
        assertEquals(3, freqs.get("java"));
        assertEquals(2, freqs.get("stream"));
        assertEquals(1, freqs.get("code"));
    }

    @Test
    @DisplayName("Pregunta 23 - Detección de lecturas anómalas alejadas de la media general")
    void test23_filterTemperatureOutliers() {
        // Enunciado: Calcula la media global de temperatura de todos los sensores y filtra aquellas lecturas
        // cuya temperatura diste en más de 10.0 grados de la media global (|temp - media| > 10.0).
        List<SensorReading> readings = DataMock.getSensorReadings();

        // TODO: Tu solución aquí calculando media primero y luego filtrando
        List<SensorReading> outliers = null;

        assertNotNull(outliers);
        assertEquals(3, outliers.size());
        List<Double> outlierTemps = outliers.stream().map(SensorReading::temperature).toList();
        assertTrue(outlierTemps.containsAll(List.of(4.0, 3.5, 38.0)));
    }

    @Test
    @DisplayName("Pregunta 24 - Algoritmo Top-K: Cliente con mayor cantidad de órdenes")
    void test24_topKCustomersByOrderCount() {
        // Enunciado: Encuentra el nombre del cliente que ha realizado la mayor cantidad de órdenes.
        List<Order> orders = DataMock.getOrders();

        // TODO: Tu solución aquí agrupando por customerName con counting(), ordenando entradas y tomando la primera
        String topCustomer = null;

        assertEquals("Carlos Gomez", topCustomer); // Carlos Gomez tiene 2 órdenes (1001, 1005)
    }

    @Test
    @DisplayName("Pregunta 25 - Traza de una matriz cuadrada con IntStream")
    void test25_traceOfSquareMatrix() {
        // Enunciado: Calcula la traza de la siguiente matriz cuadrada 3x3 (suma de los elementos en la diagonal principal: matriz[i][i]).
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // TODO: Tu solución aquí usando IntStream.range(0, matrix.length).map(i -> matrix[i][i]).sum()
        int trace = 0;

        assertEquals(15, trace); // 1 + 5 + 9 = 15
    }

    @Test
    @DisplayName("Pregunta 26 - Aplanar heterogéneo con Optionals y valores nulos seguros")
    void test26_flattenHeterogeneousOptionals() {
        // Enunciado: A partir de una lista que contiene Optionals y elementos nulos, extrae únicamente los valores presentes en MAYÚSCULAS.
        List<Optional<String>> rawList = Arrays.asList(
                Optional.of("spring"),
                null,
                Optional.empty(),
                Optional.of("docker"),
                null,
                Optional.of("kubernetes")
        );

        // TODO: Tu solución aquí filtrando no nulos y aplanando Optional::stream
        List<String> validUpperTokens = null;

        assertEquals(List.of("SPRING", "DOCKER", "KUBERNETES"), validUpperTokens);
    }

    @Test
    @DisplayName("Pregunta 27 - Procesamiento paralelo con parallelStream para lecturas de alta humedad")
    void test27_parallelCountHighHumidity() {
        // Enunciado: Cuenta de forma concurrente cuántas lecturas de sensores tienen una humedad relativa >= 60.0% usando parallelStream().
        List<SensorReading> readings = DataMock.getSensorReadings();

        // TODO: Tu solución aquí con readings.parallelStream().filter(...).count()
        long highHumidityCount = 0;

        assertEquals(4L, highHumidityCount); // 65.0, 62.0, 80.0, 82.0
    }

    @Test
    @DisplayName("Pregunta 28 - Ventana de diferencias adyacentes: Variación térmica consecutiva")
    void test28_sensorConsecutiveDifferences() {
        // Enunciado: Para las lecturas del sensor "S1", calcula las diferencias térmicas consecutivas (temp[i+1] - temp[i]) usando IntStream.
        List<SensorReading> s1Readings = DataMock.getSensorReadings().stream()
                .filter(r -> "S1".equals(r.sensorId()))
                .toList();

        // TODO: Tu solución aquí usando IntStream.range(0, s1Readings.size() - 1)
        List<Double> deltaTemps = null;

        assertNotNull(deltaTemps);
        assertEquals(2, deltaTemps.size());
        assertEquals(1.5, deltaTemps.get(0), 0.01); // 26.0 - 24.5
        assertEquals(2.5, deltaTemps.get(1), 0.01); // 28.5 - 26.0
    }

    @Test
    @DisplayName("Pregunta 29 - Procesamiento asíncrono con CompletableFuture y Streams")
    void test29_asyncFlightSeatValidation() {
        // Enunciado: A partir de los vuelos provistos, simula una validación asíncrona de disponibilidad que devuelva:
        // "VUELO: DISPONIBLE" si tiene asientos > 0, o "VUELO: AGOTADO" si no tiene.
        // Procesa concurrentemente con CompletableFuture.supplyAsync(...) y recolecta con join().
        List<Flight> sampleFlights = List.of(
                new Flight("F1", "A", "B", LocalDateTime.now(), 60, 100.0, 5),
                new Flight("F2", "A", "C", LocalDateTime.now(), 60, 100.0, 0),
                new Flight("F3", "B", "C", LocalDateTime.now(), 60, 100.0, 10)
        );

        // TODO: Tu solución aquí mapeando a CompletableFuture y esperando resultados
        List<String> availabilityStatuses = null;

        assertEquals(List.of("F1: DISPONIBLE", "F2: AGOTADO", "F3: DISPONIBLE"), availabilityStatuses);
    }

    // Record para el Gran Desafío Final (Pregunta 30)
    public record DepartmentAudit(
            long employeeCount,
            double totalPayroll,
            double averageSalary,
            List<String> uniqueSkillsSorted,
            String highestPaidEmployee
    ) {}

    @Test
    @DisplayName("Pregunta 30 - Gran Desafío Final: Reporte Ejecutivo Multidimensional de Auditoría")
    void test30_comprehensiveDepartmentAuditReport() {
        // Enunciado: Construye un reporte ejecutivo por departamento Map<String, DepartmentAudit> que calcule:
        // 1. Cantidad de empleados en el departamento.
        // 2. Masa salarial total (suma de salarios).
        // 3. Salario promedio del departamento.
        // 4. Lista de habilidades únicas del departamento ordenadas alfabéticamente.
        // 5. Nombre del empleado con el salario más alto del departamento.
        List<Employee> employees = DataMock.getEmployees();

        // TODO: Tu solución aquí agrupando y ensamblando cada DepartmentAudit
        Map<String, DepartmentAudit> auditReport = null;

        assertNotNull(auditReport);
        assertEquals(4, auditReport.size());

        // Verificación exhaustiva del departamento IT:
        DepartmentAudit itAudit = auditReport.get("IT");
        assertNotNull(itAudit);
        assertEquals(4L, itAudit.employeeCount());
        assertEquals(348000.0, itAudit.totalPayroll(), 0.01);
        assertEquals(87000.0, itAudit.averageSalary(), 0.01);
        assertEquals("Ian Malcolm", itAudit.highestPaidEmployee());
        assertEquals(List.of(
                "AWS", "Architecture", "Cloud", "Docker", "Go", "Java",
                "JavaScript", "Kubernetes", "Node", "Python", "React", "Spring"
        ), itAudit.uniqueSkillsSorted());

        // Verificación del departamento HR:
        DepartmentAudit hrAudit = auditReport.get("HR");
        assertNotNull(hrAudit);
        assertEquals(2L, hrAudit.employeeCount());
        assertEquals(104000.0, hrAudit.totalPayroll(), 0.01);
        assertEquals(52000.0, hrAudit.averageSalary(), 0.01);
        assertEquals("Hannah Abbott", hrAudit.highestPaidEmployee());
        assertEquals(List.of("Communication", "Payroll", "Recruiting"), hrAudit.uniqueSkillsSorted());
    }
}
