import Util.Check
import Util.Setup
import org.testng.Assert
import org.testng.annotations.Test

class SystemShould {
    @Test
    fun `check if is an email`() {
        val check = Check()
        Assert.assertTrue(check.thisIsA("marcos@outlook.com"))
        Assert.assertFalse(check.thisIsA("markensi%@frfgr.com"))
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

        Assert.assertTrue(check.existThisEmailIn(listOfUsers, "marcos@outlook.com"))
        Assert.assertFalse(check.existThisEmailIn(listOfUsers, "diei.frij93@gmial.com"))
    }
}