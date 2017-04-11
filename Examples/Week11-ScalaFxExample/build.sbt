name := "Week11-ScalaFxExample"

version := "1.0"

scalaVersion := "2.12.1"

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.102-R11"

// Add dependency on JavaFX library based on JAVA_HOME variable
unmanagedJars in Compile += Attributed.blank(file(System.getenv("JAVA_HOME") + "/jre/lib/jfxrt.jar"))