/import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def token = message.getHeader("X-CSRF-Token", String)

    message.setProperty("csrfToken", token)

    return message
}