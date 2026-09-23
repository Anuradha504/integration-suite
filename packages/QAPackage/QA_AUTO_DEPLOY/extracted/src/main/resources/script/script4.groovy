import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {
    message.setHeader("Content-Type", "application/json")
    message.setHeader("Accept", "application/json")
    return message
}