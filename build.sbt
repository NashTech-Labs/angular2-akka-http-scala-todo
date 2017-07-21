import BuildSettings._
import Dependencies._

def compile(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")

def provided(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")

def test(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

lazy val root = Project("Todo", file("."))
.aggregate(tBackend, tFrontend)

lazy val tBackend = Project("t-backend", file("t-backend"))
  .settings(basicSettings: _*)
  .settings(libraryDependencies ++= compile(akkaHttp, circeCore, circeParser, circeGeneric, hikariCP, slick, scalaGuice))

lazy val tFrontend = Project("t-frontend", file("t-frontend"))
