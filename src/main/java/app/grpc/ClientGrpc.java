package app.grpc;

import app.grpc.UserProto.LoginRequest;
import app.grpc.UserProto.LoginResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientGrpc {
    public static void main(String[] args) {
        // 1. CHANGER LE PORT : Utiliser 9091 (port du serveur Spring Boot)
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext()
                .build();

        // 2. CHANGER LE STUB : Utiliser 'AuthenticationGrpc' (nouveau nom du service)
        // Si 'AuthenticationGrpc' est rouge/introuvable, vérifiez votre fichier user.proto
        AuthenticationGrpc.AuthenticationBlockingStub stub = AuthenticationGrpc.newBlockingStub(channel);

        // 3. PRÉPARER LA REQUÊTE
        LoginRequest loginRequest = LoginRequest.newBuilder()
                .setUsername("admin")
                .setPassword("1234")
                .build();

        // 4. APPELER LE SERVEUR
        LoginResponse response = stub.login(loginRequest);

        // 5. AFFICHER LA RÉPONSE
        System.out.println("Réponse du serveur gRPC : " + response.getMsgReponse());

        channel.shutdown();
    }
}