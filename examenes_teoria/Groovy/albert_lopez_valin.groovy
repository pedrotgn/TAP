"""
Ejercicio 1. Se trata de realizar un programa de gestión de correo electronico.
 Un correo tiene un origen (from), un destino (to), un tema (subject), un cuerpo (body) y un tipo (URGENT, WORK, FAMILY).

Dada una lista de correos calculad:

"""
println "CLASS DEFINITION"
enum Type {URGENT, WORK, FAMILY}
class Email{
	def from
	def to
	def subject
	def body
	def Type type

	def String toString(){
		'subject: '+subject
	}
}
test_mail = new Email(from:'Albert', to:'Susana', subject:'Exam deliver', body:'This is my exam.', type:Type.WORK)
test_mail2 = new Email(from:'Susana', to:'Albert', subject:'Exam received', body:'I received your exam.', type:Type.WORK)
test_mail3 = new Email(from:'Susana', to:'Albert', subject:'!Exam received', body:'Your exam is not compiling. Send it again cretino!', type:Type.URGENT)
test_mail4 = new Email(from:'Albert', to:'Mom', subject:'Exam family', body:'I am late due to the exam, I will come at 20:00h. I am a cretino', type:Type.FAMILY)
test_mail5 = new Email(from:'Albert', to:'Susana', subject:'!Exam deliver', body:'This is my exam again.', type:Type.URGENT)
mail_list = [test_mail, test_mail2, test_mail3, test_mail4, test_mail5]
println test_mail
println "------------------------------------------------"

println "EX1"
//1. Crear una función getMails(kind,lista) que devuelva una lista con todos los mails del tipo pasado por parámetro.
def getMails = {kind, lista -> 
		lista.findAll {it.type==kind}
		}
println getMails(Type.WORK, mail_list)
println getMails(Type.URGENT, mail_list)
println getMails(Type.FAMILY, mail_list)
println "------------------------------------------------"

println "EX2"
//2. Parametrizar parcialmente getMails para que retorne los mails de trabajo

def getWorkMails
getWorkMails = getMails.curry(Type.WORK)
println getWorkMails(mail_list)
println "------------------------------------------------"

println "EX3"
// 3.  Obtener de la lista los correos que contengan la palabra cretino en el body

def getCretinoFromBody(list){
	def ret_list = []
	for (elem in list){
		if (elem.body.contains("cretino")){
			ret_list<<elem
		}
	}
	ret_list
}
println getCretinoFromBody(mail_list)
println "------------------------------------------------"


println "EX4.1 (list.each)"
//4. Obtener de dos formas diferentes la lista de gente con la que nos comunicamos en el mailbox (to)

def getAllToFromList = {list -> 
			def ret_list = []
			list.each {ret_list<<it.to}
			ret_list
			}
println getAllToFromList(mail_list)
println "------------------------------------------------"

println "EX4.2 (with a for)"
def getAllToFromList2(list){
	def ret_list = []
	for (elem in list){
		ret_list<<elem.to
	}
	ret_list
}
println getAllToFromList2(mail_list)
println "------------------------------------------------"

println "EX5"
//5. Calculad el tamaño total del mailbox sumando los tamaños del body de cada mensaje
def getMailBoxSize(list){
	def total = 0
	for (elem in list){
		if(elem.body.size()!=null){
			total = total + elem.body.size()
		}
	}
	total
}

println "Size of the mailbox: "+getMailBoxSize(mail_list)+"KB."
println "------------------------------------------------"


println "EX6.1"
//6. Implementar la funcion filterreduce en groovy con recursividad de pila y acumulativa.
//  Usadla para calcular la suma de los numeros pares de una lista
def list1 = [1,2,3,4,5,6]
def void_list = []

isPar = {number -> (number%2==0)?1:-1}

def filterreduce1(list, ret_list){
	if(list==[]){
		ret_list
	}
	else{
		if(isPar(list[0])==1)
			ret_list<<list[0]
		filterreduce1(list.tail(), ret_list)
	}
	ret_list
}

println filterreduce1(list1, void_list)

println "EX6.2"

void_list = []

def filterreduce2(list, ret_list){
	if(list == []){
		ret_list
	}
	else{
		if(isPar(list[-1])==1){
			ret_list<<list[-1]
		}
		filterreduce2(list-list[-1], ret_list)
	}
	ret_list
}
println filterreduce2(list1, void_list)

println "------------------------------------------------"
println "------------------------------------------------"
println "------------------------------------------------"
println "------------------------------------------------"

println "Ejercicio 2. Solo declaradas las clases."
// Ejercicio 2. Implementar un árbol de ficheros y directorios en Groovy. Un directorio contiene ficheros y directorios.
// Un fichero tiene un nombre y un tamaño. Un directorio tiene un nombre y una lista de ficheros y directorios.
// a) Queremos una funcion que planarice el arbol a una lista.
// b) Añadir una funcion reduce al arbol que permita aplicarle una función y obtener un resultado. Usadla para
// obtener el fichero mas grande del arbol
// c) Añade el método toList usando metaprogramming	metaClass.class = toList
// d) Añade el método toList usando Traits.

class File extends Directory{
	def name
	def length

	def String toString(){
		'file: '+name+'||size: '+length+'KB.'
	}
}

class Directory{
	def name
	def list

	def String toString(){
		"Directory: "+name+"."
	}

}

file1 = new File(name:'test', length:10)
file2 = new File(name:'test', length:10)
file3 = new File(name:'test', length:10)
file4 = new File(name:'test', length:10)
directory1 = new Directory(name:'usr', list:[file1])
directory3 = new Directory(name:'bin', list:[file4])
directory2 = new Directory(name:'root', list:[directory1, directory3, file2, file3])
tree=directory2
ret_list_folder = []
def allToList(tree, ret_list_folder){
	ret_list_folder<<tree.name
}
//println allToList(tree)






















