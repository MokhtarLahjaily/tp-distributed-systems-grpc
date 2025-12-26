package app.grpc.service;

import app.grpc.AuthenticationGrpc;
import app.grpc.UserProto;
import app.grpc.entity.Utilisateur;
import app.grpc.repository.UtilisateurRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class UserService extends AuthenticationGrpc.AuthenticationImplBase {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public void login(UserProto.LoginRequest request, StreamObserver<UserProto.LoginResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        Utilisateur user = utilisateurRepository.findByUsername(username);

        UserProto.LoginResponse.Builder response = UserProto.LoginResponse.newBuilder();

        if (user != null && user.getPassword().equals(password)) {
            response.setMsgReponse("SUCCESS").setIdResponse(user.getId().intValue());
        } else {
            response.setMsgReponse("WRONG CREDENTIALS").setIdResponse(0);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}