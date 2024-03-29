version := "0.0.1"
organization:= "com.yen"
name := "RedditScrapper"
scalaVersion := "2.11.8"

val sparkVersion = "2.4.3"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(

  // spark-core
  "com.typesafe" % "config" % "1.2.1", 
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.scalactic" %% "scalactic" % "3.1.0",
  "org.apache.spark" %% "spark-sql" % sparkVersion,

  // test
  "org.scalatest" %% "scalatest" % "3.1.1" % "test",

  // json op
  // https://index.scala-lang.org/spray/spray-json/spray-json/1.2.5?target=_2.10
  "io.spray" %%  "spray-json" % "1.3.6",
  "com.typesafe.play" %% "play-json" % "2.6.13"
  //"org.json4s" %% "json4s-jackson"
)

dependencyOverrides ++= {
  Seq(
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.6.7.1",
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.7",
    "com.fasterxml.jackson.core" % "jackson-core" % "2.6.7"
  )
}

conflictManager := ConflictManager.latestRevision

assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}