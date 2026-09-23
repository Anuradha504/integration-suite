import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def token = message.getHeader("X-CSRF-Token", String)
    def cookies = message.getHeaders().get("Set-Cookie")

    def cookieString = ""

    if (cookies instanceof List) {
        cookieString = cookies.collect { it.split(";")[0] }.join("; ")
    } else if (cookies != null) {
        cookieString = cookies.toString().split(";")[0]
    }

    message.setProperty("csrfToken", token)
    message.setProperty("sessionCookie", cookieString)

    return message   
}