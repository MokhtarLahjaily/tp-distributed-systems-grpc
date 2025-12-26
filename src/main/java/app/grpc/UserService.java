package app.grpc;

import app.grpc.UserProto.LoginRequest;
import app.grpc.UserProto.LoginResponse;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        // Construction de la réponse
        LoginResponse.Builder response = LoginResponse.newBuilder();

        // Logique métier simple : succès si le mot de passe est identique au nom d'utilisateur
        if (username.equals(password)) {
            response.setIdResponse(0).setMsgReponse("SUCCES");
        } else {
            response.setIdResponse(100).setMsgReponse("NON VALIDE");
        }

        // Envoi de la réponse au client
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}