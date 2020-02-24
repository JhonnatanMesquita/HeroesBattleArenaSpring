package me.jhonnatanmesquita.heroesbattlearena.security.configs;

import me.jhonnatanmesquita.heroesbattlearena.security.JWTAuthenticationFilter;
import me.jhonnatanmesquita.heroesbattlearena.security.JWTAuthorizationFilter;
import me.jhonnatanmesquita.heroesbattlearena.security.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment env;

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    private static final String[] PUBLIC_MATCHERS_GET = {
            "/jogador/**",
            "/heroi/**"
    };

    private static final String[] PUBLIC_MATCHERS_POST ={
            "/login",
            "/jogador"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        if(Arrays.asList(env.getActiveProfiles()).contains("test")){
            http.headers().frameOptions().disable();
        }

        http.cors().and().csrf().disable();  //chama a configuração de Cors e desabilita o CSRF (a aplicação não armazena nada em estado, então o CSRF não é necessario)
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
                .anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){  //Habilita o Cors ao back-end
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfiguration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
