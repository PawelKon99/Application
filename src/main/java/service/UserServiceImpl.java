package service;
import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {


    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl(){}


    public static UserServiceImpl getInstance(){
        if (instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers()throws IOException {
        return userDao.getAllUsers();
    }

    public boolean addUser(User user){
        try {
            if (isLoginAlreadyExist(user.getLogin())){
                throw new UserLoginAlreadyExistException();
            }
            if (userValidator.isValidate(user)){
                userDao.saveUser(user);
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public User getUserById(Long userId) throws IOException{
        List<User> users = getAllUsers();

        try {
            for (User user : getAllUsers()) {
                boolean isUserIdCorrect = user.getId().equals(userId);
                if (isUserIdCorrect) {
                    return user;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByLogin(String login) {
        List<User> users = null;

        try {
            users = getAllUsers();
            for (User user : users
            ) {
                boolean isFoundUser = user.getLogin().equals(login);
                if (isFoundUser) {
                    return user;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean isLoginAlreadyExist(String login) {
        User user = getUserByLogin(login);

        return user != null;
    }

    public boolean isCorrectLoginAndPassword(String login, String password){
        User foundUser = getUserByLogin(login);

        if (foundUser == null){
            return false;
        }

        boolean isCorrectLogin = foundUser.getLogin().equals(login);
        boolean isCorrectPassword = foundUser.getPassword().equals(password);

        return isCorrectLogin && isCorrectPassword;
    }


    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }
}
