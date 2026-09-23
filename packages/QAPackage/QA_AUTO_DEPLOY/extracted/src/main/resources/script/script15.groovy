import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def Message processData(Message message) {

    // Read GitHub API response
    def reader = message.getBody(java.io.Reader)
    def json = new JsonSlurper().parse(reader)

    // Extract Base64 content
    def base64Content = json.content

    if (!base64Content) {
        throw new Exception("GitHub content field is EMPTY")
    }

    // Remove line breaks
    base64Content = base64Content.replaceAll("\\n", "")

    // Decode Base64
    def decoded = new String(base64Content.decodeBase64(), "UTF-8")

    // Parse decoded metadata.json
    def meta = new JsonSlurper().parseText(decoded)

    // Extract values
    def artifactId = meta.artifactId?.toString()?.trim()
    def packageId = meta.packageId?.toString()?.trim()

    if (!artifactId) {
        throw new Exception("artifactId NOT FOUND in decoded metadata")
    }

    // Store properties
    message.setProperty("artifactId", artifactId)
    message.setProperty("packageId", packageId)

    // Optional
    message.setBody(decoded)

    return message
}