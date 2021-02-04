// matching on ints

val n: Int = 1

n match {
  case 1 => println("One")
  case 2 =>  println("Two")
  case _ => println("Some other number")
}

// Type guards
val something: Any = 6

something match {
  case int: Int => println(s"It's an int: $int")
  case int: Int if int > 5 => println(s"It's an int greater than 5: $int")
  case str: String => println(s"It's a string: $str")
  case _ => println("I don't know what it is...")
}

// Avoiding match errors
val n2 = 4

n2 match {
  case 3 => println("It's 3")
  case _ => println("Phew")
}

// Don't do silly things

val isTrue = true

isTrue match {
  case true => println("It's TRUE that this works... But it's dumb")
  case false => println("It's FALSE that you should write code like this")
}

// do this instead - yes, it's idiomatic in Scala
if (isTrue) println("Simon will like you for this")
else println("Still not a good reason for using pattern matching here")
