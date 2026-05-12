import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {
    def zipBytes = message.getProperty("zipBinary")

    if (zipBytes == null) {
        throw new Exception("zipBinary property is NULL")
    }

    message.setBody(zipBytes)
    return message
}