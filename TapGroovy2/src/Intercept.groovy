/**
 * Created by pedro on 26/10/14.
 */

class MyClass implements GroovyInterceptable {
    def invokeMethod(String name, args) {
        System.out.println ("Beginning $name")
        def metaMethod = metaClass.getMetaMethod(name, args)
        def result = metaMethod.invoke(this, args)
        System.out.println ("Completed $name")
        return result
    }
    def sayHello(){
        println "hello"
    }
}

def a = new MyClass()
a.sayHello()
