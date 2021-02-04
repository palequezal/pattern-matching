// Funky unapply uses


// Creating boolean constraints
object StartsWithA {
  def unapply(value: String): Boolean = value head match {
    case 'A' | 'a' => true
    case _ => false
  }
}

object StartsWithB {
  def unapply(value: String): Boolean = value head match {
    case 'B' | 'b' => true
    case _ => false
  }
}

val str = "Adams"

str match {
  case StartsWithA() => println("Starts with A")
  case StartsWithB() => println("Starts with B")
  case _ => println("Starts with neither A or B")
}


// Creating constraints that extract values
object SingleDigit {
  def unapply(value: Int): Option[String] = value match {
    case x if x >= 0 && x < 10 => Some("Single digit")
    case _ => None
  }
}


object Even {
  def unapply(value: Int): Option[String] = value match {
    case x if x % 2 == 0 => Some ("Even")
    case _ => None
  }
}

val answer = 1 match {
  case SingleDigit(x) => x
  case Even(x) => x
}

println(answer)

// Creating more sophisticated matchers
object ServerError {
  val InternalServerError = 500
  val NotImplemented = 501
  val badGateway = 502
  val serviceUnavailable = 503
  val gatewayTimeout = 504

  def unapply(status: Int): Option[String] = status match {
    case InternalServerError => Some("Internal Server Error") // Why is this the case?
    case NotImplemented => Some("Not implemented - this shouldn't happen!")
    case `badGateway` | `serviceUnavailable` | `gatewayTimeout` => Some("Issue with downstream service")
    case _ => None
  }
}

object UserError {
  val badRequest = 400
  val Forbidden = 403
  val notFound = 404

  def unapply(status: Int): Option[String] = status match {
    case `badRequest` => Some("You've provided some nonsense or something")
    case Forbidden => Some("YOUUUU SHALLL NOT PAAAAAAAASSSSSSSSSS!")
    case `notFound` => Some("This doesn't exist")
    case _ => None
  }
}

val status = 401

val response = status match {
  case UserError(message) => message
  case ServerError(message) => message
  case _ => "Some other status"
}

println(response)