

### Polymorphism and Functional Java


1. If class C implements interfaces A and B with methods f and g, ...
[ ] A a = new C(); a.g()
[X] C c = new C(); B b = c; b.g();
[ ] Object o = new B(); B b = o; b.g();
[X] Object o = new C(); B b = (B) o; b.g();


2. If class C implements two interfaces A and B with same default method f ...
[ ] No errors
[X] Compile time error
[ ] Runtime error


3. If class C implements interfaces A and B with methods f and g respectively, ...
[ ] A a = new A(); a.f();
[ ] B b = new C(); b.f();
[X] B b = new C(); A a = (A)b; a.f();
[ ] B b = new C(); A a = b; a.f();

4. Predicate<Integer> pred = a -> a+1; pred.test();
[ ] Correct
[X] Compile time error (Incorrect return type)
[ ] Runtime error
[ ] Compile time error(cannot assign a closure to interface)

5. We can assign a closure to an interface if
[ ] the method name is the same
[X] if signature of parameters type and result are equal
[ ] only if it is in java.functional interfaces
[ ] only for Predicate and Function

6. Function<Integer,Boolean> func = v -> v>3
[ ] Incorrect, use instead: func = (Integer v) -> v>3
[ ] Closures cannot be assigned to interfaces, only instances
[X] Correct
[ ] Incorrect:  func = (Integer v) -> v +1

7. How to obtain the integers greater than 3
[ ] list.stream.map(v->v>3)
[X] list.stream.filter(v->v>3)
[ ] list.forEach(v->v>3)
[ ] list.stream.map(System.out::println)

8. Obtain the number of persons of age greater than 30
[ ] list.map(x->x.getAge()>30)
[ ] list.filter(x->x.getAge()>30)
[ ] list.filter(Person::.getAge()).count()
[X] list.filter(x->x.getAge()>30).count();

9. Obtain the names of persons of age greater than 30
[ ] list.filter(p->p.getAge()>30)
[X] list.filter(p->p.getAge()>30).map(p->p.getName())
[ ] list.map(p->p.getName()).filter(p->p.getAge()>30)
[ ] list.map(p->p.getAge()>30)

10. students.stream().map(Student::getCourses).collect(Collectors.toList()) returns a
[ ] List<Course>
[ ] Stream<Course>
[X] List<List<Course>>
[ ] List<List<List<Course>>>

11. Is it possible to pass functions as parameters in Java ?
[ ] Yes
[X] No, only classes and interfaces


12. Is this correct?   Predicate<Integer> x =a->a>3
[X] Yes
[ ] No

13. With stream.map we can
[ ] obtain a new list of the same type
[X] obtain a new list of any type
[ ] obtain a new list with the elements that match the predicate



