import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {
    // Read the body from the input message
    def body = message.getBody(String)
    
    // Read the property "payload"
    def payload = message.getProperty("payload")
    
    // Create the new body structure
    def newBody = """
        ${payload}
        <Error>${body}</Error>
    """
    
    // Set the new body to the message
    message.setBody(newBody.trim())
    
    return message
}
