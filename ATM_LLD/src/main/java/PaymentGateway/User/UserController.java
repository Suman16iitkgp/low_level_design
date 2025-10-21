package PaymentGateway.User;

public class UserController {
    UserService userService;

    public UserController() {
        this.userService = new UserService();
    }


    public void addUser(UserDTO userDTO){
        try {
            userService.addUser(userDTO);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public UserDTO getUser(int userId){
        try{
            return userService.getUser(userId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
