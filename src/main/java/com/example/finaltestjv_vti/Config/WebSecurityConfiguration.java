package com.example.finaltestjv_vti.Config;

import com.example.finaltestjv_vti.Service.impl.AccountService;
//import com.example.shoppeerw59.Config.jwt.JwtRequestFilter;
//import com.example.shoppeerw59.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration // kết hợp với @Bean để tạo thành 1 bean trong spring IOC
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Để có thể phân quyền tại controller
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountService accountService;

//    @Autowired
//    BCryptPasswordEncoder encoder;

//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(accountService).// Cấu hình UserDetailsService để khi xác thực người dùng sẽ gọi tới hàm loadUserByUsername()
//                passwordEncoder(encoder);// Cấu hình phương thức để mã hoá mật khẩu
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/api/v1/auth/login-v2", "/api/final/account").permitAll() // config API ko cần xác thực
//                .antMatchers(HttpMethod.GET,"api/admin").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.GET,"api/admin-or-user").hasAnyAuthority("ADMIN", "User")
                .anyRequest().permitAll() // Những đường dẫn còn lại cần được xác thực
                .and().httpBasic() // Kích hoạt cấu hình http basic trong Spring Security
                .and().cors().and().csrf().disable(); // tắt tính năng Cross-Site Request Forgery (CSRF) trong Spring Security.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//        http.headers().cacheControl();
    }

    @Override // Config cho đường dẫn (swagger) ko bị chặn bởi sercurity
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/swagger-ui/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/v3/api-docs/**");
    }
}
