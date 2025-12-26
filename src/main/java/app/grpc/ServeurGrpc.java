package app.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class ServeurGrpc {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Création et démarrage du serveur sur le port 9082
        Server server = ServerBuilder.forPort(9082)
                .addService(new UserService())
                .build();

        server.start();
        System.out.println("Serveur gRPC démarré sur le port : " + server.getPort());

        // Maintient le serveur en vie
        server.awaitTermination();
    }
}