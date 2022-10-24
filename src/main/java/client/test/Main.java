package client.test;

import java.io.IOException;

import client.DeltaTCPHelper;
import client.DeltaUDPHelper;

public class Main {
    public static void main(String[] args) throws IOException {

        // sendTCP();
        sendUDP();

    }

    public static void sendTCP() throws IOException {
        String host = "10.97.191.73";
        int port = 8094;
        DeltaTCPHelper tcpHelper = new DeltaTCPHelper(host, port);

        tcpHelper.send("cpu_load_short,host=server03,region=us-west value=0.64 1422568543702900257");
        tcpHelper.send("cpu_load_short,host=server03,region=us-west value=0.68 1441212145121202121");
        tcpHelper.send("cpu_load_short,host=server05,region=us-west value=0.61 1241214212355656586");
        tcpHelper.send("cpu_load_short,host=server03,region=us-west value=0.63 1234568698975364533");
        tcpHelper.send("cpu_load_short,host=server03,region=us-west value=0.65 1324568979863312312");
        tcpHelper.send("cpu_load_short,host=server04,region=us-west value=0.55 1423562321233221223");
        tcpHelper.send("cpu_load_short,host=server03,region=us-west value=0.56 1354664411155444545");
        tcpHelper.send("cpu_load_short,host=server04,region=us-west value=0.54 1425566665543125555");
        tcpHelper.send("cpu_load_short,host=server04,region=us-west value=0.55 ");
        tcpHelper.send("cpu_load_short,host=server07,region=us-west value=0.57");
    }

    public static void sendUDP() throws IOException {
        String host = "10.97.192.73";
        int port = 8092;
        String domain = "mo-ca0ebe818.mo.sap.corp";
        DeltaUDPHelper udpHelper = new DeltaUDPHelper(domain, port);

        // udpHelper.send("cpu_load_short,host=server08,region=us-west value=0.64 ");
        udpHelper.send("cpu_load_short,host=server08,region=us-west value=0.61 ");

        udpHelper.close();
    }

}
