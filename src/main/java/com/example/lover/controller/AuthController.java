package com.example.lover.controller;

import com.example.lover.model.account.Role;
import com.example.lover.model.account.RoleName;
import com.example.lover.model.account.User;
import com.example.lover.model.dto.ResponseMessage;
import com.example.lover.model.dto.SignUpForm;
import com.example.lover.security.jwt.JwtAuthTokenFilter;
import com.example.lover.security.jwt.JwtProvider;
import com.example.lover.security.userPrinciple.UserDetailServiceImpl;
import com.example.lover.service.role.IRoleService;
import com.example.lover.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IUserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private IRoleService roleService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
//    @Autowired
//    JwtAuthTokenFilter jwtAuthTokenFilter;
    @Autowired
    UserDetailServiceImpl userDetailService;
    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm){
        if (userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(new ResponseMessage("username is existed!"), HttpStatus.OK);
        }
        if (userService.existsByEmail(signUpForm.getEmail())){
            return new ResponseEntity<>(new ResponseMessage("email is existed!"), HttpStatus.OK);
        }
        if (signUpForm.getAvatar() == null || signUpForm.getAvatar().trim().isEmpty()){
            signUpForm.setAvatar("https://firebasestorage.googleapis.com/v0/b/lover-4a315.appspot.com/o/z2991517625512_44867f24c34add5c41afac4a6f6e5b9f.jpg?alt=media&token=734ffdf5-dac8-4e1a-8ed2-330c57f99f93");
        }
        User user = new User(signUpForm.getUsername(), signUpForm.getEmail(), passwordEncoder.encode(signUpForm.getPassword()), signUpForm.getAvatar());
        Set<String> strRole = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRole.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "provider":
                    Role providerRole = roleService.findByName(RoleName.ROLE_PROVIDER).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(providerRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.ROLE_USER).orElseThrow(()-> new RuntimeException("Role not found"));
                    roles.add(userRole);
            }
        });
        user.setRoles(roles);
        userService.save(user);
        SimpleMailMessage sendMail = new SimpleMailMessage();
        sendMail.setTo(user.getEmail());
        sendMail.setSubject("Bạn đã đăng ký tài khoản thành công!");
        sendMail.setText("Bạn đã đăng ký tài khoản thành công");
        javaMailSender.send(sendMail);
        return new ResponseEntity<>(new ResponseMessage("Create success!"), HttpStatus.OK);
    }
}
