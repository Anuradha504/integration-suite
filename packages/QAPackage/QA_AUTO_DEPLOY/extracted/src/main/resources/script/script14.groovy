import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def zipBinary = message.getProperty("zipBinary")
    message.setBody(zipBinary)

    return message
}