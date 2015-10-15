class IPerson {
   String name = "Fred"
}

IPerson.metaClass.getProperty = { String name ->
   def metaProperty = Person.metaClass.getMetaProperty(name)
   def result
   if(metaProperty) result = metaProperty.getProperty(delegate)
   else {
      result = "Flintstone"
   }
   result
}

def p = new IPerson()

assert "Fred" == p.name
assert "Flintstone" == p.other