import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def reader = message.getBody(java.io.Reader)
    def xml = new XmlSlurper().parse(reader)

    def version = xml.'**'.find { it.name() == 'Version' }?.text()

    message.setProperty("version", version)

    return message
}