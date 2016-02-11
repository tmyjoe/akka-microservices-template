package com.tmyjoe.akka

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

/**
  * @author tmyjoe
  */
class SampleModule extends AbstractModule with ScalaModule {
  override protected def configure() {
//    bind(classOf[Service]).to(classOf[RealService])
  }
}
