# 🚀 Java Streams Mastery - Proyecto de Ejercicios y Práctica

Bienvenido al proyecto definitivo para dominar **Java Streams** desde cero hasta un nivel experto y profesional.

Este proyecto contiene **90 ejercicios prácticos organizados en tres niveles de dificultad (30 ejercicios por nivel)**, diseñados bajo el enfoque TDD (Test-Driven Development) usando **JUnit 5**.

---

## 📁 Estructura del Proyecto

```text
java-streams-exercises/
├── pom.xml                                    # Configuración para Maven y cualquier IDE (IntelliJ, VS Code, Eclipse)
├── run-tests.bat                              # Script ejecutable en Windows CMD
├── run-tests.ps1                              # Script ejecutable en Windows PowerShell
├── SOLUTIONS.md                               # Solucionario paso a paso de los 90 ejercicios
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
│       ├── EasyStreamExercisesTest.java        # Nivel Fácil: 30 Ejercicios
│       ├── IntermediateStreamExercisesTest.java # Nivel Intermedio: 30 Ejercicios
│       └── AdvancedStreamExercisesTest.java    # Nivel Avanzado: 30 Ejercicios
```

---

## 🎯 Contenido por Nivel

### 🟢 Nivel Fácil (`EasyStreamExercisesTest.java`) - 30 Ejercicios
Fundamentos y operaciones básicas de flujo:
1. `filter`: Números pares, longitud de strings, umbrales numéricos.
2. `map`: Transformación a mayúsculas, extracción de campos, cuadrados numéricos.
3. `distinct`: Eliminación de duplicados.
4. `sorted`: Orden natural, reversa y ordenación mediante `Comparator.comparingInt`.
5. `limit` y `skip`: Paginación básica y corte de flujos.
6. `count`: Conteo de elementos filtrados.
7. `findFirst` y `findAny`: Búsquedas que devuelven `Optional`.
8. `anyMatch`, `allMatch` y `noneMatch`: Comprobaciones lógicas sobre flujos.
9. `reduce` elemental: Sumatorias y acumulaciones.
10. `Collectors.joining`: Unión de cadenas simple.
11. `IntStream.rangeClosed`: Generación de secuencias numéricas.

### 🟡 Nivel Intermedio (`IntermediateStreamExercisesTest.java`) - 30 Ejercicios
Transformaciones avanzadas, agrupaciones y colectores downstream:
1. `flatMap`: Aplanado de `List<List<T>>`, extracción de hobbies, skills y productos de órdenes.
2. `Collectors.groupingBy`: Agrupación simple y con recolectores downstream:
   - `counting()`
   - `averagingDouble()`
   - `mapping()`
   - `summingDouble()`
3. `Collectors.partitioningBy`: Particionado booleano (pares/impares, umbrales de salario).
4. `Collectors.toMap`: Conversión a mapas con y sin función de resolución de colisiones (merge).
5. Comparadores encadenados: `Comparator.comparing(...).thenComparing(...)`, `reversed()`, `nullsLast()`.
6. Primitivos numéricos (`mapToInt`, `mapToDouble`, `summaryStatistics`).
7. Búsquedas compuestas, fechas con `LocalDate` y `Month`.
8. `peek`: Depuración e inspección de flujo.
9. `Collectors.collectingAndThen`.

### 🔴 Nivel Avanzado (`AdvancedStreamExercisesTest.java`) - 30 Ejercicios
Técnicas avanzadas, algoritmos y características modernas de Java (9 a 17+):
1. `Collectors.teeing` (Java 12+): Cálculo simultáneo de min/max y agregaciones combinadas en un solo pase.
2. `takeWhile` y `dropWhile` (Java 9+): Procesamiento condicional en streams ordenados.
3. `Stream.iterate` con predicado: Secuencias de Fibonacci y potencias.
4. Custom Collectors: Creación de recolectores personalizados mediante `Collector.of(...)` (inversión de orden, acumuladores personalizados).
5. `Collectors.flatMapping` y `Collectors.filtering` downstream (Java 9+).
6. Multi-level Grouping: Agrupación jerárquica multinivel (Moneda -> Tipo de transacción -> Suma).
7. Algoritmos en Streams:
   - Top-K elementos más frecuentes.
   - Agrupación de Anagramas.
   - Transposición de matrices $N \times M$.
   - Producto Cartesiano ($A \times B$).
   - Detección de duplicados mediante `Set.add()`.
8. `Optional.stream()` (Java 9+).
9. Paginación en fragmentos (*chunks*) de tamaño fijo con `IntStream`.
10. Producto punto (*dot product*) de vectores numéricos.
11. Búsqueda de pares adyacentes crecientes.
12. Intersección de múltiples colecciones con `reduce`.
13. Aplanamiento recursivo de árboles de categorías con streams.
14. Streams paralelos y concurrencia segura con `Collectors.toConcurrentMap()`.
15. Tablas de contingencia / Conteo cruzado (*Cross-tabulation*).

---

## 🛠️ ¿Cómo practicar?

1. Abre el proyecto en tu editor favorito:
   - **IntelliJ IDEA**: Archivo -> Abrir -> selecciona esta carpeta. Automáticamente detectará el `pom.xml`.
   - **VS Code**: Abre la carpeta y ejecuta los tests desde el panel "Testing".
   - **Línea de comandos / Terminal**: Sin necesidad de instalar nada adicional.

2. Abre cualquiera de las clases de test:
   - `src/test/java/com/exercise/EasyStreamExercisesTest.java`
   - `src/test/java/com/exercise/IntermediateStreamExercisesTest.java`
   - `src/test/java/com/exercise/AdvancedStreamExercisesTest.java`

3. Cada método de test contiene un comentario explicativo y una línea `// TODO: Tu solución aquí`.
   Reemplaza el valor por defecto (`null`, `0`, etc.) con la expresión en Streams que cumpla el enunciado.

4. Ejecuta los tests:
   - Desde el IDE haciendo clic en el icono verde de "Run Test" al lado del método o de la clase.
   - O desde PowerShell:
     ```powershell
     # Ejecutar nivel fácil
     .\run-tests.ps1 easy

     # Ejecutar nivel intermedio
     .\run-tests.ps1 intermediate

     # Ejecutar nivel avanzado
     .\run-tests.ps1 advanced

     # Ejecutar todos
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

