class APerson {
   String name = "Fred"
}

def methodName = "Bob"

APerson.metaClass."changeNameTo${methodName}" = {-> delegate.name = "Bob" }

def p = new APerson()

assert "Fred" == p.name

p.changeNameToBob()

assert "Bob" == p.name