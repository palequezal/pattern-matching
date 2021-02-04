// Under the hood of Case classes

//case class Person(name: String, age: Int)
class Person(val name: String, val age: Int)

object Person {
  def apply(name: String, age: Int): Person = new Person(name, age)

  def unapply(person: Person): Option[(String, Int)] =
    Some((person.name, person.age))
}

val person = Person("Simon", 21)  // Wink ;)

person match {
  case Person(name, age) => println(s"$name is $age years old... No really!")
  case _ => println("Not a person!")
}

