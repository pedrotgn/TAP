"""
Ejercicio 1. Se trata de realizar un programa de gestión de correo electronico.
 Un correo tiene un origen (from), un destino (to), un tema (subject), un cuerpo (body) y un tipo (URGENT, WORK, FAMILY).

Dada una lista de correos calculad:

"""

enum TYPE {URGENT,WORK,FAMILY}

class correo{
    def origen,destino
    def tema,cuerpo
    def TYPE tipo

    def getMails = {type,list->
        list.findAll({it.tipo==type})
    }

    def String toSting(){
        'name: ' + origen
    }
}

mail1 = new correo(origen:'a',destino: 'b',tema: 'c',cuerpo:'cretino',tipo:TYPE.FAMILY )
mail2 = new correo(origen:'a',destino: 'b',tema: 'c',cuerpo: 'nocretino',tipo:TYPE.WORK )
mail3 = new correo(origen:'a',destino: 'b',tema: 'c',cuerpo: 'cretino',tipo:TYPE.FAMILY )
mail4 = new correo(origen:'a',destino: 'b',tema: 'c',cuerpo: 'nocretino',tipo:TYPE.FAMILY )



//1. Crear una función getMails(kind,lista) que devuelva una lista con todos los mails del tipo pasado por parámetro.

mails = [mail1,mail2,mail3,mail4]

println getMails(TYPE.FAMILY,mails)




//2. Parametrizar parcialmente getMails para que retorne los mails de trabajo

mTrabajo = getMails.curry(TYPE.WORK)
getMails{println.it}



// 3.  Obtener de la lista los correos que contengan la palabra cretino en el body

def getCretino = {cuerpo,list->
        list.findAll({it.cuerpo=='cretino'})
}

println getCretino('cretino',mails)



//4. Obtener de dos formas diferentes la lista de gente con la que nos comunicamos en el mailbox (to)




//5. Calculad el tamaño total del mailbox sumando los tamaños del body de cada mensaje


def sum = {x,y->x+y}
println mails.collect{it.cuerpo}.suma()




//6. Implementar la funcion filterreduce en groovy con recursividad de pila y acumulativa.
//  Usadla para calcular la suma de los numeros pares de una lista









// Ejercicio 2. Implementar un árbol de ficheros y directorios en Groovy. Un directorio contiene ficheros y directorios.
// Un fichero tiene un nombre y un tamaño. Un directorio tiene un nombre y una lista de ficheros y directorios.

class fichero{
	def nombre,tamaño
}

class directorio implements Listable{
	def hijo
	def nombre
}

fixero1 = new arbol(nombreFichero: 'f1',tamañoFichero: 1)
fixero2 = new arbol(nombreFichero: 'f2',tamañoFichero: 1)
dir1 = new arbol(nombre: 'dir1',hijo: [fixero1])
dir2 = new arbol(nombre: 'dir2',hijo: [fixero2])

// a) Queremos una funcion que planarice el arbol a una lista.
// b) Añadir una funcion reduce al arbol que permita aplicarle una función y obtener un resultado. Usadla para


def reduce(f,value){
    def result = value
    result = f(this,vaue)
    hijo.each{result=f(result,it.reduce(f,value))}
    result
}

// obtener el fichero mas grande del arbol
// c) Añade el método toList usando metaprogramming
def toList(){
        def result = []
        result << this
        hijo.each({result.addAll(it.toList())})
        result
 }

directorio.metaClass.toList=toList()

// d) Añade el método toList usando Traits.

trait Listable{
    def toList(){
        def result = []
        result << this
        hijo.each({result.addAll(it.toList())})
        result
    }
}


















