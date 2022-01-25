package client;

import text.Acknowledge;
import text.Chunk;
import io.grpc.stub.StreamObserver;

public class ChunkStreamObserver implements StreamObserver<Chunk> {
    StreamObserver<Acknowledge> ackObserver;
    StringBuilder message;

    public ChunkStreamObserver() {}

    public void start(StreamObserver<Acknowledge> ackObserver) {
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
        System.out.println("Download from server was successful!");
        // Update message:
        Client.message = message.toString();
        // Call onCompleted:
        ackObserver.onCompleted();
    }
}
