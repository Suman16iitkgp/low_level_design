package PaymentGateway.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {
    public List<UserEntity> user;

    UserService(){
        user = new ArrayList<>();
    }

    public void addUser(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserId(new Random().nextInt(1000));
        userEntity.setEmail(userDTO.getEmail());

        user.add(userEntity);
    }

    public UserDTO getUser(int userId){
        for(UserEntity userEntity : user){
            if(userEntity.getUserId() == userId){
                return convertUserEntityToUserDTO( userEntity );
            }
        }

        return null;
    }

    private UserDTO convertUserEntityToUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setEmail(userEntity.getEmail());

        return userDTO;
    }

}
