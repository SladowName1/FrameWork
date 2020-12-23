package service;

import model.User;
import static util.Resolver.resolveTemplate;

public class UserCreator {
    public static final String First_Name="testdata.user.%s.firstname";
    public static final String Last_Name="testdata.user.%s.lastname";
    public static final String Email="testdata.user.%s.email";
    public static final String Login="testdata.user.%s.login";
    public static final String Password="testdata.user.%s.password";

    public static User withCredantialsFromProperty(String orderNumber){
        orderNumber=orderNumber.toLowerCase();

        return new User(TestDataReader.getUser(resolveTemplate(First_Name,orderNumber)),
                TestDataReader.getUser(resolveTemplate(Last_Name,orderNumber)),
                TestDataReader.getUser(resolveTemplate(Email,orderNumber)),
                TestDataReader.getUser(resolveTemplate(Login,orderNumber)),
                TestDataReader.getUser(resolveTemplate(Password,orderNumber)));
    }

    public static User withEmptyPassword(){
        return new User("","",
                "",TestDataReader.getUser(Login),"");
    }
}
