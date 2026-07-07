

# Design Patterns 2


1. Singleton allows
- [ ] to create global variables using polymorphism
- [ ] to create objects following a template class
- [X] to create a unique instance using static methods
- [ ] it is a tool for single developers


2. Visitor uses as 
- [ ] parametric polymorphism and sub type polymorphism
- [X] overload polymorphism as sub type polymorphism
- [ ] overload polymorphism as parametric polymorphism


3. Iterable<T> and Iterator<T> require respectively methods
- [ ] iterator() and iterable(), forEach()
- [ ] iterator() and next() , forEach()
- [ ] iterator() and toString()
- [X] iterator()  and next(), hasNext()

4. Factories are used in 
- [ ] stream libraries (InputStream, InputReader)
- [ ] graphical libraries 
- [X] database libraries (java.sql)


5. Which patterns use delegation ?
- [ ] Factory and Observer
- [ ] Singleton and Composite
- [X] Decorator and Adapter
- [ ] Adapter and  State

6. Add new methods to AComponent in Composite
- [ ] has no problem at all
- [X] it may involve the Fragile Base Class Problem
- [ ] it is incorrect
- [ ] it is illegal


7. A pattern that could avoid the FGC problem to add new methods is 
- [ ] Composite
- [ ] Adapter
- [X] Visitor
- [ ] Singleton


8. class Namerepository implements Iterable<String>
- [ ] can contain variables of type T
- [X] it only works with Strings
- [ ] it can contain variable of type Iterable

9. Why you do not need to implement  forEach or remove methods in Iterator<T> ?
- [ ] Because they are  deprecated
- [ ] Because they cannot exist in the implemented class
- [X] Because they are default methods
- [ ] Because they are static methods

