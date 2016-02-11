package com.tmyjoe.akka.http

import akka.http.scaladsl.server.Directives._
import com.tmyjoe.akka.http.routes.{SampleRoutes}
import com.tmyjoe.akka.support.CorsSupport

trait HttpService extends CorsSupport with SampleRoutes {

  val routes = pathPrefix("v1") {
    corsHandler {
      sampleRoute
    }
  }
}
