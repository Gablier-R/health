package com.br.apiheath.api.controller;//package com.br.heath.api.controller;
//
//import com.br.heath.api.dtoGeneral.UserResponseDTO;
//import com.br.heath.domain.entity.User;
//import com.br.heath.domain.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.OidcIdToken;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("auth")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/login")
//    ResponseEntity<UserResponseDTO> login(@AuthenticationPrincipal OidcUser oidcUser) {
//
//        return new ResponseEntity<>(userService.createUserFromOidcUser(oidcUser), HttpStatus.OK);
//    }
//
//
//}
