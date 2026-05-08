import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    // Save Base64 body into property
    message.setProperty(
        "base64Content",
        message.getBody(String)
    )

    return message
}