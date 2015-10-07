/**
 * Created by pedro on 09/10/14.
 */

def marks = [:]
marks['pepe']=2

new File('tap.txt').eachLine { line ->
    student = line.split(',')
    scores = student[1..-1].collect({it.toInteger()})
    marks[student[0]]= (scores[0]+scores[1]+scores[2])/3
}

marks.each {k,v->println k + ':' + v}