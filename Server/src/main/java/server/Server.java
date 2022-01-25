package server;

import text.*;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class Server extends TextGrpc.TextImplBase{
    public static String message = "Hi, I'm the original file!";

    public static final Logger logger = Logger.getLogger(Server.class.getName());

    public static int serverPort = 9000;

    public static void main(String[] args) throws Exception {
        try {
            final io.grpc.Server svc = ServerBuilder.forPort(serverPort)
                    .addService(new Server())
                    .build()
                    .start();
            logger.info("SERVER: Server started, listening on " + serverPort + "...");
            svc.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public StreamObserver<Chunk> upload(StreamObserver<Acknowledge> responseObserver) {
        return new ChunkStreamObserver(responseObserver);
    }

    @Override
    public StreamObserver<Acknowledge> download(StreamObserver<Chunk> responseObserver) {
        return new AcknowledgeStreamObserver(responseObserver);
    }
}
