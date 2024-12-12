package rpc;

import grpc.RpcServiceGrpc;
import grpc.RpcServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientApp {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        RpcServiceGrpc.RpcServiceBlockingStub stub = RpcServiceGrpc.newBlockingStub(channel);

        RpcServiceOuterClass.HelloRequest request = RpcServiceOuterClass.HelloRequest.newBuilder()
                .setName("Usuario RPC")
                .build();

        RpcServiceOuterClass.HelloResponse response = stub.sayHello(request);
        System.out.println("Respuesta del servidor: " + response.getMessage());

        channel.shutdown();
    }
}
