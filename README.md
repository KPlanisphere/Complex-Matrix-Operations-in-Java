# Complex Matrix Operations in Java

## Project Overview

This repository contains a Java project for performing operations on complex matrices. The project is structured into several classes, each responsible for different aspects of handling and manipulating complex numbers and matrices. The main functionalities include creating complex matrices, performing arithmetic operations, and handling complex number arithmetic.

## Features

-   **Complex Number Operations**: Basic operations on complex numbers such as addition, subtraction, multiplication, and division.
-   **Complex Matrix Operations**: Creation and manipulation of matrices with complex numbers including matrix addition, subtraction, multiplication, and scalar operations.
-   **Utility Methods**: Helper methods to facilitate complex number and matrix operations.
-   **Input Handling**: Reading complex matrices from input files and processing them.

## Project Structure

```plaintext
src/
├── TComplejo.java
├── TOperaComplejos.java
├── TMatrizCompleja.java
├── TOpMatricesComplejas.java
└── MatricesComplejas.java
```

### TComplejo.java

This class defines the structure and basic operations for complex numbers. It includes methods for addition, subtraction, multiplication, and division of complex numbers.

#### Key Methods
```java
public class TComplejo {
    private double real;
    private double imag;

    public TComplejo(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public TComplejo add(TComplejo c) {
        return new TComplejo(this.real + c.real, this.imag + c.imag);
    }

    public TComplejo subtract(TComplejo c) {
        return new TComplejo(this.real - c.real, this.imag - c.imag);
    }

    // Other operations...
}
```

### TOperaComplejos.java

This class provides additional operations for complex numbers, possibly including utility functions that extend the basic arithmetic operations provided in `TComplejo.java`.

### TMatrizCompleja.java

This class represents a matrix with complex numbers. It includes methods to perform matrix-specific operations such as addition, subtraction, and multiplication.

#### Key Methods
```java
public class TMatrizCompleja {
    private TComplejo[][] data;

    public TMatrizCompleja(int rows, int cols) {
        data = new TComplejo[rows][cols];
    }

    public TMatrizCompleja add(TMatrizCompleja m) {
        // Implementation for matrix addition
    }

    public TMatrizCompleja multiply(TMatrizCompleja m) {
        // Implementation for matrix multiplication
    }

    // Other matrix operations...
}
```

### TOpMatricesComplejas.java

This class likely provides additional operations for complex matrices, complementing the basic operations defined in `TMatrizCompleja.java`.

### MatricesComplejas.java

This is the main class that coordinates the complex matrix operations, possibly including reading inputs, initializing matrices, and invoking operations.

#### Example Usage
```java
public class MatricesComplejas {
    public static void main(String[] args) {
        // Initialize matrices and perform operations
        TMatrizCompleja matrix1 = new TMatrizCompleja(3, 3);
        TMatrizCompleja matrix2 = new TMatrizCompleja(3, 3);

        TMatrizCompleja result = matrix1.add(matrix2);
        // Output the result...
    }
}
```

## How to Use

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/ComplexMatrixOperations.git
```
2. **Navigate to the project directory**:    
```bash
cd ComplexMatrixOperations
```
3.  **Compile the Java files**:
```bash
javac src/*.java
```
4. **Run the main class**:
```bash
java src/MatricesComplejas
```

## Input File Format (example)

The input file `ENTRADAS MATRICES COMPLEJAS.txt` contain the matrices to be processed. Each matrix is represented by its elements, where each complex number is specified in the format (real, imaginary).

```plaintext
3
3
3
2
3
5
2
1
-4
2
5
4
6
...
```
