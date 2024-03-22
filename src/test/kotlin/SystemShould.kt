import Util.Check
import Util.Setup
import org.testng.Assert
import org.testng.annotations.Test

class SystemShould {
    @Test
    fun `check if is an email`() {
        val check = Check()
        Assert.assertTrue(check.thisIsA("markensi9@outlook.com"))
        Assert.assertFalse(check.thisIsA("markensi%@outlook.com"))
    }

    @Test
    fun `check if is an admin email`() {
        val check = Check()
        Assert.assertTrue(check.thisIsAnAdmin("admin.moya9@outlook.es"))
        Assert.assertFalse(check.thisIsAnAdmin("moya@aaa.es"))
    }

    @Test
    fun `check if the emial exist in our datas`() {
        val check = Check()
        val setup = Setup()
        setup.users()
        val listOfUsers = setup.listOfUsers()

        Assert.assertTrue(check.existThisEmailIn(listOfUsers, "markensi9@outlook.com"))
        Assert.assertFalse(check.existThisEmailIn(listOfUsers, "gt5rt93@gmial.com"))
    }
}