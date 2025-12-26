package app.grpc;

import app.grpc.MultiplicationProto.MultiplicationRequest;
import app.grpc.MultiplicationProto.MultiplicationResponse;
import io.grpc.stub.StreamObserver;

public class MultiplicationService extends MultiplicationGrpc.MultiplicationImplBase {

    @Override
    public void getMultiplicationTable(MultiplicationRequest request, StreamObserver<MultiplicationResponse> responseObserver) {
        int nombre = request.getNombre();
        int limite = request.getLimite();

        System.out.println("Début du calcul de la table de " + nombre + " jusqu'à " + limite);

        // On boucle pour générer les réponses une par une
        for (int i = 1; i <= limite; i++) {
            String resultat = nombre + " x " + i + " = " + (nombre * i);

            // Création de l'objet réponse
            MultiplicationResponse response = MultiplicationResponse.newBuilder()
                    .setResultat(resultat)
                    .build();

            // Envoi de la réponse partielle au client
            responseObserver.onNext(response);

            // Simulation d'un petit délai (optionnel, pour bien voir l'effet streaming)
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Une fois la boucle finie, on signale la fin du flux
        responseObserver.onCompleted();
        System.out.println("Fin du flux pour la table de " + nombre);
    }
}