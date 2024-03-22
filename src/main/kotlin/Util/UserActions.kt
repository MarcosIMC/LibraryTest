package Util

import Book
import User

class UserActions {
    val setup = Setup()
    val messages = Messages()
    init {
        setup.books()
        setup.users()
    }

    fun listAllBooks(): String {
        var result = ""
        for (book in setup.listOfBooks()) {
            result += book.toString()+"\n"
        }
        return result
    }

    fun booksRented(email: String): String {
        var result = ""
        val user: User = setup.listOfUsers.filter { user: User -> user.email == email }.first()
        if (!user.books.isEmpty()) {
            for (book in user.books) {
                result += book.toString()
            }
        } else {
            return messages.dontHaveBooksRented
        }
        return result
    }

    fun rentABook(email: String): Boolean {
        val message = Messages()
        println(message.insertIsbn)
        val isbn = readln().toLong()
        val book = setup.listOfBooks().filter { book: Book -> book.isbn == isbn }.first()

        if (book != null && book.stock > 0) {
            val user = setup.listOfUsers().filter { user: User -> user.email == email }.first()
            user.books.add(book)
            book.stock -= 1
            val params: Array<String> = arrayOf(book.title, book.pages.toString(), book.stock.toString())
            book.editBookWith(book.isbn, params, setup.listOfBooks())
            println(message.bookRented)
            return true
        }
        println(message.bookCantRented)
        return false
    }

    fun returBook(email: String, isbn:Long): Boolean {
        val user = setup.listOfUsers().filter { user: User -> user.email == email }.first()
        if (user.books.count() > 0) {
            val bookToReturn = user.books.filter { book: Book -> book.isbn == isbn }.first()
            user.books.remove(bookToReturn)
            bookToReturn.stock++
            val params: Array<String> = arrayOf(bookToReturn.title, bookToReturn.pages.toString(), bookToReturn.stock.toString())
            bookToReturn.editBookWith(isbn, params, setup.listOfBooks())

            return true
        }
        return false
    }

    fun editProfile(email: String): Boolean {
        val messages = Messages()
        println(messages.insertName)
        val name = readln()
        println(messages.insertSurname)
        val surname = readln()
        println(messages.insertAge)
        val age = readln().toInt()
        println(messages.insertNewEmail)
        val email = readln()

        val user = User(name, surname, age, email, mutableListOf())
        return user.edit(user, email, setup.listOfUsers())
    }

    fun exit() {
        System.exit(0)
    }
}