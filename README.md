# Java 21 Algorithm Practice

A Java 21 project for practicing algorithms and data structures, perfect for LeetCode-style problems with comprehensive unit testing.

## Features

- **Java 21**: Latest Java features including pattern matching, records, and more
- **Maven**: Dependency management and build automation
- **JUnit 5**: Modern testing framework with advanced features
- **AssertJ**: Fluent assertions for better test readability
- **Comprehensive Testing**: Unit tests with parameterized tests, nested test classes, and edge case coverage


## Prerequisites

- Java 21 or higher
- Maven 3.6+

## Getting Started

### 1. Verify Java Version
```bash
java --version
```

### 2. Clean and Compile
```bash
mvn clean compile
```

### 3. Run Tests
```bash
mvn test
```

### 4. Run Tests with Detailed Output
```bash
mvn test -Dtest="*Test"
```

### 5. Run Specific Test Class
```bash
mvn test -Dtest="TwoSumTest"
```


## Adding New Algorithms

### 1. Create Algorithm Class
```java
package com.dorito.algorithms;

/**
 * LeetCode Problem XXX: Problem Name
 * 
 * Problem description here...
 */
public class YourAlgorithm {
    public int solve(int[] input) {
        // Your solution here
        return -1;
    }
}
```

### 2. Create Test Class
```java
package com.dorito.algorithms;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Your Algorithm Tests")
class YourAlgorithmTest {
    
    private YourAlgorithm algorithm;
    
    @BeforeEach
    void setUp() {
        algorithm = new YourAlgorithm();
    }
    
    @Test
    @DisplayName("Should solve basic case")
    void shouldSolveBasicCase() {
        // Given
        int[] input = {1, 2, 3};
        
        // When
        int result = algorithm.solve(input);
        
        // Then
        assertThat(result).isEqualTo(expectedValue);
    }
}
```

## Testing Best Practices

This project demonstrates several testing best practices:

1. **Descriptive Test Names**: Use `@DisplayName` for clear test descriptions
2. **Nested Test Classes**: Group related tests using `@Nested`
3. **Parameterized Tests**: Test multiple scenarios with `@ParameterizedTest`
4. **Fluent Assertions**: Use AssertJ for readable assertions
5. **Given-When-Then**: Structure tests with clear sections
6. **Edge Cases**: Test boundary conditions and error scenarios

## Java 21 Features Used

- **Preview Features**: Enabled for cutting-edge Java features
- **Pattern Matching**: Enhanced switch expressions
- **Records**: Immutable data classes
- **Text Blocks**: Multi-line strings for better readability

## Maven Commands Reference

```bash
# Clean project
mvn clean

# Compile source code
mvn compile

# Compile test code
mvn test-compile

# Run all tests
mvn test

# Run tests with coverage
mvn test jacoco:report

# Generate documentation
mvn javadoc:javadoc

# Package JAR
mvn package
```

## IDE Setup

### IntelliJ IDEA
1. Import as Maven project
2. Set Project SDK to Java 21
3. Enable preview features in Settings → Build → Compiler → Java Compiler

### VS Code
1. Install Java Extension Pack
2. Set `java.compile.nullAnalysis.mode` to `automatic`
3. Configure `java.configuration.runtimes` for Java 21

## Contributing

When adding new algorithms:
1. Follow the existing naming conventions
2. Include comprehensive JavaDoc comments
3. Add thorough unit tests
4. Include time/space complexity analysis
5. Test edge cases and error conditions

## Resources

- [LeetCode](https://leetcode.com/) - Algorithm problems
- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [AssertJ Documentation](https://assertj.github.io/doc/)

