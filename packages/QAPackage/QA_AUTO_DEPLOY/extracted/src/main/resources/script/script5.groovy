import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def content = message.getBody(String)

    content = content.replaceAll("\\r|\\n", "")

    message.setProperty("zipBase64", content)
    message.setBody(content)

    return message
}