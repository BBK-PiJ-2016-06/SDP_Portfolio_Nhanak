name := "Week09-AkkaTutorial"

version := "1.0"

scalaVersion := "2.12.1"

resolvers ++=
  Seq("repo" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies ++= {

  val akkaVersion = "2.4.17"

  Seq("com.typesafe.akka" %% "akka-actor" % "2.4.17",
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.1.2"
  )
}