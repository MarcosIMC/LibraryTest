package Util

import Book
import User

class AdminActions {
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

    fun addNewBook(book: Book): Boolean {
        return setup.listOfBooks.add(book)
    }

    fun deleteBook(isbn: Long): Boolean {
        val book = setup.listOfBooks.filter { book: Book -> book.isbn == isbn }.first()
        return setup.listOfBooks.remove(book)
    }

    fun editBook(isbn: Long, newBook: Book): Boolean {
        val listOfQuery = setup.listOfBooks.filter { book: Book -> book.isbn == isbn }
        if (!listOfQuery.isEmpty()) {
            val bookToEdit = listOfQuery.first()
            val indexOfBook = setup.listOfBooks.indexOf(bookToEdit)
            setup.listOfBooks[indexOfBook] = newBook
            return true
        }
        return false
    }

    fun listAllUsers(): String {
        var result = ""
        for (user in setup.listOfUsers()) {
            result += user.toString()+"\n"
        }
        return result
    }

    fun addNewUser(user: User): Boolean {
        return setup.listOfUsers.add(user)
    }

    fun deleteUser(emailUser: String): Boolean {
        val userToDeleteList = setup.listOfUsers.filter { user: User -> user.email == emailUser }
        if (!userToDeleteList.isEmpty()) {
            val userToDelete = userToDeleteList.first()
            setup.listOfUsers.remove(userToDelete)
            return true
        }
        return false
    }

    fun editUser(email: String, newUser: User): Boolean {
        val listOfUser = setup.listOfUsers.filter { user: User -> user.email == email }
        if (!listOfUser.isEmpty()) {
            val oldUser = listOfUser.first()
            val indexOfUser = setup.listOfUsers.indexOf(oldUser)
            setup.listOfUsers[indexOfUser] = newUser
            return true
        }
        return false
    }

    fun exit() {
        System.exit(0)
    }
}