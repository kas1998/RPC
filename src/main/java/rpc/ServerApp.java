package rpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerApp {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new RPCServiceImpl())
                .build();

        System.out.println("Servidor RPC iniciado en el puerto 50051.");
        server.start();
        server.awaitTermination();
    }
}
