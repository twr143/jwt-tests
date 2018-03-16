import Dependencies._
import sbt._
import Keys._
import Tests._
import scala.sys.process._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.4",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "jwt-tests",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.jmockit" % "jmockit" % "1.8" % Test,
    libraryDependencies += "junit" % "junit" % "4.11" % Test,
      libraryDependencies ++= Seq(
      "com.pauldijou" %% "jwt-core" % "0.16.0",
      "com.pauldijou" %% "jwt-core-legacy" % "0.16.0"
    )
  )
resolvers ++= Seq(
  "mvn central" at "http://central.maven.org/maven2/"
)