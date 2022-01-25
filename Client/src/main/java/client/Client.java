package client;

import text.TextGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static final Logger logger = Logger.getLogger(Client.class.getName());

    public static String serverIP = "localhost";
    public static int serverPort = 9000;

    public static String message = "Nothing to see here!";

    public static void main(String[] args) throws Exception {
        ManagedChannel channel = null;

        try {
            channel = ManagedChannelBuilder.forAddress(serverIP, serverPort)
                    .usePlaintext()
                    .build();

            TextGrpc.TextBlockingStub blockingStub = TextGrpc.newBlockingStub(channel);
            TextGrpc.TextStub nonBlockingStub = TextGrpc.newStub(channel);

            String options = "OPTIONS:\n1 - Download message\n2 - Upload message\n3 - See message\n4 - Update message\n5 - Exit";
            Scanner input = new Scanner(System.in);
            boolean end = false;
            while(!end) {
                System.out.println(options);
                switch(input.nextLine()) {
                    case "1":
                        ChunkStreamObserver chunks = new ChunkStreamObserver();
                        chunks.start(nonBlockingStub.download(chunks));
                        break;
                    case "2":
                        AcknowledgeStreamObserver acks = new AcknowledgeStreamObserver();
                        acks.start(nonBlockingStub.upload(acks));
                        break;
                    case "3":
                        System.out.println(message);
                        break;
                    case "4":
                        System.out.println("Write new message:");
                        message = input.nextLine();
                        System.out.println("Message updated.");
                        break;
                    case "5":
                        end = true;
                        break;
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error:" + ex.getMessage());
        }
        if (channel != null) {
            logger.log(Level.INFO, "Shutdown channel to Server.");
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
