/**
 * Created by pedro on 09/10/14.
 */


def text = new File('tap.txt').text

//print text

new File('tap.txt').eachLine { line ->
    println 'line:' + line
}


