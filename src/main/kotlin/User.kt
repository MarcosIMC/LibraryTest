import Util.Setup

class User(var name: String, var surname: String, var age: Int, var email: String, var books: MutableList<Book>) {

    fun edit(newUser: User, email: String, listOfUsers: MutableList<User>): Boolean {
        val setup = Setup()
        val userToEdit = listOfUsers.filter { user: User -> user.email == email }
        if (!userToEdit.isEmpty()) {
            val user: User = userToEdit.first()
            val oldUserIndex = listOfUsers.indexOf(user)
            listOfUsers[oldUserIndex] = newUser
            println(newUser.toString())
            return true
        }
        return false
    }

    override fun toString(): String {
        return "Nombre: $name\n" +
                "Apellido: $surname\n" +
                "Edad: $age\n" +
                "Email: $email\n" +
                "Libros: $books\n"
    }
}