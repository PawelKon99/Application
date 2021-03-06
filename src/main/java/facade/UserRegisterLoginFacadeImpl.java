package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import service.UserServiceImpl;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {

    private static UserRegisterLoginFacadeImpl instance = null;
    private static UserService userService = UserServiceImpl.getInstance();

    public static UserRegisterLoginFacadeImpl getInstance(){
        if (instance==null){
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    public boolean registerUser(User user){
        return userService.addUser(user);
    }

    public boolean loginUser(String login, String password){
        if (userService.isCorrectLoginAndPassword(login, password)){
            return true;
        }
        return false;
    }
}
