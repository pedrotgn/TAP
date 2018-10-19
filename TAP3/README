

TAP 3: DESIGN PATTERNS
-----------------------------



  1. Singleton: http://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
  2. Adapter: http://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
  3. Proxy: http://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
  4. Composite: http://www.tutorialspoint.com/design_pattern/composite_pattern.htm
  5. Observer: http://www.tutorialspoint.com/design_pattern/observer_pattern.htm
  6. Strategy: http://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
  7. Template: http://www.tutorialspoint.com/design_pattern/template_pattern.htm
  8. Visitor: http://www.tutorialspoint.com/design_pattern/visitor_pattern.htm

Exercises:
--------------


1. Convert the adapter sample to a Class Adapter.
2. Create a Counter Singleton that maintains a global counter with methods to increment and get the current value. Show a simple example.
3. Modify the observer sample to count the number of invocations of observers. Use the Counter Singleton inside each Observer implementation (BinaryObserver, ...).
   Show the final result of the Counter in the main program.
4. Attach a new Observer using a Lambda Function that shows in the screen only the odd numbers. You will have to modify the Observer class to do this.
5. Create a Message class with one single text property. Create a UpperCaseDecorator of Message that converts the message to upeercase (getText). Create an Insult Decorator that adds an insult to the text.
 Create a FilterDecorator that replaces all appearances of "tonto" by xxx.


6. FILESYSTEM
 ---------------------------------

   Based on the Composite pattern we will implement a basic file system supporting files and directories.
   Every directory has a name and it can contain N files and N directories.
   Every file has name and size.

   You have to implement the following operations:

   1. ls()
   If we perform ls() over one directory, it will print the name of all files and directories that it contains.

   2. collect(): It returns a list of String that contains all names of files and directories that are contained in this directory (include subdirectories).

   3. toList(): It returns one list of all components (can be files or directories) that are contained in this directory (include subdirectories).


   4. search(name): It returns a list of files whose name coincides with name in all sub tree of this directory.

   5. search(Predicate): It returns the  list of elements that match this predicate (include subdirectories).
      For example, obtain all components with size>200, or obtain all components whose name begins with "r". Use closures.

   6. toString(): Redefine toString method of files and directories in order to print on screen the entire path of every file and directory.

   Ex: /home/lp/c.txt or /home/lp

   Example:
   In a main program create this structure of directories:

   /home/
   	  a.txt
    	  b.txt
   	  /lp/
   	      c.txt
   /tmp/
         a.txt
   Check the six functions. You have to use parametric polymorphism in your code when it is possible.

   OPTIONAL PART:
   1. When we add a file that already exists in this directory, throw a custom exception.
   2. Enable the iteration over directories with the for clause (Iterable)
   3. Use Comparator<T>, Collections.sort and Closures to order by name the list that is obtained by toList.


7. Modify the existing Iterator sample to use java,util.Iterable<T> and java.util.Iterator<T>


8. FileSystem combining composite and visitor

The problem of the previous solution is that every new operation that we want to apply to the entire tree must be added to the parent interface AComponent.
This reminds us the classical Fragile Base Class problem of modifying parent classes in OOP.
To solve this problem and enable adding new operations in a flexible way, combine the Visitor and Composite patterns. Since every node in the structure can be visited,
we will be able to add any operation very easily using Visitors.
Convert all operations [1-6] to Visitors and demonstrate them.


9. ObserverList

The problem is to create an ObserverList collection that implements the observer design pattern.
It will notify of  changes to the observers (notifyAdd and notifyRemove methods)
when the state of ObserverList is modified (add or remove elements).
The collection must be Iterable and generic.

Steps:

  1. Define observer contract
  2. Implement PrinterObserver to show by standard output the element and the completed operation (add or remove).
  3. Implement BackupObserver  to keep a copy of each added element and this function and remove then when was indicated.
  4. Make ObservgerList Iterable
  5. Implement ObserverList collection using parameteric polymorphism.
  6. Throw AlreadyExistsObserverException exception
  7. Create main class demonstrating all exercises








