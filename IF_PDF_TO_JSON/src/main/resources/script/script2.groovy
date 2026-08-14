import com.sap.gateway.ip.core.customdev.util.Message
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.util.PDFTextStripper

def Message processData(Message message) {

    def attachments = message.getAttachments()

    if (attachments == null || attachments.isEmpty()) {
        message.setBody("NO ATTACHMENT FOUND")
        return message
    }

    def pdfAttachment = null

    attachments.each { name, attachment ->
        if (name.toLowerCase().endsWith(".pdf")) {
            pdfAttachment = attachment
        }
    }

    if (pdfAttachment == null) {
        message.setBody("NO PDF ATTACHMENT FOUND")
        return message
    }

    InputStream inputStream = pdfAttachment.getInputStream()
    PDDocument document = null

    try {
        document = PDDocument.load(inputStream)

        PDFTextStripper stripper = new PDFTextStripper()

        String text = stripper.getText(document)

        message.setBody(text)

    } finally {
        if (document != null) {
            document.close()
        }

        inputStream.close()
    }

    return message
}