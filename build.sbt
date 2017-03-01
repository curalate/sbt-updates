sbtPlugin := true

name := "sbt-updates"
organization := "com.timushev.sbt"

scalacOptions := Seq("-deprecation", "-unchecked", "-feature")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

scriptedSettings

enablePlugins(GitVersioning)
git.versionProperty := "version"
git.useGitDescribe := true
git.gitTagToVersionNumber := {
  case VersionNumber(Seq(x, y, z), Seq(), Seq()) => Some(s"$x.$y.$z")
  case VersionNumber(Seq(x, y, z), Seq(since, commit), Seq()) => Some(s"$x.$y.${z + 1}-$since+$commit")
  case _ => None
}
