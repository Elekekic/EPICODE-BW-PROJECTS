package BW_5.gruppo_3.Service;

import BW_5.gruppo_3.DTO.UserLoginDTO;
import BW_5.gruppo_3.Exception.UnauthorizedException;
import BW_5.gruppo_3.Security.AuthenticationResponse;
import BW_5.gruppo_3.Security.JwtTool;
import BW_5.gruppo_3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTool jwtTool;
    @Autowired
    private PasswordEncoder passwordEncoder;


               public AuthenticationResponse authenticateUserAndCreateToken(UserLoginDTO userLoginDTO){
                User user = userService.getUserByEmail(userLoginDTO.getEmail());

                if (passwordEncoder.matches(userLoginDTO.getPassword() ,user.getPassword())) {

                    String token = jwtTool.createToken(user);
            /*String role = user.getRole().toString();
            int id = user.getId();
            String name = jwtTool.createToken(user);
            String surname = user.getRole().toString();
            String email = jwtTool.createToken(user);*/

            return new AuthenticationResponse(token,user);
        }else{
            throw  new UnauthorizedException("Dati errati, controllare i dati inseriti e prova nuovamente, se riscontri ancora problemi contatta l'assistenza di TicketGenius");
        }
    }


}
