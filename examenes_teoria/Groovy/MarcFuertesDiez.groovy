"""
Ejercicio 1. Se trata de realizar un programa de gestión de correo electronico.
 Un correo tiene un origen (from), un destino (to), un tema (subject), un cuerpo (body) y un tipo (URGENT, WORK, FAMILY).

Dada una lista de correos calculad:

"""

enum Tipos {URGENT, WORK, FAMILY}

class Correo{
    def origen
    def destino
    def tema
    def cuerpo
    def Tipos tipo

    def String toString(){
        "correo: "+origen+" "+destino+" "+tema
    }


}


//1. Crear una función getMails(kind,lista) que devuelva una lista con todos los mails del tipo pasado por parámetro.

def getMails = {kind,list ->
    list.findAll{it.tipo==kind}
}
persona1 = new Correo(origen:'urv',destino: 'uab', tema: 'practicas', cuerpo: 'Hola', tipo:Tipos.WORK)
persona2 = new Correo(origen:'urv',destino: 'udg', tema: 'familia', cuerpo: 'cretino', tipo: Tipos.FAMILY)
persona3 = new Correo(origen:'personal',destino: 'urv', tema: 'informacion', cuerpo: 'masinformacion', tipo:Tipos.URGENT )
persona4 = new Correo(origen:'personal2',destino: 'hermano', tema: 'informacion', cuerpo: 'cretino', tipo:Tipos.FAMILY )

lista = [persona1,persona2,persona3,persona4]

println getMails(Tipos.WORK, lista)

//2. Parametrizar parcialmente getMails para que retorne los mails de trabajo


correoWORK = getMails.curry(Tipos.WORK)

println correoWORK(lista)

// 3.  Obtener de la lista los correos que contengan la palabra cretino en el body

def getParaula = {list ->
    list.findAll{it.cuerpo=="cretino"}
}

println getParaula(lista)


//4. Obtener de dos formas diferentes la lista de gente con la que nos comunicamos en el mailbox (to)


def getDestino1 = {list ->
    def result =[]
    list.findAll{result<<{it.destino}}
}

println getDestino1(lista)

def getDestino2 = {list ->
    def result2 =[]
    if (list==[]){
        result2
    }else{
        result2<<list.first().destino
        getDestino2(list.tail())
    }
}

println getDestin2( lista)

//5. Calculad el tamaño total del mailbox sumando los tamaños del body de cada mensaje

def suma = {x,y -> x+y}
def var
def getSize = {result,list ->
    if (list==[]){
        result
    }else{
        var = list.first().cuerpo
        result = suma(result, var.size())
        getSize(result,list.tail())
    }
}
println getSize(lista)




//6. Implementar la funcion filterreduce en groovy con recursividad de pila y acumulativa.
//  Usadla para calcular la suma de los numeros pares de una lista

lista2 = [1,2,3,4,5,6]
def suma2 = {x,y -> x+y}

def filterreduceACC = {op,acc,list ->
    if(list==[]){
        acc
    }else{
       if(list.first%2==0){
           filterreduce(op, op(acc,list.first()),list.tail())
       }else{
           list.tail()
           filterreduce(op, op(acc,list.first()),list.tail())
       }

    }

}


def filterreducePILA = {op, list ->
    if(list==[]){

    }else{
        if(list.first%2==0){
            op(list.first(), filterreducePILA(op,list.tail()))
        }else{
            list.tail()
            op(list.first(), filterreducePILA(op,list.tail()))
        }

    }

}
println filterreduceACC(suma2,0,lista2)
println filterreducePILA(suma2,lista2)



// Ejercicio 2. Implementar un árbol de ficheros y directorios en Groovy. Un directorio contiene ficheros y directorios.
// Un fichero tiene un nombre y un tamaño. Un directorio tiene un nombre y una lista de ficheros y directorios.
// a) Queremos una funcion que planarice el arbol a una lista.
// b) Añadir una funcion reduce al arbol que permita aplicarle una función y obtener un resultado. Usadla para
// obtener el fichero mas grande del arbol
// c) Añade el método toList usando metaprogramming
// d) Añade el método toList usando Traits.



class fichero{
    def nombre
    def tamaño
}

class directorio{
    def nombre
    def List [] lista
}
def resultList []
def toList = {arrel
    if (arrel.lista == [] ){
        resultList<<this.name
    }else{
        arrel.lista.each(toList())
    }
}


def reduce = {
    
}
def toList = {
    
}




