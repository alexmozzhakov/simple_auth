import io.javalin.Javalin
import java.util.logging.Level
import java.util.logging.Logger

var logger: Logger = Logger.getAnonymousLogger()
fun main(args: Array<String>) {
    val app = Javalin.start(7000)
    app.post("/login") { handler ->
        val password = handler.formParam("pass")
        val login = handler.formParam("login")
        val userAgent = handler.userAgent()
        logger.log(Level.INFO, "Tried to login with $login:$password with User-Agent:$userAgent")
        handler.result(when {
            isCorrectLoginInfo(login, password, userAgent) -> "login successful"
            else -> "login failed"
        })
    }
    app.get("/") { ctx -> ctx.result("I'm up and running") }
}

fun isCorrectLoginInfo(login: String?, password: String?, ua: String?): Boolean {
    return login.equals("root") && password.equals("password") && ua.equals("Specific UA/1.0")
}