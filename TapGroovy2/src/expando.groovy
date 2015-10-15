String.metaClass.swapCase = {->
      def sb = new StringBuffer()
      delegate.each {
           sb << (Character.isUpperCase(it as char) ? Character.toLowerCase(it as char) : 
                   Character.toUpperCase(it as char))
      }
      sb.toString()
}

def s = "pero que bueno"
println s.swapCase()

class Book {
    String title
}
Book.metaClass.constructor << { String title -> new Book(title:title) }


def b = new Book("The Stand")


