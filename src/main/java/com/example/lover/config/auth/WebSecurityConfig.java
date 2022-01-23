package com.example.lover.config.auth;

import com.example.lover.model.account.Role;
import com.example.lover.model.account.RoleName;
import com.example.lover.model.account.User;
import com.example.lover.security.jwt.JwtAuthEntryPoint;
import com.example.lover.security.jwt.JwtAuthTokenFilter;
import com.example.lover.security.userPrinciple.UserDetailServiceImpl;
import com.example.lover.service.role.IRoleService;
import com.example.lover.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    private JwtAuthTokenFilter jwtAuthTokenFilter;

    @Autowired
    JwtAuthEntryPoint jwtAuthEntryPoint;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

//    ham xét mac dinh khoi tao tai khoan admin khi chua dang ky
    @PostConstruct
    public void init(){
        List<User> users = (List<User>) userService.findAll();
        List<Role> roles = (List<Role>) roleService.findAll();
        if (roles.isEmpty()){
            Role roleAdmin = new Role();
            roleAdmin.setId(1L);
            roleAdmin.setName(RoleName.ROLE_ADMIN);
            roleService.save(roleAdmin);

            Role roleUser = new Role();
            roleUser.setId(2L);
            roleUser.setName(RoleName.ROLE_USER);
            roleService.save(roleUser);

            Role roleProvider = new Role();
            roleProvider.setId(3L);
            roleProvider.setName(RoleName.ROLE_PROVIDER);
            roleService.save(roleProvider);
        }
        if (users.isEmpty()){
            User userAdmin = new User();
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(new Role(1L, RoleName.ROLE_ADMIN));
            userAdmin.setUsername("admin");
            userAdmin.setPassword(passwordEncoder().encode("123456"));
            userAdmin.setRoles(roleSet);
            userService.save(userAdmin);
        }
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthTokenFilter jwtAuthTokenFilter() {
        return new JwtAuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint(){
        return new RestAuthenticationEntryPoint();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors().and().csrf().disable()
                .authorizeRequests().antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().exceptionHandling().accessDeniedHandler(customAccessDeniedHandler())
                .authenticationEntryPoint(restAuthenticationEntryPoint())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
