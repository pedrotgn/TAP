


TAP 4
-------------------------------------


1. Reflection (reflection. annotations)
2. Interception (dynamic, dynamicproxy)
3. Unit testing (calculator, employee)
4. JSON parsing (json)

Proposed exercises
----------------------------------------


1. Create your own dynamic proxy (use dynamic package) to intercept your own class.
2. Create your own dynamic proxy that intercepts all calls to EmpBusinessLogic and shows in System.out method name and parameters.
3. Modify the proxy to increment the salary returned by each function in 1000 bonus units.
4. Create an annotation Bonus(money) and use it in the  EmpBusinessLogic class. It will tell the dynamic proxy the bonus amount to increase.
5. Now the tests don't work. Modify the test to include the bonus found in the annotation.
