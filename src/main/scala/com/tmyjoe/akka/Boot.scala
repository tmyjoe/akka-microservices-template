package com.tmyjoe.akka

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.tmyjoe.akka.http.HttpService
import com.tmyjoe.akka.support.Config

import scala.concurrent.ExecutionContext

/**
  * @author tmyjoe
  */
object Boot extends App with Config with HttpService {
  private implicit val system = ActorSystem()

  override protected implicit val executor: ExecutionContext = system.dispatcher
  override protected val log: LoggingAdapter = Logging(system, getClass)
  override protected implicit val materializer: ActorMaterializer = ActorMaterializer()

  val serverBindingsFuture = Http().bindAndHandle(routes, httpInterface, httpPort)
  serverBindingsFuture.onFailure { case e =>
    log.error(s"Server binding failed with ${e.getMessage}")
    system.shutdown()
  }
}
