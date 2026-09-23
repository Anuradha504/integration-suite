import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    // 1. Clear body
    message.setBody(null)

    // 2. Remove only problematic HTTP headers
    message.setHeader("CamelHttpUri", null)
    message.setHeader("CamelHttpPath", null)
    message.setHeader("CamelHttpQuery", null)
    message.setHeader("CamelHttpMethod", null)
    message.setHeader("Content-Type", null)

    return message
}