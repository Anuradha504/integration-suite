import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def ex = message.getProperty("CamelExceptionCaught")

    if (ex != null) {
        message.setProperty("ErrorMessage", ex.getMessage())
    } else {
        message.setProperty("ErrorMessage", "Unknown Error")
    }

    return message
}