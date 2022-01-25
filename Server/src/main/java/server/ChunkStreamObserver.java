package server;

import text.Acknowledge;
import text.Chunk;
import io.grpc.stub.StreamObserver;

public class ChunkStreamObserver implements StreamObserver<Chunk> {
    private final StreamObserver<Acknowledge> ackObserver;
    StringBuilder message;

    public ChunkStreamObserver(StreamObserver<Acknowledge> ackObserver) {
        this.ackObserver = ackObserver;
        message = new StringBuilder();
        // Send first Acknowledge to trigger chunk events:
        ackObserver.onNext(Acknowledge.newBuilder().setValue(true).build());
    }

    @Override
    public void onNext(Chunk chunk) {
        // Concatenate chunk bytes with current data:
        message.append(new String(chunk.getData().toByteArray()));
        // Acknowledge:
        ackObserver.onNext(Acknowledge.newBuilder().setValue(true).build());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        // Print full data:
        System.out.println(message.toString());
        // Update message:
        Server.message = message.toString();
        // Call onCompleted:
        ackObserver.onCompleted();
    }
}
