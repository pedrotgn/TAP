/**
 * Created by pedro on 9/5/14.
 */
def  m = [1:'tap', 2: 'sd', 3: 'sob']
println m.getClass()  //  java.util.LinkedHashMap
println m[1]
m[66] = "new"
m['test'] = 34
for (elem  in m)
    println elem.getKey() + " " +  elem.getValue()

def m2 = [:]