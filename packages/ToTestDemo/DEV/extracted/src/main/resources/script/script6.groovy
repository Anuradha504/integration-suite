import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonOutput

def Message processData(Message message) {

    def artifactId  = message.getProperty("artifactId")
    def packageId   = message.getProperty("packageId")
    def version     = message.getProperty("version")
    def triggeredBy = message.getProperty("triggeredBy")

    def metadata = [
        artifactId : artifactId,
        packageId  : packageId,
        version    : version,
        triggeredBy: triggeredBy,
        timestamp  : new Date().format("yyyy-MM-dd'T'HH:mm:ss'Z'"),
        target     : "QA"
    ]

    def json = JsonOutput.prettyPrint(JsonOutput.toJson(metadata))

    // store pretty JSON (for readability/debug)
    message.setProperty("metadataRaw", json)

    return message
}