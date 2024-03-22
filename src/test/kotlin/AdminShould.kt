import Util.AdminActions
import Util.Setup
import org.testng.Assert.*
import org.testng.annotations.Test

class AdminShould {
    @Test
    fun `list all books on library`() {
        val setup = Setup()
        val adminActions = AdminActions()

        for (book in setup.listOfBooks()) {
            assertEquals(adminActions.listAllBooks(), book.toString())
        }
    }

    @Test
    fun `add a new book to library`() {
        val setup = Setup()
        val adminActions = AdminActions()
        val book = Book("Los multimillonarios del Bitcoin", 4563278456239487256, 315, 4)
        assertTrue(adminActions.addNewBook(book))
    }

    @Test
    fun `delete a book of bookCollection`() {
        val adminActions = AdminActions()
        val isbn: Long = 123456789
        assertTrue(adminActions.deleteBook(isbn))
    }

    @Test
    fun `edit an exist book`() {
        val adminActions = AdminActions()
        val isbn: Long = 123456789
        val newBook = Book("El libro de Uncle Bob", 123456789, 300, 5)
        assertTrue(adminActions.editBook(isbn, newBook))
        assertFalse(adminActions.editBook(1111, newBook))
    }

    @Test
    fun `show all user members of library`() {
        val setup = Setup()
        val adminActions = AdminActions()
        for (user in setup.listOfUsers()) {
            assertEquals(adminActions.listAllUsers(), user.toString())
        }
    }

    @Test
    fun `add new user to library`() {
        val adminActions = AdminActions()
        val user = User("Prueba", "Pruebita", 15, "prueba@prueba.com", mutableListOf<Book>())
        assertTrue(adminActions.addNewUser(user))
    }

    @Test
    fun `delete an exist user`() {
        val adminActions = AdminActions()
        val emailUser = "sonia@outlook.com"
        assertTrue(adminActions.deleteUser(emailUser))
    }

    @Test
    fun `edit all params of an user`() {
        val adminActions = AdminActions()
        val email = "sonia@outlook.com"
        val user = User("Carmen", "Pérez", 40, "carmen@outlook.com", mutableListOf())
        assertTrue(adminActions.editUser(email, user))
    }
}