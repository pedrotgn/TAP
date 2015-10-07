/**
 * Created by pedro on 06/11/14.
 */

enum Gang  {PP, PSOE, IU, CIU, ERC}

class Corrupt {
    def String name
    def Gang party

    def static hi(){
        println 'I am corrupt'
    }

    def colleague(corrupt){
        corrupt.party==this.party
    }

    def String toString(){
        'name:'+ name
    }

}

def hello = Corrupt.&hi
acebes = new Corrupt(name:'acebes',party:Gang.PP)
nicolas = new Corrupt(name:'nicolas',party:Gang.PP)

def mafia = acebes.&colleague

if (mafia(nicolas))
    println 'My friend !!'

pujol = new Corrupt(name:'pujol',party:Gang.CIU)

def corrupts = [acebes,nicolas,pujol]

println corrupts.findAll(mafia)




