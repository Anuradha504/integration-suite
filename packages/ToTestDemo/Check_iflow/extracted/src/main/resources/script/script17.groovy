import com.sap.gateway.ip.core.customdev.util.Message

def Message processData(Message message) {

    def fileName =
            message.getHeader("SapZipEntryName", String) ?:
            message.getHeader("CamelFileName", String) ?:
            message.getHeader("CamelFileNameOnly", String)

    def packageId = message.getProperty("packageId")

    // fallback if null
    def iflowName = message.getProperty("iflowName")

    if(iflowName == null || iflowName.trim().isEmpty()) {
        iflowName = "Check_iflow"
    }

    def filePath =
            "packages/" +
            packageId +
            "/" +
            iflowName +
            "/extracted/" +
            fileName

    message.setProperty("filePath", filePath)

    return message
}