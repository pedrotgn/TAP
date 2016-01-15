import groovy.transform.Trait

"""
Ejercicio 1. Se trata de realizar un programa de gestión de correo electronico.
 Un correo tiene un origen (from), un destino (to), un tema (subject), un cuerpo (body) y un tipo (URGENT, WORK, FAMILY).

Dada una lista de correos calculad:

"""

enum Tipo{URGENT, WORK, FAMILY}

class Correu{
    def from, to, subject, body
    def Tipo tipo

    def String toString(){
        from + 'to' + to
    }

}

def llistaCorreu = []


llistaCorreu << new Correu(from: 'P1', to: 'P2', tipo:Tipo.FAMILY, body: 'Eres un cretino')
llistaCorreu << new Correu(from: 'P3', to: 'P4', tipo:Tipo.FAMILY, body: 'Eres un')
llistaCorreu << new Correu(from: 'P5', to: 'P6', tipo:Tipo.WORK, body: ' ')
llistaCorreu << new Correu(from: 'P7', to: 'P8', tipo:Tipo.WORK, body: ' ')
llistaCorreu << new Correu(from: 'P9', to: 'P10', tipo:Tipo.URGENT, body: 'cretino')
llistaCorreu << new Correu(from: 'P11', to: 'P12', tipo:Tipo.URGENT, body: 'cre')
llistaCorreu << new Correu(from: 'P13', to: 'P14', tipo:Tipo.URGENT, body: ' ')




//1. Crear una función getMails(kind,lista) que devuelva una lista con todos los mails del tipo pasado por parámetro.

def getMails = {kind, lista ->
    lista.findAll({it.tipo == kind})
}

println getMails(Tipo.FAMILY, llistaCorreu)



//2. Parametrizar parcialmente getMails para que retorne los mails de trabajo


def getMailsTabajo = getMails.curry(Tipo.WORK)

println getMailsTabajo(llistaCorreu)


// 3.  Obtener de la lista los correos que contengan la palabra cretino en el body

println llistaCorreu.findAll({it.body.split(' ').contains('cretino')})


//4. Obtener de dos formas diferentes la lista de gente con la que nos comunicamos en el mailbox (to)



//5. Calculad el tamaño total del mailbox sumando los tamaños del body de cada mensaje

/*
def resultat = 0
llistaCorreu.each {resultat + it.body.size()}
println resultat
*/

// println llistaCorreu.body.inject {x, y -> x.size() + y.size()}



//6. Implementar la funcion filterreduce en groovy con recursividad de pila y acumulativa.
//  Usadla para calcular la suma de los numeros pares de una lista
def listaNumeros = 0..4
def par = {x -> x % 2 == 0}
def suma = {x, y -> x + y}

def filterreduce(f, op, list, acc){
    result = acc
    if(list == []){
        acc
    } else {
        f(list.first())? op(list.first(), filterreduce(f, op, list.tail(), acc)) : filterreduce(f, op, list.tail(), acc)
        //op(list.first(), filterreduce(f, op, list.tail(), acc))     //falta aplicar el filtre ( f )
    }
}

println filterreduce(par, suma, listaNumeros, 0)

def filterreduce2(f, op, list, acc){
    result = acc
    if(list == []){
        acc
    } else {
        filterreduce2(f, op, list.tail(), f(list.first())? op(acc, list.first()) : acc)
    }
}

println filterreduce2(par, suma, listaNumeros, 0)



// Ejercicio 2. Implementar un árbol de ficheros y directorios en Groovy. Un directorio contiene ficheros y directorios.
// Un fichero tiene un nombre y un tamaño. Un directorio tiene un nombre y una lista de ficheros y directorios.
// a) Queremos una funcion que planarice el arbol a una lista.
// b) Añadir una funcion reduce al arbol que permita aplicarle una función y obtener un resultado. Usadla para
// obtener el fichero mas grande del arbol
// c) Añade el método toList usando metaprogramming
// d) Añade el método toList usando Traits.



// Se con funciona l'arbre de fitxers, però no recordo com implementar-lo. Espero que puguis contar els apartars c i d encara que no hi hagi el codi del mètode

class Component{

}

class Fitxer{

}

// a)

// La funció ha d'afegir el propi node i despres recorre cada un dels seus fills



// c) metaprogramming
def toList2(){
    // Codi del toList() utilitzant 'delegate'
}

Fitxer.metaClass.toList2 = toList2()



// d) traits
trait Implementable {
    def tolist3 = { ->
        // Codi del toList() utilitzant 'this'
    }
}
// en la classe hauriem de ficar ' implements Implementable '


