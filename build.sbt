organization := "io.github.retronym"

name := "java9-rt-export"

autoScalaLibrary := false

crossPaths := false

description := "Exports the contents of the Java 9 / JEP-220 runtime image to a JAR for compatibility with older tools."

homepage := Some(url("http://github.com/retronym/" + name.value))

startYear := Some(2017)

licenses +=("Scala license", url(homepage.value.get.toString + "/blob/master/LICENSE"))
