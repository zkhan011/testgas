package com.dpw.gasws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GaswsApplication {
    public static void main(String[] args) {
        if (args.length == 1 && "--generate-password-hash".equals(args[0])) {
            var console = System.console();
            if (console == null) throw new IllegalStateException("Run this command in an interactive terminal");
            char[] password = console.readPassword("API password: ");
            if (password == null || password.length == 0) throw new IllegalArgumentException("Password must not be empty");
            try {
                console.printf("%s%n", new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder()
                        .encode(new String(password)));
            } finally {
                java.util.Arrays.fill(password, '\0');
            }
            return;
        }
        SpringApplication.run(GaswsApplication.class, args);
    }
}
