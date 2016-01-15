/**
 * Eduard Gonzalez Vioque
 * 29 de gener de 2015
 * Tecniques avançades de programacio
 */

"""
Ejercicio 1. Se trata de realizar un programa de gestiÃ³n de correo electronico.
 Un correo tiene un origen (from), un destino (to), un tema (subject), un cuerpo (body) y un tipo (URGENT, WORK, FAMILY).

Dada una lista de correos calculad:

"""

enum Tipo{URGENT, WORK, FAMILY}

class Correo {
    def from, to, subject, body
    def Tipo tipo

    def String toString() {
        'Subject: ' + subject
    }
}

correo1 = new Correo(from: 'mortadelo', to: 'super', subject: 'aumento', body: 'quiero un aumento de dioptrias, cretino', tipo: Tipo.WORK)
correo2 = new Correo(from: 'filemon', to: 'tecnico', subject: 'cambio movil', body: 'el zapatofono se ha estropeado', tipo: Tipo.WORK)
correo3 = new Correo(from: 'ofelia', to: 'super', subject: 'nueva silla', body: 'se ha roto la silla por culpa de otro cretino', tipo: Tipo.WORK)
correo4 = new Correo(from: 'mujer', to: 'super', subject: 'cena amigos', body: 'esta noche tenemos cena con el ministro', tipo: Tipo.FAMILY)
correo5 = new Correo(from: 'bacterio', to: 'ministro', subject: 'paredes plomo', body: 'corremos peligro', tipo: Tipo.URGENT)


listaCorreo = [correo1, correo2, correo3, correo4, correo5]

//1. Crear una funciÃ³n getMails(kind,lista) que devuelva una lista con todos los mails del tipo pasado por parÃ¡metro.
def getMails = {kind, lista -> lista.findAll{it.tipo == kind}}
println '--- Ejercicio 1.1 ---'
println getMails(Tipo.FAMILY, listaCorreo)
println getMails(Tipo.URGENT, listaCorreo)





//2. Parametrizar parcialmente getMails para que retorne los mails de trabajo
def mailsWork = getMails.curry(Tipo.WORK)
println '\n--- Ejercicio 1.2 ---'
println mailsWork(listaCorreo)




// 3.  Obtener de la lista los correos que contengan la palabra cretino en el body
def mailFilter = {palabra, lista -> lista.findAll {it.body.contains(palabra)}}
println '\n--- Ejercicio 1.3 ---'
println mailFilter('cretino', listaCorreo)


//4. Obtener de dos formas diferentes la lista de gente con la que nos comunicamos en el mailbox (to)

def mailboxTo1 = {lista -> lista.collect {it.to}}
def mailboxTo2 = {lista -> lista.each {println it.to}}

println '\n--- Ejercicio 1.4 ---'
println 'forma 1)'
println mailboxTo1(listaCorreo)
println '\nforma 2)'
mailboxTo2(listaCorreo)


//5. Calculad el tamaÃ±o total del mailbox sumando los tamaÃ±os del body de cada mensaje

def sizeMailbox = {lista -> lista.collect({it.body.length()}).inject {x, y -> x + y}}

println '\n--- Ejercicio 1.5 ---'
println 'Size total del mailbox: ' + sizeMailbox(listaCorreo)



//6. Implementar la funcion filterreduce en groovy con recursividad de pila y acumulativa.
//  Usadla para calcular la suma de los numeros pares de una lista

/*def filterreducePila
filterreducePila = {list, f, op ->
    def resultado = 0
    if (list == [])
        resultado
}

def filterreduceAcum
filterreduceAcum = {list ->

}

listaNumeros = [1,3,4,2,17,21,6]
def isOdd = {x -> (x % 2 == 0)}
def suma = {x, y -> x + y}
*/
println '\n--- Ejercicio 1.6---'
//println 'Recursividad de pila: ' + filterreducePila(listaNumeros, isOdd, suma)
//println 'Recursividad acumulada: ' + filterreduceAcum(listaNumeros)

// Ejercicio 2. Implementar un Ã¡rbol de ficheros y directorios en Groovy. Un directorio contiene ficheros y directorios.
// Un fichero tiene un nombre y un tamaÃ±o. Un directorio tiene un nombre y una lista de ficheros y directorios.
// a) Queremos una funcion que planarice el arbol a una lista.
// b) AÃ±adir una funcion reduce al arbol que permita aplicarle una funciÃ³n y obtener un resultado. Usadla para
// obtener el fichero mas grande del arbol
// c) AÃ±ade el mtodo toList usando metaprogramming
// d) AÃ±ade el mÃtodo toList usando Traits.

class File {
    def name, size

    def String toString() {
        'File name: ' + name
    }
}

class Folder {
    def name
    def folderList = []

    def planarizarArbol() {
        def resultado = []
        resultado << this
        if(folderList) {
            folderList.each {resultado.addAll({it.planarizarArbol()})}
        }
        else {
            resultado
        }
    }

    def reduce(f) {
        def resultado
        if(folderList){
            folderList.each {resultado = it.reduce(f)}
        }
    }

    def String toString() {
        'Folder name: ' + name
    }
}

file1_1 = new File(name: 'file1_1.txt', size: 32)
file2_1 = new File(name: 'file2_1.txt', size: 256)
file3_1 = new File(name: 'file3_1.txt', size: 16)
file1_2 = new File(name: 'file1_2.txt', size: 1024)

folder1 = new Folder(name: 'folder1')
folder2 = new Folder(name: 'folder2')


folder2.folderList = [file1_2]
folder1.folderList = [file1_1, file2_1, file3_1, folder2]

println '\n+++ Ejercicio 2.1 +++'
println folder1.planarizarArbol()

println '\n+++ Ejercicio 2.2 +++'
def masGrande = {x, y -> (Math.max(x.size, y.size) == x.size) ? x : y}
println folder1.reduce(masGrande)