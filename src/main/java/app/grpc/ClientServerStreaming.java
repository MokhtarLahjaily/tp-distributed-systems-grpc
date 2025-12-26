package app.grpc;

import app.grpc.MultiplicationProto.MultiplicationRequest;
import app.grpc.MultiplicationProto.MultiplicationResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;

public class ClientServerStreaming {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9082)
                .usePlaintext()
                .build();

        // Pour le Server Streaming, on peut utiliser un stub bloquant ou asynchrone.
        // Le TP utilise l'approche asynchrone (newStub) avec StreamObserver.
        MultiplicationGrpc.MultiplicationStub stub = MultiplicationGrpc.newStub(channel);

        MultiplicationRequest request = MultiplicationRequest.newBuilder()
                .setNombre(5)
                .setLimite(10)
                .build();

        CountDownLatch latch = new CountDownLatch(1);

        System.out.println("Demande de la table de 5...");

        stub.getMultiplicationTable(request, new StreamObserver<MultiplicationResponse>() {
            @Override
            public void onNext(MultiplicationResponse response) {
                // Cette méthode est appelée à chaque fois que le serveur envoie une ligne
                System.out.println("Reçu : " + response.getResultat());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Fin du streaming reçu du serveur.");
                latch.countDown();
            }
        });

        // On attend que le serveur ait fini d'envoyer toutes les données
        latch.await();

        channel.shutdown();
    }
}