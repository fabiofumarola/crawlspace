import com.typesafe.sbt.SbtAspectj._

name := """crawlspace"""

version := "1.0"

scalaVersion := "2.11.4"

libraryDependencies ++= {
  val kamonVersion = "0.3.4"
  val akkaVersion = "2.3.8"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "ch.qos.logback" % "logback-classic" % "1.1.2",
    "io.kamon" %% "kamon-core" % kamonVersion,
    "io.kamon" %% "kamon-statsd" % kamonVersion,
    "io.kamon" %% "kamon-log-reporter" % kamonVersion,
    "io.kamon" %% "kamon-system-metrics" % kamonVersion,
    "org.aspectj" % "aspectjweaver" % "1.8.1"
  )
}

aspectjSettings

javaOptions <++= AspectjKeys.weaverOptions in Aspectj

fork in run := true