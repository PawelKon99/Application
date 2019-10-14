package validator;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import api.UserDao;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.UserServiceImpl;

public class UserValidator {

    private final int MIN_LENGTH_PASSWORD = 6;
    private final int MIN_LENGTH_LOGIN = 4;

    private UserValidator(){}

    private static UserValidator instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();



    public static UserValidator getInstance(){
        if (instance == null){
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user)throws UserShortLengthPasswordException, UserShortLengthLoginException, UserLoginAlreadyExistException{
        if (isLoginLongEnough(user.getLogin())){
            throw new UserShortLengthLoginException("Login is too short");
        }

        if (isUserPasswordLongEnough(user.getPassword())){
            throw new UserShortLengthPasswordException("Password is too short");
        }

        return true;
    }

    private boolean isLoginLongEnough(String login) {
       return login.length() < MIN_LENGTH_LOGIN;
    }

    private boolean isUserPasswordLongEnough(String password){
        return password.length() < MIN_LENGTH_PASSWORD;
    }


}
