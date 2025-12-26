package app.grpc;

import app.grpc.SalutationProto.SalutRequest;
import app.grpc.SalutationProto.SalutResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;

public class ClientStreaming {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9082)
                .usePlaintext()
                .build();

        // Création d'un stub asynchrone (non-bloquant)
        SalutationGrpc.SalutationStub stub = SalutationGrpc.newStub(channel);

        // Utilisé pour attendre que le serveur réponde avant de quitter le programme
        CountDownLatch latch = new CountDownLatch(1);

        // On définit comment on gère la réponse du serveur
        StreamObserver<SalutRequest> requestObserver = stub.message(new StreamObserver<SalutResponse>() {
            @Override
            public void onNext(SalutResponse response) {
                // Réponse finale du serveur
                System.out.println("Réponse du serveur : " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Communication terminée.");
                latch.countDown();
            }
        });

        // Envoi du flux de données (Streaming)
        System.out.println("Envoi de Ahmed...");
        requestObserver.onNext(SalutRequest.newBuilder().setName("Ahmed").build());
        Thread.sleep(500); // Juste pour voir l'effet temps réel

        System.out.println("Envoi de Brahim...");
        requestObserver.onNext(SalutRequest.newBuilder().setName("Brahim").build());
        Thread.sleep(500);

        System.out.println("Envoi de Imane...");
        requestObserver.onNext(SalutRequest.newBuilder().setName("Imane").build());

        // On signale au serveur qu'on a fini d'envoyer
        requestObserver.onCompleted();

        // On attend la réponse (sinon le programme s'arrête avant de recevoir la réponse)
        latch.await();

        channel.shutdown();
    }
}