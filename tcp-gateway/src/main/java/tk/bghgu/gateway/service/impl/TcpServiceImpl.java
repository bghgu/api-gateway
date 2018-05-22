package tk.bghgu.gateway.service.impl;

import org.springframework.stereotype.Service;
import tk.bghgu.gateway.service.TcpService;

import java.io.DataInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by ds on 2018-05-22.
 */

@Service
public class TcpServiceImpl implements TcpService {

    public String callTcpServer() {
        String res = "Tcp Server Connection Fail";
        try (Socket serverSocket = new Socket()) {
            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 5000);
            serverSocket.connect(inetSocketAddress);

            try (
                    //InputStream inputStream = serverSocket.getInputStream();
                    DataInputStream dataInputStream = new DataInputStream(serverSocket.getInputStream())
            ) {
                res = dataInputStream.readUTF();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return res;
    }
}
