import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def pkg = message.getProperty("packageId")

    if (!pkg) {
        throw new Exception("packageId is NULL")
    }

    pkg = pkg.trim()   

    message.setProperty("packageId", pkg)

    return message
}