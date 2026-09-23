import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonOutput

def Message processData(Message message) {

    def base64 = message.getBody(String)

    def artifactId = message.getProperty("artifactId")
    def packageId = message.getProperty("packageId")

    def json = [
        Name: artifactId,
        Id: artifactId,
        PackageId: packageId,
        ArtifactContent: base64
    ]

    message.setBody(JsonOutput.toJson(json))

    return message
}