// WEIRD SYMBOLS

val n = 5

// guards
val result = n match {
  case something if something > 4 => s"$something was greater than 4"
  case something => s"$something was less than or equal to 4"
}

println(result)

val list: List[Int] = List(2,3,4,5)

val result2 = list match {
  // Match on an empty list
  case Nil => "list was empty"

  // You can use '@' to give a variable name for the value that is being matched so you can use it
  case firstFourInts @ List(1, 2, 3 ,4, _*) => s"This list contained the first four ints. See? $firstFourInts"

  // '::' can be used to create a list. How it is used below you can give a name to the head and the tail
  case head :: tail => s"the first element in the list is $head, the last is ${tail.last}"

  // You can also use '::' to match on the whole list,
  // but to do so it must end in Nil (a list ends when the tail is Nil)
  case 2 :: 3 :: 4 :: 5 :: Nil => s"2 to 5"

  // _* matches on the rest of a sequence, so below we extract the second item in the list
  case List(_, second, _*) => s"the second element is $second"
  case _ => "Something else"
}

println(result2)

