import controllers.UserController;

public class AppUsers {
    public static void main( String[] args )
    {
        UserController userController = new UserController();
        userController.process();
    }
}
