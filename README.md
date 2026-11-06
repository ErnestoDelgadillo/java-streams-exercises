# 🚀 Java Streams Mastery - Proyecto de Ejercicios y Práctica

Bienvenido al proyecto definitivo para dominar **Java Streams** desde cero hasta un nivel experto y profesional.

Este proyecto contiene **150 ejercicios prácticos organizados en tres niveles de dificultad (50 ejercicios por nivel)**, diseñados bajo el enfoque TDD (Test-Driven Development) usando **JUnit 5**.

---

## 📁 Estructura del Proyecto

```text
java-streams-exercises/
├── pom.xml                                    # Configuración para Maven y cualquier IDE (IntelliJ, VS Code, Eclipse)
├── run-tests.bat                              # Script ejecutable en Windows CMD
├── run-tests.ps1                              # Script ejecutable en Windows PowerShell
├── SOLUTIONS.md                               # Solucionario paso a paso de los 150 ejercicios
├── lib/
│   └── junit-platform-console-standalone-1.10.2.jar  # Runner JUnit 5 integrado para ejecución sin instalación de Maven
├── src/
│   ├── main/java/com/exercise/
│   │   ├── model/                             # Modelos de datos de dominio (Records en Java 17)
│   │   │   ├── Department.java
│   │   │   ├── Employee.java
│   │   │   ├── Gender.java
│   │   │   ├── Order.java
│   │   │   ├── OrderItem.java
│   │   │   ├── OrderStatus.java
│   │   │   ├── Person.java
│   │   │   ├── Product.java
│   │   │   ├── Student.java
│   │   │   ├── Transaction.java
│   │   │   └── TransactionType.java
│   │   └── data/
│   │       └── DataMock.java                  # Datos de prueba realistas (Personas, Empleados, Órdenes, etc.)
│   └── test/java/com/exercise/                # Clases de Test con los Ejercicios
│       ├── EasyStreamExercisesTest.java        # Nivel Fácil: 50 Ejercicios
│       ├── IntermediateStreamExercisesTest.java # Nivel Intermedio: 50 Ejercicios
│       └── AdvancedStreamExercisesTest.java    # Nivel Avanzado: 50 Ejercicios
```

---

## 🎯 Contenido por Nivel

### 🟢 Nivel Fácil (`EasyStreamExercisesTest.java`) - 50 Ejercicios
Fundamentos y operaciones básicas de flujo:
1. `filter`: Números pares, longitud de strings, umbrales numéricos, filtrado múltiple en cascada.
2. `map`: Transformación a mayúsculas, extracción de campos, cuadrados numéricos, mapeo encadenado, mapeo a listas booleanas.
3. `distinct`: Eliminación de duplicados y conteo de únicos.
4. `sorted`: Orden natural, orden inverso (`Comparator.reverseOrder`) y comparadores por propiedad o longitud.
5. `limit` y `skip`: Paginación básica y corte de flujos.
6. `count`: Conteo de elementos filtrados.
7. `findFirst` y `findAny`: Búsquedas con `Optional`, uso de `orElse` y `orElseThrow`.
8. `anyMatch`, `allMatch` y `noneMatch`: Comprobaciones lógicas sobre flujos (edad, stock, sufijos).
9. `reduce`: Sumatorias, multiplicaciones y acumulaciones con y sin valor de identidad.
10. `Collectors.joining` y `Collectors.toSet`: Recolección a cadenas unidas y conjuntos únicos.
11. `IntStream`: `range`, `rangeClosed`, `of`, cálculo de sumas, promedios y conversiones con `boxed()`.
12. Creación de flujos: `Stream.of`, `Stream.empty`, `Stream.concat`, `Arrays.stream` y filtrado con `Objects::nonNull`.

### 🟡 Nivel Intermedio (`IntermediateStreamExercisesTest.java`) - 50 Ejercicios
Transformaciones avanzadas, agrupaciones y colectores downstream:
1. `flatMap`: Aplanado de `List<List<T>>`, extracción de hobbies, skills, productos de órdenes y valores de mapas.
2. `Collectors.groupingBy`: Agrupación simple, en `TreeMap` (ordenado por clave), y con colectores downstream:
   - `counting()`
   - `averagingDouble()`
   - `mapping()` (con `toList()`, `toSet()` y `joining()`)
   - `summingDouble()`
   - `maxBy()` y `minBy()`
3. `Collectors.partitioningBy`: Particionado booleano (pares/impares, umbrales de salario y precio con `counting` y `averagingDouble`).
4. `Collectors.toMap`: Conversión a mapas con resolución de colisiones (merge) y conservación de orden de inserción con `LinkedHashMap`.
5. Comparadores encadenados: `Comparator.comparing(...).thenComparing(...)`, `reversed()`, manejo de nulos con `nullsFirst` y `nullsLast`.
6. Primitivos y estadísticas: `mapToInt`, `mapToDouble`, `chars()` para conteo de caracteres/vocales, `LongStream.rangeClosed` para factoriales y `Collectors.summarizingDouble`.
7. Construcción y control de flujos: `Stream.builder()`, inspección con `peek`, recolección a listas inmodificables con `collectingAndThen`.
8. Operaciones con fechas: Filtros por año, mes (`Month`) y rangos (`LocalDate.isBefore` / `isAfter`).
9. `ConcurrentMap`: Recolección concurrente thread-safe con `Collectors.toConcurrentMap`.

### 🔴 Nivel Avanzado (`AdvancedStreamExercisesTest.java`) - 50 Ejercicios
Técnicas expertas, algoritmos y características modernas de Java (9 a 17+):
1. `Collectors.teeing` (Java 12+): Cálculo simultáneo de min/max, promedios/totales combinados, proporciones porcentuales y extracción de primer y último elemento en un solo pase.
2. `takeWhile` y `dropWhile` (Java 9+): Procesamiento condicional en streams ordenados y generación acotada de números primos.
3. `Stream.iterate`: Secuencias de Fibonacci, potencias de 2 y flujos infinitos controlados.
4. Custom Collectors: Creación de recolectores personalizados mediante `Collector.of(...)` (inversión de orden, mapas de frecuencia, cálculo de mediana y ventana deslizante tipo *sliding window*).
5. `Collectors.flatMapping` y `Collectors.filtering` downstream (Java 9+).
6. Multi-level Grouping y Pivot Tables: Tablas dinámicas y agrupaciones jerárquicas multinivel.
7. Algoritmos en Streams:
   - Top-K elementos más frecuentes.
   - Agrupación de Anagramas.
   - Transposición de matrices $N \times M$.
   - Producto Cartesiano ($A \times B$).
   - Detección de duplicados mediante `Set.add()`.
   - Run-Length Encoding (RLE) para compresión de secuencias repetidas.
   - Algoritmo de Kadane (subarreglo contiguo de suma máxima).
   - Longest Common Prefix (prefijo común más largo).
   - Mayor racha consecutiva (*longest streak*).
   - Desduplicación por clave personalizada (*distinct by key*) con predicados con estado.
8. `Optional.stream()` y `Stream.ofNullable` (Java 9+).
9. Paginación en fragmentos (*chunks*) de tamaño fijo con `IntStream`.
10. Producto punto (*dot product*) de vectores y cálculos estadísticos (varianza y desviación estándar poblacional).
11. Recorridos recursivos en grafos y jerarquías (árboles y dependencias transitivas).
12. Concurrencia y paralelismo: `parallelStream` con `LongAdder` atómico y colectores ordenados hacia `ConcurrentSkipListMap`.
13. Procesamiento asíncrono no bloqueante combinando Streams con `CompletableFuture`.

---

## 🛠️ ¿Cómo practicar?

1. Abre el proyecto en tu editor favorito:
   - **IntelliJ IDEA**: Archivo -> Abrir -> selecciona esta carpeta. Automáticamente detectará el `pom.xml`.
   - **VS Code**: Abre la carpeta y ejecuta los tests desde el panel "Testing".
   - **Línea de comandos / Terminal**: Sin necesidad de instalar nada adicional.

2. Abre cualquiera de las clases de test:
   - `src/test/java/com/exercise/EasyStreamExercisesTest.java` (50 ejercicios)
   - `src/test/java/com/exercise/IntermediateStreamExercisesTest.java` (50 ejercicios)
   - `src/test/java/com/exercise/AdvancedStreamExercisesTest.java` (50 ejercicios)

3. Cada método de test contiene un comentario explicativo y una línea `// TODO: Tu solución aquí`.
   Reemplaza el valor por defecto (`null`, `0`, etc.) con la expresión en Streams que cumpla el enunciado.

4. Ejecuta los tests:
   - Desde el IDE haciendo clic en el icono verde de "Run Test" al lado del método o de la clase.
   - O desde PowerShell:
     ```powershell
     # Ejecutar nivel fácil (50 tests)
     .\run-tests.ps1 easy

     # Ejecutar nivel intermedio (50 tests)
     .\run-tests.ps1 intermediate

     # Ejecutar nivel avanzado (50 tests)
     .\run-tests.ps1 advanced

     # Ejecutar todos los 150 tests
     .\run-tests.ps1
     ```
   - O desde CMD:
     ```cmd
     run-tests.bat easy
     run-tests.bat intermediate
     run-tests.bat advanced
     ```

5. Si usas Maven (`mvn`):
   ```bash
   mvn test
   ```

6. Si en algún momento necesitas una pista o validar tu respuesta, consulta el archivo [SOLUTIONS.md](SOLUTIONS.md).
