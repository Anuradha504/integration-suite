import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def newHeaders = [:]
    message.setHeaders(newHeaders)

    return message
}