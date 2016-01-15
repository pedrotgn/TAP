Ejercicio 1. Se trata de realizar un programa de gestiÃ³n de correo electronico.
 Un correo tiene un origen (from), un destino (to), un tema (subject), un cuerpo (body) y un tipo (URGENT, WORK, FAMILY).

Dada una lista de correos calculad:

"""

enum tipo {URGENT, WORK, FAMILY}

class Correo{
    def String from
    def String to
    def String subject
    def String body
    def tipo clase

    def String toString(){
        'name:'+ subject
    }
}

quedar=new Correo(from: 'esteban', to: 'isaias', subject: 'quedada', body: 'quedamos a las 5', clase: tipo.FAMILY)
informe1=new Correo(from: 'Lysa', to: 'Marina', subject: 'informe', body: 'necesito el informe hoy', clase: tipo.WORK)
informe2=new Correo(from: 'Marina', to: 'Lysa', subject: 'informe', body: 'el informe esta listo', clase: tipo.WORK)
enfermo=new Correo(from: 'pedro', to: 'Maria', subject: 'enfermo', body: 'tengo fiebre', clase: tipo.URGENT)

bandeja=[quedar,trabajo1,trabajo2,enfermo]

//1. Crear una funciÃ³n getMails(kind,lista) que devuelva una lista con todos los mails del tipo pasado por parÃ¡metro.

def getMails(kind, lista){
    return lista.findAll{it.clase==kind}
}
println getMails(tipo.FAMILY, bandeja)

//2. Parametrizar parcialmente getMails para que retorne los mails de trabajo

def method = getMails.curry(tipo.FAMILY)

println method(bandeja)

// 3.  Obtener de la lista los correos que contengan la palabra cretino en el body

def palabraCretino(lista, palabra){
    def correo=[]
    if (lista==[]) return correo
    else{
        correo = lista.first().body.split(" ")
        correo.findAll(it==palabra)
    }
}

//4. Obtener de dos formas diferentes la lista de gente con la que nos comunicamos en el mailbox (to)

def compare(nom1, nom2){
    if(nom1==nom2) return ""
    else return nom2
}

def listaGente(lista, gente, compare){

}
//5. Calculad el tamaÃ±o total del mailbox sumando los tamaÃ±os del body de cada mensaje

sum

def tamañoMailBox(lista,sum)






//6. Implementar la funcion filterreduce en groovy con recursividad de pila y acumulativa.
//  Usadla para calcular la suma de los numeros pares de una lista
def suma(x,y){
    return x+y
}

def filterreduce1(lista, acc){
    if(lista==[])return acc
    else{
        if(lista.first()%2==0){
            acc<<suma(acc, listafirst())
        }
        filterreduce(lista.tail(), acc)
    }
}

filterreduce1([1,2,3,6,8,9,7,10], 0)

def filterreduce2(lista, value){
    if(lista==[])value
    else{
        if(lista.first()%2==0){
            suma(lista.first(), filterreduce2(lista.tail(), value))
        }
        else
        filterreduce2(lista.tail(), value)
    }
}

filterreduce1([1,2,3,6,8,9,7,10], 0)


// Ejercicio 2. Implementar un Ã¡rbol de ficheros y directorios en Groovy. Un directorio contiene ficheros y directorios.
// Un fichero tiene un nombre y un tamaÃ±o. Un directorio tiene un nombre y una lista de ficheros y directorios.
// a) Queremos una funcion que planarice el arbol a una lista.
// b) AÃ±adir una funcion reduce al arbol que permita aplicarle una funciÃ³n y obtener un resultado. Usadla para
// obtener el fichero mas grande del arbol
// c) AÃ±ade el mÃ©todo toList usando metaprogramming
// d) AÃ±ade el mÃ©todo toList usando Traits.

Traits ToList = {list ->
    f(delegate)
    println list.toList()
}

metaClass

class fichero{
    def name
    def size
}

class directorio{
    def fichero
    def directorios = []

