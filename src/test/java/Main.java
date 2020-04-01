import org.junit.Before;
import org.junit.Test;
import services.Dashboard;
import services.UserManagement;
import utils.Constant;
import utils.ExternalFIle;

public class Main {

    private String  userFirstName;
    private String userLastName;
    private String email;
    private String number;
    private String password;
    private String confirmPassword;
    private String address1;
    private String address2;
    private String adminUser;
    private String adminPassword;
    private String emailCustomer;
    @Before
    public void setUp() throws Exception {

        ExternalFIle.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
        userFirstName = ExternalFIle.getCellData(1, 0);
        userLastName = ExternalFIle.getCellData(1, 1);
        number = ExternalFIle.getCellData(1, 2);
        email = ExternalFIle.getCellData(1, 3);
        password = ExternalFIle.getCellData(1, 5);
        confirmPassword = ExternalFIle.getCellData(1, 4);
        address1 = ExternalFIle.getCellData(1, 7);
        address2 = ExternalFIle.getCellData(1, 8);
        adminUser = ExternalFIle.getCellData(3, 3);
        adminPassword = ExternalFIle.getCellData(3, 4);
        emailCustomer = ExternalFIle.getCellData(2, 4);

        System.setProperty("webdriver.gecko.driver","C://Users//RashadTantawy//IdeaProjects//cequens//geckodriver.exe");


    }


    @Test
    public void ExecuteSignUp() throws InterruptedException {

        UserManagement.signUp(userFirstName,userLastName,number,email,password,confirmPassword,true);

    }

    @Test
    public  void ExecuteUserSignIn() throws InterruptedException {

        UserManagement.UsersSignIn(email,password,"https://www.phptravels.net/login",true);

    }
    @Test
    public void ExecuteCreateCustomer() throws InterruptedException {

        Dashboard.adminSignIn(adminUser,adminPassword,"https://www.phptravels.net/admin",true);
        Thread.sleep(2500);
        Dashboard.createCustomer(userFirstName,userLastName,email,password,number,address1,address1,true);

    }
    @Test
    public  void ExecuteRemoveCustomer(){

        Dashboard.removeCustomer();

    }


}
