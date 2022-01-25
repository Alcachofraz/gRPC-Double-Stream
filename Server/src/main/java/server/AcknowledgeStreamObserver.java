package server;

import com.google.protobuf.ByteString;
import text.Acknowledge;
import text.Chunk;
import io.grpc.stub.StreamObserver;

public class AcknowledgeStreamObserver implements StreamObserver<Acknowledge> {
    final int CHUNK_LENGTH = 4;

    StreamObserver<Chunk> chunkObserver;

    private int index;
    private String currentChunk;

    public AcknowledgeStreamObserver(StreamObserver<Chunk> chunkObserver) {
        this.chunkObserver = chunkObserver;
        index = 0;
    }

    @Override
    public void onNext(Acknowledge acknowledge) {
        try {
            if (acknowledge.getValue()) {
                if (index >= Server.message.length()) {
                    chunkObserver.onCompleted();
                    return;
                }
                int newIndex = Math.min(index + CHUNK_LENGTH, Server.message.length());
                currentChunk = Server.message.substring(index, newIndex);
                index = newIndex;
            }
            System.out.println("Sending: " + currentChunk);
            chunkObserver.onNext(Chunk.newBuilder().setData(ByteString.copyFrom(currentChunk.getBytes())).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        System.out.println("Client got whole file! Success!");
    }
}
