/**
 * Created by pedro on 10/09/14.
 */

[1,2,3,4,5,6].join()  // '123456'
[1,2,3,4,5,6].join('-') // '1-2-3-4-5-6'
'TAP is my favourite course'.split() // ['TAP','is','my', …]
'SD is good, TAP is better'.split(',')  // ['SD is OK','TAP is good']
[4,2,5,7].sort() // [2,4,5,7]
['abc', 'z', 'xyzuvw', 'Hello', '321'].sort{ it.size() }
//  [z, abc, 321, Hello, xyzuvw]
def list2= [7,4,-6,-1,11,2,3,-9,5,-13]
println list2.sort{a,b-> a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 }

def incr = {it +1}

list3 = [1,2,3,4,5].collect(incr)
println list3

list4 = [1,2,3,4,5].findAll({it%2==0})
println list4

def suma = {x,y->x+y}

list5 = [1,2,3,4,5].inject(suma)
println list5

list6 = [1,2,3,4,5].inject(1,suma)
println list6
