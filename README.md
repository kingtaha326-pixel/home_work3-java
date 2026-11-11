# Workshop Registration Demo

A small Java console program demonstrating checked exceptions and input validation through a workshop-registration example. Registration is accepted for participants who are at least 18 years old; younger participants receive a custom `InvalidAgeException`.

> **Repository/source note:** The repository currently contains `DynamicSearch.java`, whose public entry-point class is `WorkshopDemo`. Java requires a public top-level class to be declared in a source file with the same name. As checked in, the filename therefore does not match the public class name and standard compilation will fail until the file is renamed to `WorkshopDemo.java`. This README documents the code as it exists and does not change any Java source files.

## Objectives

- Define and use a custom checked exception.
- Validate participant age before completing registration.
- Demonstrate exception propagation with `throws`, exception creation with `throw`, and handling with `try`/`catch`.
- Print an informative success or failure message to the console.

## Technologies

- **Java** — source code uses standard Java language features and APIs.
- **JDK** — install a JDK compatible with your Java environment. No specific minimum JDK version is declared in the source.
- **IDE** — the project can be opened or created in NetBeans, or compiled from a terminal after addressing the source filename mismatch described above.

## Project structure

| File | Purpose |
|---|---|
| `DynamicSearch.java` | Contains the `InvalidAgeException` checked exception, the `WorkshopRegistration` validation class, and the `WorkshopDemo` entry point. The filename currently does not match the public class name. |
| `README.md` | Project description and instructions. |

There are no separate package declarations or external dependencies in the Java source.

## How it works

### `InvalidAgeException`

`InvalidAgeException` extends `Exception`, making it a checked exception. Its constructor accepts a message and passes it to the superclass so the explanation can be retrieved through `getMessage()`.

### `WorkshopRegistration`

The `registerParticipant(String name, int age)` method checks the supplied age:

- If `age` is less than 18, it throws `InvalidAgeException` with a message that includes the participant's name and provided age.
- Otherwise, it prints a successful-registration message.

The method declares `throws InvalidAgeException`, requiring callers to handle or further declare this checked exception.

### `WorkshopDemo`

The `main` method creates a `WorkshopRegistration` object and attempts to register Ali, age 16. The call is wrapped in a `try` block; the matching `catch` block prints the exception message.

## Registration rule

The only rule implemented is a minimum age of 18:

| Condition | Result |
|---|---|
| `age < 18` | Throws `InvalidAgeException`; no success message is printed. |
| `age >= 18` | Prints that the participant has been successfully registered. |

The example does not implement persistence, a user-input prompt, a registration list, or other validation rules.

## Example output

The checked-in `main` method attempts registration with age 16, so its output is:

```text
Attempting to register participant (Age: 16)...
Caught Custom Exception: Registration denied for [Ali]: Must be at least 18 years old (provided age: 16)
```

For an age of 18 or older, `registerParticipant` prints a success message. That path is not exercised by the current `main` method.

## Run in NetBeans

1. Install a JDK and open NetBeans.
2. Create or open a Java project.
3. Because the source file is named `DynamicSearch.java` but declares `public class WorkshopDemo`, rename the source file to `WorkshopDemo.java` in the project (or otherwise make the filename match the public class) before compiling. This is a Java language requirement; the class contents do not need to be changed.
4. Run `WorkshopDemo` as the main class.
5. View the printed messages in the NetBeans Output window.

## Run from a terminal

After making a local copy of the source file named `WorkshopDemo.java` in a working directory, compile and run it with:

```bash
javac WorkshopDemo.java
java WorkshopDemo
```

The repository file itself is left unchanged by these instructions. No build tool or external library is required.

## Java concepts demonstrated

- Classes and object instantiation
- Methods, parameters, and return type `void`
- Checked exceptions by extending `Exception`
- Exception constructors and superclass constructor calls (`super(message)`)
- Declaring an exception with `throws`
- Throwing an exception with `throw`
- Handling exceptions with `try`/`catch`
- Conditional logic and comparison operators
- String concatenation and console output with `System.out.println`
- The `main` method as a Java application entry point
- The public-class/source-file naming convention
