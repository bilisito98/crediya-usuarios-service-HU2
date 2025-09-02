package co.com.crediya.solicitudes.appservice.config;

import co.com.crediya.solicitudes.domain.usecase.ClienteUseCase;
import co.com.crediya.solicitudes.domain.ports.ClienteRepositoryPort;
import co.com.crediya.solicitudes.appservice.service.ClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    public ClienteUseCase clienteUseCase(ClienteRepositoryPort clienteRepo) {
        return new ClienteUseCase(clienteRepo); // tu clase concreta
    }

    @Bean
    public ClienteService clienteService(ClienteUseCase clienteUseCase) {
        return new ClienteService(clienteUseCase);
    }
}
