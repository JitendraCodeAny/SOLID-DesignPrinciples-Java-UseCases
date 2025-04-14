
# SOLID PRINCIPLES - REAL TIME USE CASES

## java code examples  (Real world examples)

### Description 

```
SOLID design principles are a set of five principles that helps to write code that is easy to read and understand and test, maintainable and flexible 

Increase Productivity in Software Development

These are high-level guidelines also can be used to write predictable, clean, readable and modular code that will help to safely refactor, reduce  testing time, easly find bugs, during enhancement and maintainance phase.

--------------

1. S -> Single Responsibility Principle -
A class should contain only one functionality.
When code follow SRP, code will be easier to read, understand, test, and debug

Java code example -1 
Code does not follow SRP - SRPViolation.java
Code follows SRP - SRP.java

Java code example -2 
Code does not follow SRP - SRPViolation2.java
Code follows SRP - SRP2.java


2. O-> Open/Closed Principle - Open for extension and closed for modification.
We should be able add a new functionality in a class or module without modifying its existing code. 
When follow OCP, it helps to add features without breaking existing code

Java code example -1 
Code does not follow OCP - OCPViolation.java
Code follows OCP - OCP.java

3. L-> Liskov Substitution Principle

When subclass objects substitute super class objects and override methods
then should not break existing superclass functionality.

When your code follows LSP, subclass behaviour will be predictable, avoiding weird runtime bug with safe inheritance tree

Java code example -1 
Code does not follow LSP - LSPViolation.java
Code follows LSP - LSP.java

Java code example -2 
Code does not follow LSP - LSPViolation2.java
Code follows LSP - LSP2.java


4. I-> Interface Segregation Principle 

A class should not be forced to implement interface and its methods, 
which are not needed and irrelevant.

To follow ISP, use focused interfaces that helps creating less boilerplate code and simplified unit tests.

Java code example -1 
Code does not follow ISP - ISPViolation.java
Code follows ISP - ISP.java

Java code example -2 
Code does not follow ISP - ISPViolation2.java
Code follows ISP - ISP2.java


5. D-> Dependency Inversion Principle

High level modules (class) should not interact with low level modules (class)
Both high level module (class) and low level module(class) should interact with 
abstraction to follow DI principle.

When code follow DIP, it helps to write loosely coupled code which will be easier to to mock during unit test and maintain

Java code example -1 
Code does not follow DIP - DIPViolation.java
Code follows DIP - DIP.java

Java code example -2 
Code does not follow DIP - DIPViolation2.java
Code follows DIP - DIP2.java

 
```
