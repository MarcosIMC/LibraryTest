import Util.Setup

class Book(var title: String, var isbn: Long, var pages: Int, var stock: Int) {

    fun editBookWith(isbn: Long, params: Array<String>, listOfBook: MutableList<Book>) {
        var bookToEdit = listOfBook.filter { book: Book -> book.isbn == isbn }
        if (!bookToEdit.isEmpty()) {
            var book: Book = bookToEdit.first()
            book.title = params[0]
            book.isbn = isbn
            book.pages = params[1].toInt()
            book.stock = params[2].toInt()

            val oldBookIndex: Int = listOfBook.indexOf(bookToEdit.first())
            listOfBook[oldBookIndex] = book
        }
    }

    override fun toString(): String {
        return "Title:$title \n" +
                "ISBN: $isbn \n" +
                "Pages: $pages \n" +
                "Stock: $stock\n"
    }

}