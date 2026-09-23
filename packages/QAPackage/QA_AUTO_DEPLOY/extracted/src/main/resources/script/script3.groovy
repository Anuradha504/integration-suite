import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {
    message.setProperty("artifactId", "Order_iFlow")
    return message
}