package Util

import Book
import User

class Setup {
    val listOfUsers = mutableListOf<User>()
    val listOfBooks = mutableListOf<Book>()

    fun users() {
        val user1 = User("Marcos", "Medina", 30, "admin.marcos@outlook.com", mutableListOf<Book>())
        val user2 = User("Sonia", "Castellano", 54, "sonia@outlook.com", mutableListOf<Book>())
        val user3 = User("Anabel", "Medina", 27, "anabel@gmail.com", mutableListOf<Book>())
        val user4 = User("María", "Moreno", 16, "maria@libreria.es", mutableListOf<Book>())
        listOfUsers.add(user1)
        listOfUsers.add(user2)
        listOfUsers.add(user3)
        listOfUsers.add(user4)
    }

    fun listOfUsers(): MutableList<User> {
        return listOfUsers
    }

    fun books() {
        val book1 = Book("Clean Code", 123456789, 350,3)
        val book2 = Book("Clean Architecture", 987654321, 280, 5)
        val book3 = Book("El bosón de higgs no te va a hacer la cama", 547398345, 320,2)
        val book4 = Book("Design Patters", 8796876879, 380, 7)
        listOfBooks.add(book1)
        listOfBooks.add(book2)
        listOfBooks.add(book3)
        listOfBooks.add(book4)
    }

    fun listOfBooks(): MutableList<Book> {
        return listOfBooks
    }
}