/**
 * Created by pedro on 10/09/14.
 */

import groovy.transform.TailRecursive

@groovy.transform.TailRecursive
def tlength(acc,list){
    (list==[])?acc: tlength(acc+1, list.tail())
}

println tlength(0,1..30000)