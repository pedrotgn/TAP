


### Polumorphism


1. Can we use overload polymorphism in a dynamically typed language ?
[ ] Yes
[X] No
[ ] Only combined with parametric polymorphism
[ ] In Python yes


2. If A and B are interfaces with method f(), what happens if C implements A,B?
[ ] Error: cannot inherit the same method from two interfaces
[X] No error: the method is only implemented in C
[ ] Error: A class cannot implement two interaces
[ ] Error: A should be abstract


3. If C extends A implements B, D, what is correct?
[ ] C c = new A();
[ ] B b = new A()
[ ] D d = new A()
[X] D d = new C()

4. If C extends A implements B, D, what is correct?
[ ] C c = new D(); A a = c;
[ ] C c = new A(); A a = c;
[X] C c = new C(); D d = (D)c;
[ ] A a = new C(); D d = (D)a;

5. Overload polymorphism is an aparent polymorphism
[ ] Because the code is not repeated for the end-user
[ ] Because it does not achieve code reuse
[X] Because the code is repeated in different functions
[ ] Because types are hidden for the programmer

6. Subtype polymorphism can 
[X] be used in both staticly typed and dynamically typed languages
[ ] be used only in staticly types languages
[ ] be used only in dynamically typed languages
[ ] only be used in scripting languages

7. In a dynamically typed languages we have full polymorphism because 
[ ] In the same program, a variable only have one type
[ ] In the same program, a variable can change types once
[X] In the same program, a variable, can change types many times
[ ] In the same program, variables never have types

8. In Collections.sort the Contract and dynamic binding are
[ ] Comparator<T> and in the implementation of this interface
[ ] Comparator<T> and inside sort when compare is invoked
[X] List<T> and Comparator<T>
[ ] sort(Comparator<T>) and in the implementation of sort

