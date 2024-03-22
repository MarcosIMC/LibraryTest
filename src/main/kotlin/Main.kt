import Util.*

fun main(args: Array<String>) {
    val setup = Setup()
    val userActions = UserActions()
    val adminActions = AdminActions()
    setup.users()
    setup.books()

    val messages = Messages()
    val check = Check()
    println(messages.welcomeLogo)
    println(messages.welcome)
    println(messages.insertEmail)
    val email = readln()

    if (check.thisIsA(email) && check.existThisEmailIn(setup.listOfUsers(), email)) {
            if (!check.thisIsAnAdmin(email)) {
                while (true) {
                    println(messages.mainUserOption)
                    val option = readln().toInt()

                    val result = when (option) {
                        1 -> userActions.listAllBooks()
                        2 -> userActions.booksRented(email)
                        3 -> userActions.rentABook(email)
                        4 -> userActions.returBook(email, 123456789)
                        5 -> userActions.editProfile(email)
                        6 -> userActions.exit()
                        else -> {
                            println("Error")
                        }
                    }
                    println(result)
                }
            } else if (check.thisIsAnAdmin(email)) {
                while (true) {
                    println(messages.mainAdminOptions)
                    val option = readln().toInt()
                    val result = when  (option) {
                        1 -> adminActions.listAllBooks()
                        2 -> {
                                println(messages.insertTitle)
                                val title = readln()
                                println(messages.insertIsbn)
                                val isbn = readln().toLong()
                                println(messages.insertPages)
                                val pages = readln().toInt()
                                println(messages.insertStock)
                                val stock = readln().toInt()
                                val book = Book(title, isbn, pages, stock)
                                adminActions.addNewBook(book)
                            }
                        3 -> {
                                println(messages.insertIsbn)
                                val isbn = readln().toLong()
                                adminActions.deleteBook(isbn)
                            }
                        4 -> {
                                println(messages.insertIsbn)
                                val currentBookIsbn = readln().toLong()
                                println(messages.insertTitle)
                                val newBookTitle = readln()
                                println(messages.insertIsbn)
                                val newBookIsbn = readln().toLong()
                                println(messages.insertPages)
                                val newBookPages = readln().toInt()
                                println(messages.insertStock)
                                val newBookStock = readln().toInt()
                                val book = Book(newBookTitle, newBookIsbn, newBookPages, newBookStock)
                                adminActions.editBook(currentBookIsbn, book)
                            }
                        5 -> adminActions.listAllUsers()
                        6 -> {
                                println(messages.insertName)
                                val userName = readln()
                                println(messages.insertSurname)
                                val surname = readln()
                                println(messages.insertAge)
                                val age = readln().toInt()
                                println(messages.insertEmail)
                                val email = readln()
                                val user = User(userName, surname, age, email, mutableListOf())
                                adminActions.addNewUser(user)
                            }
                        7 -> {
                                println(messages.insertEmail)
                                val email = readln()
                                adminActions.deleteUser(email)
                            }
                        8 -> {
                                println(messages.insertEmail)
                                val emailOld = readln()
                                println(messages.insertName)
                                val userName = readln()
                                println(messages.insertSurname)
                                val surname = readln()
                                println(messages.insertAge)
                                val age = readln().toInt()
                                println(messages.insertEmail)
                                val email = readln()
                                val user = User(userName, surname, age, email, mutableListOf())
                                adminActions.editUser(emailOld, user)
                            }
                        9 -> adminActions.exit()
                        else -> {
                            println("Error")
                        }
                    }
                    println(result)
                }
            }
    } else {
        println(messages.errorEmail)
    }
}