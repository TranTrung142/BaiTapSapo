package com.sapo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.net.Authenticator;

@Configuration      //su dung java config
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")     //bat tinh nang jpaAuditing
public class JpaAuditingConfig {
    @Bean
    public AuditorAware<String> auditorProvider(){
        return new AuditorAwareImpl();
    }

    //lay username
    public static class AuditorAwareImpl implements AuditorAware<String>{

        @Override
        public String getCurrentAuditor() {     //get username insert into 
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication == null || !authentication.isAuthenticated()){ //authentication == null or chua dang nhap
                //chua dang nhap
                return null;
            }
            return authentication.getName();
        }
    }
}
