package Util

class Messages {
    constructor()

    val mainAdminOptions: String = "Seleccione una opción: " +
            "\n1. Ver libros disponibles.\n" +
            "2. Añadir un libro.\n" +
            "3. Eliminar un libro.\n" +
            "4. Editar un libro.\n" +
            "5. Ver lista de usuarios.\n" +
            "6. Añadir un usuario.\n" +
            "7. Eliminar un usuario.\n" +
            "8. Editar un usuario.\n" +
            "9. Salir."
    val welcomeLogo: String = "-------------------------------------------" +
                              "|                LIBRERÍA                 |" +
                              "-------------------------------------------"
    val welcome: String = "Bienvenido al sistema de renta de libros, por favor inicia sesión:"
    val insertEmail: String = "Introduce tu email: "
    val insertPassword: String = "Introduce tu contraseña: "
    val errorEmail: String = "El email introducido no es el correcto."
    val errorPassword: String = "La contraseña no cumple los requisitos."
    val mainUserOption: String = "Seleccione una opción: " +
            "\n1. Ver libros disponibles.\n" +
            "2. Ver libros que tengo en alquiler.\n" +
            "3. Alquilar un libro.\n" +
            "4. Devolver un libro.\n" +
            "5. Editar mis datos.\n" +
            "6. Salir.\n"
    val insertIsbn = "Inserta el código ISBN del libro: "
    val insertTitle = "Inserta el título del nuevo libro: "
    val insertPages = "Inserta el número de páginas del libro: "
    val insertStock = "Inserta el número de unidades del libro: "
    val dontHaveBooksRented = "No tienes libros en alquiler."
    val bookRented = "Libro alquilado correctamente."
    val bookCantRented = "El libro no se pudo alquilar."
    val insertName = "Introduce el nuevo nombre de usuario: "
    val insertSurname = "Introduce el nuevo apellido del usuairo: "
    val insertAge = "Introduce la edad del nuevo usuario: "
    val insertNewEmail = "Introduce el nuevo email del usuario: "
}