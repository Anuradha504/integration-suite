import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def zipBytes = message.getBody(byte[])
    message.setBody(zipBytes)

    return message
}