# Solucionario Completo de Ejercicios de Java Streams

Este documento contiene las soluciones de referencia para los 90 ejercicios repartidos en los 3 niveles: Fácil, Intermedio y Avanzado.

---

## Nivel Fácil (`EasyStreamExercisesTest.java`)

```java
// 01 - Filtrar números pares
List<Integer> evens = numbers.stream()
        .filter(n -> n % 2 == 0)
        .toList();

// 02 - Filtrar palabras de longitud mayor a 5
List<String> result = words.stream()
        .filter(w -> w.length() > 5)
        .toList();

// 03 - Filtrar personas mayores o iguales a 30 años
List<Person> result = persons.stream()
        .filter(p -> p.age() >= 30)
        .toList();

// 04 - Filtrar empleados de IT
List<Employee> itEmployees = employees.stream()
        .filter(e -> "IT".equalsIgnoreCase(e.department()))
        .toList();

// 05 - Filtrar productos con stock bajo (< 15)
List<Product> lowStock = products.stream()
        .filter(p -> p.stock() < 15)
        .toList();

// 06 - Filtrar palabras que comiencen con 'j' o 'J'
List<String> result = words.stream()
        .filter(w -> w.toLowerCase().startsWith("j"))
        .toList();

// 07 - Transformar palabras a MAYÚSCULAS
List<String> upper = words.stream()
        .map(String::toUpperCase)
        .toList();

// 08 - Extraer nombres de personas
List<String> names = persons.stream()
        .map(Person::name)
        .toList();

// 09 - Obtener longitud de cada palabra
List<Integer> lengths = words.stream()
        .map(String::length)
        .toList();

// 10 - Calcular el cuadrado de cada número
List<Integer> squares = numbers.stream()
        .map(n -> n * n)
        .toList();

// 11 - Extraer correos electrónicos
List<String> emails = persons.stream()
        .map(Person::email)
        .toList();

// 12 - Eliminar números duplicados
List<Integer> distincts = numbersWithDuplicates.stream()
        .distinct()
        .toList();

// 13 - Obtener categorías únicas de productos
List<String> categories = products.stream()
        .map(Product::category)
        .distinct()
        .toList();

// 14 - Ordenar palabras en orden alfabético natural
List<String> sortedFruits = fruits.stream()
        .sorted()
        .toList();

// 15 - Ordenar números de menor a mayor
List<Integer> sortedNumbers = numbers.stream()
        .sorted()
        .toList();

// 16 - Ordenar números de mayor a menor
List<Integer> descNumbers = numbers.stream()
        .sorted(Comparator.reverseOrder())
        .toList();

// 17 - Ordenar personas por edad de menor a mayor
List<Person> sortedPersons = persons.stream()
        .sorted(Comparator.comparingInt(Person::age))
        .toList();

// 18 - Tomar los primeros 3 elementos (limit)
List<Integer> firstThree = numbers.stream()
        .limit(3)
        .toList();

// 19 - Omitir los primeros 12 elementos (skip)
List<Integer> remaining = numbers.stream()
        .skip(12)
        .toList();

// 20 - Paginación simple: página 2 con tamaño 3
List<String> page2 = items.stream()
        .skip(3)
        .limit(3)
        .toList();

// 21 - Contar empleados con salario superior a 70,000
long count = employees.stream()
        .filter(e -> e.salary() > 70000.0)
        .count();

// 22 - Contar palabras que contienen la letra 'a'
long count = words.stream()
        .filter(w -> w.contains("a"))
        .count();

// 23 - Encontrar el primer producto con precio mayor a 1,000
Optional<Product> expensiveProduct = products.stream()
        .filter(p -> p.price() > 1000.0)
        .findFirst();

// 24 - Encontrar cualquier empleado del departamento 'Finance'
Optional<Employee> financeEmp = employees.stream()
        .filter(e -> "Finance".equals(e.department()))
        .findAny();

// 25 - Verificar si hay alguna persona menor de edad (anyMatch)
boolean hasMinors = persons.stream()
        .anyMatch(p -> p.age() < 18);

// 26 - Verificar si todos los productos tienen stock (allMatch)
boolean allInStock = products.stream()
        .allMatch(p -> p.stock() > 0);

// 27 - Verificar que ningún empleado tenga salario negativo (noneMatch)
boolean noneNegative = employees.stream()
        .noneMatch(e -> e.salary() < 0);

// 28 - Sumar todos los números usando reduce
int sum = numbers.stream()
        .reduce(0, Integer::sum);

// 29 - Concatenar palabras separadas por coma usando joining
String joined = tech.stream()
        .collect(Collectors.joining(", "));

// 30 - Sumar números del 1 al 100 usando IntStream
int sum = IntStream.rangeClosed(1, 100).sum();

// 31 - Crear un stream a partir de elementos con Stream.of
List<String> result = Stream.of("Alpha", "Beta", "Gamma").toList();

// 32 - Verificar un flujo vacío con Stream.empty
long count = Stream.empty().count();

// 33 - Obtener la edad máxima entre personas con mapToInt y max
int maxAge = persons.stream()
        .mapToInt(Person::age)
        .max()
        .orElse(0);

// 34 - Obtener la edad mínima entre personas con mapToInt y min
int minAge = persons.stream()
        .mapToInt(Person::age)
        .min()
        .orElse(0);

// 35 - Convertir un arreglo primitivo int[] a List<Integer> usando Arrays.stream y boxed
List<Integer> boxedList = Arrays.stream(primitiveArray)
        .boxed()
        .toList();

// 36 - Filtrar elementos no nulos usando Objects::nonNull
List<String> nonNullList = listWithNulls.stream()
        .filter(Objects::nonNull)
        .toList();

// 37 - Encontrar elemento con valor por defecto mediante orElse
String foundName = persons.stream()
        .map(Person::name)
        .filter(name -> name.startsWith("Z"))
        .findFirst()
        .orElse("No encontrado");

// 38 - Buscar por ID y lanzar excepción si no existe con orElseThrow
String productName = products.stream()
        .filter(p -> p.id() == 1)
        .map(Product::name)
        .findFirst()
        .orElseThrow();

// 39 - Mapear números a booleanos indicando si superan un umbral
List<Boolean> flags = numbers.stream()
        .map(n -> n > 10)
        .toList();

// 40 - Calcular promedio de notas usando IntStream.of
double avg = IntStream.of(80, 90, 70, 100)
        .average()
        .orElse(0.0);

// 41 - Contar elementos generados con IntStream.range exclusivo
long count = IntStream.range(1, 10).count();

// 42 - Concatenar dos streams con Stream.concat
List<String> combined = Stream.concat(stream1, stream2).toList();

// 43 - Contar palabras únicas con distinct y count
long uniqueCount = words.stream()
        .distinct()
        .count();

// 44 - Ordenar palabras por longitud de menor a mayor
List<String> sortedByLength = words.stream()
        .sorted(Comparator.comparingInt(String::length))
        .toList();

// 45 - Filtrado en cascada con múltiples filter consecutivos
List<Integer> filtered = numbers.stream()
        .filter(n -> n > 0)
        .filter(n -> n < 10)
        .toList();

// 46 - Mapeos consecutivos encadenados
List<String> transformed = fruits.stream()
        .map(String::toLowerCase)
        .map(s -> "fruta_" + s)
        .toList();

// 47 - Multiplicación acumulada con reduce sin valor identidad inicial
Optional<Integer> product = factors.stream()
        .reduce((a, b) -> a * b);

// 48 - Verificar sufijo de palabras con anyMatch
boolean hasGerund = verbs.stream()
        .anyMatch(v -> v.endsWith("ing"));

// 49 - Validar edad mínima general con allMatch
boolean allAbove15 = persons.stream()
        .allMatch(p -> p.age() >= 15);

// 50 - Recolectar nombres de departamentos únicos en un Set con Collectors.toSet
Set<String> departments = employees.stream()
        .map(Employee::department)
        .collect(Collectors.toSet());
```

---

## Nivel Intermedio (`IntermediateStreamExercisesTest.java`)

```java
// 01 - Aplanar una lista de listas de enteros
List<Integer> flatList = nestedList.stream()
        .flatMap(List::stream)
        .toList();

// 02 - Obtener todos los hobbies únicos ordenados alfabéticamente
List<String> hobbies = persons.stream()
        .flatMap(p -> p.hobbies().stream())
        .distinct()
        .sorted()
        .toList();

// 03 - Extraer todas las habilidades únicas de los empleados de IT
Set<String> itSkills = employees.stream()
        .filter(e -> "IT".equals(e.department()))
        .flatMap(e -> e.skills().stream())
        .collect(Collectors.toSet());

// 04 - Nombres de productos comprados en todas las órdenes
List<String> purchasedProducts = orders.stream()
        .flatMap(o -> o.items().stream())
        .map(item -> item.product().name())
        .distinct()
        .toList();

// 05 - Contar palabras únicas a partir de oraciones
long uniqueCount = sentences.stream()
        .flatMap(s -> Arrays.stream(s.split("\\s+")))
        .map(String::toLowerCase)
        .distinct()
        .count();

// 06 - Agrupar empleados por departamento
Map<String, List<Employee>> byDept = employees.stream()
        .collect(Collectors.groupingBy(Employee::department));

// 07 - Agrupar productos por categoría
Map<String, List<Product>> byCategory = products.stream()
        .collect(Collectors.groupingBy(Product::category));

// 08 - Contar cantidad de empleados por departamento
Map<String, Long> countByDept = employees.stream()
        .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));

// 09 - Salario promedio por departamento
Map<String, Double> avgSalaryByDept = employees.stream()
        .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));

// 10 - Nombres de empleados por departamento
Map<String, List<String>> namesByDept = employees.stream()
        .collect(Collectors.groupingBy(Employee::department, Collectors.mapping(Employee::name, Collectors.toList())));

// 11 - Particionar números en pares e impares
Map<Boolean, List<Integer>> partitioned = numbers.stream()
        .collect(Collectors.partitioningBy(n -> n % 2 == 0));

// 12 - Particionar empleados por salario mayor a 65,000
Map<Boolean, List<Employee>> highEarnersPartition = employees.stream()
        .collect(Collectors.partitioningBy(e -> e.salary() > 65000.0));

// 13 - Crear mapa de producto por ID
Map<Integer, Product> productMap = products.stream()
        .collect(Collectors.toMap(Product::id, Function.identity()));

// 14 - Stock total acumulado por categoría resolviendo colisiones
Map<String, Integer> stockByCategory = products.stream()
        .collect(Collectors.toMap(Product::category, Product::stock, Integer::sum));

// 15 - Mapa de nombre de empleado a su salario
Map<String, Double> salaryMap = employees.stream()
        .collect(Collectors.toMap(Employee::name, Employee::salary));

// 16 - Ordenar empleados por departamento y luego por salario descendente
List<Employee> sorted = employees.stream()
        .sorted(Comparator.comparing(Employee::department)
                .thenComparing(Comparator.comparingDouble(Employee::salary).reversed()))
        .toList();

// 17 - Ordenar productos por precio ascendente y ante empate por nombre
List<Product> sorted = items.stream()
        .sorted(Comparator.comparingDouble(Product::price)
                .thenComparing(Product::name))
        .toList();

// 18 - Calcular el valor total del inventario (precio * stock)
double totalValue = products.stream()
        .mapToDouble(p -> p.price() * p.stock())
        .sum();

// 19 - Calcular la edad promedio de las personas
double averageAge = persons.stream()
        .mapToInt(Person::age)
        .average()
        .orElse(0.0);

// 20 - Estadísticas resumen de números (IntSummaryStatistics)
IntSummaryStatistics stats = numbers.stream()
        .mapToInt(Integer::intValue)
        .summaryStatistics();

// 21 - Encontrar el producto más caro
Optional<Product> topProduct = products.stream()
        .max(Comparator.comparingDouble(Product::price));

// 22 - Empleado más veterano (menor joiningYear)
Optional<Employee> veteran = employees.stream()
        .min(Comparator.comparingInt(Employee::joiningYear));

// 23 - Formatear nombres de departamentos con prefijo y sufijo
String result = products.stream()
        .map(Product::category)
        .distinct()
        .collect(Collectors.joining(" | ", "[", "]"));

// 24 - Filtrar transacciones en USD con monto mayor a 500 y tipo DEPOSIT
List<Transaction> filtered = transactions.stream()
        .filter(t -> "USD".equals(t.currency()) && t.amount() > 500.0 && t.type() == TransactionType.DEPOSIT)
        .toList();

// 25 - Filtrar transacciones de Febrero 2025
List<Transaction> febTransactions = transactions.stream()
        .filter(t -> t.date().getYear() == 2025 && t.date().getMonth() == Month.FEBRUARY)
        .toList();

// 26 - Ordenar lista con valores nulos colocándolos al final (nullsLast)
List<String> sorted = listWithNulls.stream()
        .sorted(Comparator.nullsLast(Comparator.naturalOrder()))
        .toList();

// 27 - Utilizar peek para acumular logs de elementos filtrados
List<Integer> doubledEvens = numbers.stream()
        .filter(n -> n % 2 == 0)
        .peek(inspected::add)
        .map(n -> n * 2)
        .toList();

// 28 - Obtener directamente el nombre del empleado mejor pagado
String topEarnerName = employees.stream()
        .collect(Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingDouble(Employee::salary)),
                opt -> opt.map(Employee::name).orElse("")
        ));

// 29 - Monto total acumulado por tipo de transacción
Map<TransactionType, Double> totalsByType = transactions.stream()
        .collect(Collectors.groupingBy(Transaction::type, Collectors.summingDouble(Transaction::amount)));

// 30 - Estudiantes con promedio >= 85 ordenados descendente
List<String> topStudentNames = students.stream()
        .filter(s -> s.getAverageGrade() >= 85.0)
        .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
        .map(Student::name)
        .toList();

// 31 - Estadísticas resumidas de salarios con Collectors.summarizingDouble
DoubleSummaryStatistics stats = employees.stream()
        .collect(Collectors.summarizingDouble(Employee::salary));

// 32 - Recolectar a lista inmodificable con Collectors.collectingAndThen
List<String> unmodifiableNames = persons.stream()
        .map(Person::name)
        .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

// 33 - Agrupar nombres de empleados por departamento en un Set
Map<String, Set<String>> namesByDeptSet = employees.stream()
        .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.mapping(Employee::name, Collectors.toSet())
        ));

// 34 - Agrupar empleados en un TreeMap ordenado alfabéticamente por clave
Map<String, List<Employee>> sortedDeptMap = employees.stream()
        .collect(Collectors.groupingBy(
                Employee::department,
                TreeMap::new,
                Collectors.toList()
        ));

// 35 - Particionar empleados por salario > 70000 y contar la cantidad en cada grupo
Map<Boolean, Long> countPartition = employees.stream()
        .collect(Collectors.partitioningBy(
                e -> e.salary() > 70000.0,
                Collectors.counting()
        ));

// 36 - Particionar productos por precio > 100 y obtener el precio promedio en cada partición
Map<Boolean, Double> avgPricePartition = products.stream()
        .collect(Collectors.partitioningBy(
                p -> p.price() > 100.0,
                Collectors.averagingDouble(Product::price)
        ));

// 37 - Agrupar por departamento y unir nombres con comas
Map<String, String> namesSeparatedByComma = employees.stream()
        .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.mapping(Employee::name, Collectors.joining(", "))
        ));

// 38 - Convertir a LinkedHashMap preservando el orden exacto de inserción
Map<String, Double> orderedMap = products.stream()
        .collect(Collectors.toMap(
                Product::name,
                Product::price,
                (a, b) -> a,
                LinkedHashMap::new
        ));

// 39 - Aplanar todos los valores de un Map<String, List<String>> en una lista ordenada
List<String> flatSorted = dict.values().stream()
        .flatMap(List::stream)
        .sorted()
        .toList();

// 40 - Contar vocales en una cadena usando chars()
long vowelCount = text.toLowerCase().chars()
        .filter(c -> "aeiou".indexOf(c) != -1)
        .count();

// 41 - Calcular el factorial de un número con LongStream.rangeClosed
long factorial = LongStream.rangeClosed(1, n)
        .reduce(1L, (a, b) -> a * b);

// 42 - Ordenar con valores nulos posicionados al principio con nullsFirst
List<String> sorted = listWithNulls.stream()
        .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
        .toList();

// 43 - Ordenar transacciones por fecha ascendente y ante empate por monto descendente
List<Transaction> sortedTxs = txs.stream()
        .sorted(Comparator.comparing(Transaction::date)
                .thenComparing(Comparator.comparingDouble(Transaction::amount).reversed()))
        .toList();

// 44 - Construir un Stream programáticamente con Stream.builder()
List<String> builtList = Stream.<String>builder()
        .add("uno")
        .add("dos")
        .add("tres")
        .build()
        .toList();

// 45 - Filtrar órdenes DELIVERED en un rango de fechas
List<Order> janOrders = orders.stream()
        .filter(o -> o.status() == OrderStatus.DELIVERED)
        .filter(o -> !o.orderDate().isBefore(start) && !o.orderDate().isAfter(end))
        .toList();

// 46 - Monto total acumulado de compras por cliente
Map<String, Double> salesByCustomer = orders.stream()
        .collect(Collectors.groupingBy(
                Order::customerName,
                Collectors.summingDouble(Order::getTotalAmount)
        ));

// 47 - Encontrar el producto más caro por categoría
Map<String, Optional<Product>> maxByCategory = products.stream()
        .collect(Collectors.groupingBy(
                Product::category,
                Collectors.maxBy(Comparator.comparingDouble(Product::price))
        ));

// 48 - Encontrar el producto con menor stock por categoría
Map<String, Optional<Product>> minStockByCategory = products.stream()
        .collect(Collectors.groupingBy(
                Product::category,
                Collectors.minBy(Comparator.comparingInt(Product::stock))
        ));

// 49 - Transformar claves y valores de un Map mediante Streams
Map<Integer, String> transformedMap = input.entrySet().stream()
        .collect(Collectors.toMap(
                e -> e.getKey() + 100,
                e -> e.getValue().toUpperCase()
        ));

// 50 - Filtrar empleados de IT y recolectar a ConcurrentMap
ConcurrentMap<String, Double> itSalaries = employees.stream()
        .filter(e -> "IT".equals(e.department()))
        .collect(Collectors.toConcurrentMap(
                Employee::name,
                Employee::salary
        ));
```

---

## Nivel Avanzado (`AdvancedStreamExercisesTest.java`)

```java
// 01 - Collectors.teeing: Salario mínimo y máximo
MinMaxSalary minMax = employees.stream()
        .collect(Collectors.teeing(
                Collectors.minBy(Comparator.comparingDouble(Employee::salary)),
                Collectors.maxBy(Comparator.comparingDouble(Employee::salary)),
                (min, max) -> new MinMaxSalary(min.get().salary(), max.get().salary())
        ));

// 02 - Collectors.teeing: Suma, Conteo y Promedio
Summary summary = numbers.stream()
        .collect(Collectors.teeing(
                Collectors.counting(),
                Collectors.summingDouble(Integer::doubleValue),
                (count, sum) -> new Summary(count, sum, sum / count)
        ));

// 03 - takeWhile: Tomar mientras sea menor a 30
List<Integer> result = sortedNumbers.stream()
        .takeWhile(n -> n < 30)
        .toList();

// 04 - dropWhile: Descartar mientras sea menor a 30
List<Integer> result = sortedNumbers.stream()
        .dropWhile(n -> n < 30)
        .toList();

// 05 - Stream.iterate: Potencias de 2 menores a 1000
List<Integer> powers = Stream.iterate(1, n -> n < 1000, n -> n * 2)
        .toList();

// 06 - Stream.iterate: Primeros 10 números de Fibonacci
List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
        .limit(10)
        .map(f -> f[0])
        .toList();

// 07 - Custom Collector: Invertir el orden de una lista
Collector<String, List<String>, List<String>> reverseCollector = Collector.of(
        ArrayList::new,
        (list, item) -> list.add(0, item),
        (left, right) -> { right.addAll(left); return right; }
);

// 08 - Custom Collector: Mapa de frecuencias manual
Collector<String, Map<String, Integer>, Map<String, Integer>> frequencyCollector = Collector.of(
        HashMap::new,
        (map, item) -> map.merge(item, 1, Integer::sum),
        (m1, m2) -> { m2.forEach((k, v) -> m1.merge(k, v, Integer::sum)); return m1; }
);

// 09 - Collectors.flatMapping: Agrupar por dpto y reunir skills en un Set
Map<String, Set<String>> skillsByDept = employees.stream()
        .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.flatMapping(e -> e.skills().stream(), Collectors.toSet())
        ));

// 10 - Collectors.filtering: Agrupar productos caros (> 100) por categoría
Map<String, List<Product>> expensiveByCategory = products.stream()
        .collect(Collectors.groupingBy(
                Product::category,
                Collectors.filtering(p -> p.price() > 100.0, Collectors.toList())
        ));

// 11 - Agrupación multinivel: Transacciones por Moneda y luego por Tipo
Map<String, Map<TransactionType, List<Transaction>>> multiGroup = transactions.stream()
        .collect(Collectors.groupingBy(
                Transaction::currency,
                Collectors.groupingBy(Transaction::type)
        ));

// 12 - Agrupación multinivel con agregación: Monto total por Moneda y Tipo
Map<String, Map<TransactionType, Double>> totalAmounts = transactions.stream()
        .collect(Collectors.groupingBy(
                Transaction::currency,
                Collectors.groupingBy(
                        Transaction::type,
                        Collectors.summingDouble(Transaction::amount)
                )
        ));

// 13 - Top K elementos más frecuentes
List<String> top2 = words.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .limit(2)
        .map(Map.Entry::getKey)
        .toList();

// 14 - Agrupación de Anagramas
Map<String, List<String>> anagramGroups = words.stream()
        .collect(Collectors.groupingBy(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));

// 15 - Transposición de una matriz (filas por columnas)
int rows = matrix.size();
int cols = matrix.get(0).size();
List<List<Integer>> transposed = IntStream.range(0, cols)
        .mapToObj(col -> IntStream.range(0, rows)
                .mapToObj(row -> matrix.get(row).get(col))
                .toList())
        .toList();

// 16 - Producto Cartesiano de dos listas
List<String> cartesian = colors.stream()
        .flatMap(c -> sizes.stream().map(s -> c + "-" + s))
        .toList();

// 17 - Identificar todos los elementos duplicados de una lista
Set<Integer> duplicates = numbers.stream()
        .filter(n -> !seen.add(n))
        .collect(Collectors.toSet());

// 18 - Aplanar lista de Optionals usando Optional.stream
List<String> presentValues = optionals.stream()
        .flatMap(Optional::stream)
        .toList();

// 19 - Empleado con salario más alto por cada departamento
Map<String, Employee> topEarners = employees.stream()
        .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::salary)),
                        Optional::get
                )
        ));

// 20 - Dividir una lista en fragmentos (chunks) de tamaño fijo
List<List<String>> chunks = IntStream.range(0, (items.size() + chunkSize - 1) / chunkSize)
        .mapToObj(i -> items.subList(i * chunkSize, Math.min((i + 1) * chunkSize, items.size())))
        .toList();

// 21 - Calcular el producto punto (dot product) de dos vectores
int dotProduct = IntStream.range(0, vectorA.length)
        .map(i -> vectorA[i] * vectorB[i])
        .sum();

// 22 - Obtener el segundo valor más alto de una lista
Optional<Integer> secondHighest = numbers.stream()
        .distinct()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst();

// 23 - Agrupación por rangos de edad (Bucketing)
Map<String, List<Person>> byAgeBucket = persons.stream()
        .collect(Collectors.groupingBy(p -> {
            if (p.age() < 25) return "Joven";
            if (p.age() <= 35) return "Adulto";
            return "Senior";
        }));

// 24 - Conteo concurrente seguro con parallelStream y toConcurrentMap
ConcurrentMap<String, Integer> counts = words.parallelStream()
        .collect(Collectors.toConcurrentMap(
                Function.identity(),
                w -> 1,
                Integer::sum
        ));

// 25 - Encontrar pares de elementos adyacentes crecientes
List<String> increasingPairs = IntStream.range(0, series.size() - 1)
        .filter(i -> series.get(i + 1) > series.get(i))
        .mapToObj(i -> series.get(i) + "->" + series.get(i + 1))
        .toList();

// 26 - Intersección de múltiples listas con reduce
Set<Integer> intersection = listOfLists.stream()
        .map(HashSet::new)
        .reduce((s1, s2) -> {
            s1.retainAll(s2);
            return s1;
        })
        .orElse(new HashSet<>());

// 27 - Aplanar estructura de árbol recursiva
Function<CategoryNode, Stream<String>> flattenNode = new Function<>() {
    @Override
    public Stream<String> apply(CategoryNode node) {
        return Stream.concat(
                Stream.of(node.name()),
                node.subcategories().stream().flatMap(this)
        );
    }
};

// 28 - Valoración de inventario por categoría en orden descendente
Map<String, Double> sortedValuation = products.stream()
        .collect(Collectors.groupingBy(
                Product::category,
                Collectors.summingDouble(p -> p.price() * p.stock())
        ))
        .entrySet().stream()
        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldVal, newVal) -> oldVal,
                LinkedHashMap::new
        ));

// 29 - Conteo cruzado: Personas por Rango de Edad y Género
Map<Gender, Map<Boolean, Long>> crossTab = persons.stream()
        .collect(Collectors.groupingBy(
                Person::gender,
                Collectors.groupingBy(
                        p -> p.age() >= 30,
                        Collectors.counting()
                )
        ));

// 30 - Clientes frecuentes con gasto total superior a 1000 en órdenes entregadas
Map<String, Double> vipCustomers = orders.stream()
        .filter(o -> o.status() == OrderStatus.DELIVERED)
        .collect(Collectors.groupingBy(
                Order::customerName,
                Collectors.summingDouble(Order::getTotalAmount)
        ))
        .entrySet().stream()
        .filter(e -> e.getValue() > 1000.0)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

// 31 - Stream.iterate infinito y takeWhile: Generar números primos menores a 30
List<Integer> primes = Stream.iterate(2, n -> n + 1)
        .filter(isPrime)
        .takeWhile(p -> p < 30)
        .toList();

// 32 - Custom Collector con Collector.of: Calcular la mediana de una lista impar
Collector<Integer, List<Integer>, Double> medianCollector = Collector.of(
        ArrayList::new,
        List::add,
        (l1, l2) -> { l1.addAll(l2); return l1; },
        list -> {
            Collections.sort(list);
            return (double) list.get(list.size() / 2);
        }
);

// 33 - Custom Collector con Collector.of: Ventana deslizante (Sliding Window) de pares
Collector<String, List<String>, List<String>> windowCollector = Collector.of(
        ArrayList::new,
        List::add,
        (l1, l2) -> { l1.addAll(l2); return l1; },
        list -> IntStream.range(0, list.size() - 1)
                .mapToObj(i -> list.get(i) + "-" + list.get(i + 1))
                .toList()
);

// 34 - Collectors.teeing: Porcentaje de la masa salarial correspondiente a IT
Double itPercentage = employees.stream()
        .collect(Collectors.teeing(
                Collectors.filtering(e -> "IT".equals(e.department()), Collectors.summingDouble(Employee::salary)),
                Collectors.summingDouble(Employee::salary),
                (itTotal, total) -> (itTotal / total) * 100.0
        ));

// 35 - Collectors.teeing: Obtener primer y último elemento en un solo pase
FirstLast<String> result = elements.stream()
        .collect(Collectors.teeing(
                Collectors.reducing((a, b) -> a),
                Collectors.reducing((a, b) -> b),
                (first, last) -> new FirstLast<>(first.orElse(null), last.orElse(null))
        ));

// 36 - Tabla dinámica (Pivot Table): Masa salarial por Departamento y Año de Ingreso
Map<String, Map<Integer, Double>> pivotTable = employees.stream()
        .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.groupingBy(
                        Employee::joiningYear,
                        Collectors.summingDouble(Employee::salary)
                )
        ));

// 37 - Desduplicar por clave personalizada con Predicate con estado
Set<Object> seenKeys = ConcurrentHashMap.newKeySet();
Predicate<Person> distinctFirstLetter = p -> seenKeys.add(p.name().charAt(0));

List<String> uniqueFirstLetterNames = persons.stream()
        .filter(distinctFirstLetter)
        .map(Person::name)
        .toList();

// 38 - Agrupación jerárquica por longitud de palabra y luego por inicial
Map<Integer, Map<Character, List<String>>> hierarchical = words.stream()
        .collect(Collectors.groupingBy(
                String::length,
                Collectors.groupingBy(w -> w.charAt(0))
        ));

// 39 - Stream.generate con Supplier de estado: Secuencia triangular
int[] counter = {0, 0};
List<Integer> triangulars = Stream.generate(() -> {
            counter[0]++;
            counter[1] += counter[0];
            return counter[1];
        })
        .limit(8)
        .toList();

// 40 - Run-Length Encoding (RLE) con Streams
List<String> rleCompressed = IntStream.range(0, input.length())
        .filter(i -> i == 0 || input.charAt(i) != input.charAt(i - 1))
        .mapToObj(start -> {
            char ch = input.charAt(start);
            int count = (int) IntStream.range(start, input.length())
                    .takeWhile(i -> input.charAt(i) == ch)
                    .count();
            return count + "" + ch;
        })
        .toList();

// 41 - Desviación estándar poblacional con Streams
double mean = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
double variance = grades.stream().mapToDouble(g -> Math.pow(g - mean, 2)).average().orElse(0.0);
double stdDev = Math.sqrt(variance);

// 42 - Conteo thread-safe con parallelStream y LongAdder
IntStream.range(0, totalElements)
        .parallel()
        .filter(n -> n % 2 == 0)
        .forEach(n -> adder.increment());

// 43 - Aplanar mapas con valores nulos seguros usando Stream.ofNullable
List<String> flattened = keys.stream()
        .map(groups::get)
        .flatMap(Stream::ofNullable)
        .flatMap(List::stream)
        .toList();

// 44 - Prefijo común más largo (Longest Common Prefix) con reduce
String lcp = strings.stream()
        .reduce((s1, s2) -> {
            int i = 0;
            while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
                i++;
            }
            return s1.substring(0, i);
        })
        .orElse("");

// 45 - Subarreglo contiguo de suma máxima (Algoritmo de Kadane con reduce)
int maxSum = nums.stream()
        .reduce(new int[]{nums.get(0), nums.get(0)},
                (acc, x) -> new int[]{Math.max(x, acc[0] + x), Math.max(acc[1], Math.max(x, acc[0] + x))},
                (a, b) -> a)[1];

// 46 - Balance contable neto por moneda (DEPOSIT - WITHDRAWAL)
Map<String, Double> netBalance = transactions.stream()
        .filter(t -> t.type() != TransactionType.TRANSFER)
        .collect(Collectors.groupingBy(
                Transaction::currency,
                Collectors.summingDouble(t -> t.type() == TransactionType.DEPOSIT ? t.amount() : -t.amount())
        ));

// 47 - Aplanamiento de dependencias transitivas con Streams recursivos
Function<String, Stream<String>> resolveDeps = new Function<>() {
    @Override
    public Stream<String> apply(String module) {
        List<String> direct = dependencies.getOrDefault(module, List.of());
        return Stream.concat(direct.stream(), direct.stream().flatMap(this));
    }
};
Set<String> allDepsFromA = resolveDeps.apply("A").collect(Collectors.toSet());

// 48 - Mayor racha de notas consecutivas aprobadas (>= 80)
int longestStreak = IntStream.range(0, grades.size())
        .map(i -> (int) IntStream.range(i, grades.size())
                .takeWhile(j -> grades.get(j) >= 80)
                .count())
        .max()
        .orElse(0);

// 49 - Collector concurrente que recolecta a ConcurrentSkipListMap ordenado descendente
ConcurrentSkipListMap<Integer, List<String>> skipMap = words.stream()
        .collect(Collectors.groupingBy(
                String::length,
                () -> new ConcurrentSkipListMap<>(Comparator.reverseOrder()),
                Collectors.toList()
        ));

// 50 - Procesamiento asíncrono no bloqueante con CompletableFuture y Streams
List<String> asyncResults = productIds.stream()
        .map(id -> CompletableFuture.supplyAsync(() -> "Prod-" + id))
        .toList().stream()
        .map(CompletableFuture::join)
        .toList();
```

