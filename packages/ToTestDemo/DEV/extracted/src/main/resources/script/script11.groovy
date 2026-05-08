import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def fileName = message.getHeader("CamelFileName")
    message.setProperty("debugFileName", fileName)

    return message
}