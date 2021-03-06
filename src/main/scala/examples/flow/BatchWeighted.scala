package examples.flow

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source

/**
  * Created by aaron.nordyke on 5/23/17.
  */
object BatchWeighted {

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("flow")
    implicit val materializer = ActorMaterializer()
    implicit val ec = system.dispatcher

    Source(1 to 10)
      .batchWeighted(max = 3, _ ⇒ 4, seed = i ⇒ i)(aggregate = _ + _)
      .map { i => Thread.sleep(10); i}
      .runForeach(println)

  }
}
