package Util

import User
import java.util.regex.Matcher

class Check {
    fun thisIsA(email: String): Boolean {
        val emailPattern = Regex("[A-Za-z0-9-_.]+@[A-Za-z0-9]+\\.[a-zA-Z]{2,}")
        return emailPattern.matches(email)
    }

    fun thisIsAnAdmin(email: String): Boolean {
        return email.contains("admin")
    }

    fun existThisEmailIn(listOfUsers: MutableList<User>, email: String): Boolean {
        for (user in listOfUsers) {
            if (user.email.equals(email)) return true
        }
        return false
    }
}