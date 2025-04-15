
# SOLID PRINCIPLES - REAL TIME USE CASES

## java code examples  (Real world examples)

### Description 

SOLID design principles are a set of five principles that helps to write code that is easy to read and understand and test, maintainable and flexible code

It increases Productivity in Software Development

These are high-level guidelines also can be used to write predictable, clean, readable and modular code that will help to safely refactor, reduce  testing time, easly find bugs, during enhancement and maintainance phase. 

1. SRP -> Single Responsibility Principle - A class should handle only one job 

2. OCP -> Open/Closed Principle - Open for extension and closed for modification.
We should be able add new functionality (or extend) without modifying existing code.

3. LSP -> Liskov Substitution Principle - Subclass should not break super class functionality when they replace or substitute superclass

4. ISP -> Interface Segregation Principle 
A class should not be forced to use unnecessary large interface and all its methods.

5. DIP-> Dependency Inversion Principle
Class should interact with abstractions not concrete implementations.

###

```
1. SRP -> Single Responsibility Principle -
 A class should do only one job.
 There should be only one purpose to modify a class.
When code follow SRP, code will be easier to read, understand, test, and debug

 Challenges with code that does not follow SRP -
	 - Hard to understand code as multiple functonalities at one place
	 - Difficult to maintain - when change one functonalities, it may break other
	   functonalities in same class, due to dependencies
	 - Difficult to test due to dependencies multiple functionalities
	 - Less code re-usable - Due to class contains multiple things and dependencies
	 
 Key benefits with code that follow SRP - 
	 - Easy to read and understand, as it handles one job
	 - Simple to test - due to single functionality, it minimizes the need to mock irrelevant dependencies
	 - Easy to maintain - When changes required, need to modify only single functionality 
	 - Flexible and extendible - Upgrade or extend features of the functionality without breaking others 
	 - Easy to debug - Easy to resolve error at change required at one place only
	 - Re-usable - class with specific functionality reused by different classes in same or different projects

Java code example -1 
	Code does not follow SRP - SRPViolation.java
	Code follows SRP - SRP.java

Java code example -2 
	Code does not follow SRP - SRPViolation2.java
	Code follows SRP - SRP2.java

-----------------------------

2. OCP -> Open/Closed Principle - Open for extension and closed for modification.
We should be able add new functionality (extend) without modifying existing code.
When follow OCP, it helps to add functionality without breaking existing code.

Challenges with code that does not follow OCP :
	Cannot extend code without modify base class, so this code is against OCP.
	This is tight coupling, so not scalable. This can lead to error. 
	
Key Benefits with code that follows OCP
    Code is exensible, testable, maintainable and scalable


Java code example
	Code does not follow OCP - OCPViolation.java
	Code follows OCP - OCP.java
------------------------------------------

3. LSP -> Liskov Substitution Principle

Subclass should not break super class functionality when they replace or substitute superclass

LIke, An Employee can do coding and meeting both. 
Developer as an employee can do both as well.
But Recruiter as an employee can do meeting but cannot do coding.
When your code follows LSP, subclass behaviour will be predictable, avoiding weird runtime bug with safe inheritance tree

Challenges with code that does not follow LSP :
    Difficult to test and reuse as subclass behaviour is not predictable
    Less maintainable because hard to add new feature
	
Key Benefits with code that follows LSP
	Simple to test as subclass behaviour is predictable
	Code Re-usability - Reuse subclasses without breaking super class functionality
	Flexible and extendible - Add new subclasses as behaviour is predictable
	Avoid weird runtime bug with safe inheritance tree  

Java code example -1 
	Code does not follow LSP - LSPViolation.java
	Code follows LSP - LSP.java

Java code example -2 
	Code does not follow LSP - LSPViolation2.java
	Code follows LSP - LSP2.java
----------------------------------------------------------------------

4. ISP -> Interface Segregation Principle 

A class should not be forced to use unnecessary large interface and all its methods.
Rather, split large interface into smaller ones and use the one which is usefull.

Like, A large interface 'Person' with methods such as sing(), dance(), playMusic(), should not be used by class Singer because Singer can sing but may not dance or playMusic so not necessaru. 
Hence split the Person interface into smaller ones like ISinger, IDancer, IMusician and Singer should only use ISinger interface and use method sing() which is necessary Similarly, Dancer class should use IDancer interface and method dance().

To follow ISP, use focused interfaces that helps creating less boilerplate code and simplified unit tests.

Challenges with code that does not follow ISP-
	- It force classes to implement unused methods
	- Large interface contain multiple functionalities so also violates SRP
	- Very prone to bug as classes implementing unused method may be left empty, 
	  or incorrectly implement or may crash.
	- Difficult to test, as needs to test all the unused functionality as well
	- Less flexible because of code is tightly coupled, any change in any method 
	  in interface will force the classes to be updated even if they dont use the method 
	- Less code re-usability - Classes implementing unnecessary methods not efficiently reused
	
	
Key Benefits with code that follows ISP
	- Classes implement relevant and focused interfaces, so it is easy to test 
	  classes using relevant / focused interfaces 
	- Re-usable - Because class contains specific functionality, so easily reused by
	  different classes in same or different projects
	- Flexible and extensible - code is loosely coupled due to less dependency, 
	  so can change existing code or add new features without breaking other classes
	  Using focused interfaces helps creating less boilerplate code

Java code example -1 
	Code does not follow ISP - ISPViolation.java
	Code follows ISP - ISP.java

Java code example -2 
	Code does not follow ISP - ISPViolation2.java
	Code follows ISP - ISP2.java


5. DIP-> Dependency Inversion Principle

Class should interact with abstractions not concrete implementations.

When code follow DIP, it helps to write loosely coupled code which will be easier to to mock during unit test and maintain

Challenges with code that does not follow DIP :
	Not flexible
	Hard to test and extend.
	
Key Benefits with code that follows DIP
    Exensible, maintainable, scalable and easy to test
	it helps to write loosely coupled code which will be easier to to mock during unit test and maintain

Java code example -1 
	Code does not follow DIP - DIPViolation.java
	Code follows DIP - DIP.java

Java code example -2 
	Code does not follow DIP - DIPViolation2.java
	Code follows DIP - DIP2.java

 
```
