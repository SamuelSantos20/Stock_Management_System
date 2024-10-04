package dataImpl;



import org.springframework.stereotype.Repository;

import data.UserData;
import domain.User;


@Repository
public class UserDataImpl extends AbstractDao<User, Long > implements UserData  {

}
