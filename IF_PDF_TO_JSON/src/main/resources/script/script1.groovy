import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonOutput

def Message processData(Message message) {

    String text = message.getBody(String)

    List<Map<String, Object>> books = []

    String[] sections = text.split(/(?=Book ID:\s*)/)

    sections.each { String section ->

        String cleanSection = section.trim()

        if (cleanSection.startsWith("Book ID:")) {

            Map<String, Object> book = [:]

            def bookIdMatcher = cleanSection =~ /(?m)Book ID:\s*(.+)/
            def titleMatcher = cleanSection =~ /(?m)Title:\s*(.+)/
            def authorMatcher = cleanSection =~ /(?m)Author:\s*(.+)/
            def categoryMatcher = cleanSection =~ /(?m)Category:\s*(.+)/
            def priceMatcher = cleanSection =~ /(?m)Price:\s*(.+)/
            def yearMatcher = cleanSection =~ /(?m)Published Year:\s*(.+)/

            if (bookIdMatcher.find()) {
                book.put("bookId", bookIdMatcher.group(1).trim())
            }

            if (titleMatcher.find()) {
                book.put("title", titleMatcher.group(1).trim())
            }

            if (authorMatcher.find()) {
                book.put("author", authorMatcher.group(1).trim())
            }

            if (categoryMatcher.find()) {
                book.put("category", categoryMatcher.group(1).trim())
            }

            if (priceMatcher.find()) {
                book.put("price", priceMatcher.group(1).trim().toInteger())
            }

            if (yearMatcher.find()) {
                book.put("publishedYear", yearMatcher.group(1).trim().toInteger())
            }

            books.add(book)
        }
    }

    Map<String, Object> output = [
        books: books
    ]

    String jsonOutput = JsonOutput.prettyPrint(
        JsonOutput.toJson(output)
    )

    message.setBody(jsonOutput)

    return message
}