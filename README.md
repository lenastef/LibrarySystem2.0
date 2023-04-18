# HBV.Lokaverkefni.LibrarySystemTest

A simple library system that allows users to borrow and return books.

## Installation

To use this library system, you need to have Java installed on your computer.

1. Clone this repository to your local machine.
2. Open the project in an IDE or text editor of your choice.
3. Compile and run the HBV.Lokaverkefni.LibrarySystemTest.java file.

## Usage

To borrow a book:

1. Enter the name of the user and the title of the book.
2. Click the "Borrow" button.
3. If the book is available and the user is eligible to borrow, the book will be checked out to the user.

To return a book:

1. Enter the name of the user and the title of the book.
2. Click the "Return" button.
3. If the user has the book checked out, the book will be returned and marked as available.

## Dependencies

This project uses the Java 8 standard library and does not require any external dependencies.

Both the implementation and the tests are in Java package `HBV/HBV.Lokaverkefni.LibrarySystemTest/src`,
but in the usual separate Maven `src` directories:

- `src/main/java.HBV.Lokaverkefni.LibrarySystemTest`:
  A class representing cars, a class representing a person who owns a car, and a Main class with a main method.

- `src/test/java`:
  A Alltests test suite class, two classes containing test cases for the car and the car owner class.
  Maven:

- `mvn compile` compiles all implementation classes.
- `mvn exec:java` executes the main method of the implementation.
- `mvn test` runs all test cases (i.e. all classes with a name that either starts with `Test` or ends
  with `Test`, `Tests`, or `TestCase`).

