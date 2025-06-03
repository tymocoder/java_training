# Caesar Cipher & Arithmetic Expression Evaluator Application

---

## Description
Simple console application with two main functionalities:

Caesar Cipher functionality:
- Encrypts and decrypts plaintext using the Caesar cipher algorithm preserving case (uppercase/lowercase). Non-alphabetic characters (spaces, punctuation, numbers) will remain unchanged
- Accepts text input in Russian and English languages from console
- Accepts text input in Russian and English languages from a file (only .txt is allowed)
- Accepts a shift value (positive or negative integer)
- Decryption back to plaintext can be performed with or without receiving a shift value

Arithmetic Expression Evaluator:  
- Parses and evaluates arithmetic expressions, and returns the calculated result
- Supports basic operations: addition (+), subtraction (-), multiplication (*), division (/)
- Supports parentheses for operation precedence
- Supports decimal and negative numbers
- Follows standard mathematical order of operations (PEMDAS/BODMAS)

---

## Examples of usage:
### Caesar Cipher functionality:
Please choose an option:
1. Caesar Cipher Encryption
2. Caesar Cipher Decryption
3. Arithmetic Expression Evaluation
4. Exit

Enter your choice: 1

Enter text to encrypt: Hello World

Enter shift value: 3

Result: Khoor Zruog

Continue? (y/n): y

### Arithmetic Expression Evaluator functionality:
Please choose an option:
1. Caesar Cipher Encryption
2. Caesar Cipher Decryption
3. Arithmetic Expression Evaluation
4. Exit

Enter your choice: 3

Enter arithmetic expression: -10 + 3 * (2.5 + 2)

Result: 3.5

Continue? (y/n): n

---

## How to download, compile and run the application
### Requirements
- Java 8 or higher installed on the PC or laptop used
- Terminal or command prompt available on the PC or laptop used

### 1. How to download
Clone the project using this link: https://github.com/tymocoder/java_training.git

Or download as ZIP and extract it using this link: https://github.com/tymocoder/java_training/archive/refs/heads/main.zip

Follow this documentation if you need help: https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository

### 2. How to run
If the 1st step (above) was successful:
- Open terminal (command prompt) on the PC or laptop
- Navigate to the java_training/src/
- Run in your terminal: javac Main.java
- Run in your terminal: java Main

---

## Approach to the application design

The application uses modular structure.
Each feature is implemented in its own class:

Main.java – Entry point and menu logic

CaesarCipher.java – Handles encryption and decryption logic

ExpressionEvaluator.java – Handles arithmetic expressions evaluation logic

### Assumptions:
- Input files are UTF-8 encoded .txt files
