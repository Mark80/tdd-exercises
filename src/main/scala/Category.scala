


trait GenericCategory[->>[_, _]] {

  def id[A]: A ->> A

  def compose[A, B, C](f: A ->> B, g: B ->> C): A ->> C

}

object Category extends GenericCategory[Function] {

  override def id[A]: A => A = a => a

  override def compose[A, B, C](f: A => B, g: B => C): A => C = g compose f

}


trait GenericFunctor[->>[_, _], ->>>[_, _], F[_]] {

  def fmap[A, B](f: A ->> B): F[A] ->>> F[B]

}


trait Functor[F[_]] extends GenericFunctor[Function, Function, F] {

  final def fmap[A, B](as: F[A])(f: A => B): F[B] = fmap(f)(as)


}

object ListFunctor extends Functor[List] {


  override def fmap[A, B](f: A => B): List[A] => List[B] = as => as map f


}

object Functor {

  def fmap[A, B, F[_]](as: F[A])(f: A => B)(implicit functor: Functor[F]): F[B] =
    functor.fmap(as)(f)

  implicit object ListFunctor extends Functor[List] {
    def fmap[A, B](f: A => B): List[A] => List[B] =
      as => as map f
  }

}




