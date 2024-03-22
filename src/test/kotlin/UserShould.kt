import Util.Messages
import Util.Setup
import Util.UserActions
import org.testng.Assert.*
import org.testng.annotations.Test

class UserShould {
    @Test
    fun `show all books`() {
        val setup = Setup()
        setup.books()
        val listOfBooks = setup.listOfBooks()
        val listOfBooksReference = setup.listOfBooks

        assertEquals(listOfBooks, listOfBooksReference)
    }

    @Test
    fun `can see a list of all books`() {
        val userAction = UserActions()
        val setup = Setup()

        for (element in setup.listOfBooks()) {
            assertEquals(userAction.listAllBooks(), element.toString())
        }
    }

    @Test
    fun `can see his rented books`() {
        val userAction = UserActions()
        val setup = Setup()
        val messages = Messages()
        setup.books()
        val resutl = userAction.booksRented("markensi9@outlook.com")
        assertEquals(resutl, messages.dontHaveBooksRented)
    }

    @Test
    fun `can rent a book`() {
        val userAction = UserActions()
        val setup = Setup()
        val messages = Messages()
        setup.books()
        val result = userAction.rentABook("markensi9@outlook.com")
        assertTrue(result)
    }

    @Test
    fun `can return a rented book`() {
        val userAction = UserActions()
        val setup = Setup()
        setup.books()
        setup.users()
        `can rent a book`()
        val resultTrue = userAction.returBook("markensi9@outlook.com", 1234567889)
        val resultFalse = userAction.returBook("markensi9@outlook.com", 11111111)
        assertTrue(resultTrue)
        assertFalse(resultFalse)
    }

}