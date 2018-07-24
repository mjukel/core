name := "core"

//version := "2017.12.0-SNAPSHOT"

enablePlugins(ScalaJSPlugin)


val scala212 = "2.12.6"

scalaVersion := scala212

crossScalaVersions := Seq(scala212)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions"
)

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value % Provided

//bintray
resolvers += Resolver.jcenterRepo

organization := "scalajs-plus"

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

bintrayOrganization := Some("scalajs-plus")

bintrayRepository := "maven"


publishArtifact in Test := false

//Test
resolvers += Resolver.bintrayRepo("scalajs-react-interface", "maven")
resolvers += Resolver.bintrayRepo("scalajs-jest", "maven")

scalaJSUseMainModuleInitializer in Test := true

scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.CommonJSModule).withSourceMap(false))

val TEST_FILE = s"./sjs.test.js"

artifactPath in Test in fastOptJS := new File(TEST_FILE)
artifactPath in Test in fullOptJS := new File(TEST_FILE)

val testDev = Def.taskKey[Unit]("test in dev mode")
val testProd = Def.taskKey[Unit]("test in prod mode")

testDev := {
  (fastOptJS in Test).value
  runJest()
}

testProd := {
  (fullOptJS in Test).value
  runJest()
}

def runJest() = {
  import sys.process._
  val jestResult = "npm test".!
  if (jestResult != 0) throw new IllegalStateException("Jest Suite failed")
}


libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.4" % Test,
  "scalajs-jest" %%% "core" % "2018.2.2-RC" % Test
)

scalaJSStage in Global := FastOptStage
