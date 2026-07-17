import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.*

def Message processData(Message message) {
    // Read the body from the input message
    def input = message.getBody(String)
    def body = input.replaceAll("[<>&]", "")
    
    // Read the property "payload"
    def payload = message.getProperty("payload")
    def processedPayload = payload?.replaceFirst(/<\?xml version=['"].*?['"] encoding=['"].*?['"]\?>/, "").trim()
    
    // Create the new body structure
    def newBody = """<MessageProcessingLogs>
        ${processedPayload}
        <Error>${body}</Error></MessageProcessingLogs>
    """
    
    // Set the new body to the message
    message.setBody(newBody.trim())
    
    return message
}