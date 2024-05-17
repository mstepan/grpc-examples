package github.com.mstepan.grpc.examples;

import java.io.IOException;

public class AppMain {

    public static final int PORT = 50051;

    /** Main launches the server. Command line can be used to customize port */
    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer server = new GrpcServer(PORT);
        server.start();
        server.blockUntilShutdown();
    }
}
