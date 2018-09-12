import akka.actor._

class Hello extends Actor{
    override def receive: Receive = {
        case "hello" => println("Hello world")
        case "create" => {
            val c = context.actorOf(Props.empty,"hello2")
            print(s"$c")
        }
        case _ => println("undefined")
    }
}
//preStart, postStop
object Hello{
    def main(args: Array[String]): Unit = {
        val system = ActorSystem("HelloSystem")
        val act = system.actorOf(Props[Hello],"act")
        act ! "hello"
        act ! "lol"
        act ! "create"
    }
}