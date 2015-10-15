/**
 * Created by pedro on 09/09/14.
 */

def f = {1/0}

def f2 = {func,val ->
    (val==1)?1:func()
}

f2(f,1)
//f2(f,0)    //????