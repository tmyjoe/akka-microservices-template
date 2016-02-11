name         := "akka-sample-service"
organization := "com.tmyjoe"
version      := "1.0"
scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV       = "2.4.1"
  val akkaStreamV = "2.0.1"
  val scalaTestV  = "2.2.5"
  val slickVersion     = "3.1.0"
  Seq(
    "com.typesafe.akka" %% "akka-actor"                           % akkaV,
    "com.typesafe.akka" %% "akka-stream-experimental"             % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-core-experimental"          % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-experimental"               % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental"    % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-testkit-experimental"       % akkaStreamV,
    "com.typesafe.slick" %% "slick"                                % slickVersion,
    "mysql" % "mysql-connector-java" % "5.1.36",
    "net.codingwell" %% "scala-guice" % "4.0.1",
    "org.scalatest"     %% "scalatest"                            % scalaTestV % "test"
  )
}

Revolver.settings
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

dockerExposedPorts := Seq(9000)

dockerEntrypoint := Seq("bin/%s" format executableScriptName.value, "-Dconfig.resource=docker.conf")