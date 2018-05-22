package tk.bghgu.gateway.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.bghgu.gateway.service.TcpService;

/**
 * Created by ds on 2018-05-22.
 */

@RestController
public class TcpController {

    @Autowired
    private TcpService tcpService;

    @GetMapping("tcp")
    public ResponseEntity<String> echoTcpGet() {
        return new ResponseEntity<>(tcpService.callTcpServer(), HttpStatus.OK);
    }
}
