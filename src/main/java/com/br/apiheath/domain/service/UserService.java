package com.br.apiheath.domain.service;//package com.br.heath.domain.service;
//
//import com.br.heath.api.dtoGeneral.UserResponseDTO;
//import com.br.heath.domain.entity.User;
//import com.br.heath.domain.user.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Service
//public class UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//
//    public UserResponseDTO createUserFromOidcUser(OidcUser oidcUser) {
//
//        var userCreated = userRepository.save(newUser(oidcUser));
//
//        return mapToResponseUser(userCreated);
//    }
//
//    public User verifyUserByEmail(String email){
//        return userRepository.findByEmail(email);
//    }
//
//    private User newUser(OidcUser oidcUser) {
//
//        String email = oidcUser.getAttribute("email");
//        String name = oidcUser.getFullName();
//        String token = oidcUser.getIdToken().getTokenValue();
//
//        return new User(
//                email,
//                name,
//                LocalDateTime.now(),
//                token);
//
//        }
//
//    public UserResponseDTO mapToResponseUser(User user) {
//        return new UserResponseDTO(
//                user.getId(),
//                user.getName(),
//                user.getEmail(),
//                user.getCreatedAt(),
//                user.getUpdatedAt(),
//                user.getToken()
//        );
//    }
//
//}
