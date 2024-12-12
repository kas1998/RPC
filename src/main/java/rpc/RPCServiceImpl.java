package rpc;

import grpc.RpcServiceGrpc;
import grpc.RpcServiceOuterClass;

public class RPCServiceImpl extends RpcServiceGrpc.RpcServiceImplBase {

    @Override
    public void sayHello(RpcServiceOuterClass.HelloRequest request,
                         io.grpc.stub.StreamObserver<RpcServiceOuterClass.HelloResponse> responseObserver) {
        String name = request.getName();
        String message = "¡Hola, " + name + "! Bienvenido a RPC con gRPC.";

        RpcServiceOuterClass.HelloResponse response = RpcServiceOuterClass.HelloResponse.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
