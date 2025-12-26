package ma.lahjaily;

import app.grpc.entity.Utilisateur;
import app.grpc.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// 1. Pour les Services et Controlleurs
@ComponentScan(basePackages = {"ma.lahjaily", "app.grpc"})
// 2. Pour les Interfaces Repository (UtilisateurRepository)
@EnableJpaRepositories(basePackages = {"ma.lahjaily", "app.grpc.repository"})
// 3. Pour les Classes @Entity (Utilisateur)
@EntityScan(basePackages = {"ma.lahjaily", "app.grpc.entity"})
public class ClientGrpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientGrpcApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UtilisateurRepository repository) {
        return args -> {
            repository.save(Utilisateur.builder()
                    .username("admin")
                    .password("1234")
                    .build());
            System.out.println("Utilisateur 'admin' créé !");
        };
    }

}