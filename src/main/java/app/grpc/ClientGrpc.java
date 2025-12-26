package app.grpc;

import app.grpc.UserProto.LoginRequest;
import app.grpc.UserProto.LoginResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientGrpc {
    public static void main(String[] args) {
        // 1. Créer un canal de communication vers le serveur (localhost:9082)
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9082)
                .usePlaintext() // Important : désactive SSL/TLS pour le développement local
                .build();

        // 2. Créer un "stub" (le client) bloquant
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        // 3. Préparer la requête de login
        LoginRequest loginRequest = LoginRequest.newBuilder()
                .setUserName("GRPC")
                .setPassword("GRPC")
                .build();

        // 4. Appeler la méthode distante (RPC)
        LoginResponse response = userStub.login(loginRequest);

        // 5. Afficher la réponse du serveur
        System.out.println("Réponse du serveur : " + response.getMsgResponse());

        // 6. Fermer le canal
        channel.shutdown();
    }
}