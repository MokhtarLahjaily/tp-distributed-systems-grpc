package app.grpc;

import app.grpc.SalutationProto.SalutRequest;
import app.grpc.SalutationProto.SalutResponse;
import io.grpc.stub.StreamObserver;

public class SalutationService extends SalutationGrpc.SalutationImplBase {

    @Override
    public StreamObserver<SalutRequest> message(StreamObserver<SalutResponse> responseObserver) {

        // On retourne un StreamObserver pour gérer les messages entrants du client
        return new StreamObserver<SalutRequest>() {
            String names = "";

            @Override
            public void onNext(SalutRequest request) {
                // Appelé chaque fois que le client envoie un nom
                System.out.println("Nom reçu : " + request.getName());
                names += request.getName() + ", ";
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Erreur reçue : " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Appelé quand le client a fini d'envoyer ses messages
                String responseMessage = "Bienvenue à tous : " + names;

                // On construit la réponse unique
                SalutResponse response = SalutResponse.newBuilder()
                        .setMessage(responseMessage)
                        .build();

                // On l'envoie et on ferme la connexion
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }
}