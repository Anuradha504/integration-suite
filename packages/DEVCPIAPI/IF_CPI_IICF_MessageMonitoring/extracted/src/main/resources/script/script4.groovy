import com.sap.gateway.ip.core.customdev.util.Message
import groovy.util.XmlSlurper

def Message processData(Message message) {
    // Get the message body as String
    def body = message.getBody(String)
    int failure= '0'
    int nonfailure= '0'

    
    // Parse the XML content
    def xml = new XmlSlurper().parseText(body)
    
    // Find all <Status> elements
    def statusList = xml.'**'.findAll { it.name() == 'Status' }
    
    // Count Status = 'FAILED'
    def failedCount = statusList.count { it.text() == 'FAILED' }
    
    // Count Status != 'FAILED'
    def notFailedCount = statusList.count { it.text() != 'FAILED' }
    
    // Log the counts
    message.setProperty("FAILED_COUNT", failedCount)
    message.setProperty("NOT_FAILED_COUNT", notFailedCount)
    
    // Optionally print to the console/log for debugging
    println "Count of Status = FAILED: ${failedCount}"
    println "Count of Status != FAILED: ${notFailedCount}"


    return message
}
