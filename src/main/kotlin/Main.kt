import com.primogemstudio.live2dbase.MocDataInputStream
import java.nio.file.Files
import kotlin.io.path.Path

fun main(args: Array<String>) {
    val s = MocDataInputStream(Files.newInputStream(Path("E:/mmd/live2d/nahida/example.moc3")))
    val model = s.readMoc()
    println(model)
}