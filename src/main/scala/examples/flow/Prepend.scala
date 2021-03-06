package examples.flow

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

/**
  * Created by aaron.nordyke on 5/23/17.
  */
object Prepend {

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("zip")
    implicit val materializer = ActorMaterializer()

    Source(5 to 8)
      .prepend(Source(1 to 3))
      .runForeach(println)
  }
}
