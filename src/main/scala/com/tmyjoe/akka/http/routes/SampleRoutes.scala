package com.tmyjoe.akka.http.routes

import akka.http.scaladsl.server.Directives._

/**
  * @author tmyjoe
  */
trait SampleRoutes extends BaseServiceRoute {

  val sampleRoute = pathPrefix("sample") {
    path("hello") {
      pathEndOrSingleSlash {
        get {
          complete("Hello")
        }
      }
    }
  }
}
