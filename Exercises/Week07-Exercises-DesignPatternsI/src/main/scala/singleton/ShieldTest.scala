package singleton

/**
  * Created by nathanhanak on 2/23/17.
  */
object ShieldTest extends App {

  private val pg: PowerGenerator = new PowerGenerator
  private val eZPg: PowerGenerator = new PowerGenerator

  println("scanning for danger")
  LazyShield.scan(pg)
  println("Incoming comet, raising shield")
  val shield = LazyShield.getInstance(pg)
  println("are we safe? checking isProtecting")
  shield.isProtecting()
  println("trying to scan now")
  LazyShield.scan(pg)

  EagerShield
}
