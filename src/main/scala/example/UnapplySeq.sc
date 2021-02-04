
// unapplySeq allows you to extract values from sequences. Lists etc have this by defauly
// but you can use it to make your own custom behaviour
class SyList[A](val items: A*)

object SyList {
  def apply[A](items: A*) = new SyList(items)

  def unapplySeq[A](list: SyList[A]): Option[Seq[A]] =
    if (list.items.isEmpty) None else Some(list.items)
}

val x = SyList(1, 2, 3, 4)

val SyList(Seq(first, _, third, _*)) = x

x match {
  case SyList(Seq(first, second, _*)) => println(s"first: $first, second: $second")
  case _ => println("Oops")
}