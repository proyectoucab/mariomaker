/*import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.DatagramPacket;
import java.io.IOException;

public class Cliente extends Thread {
    private InetAddress ipAddress;
    private DatagramSocket socket;
    private JGameMaker juego;
    
    public Cliente(JGameMaker juego, String ipAddress) {
        this.juego = juego;
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        try {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //System.out.println("ME INICIE CLIENTE");
    }
    
    //@Override
    public void run() {
       // System.out.println("Run cliente");
        while(true) {
            byte datos[] = new byte[1024];
            DatagramPacket paquete = new DatagramPacket(datos, datos.length);
           // System.out.println("Datagram cliente");
            try {
                //System.out.println("No recibio clienteaaaa");
                socket.receive(paquete);
                //System.out.println("cle");
            } catch(IOException e) {
               // System.out.println("No ecibio cliente");
                e.printStackTrace();
            }
            //System.out.println("Recibio cliente");
            String mensaje = new String(paquete.getData());
            //System.out.println("Servidor: " + new String(paquete.getData()));
            System.out.println("Servidor: " + mensaje);
        }
    }
    
    public void enviarDatos(byte[] data) {
        DatagramPacket paquete = new DatagramPacket(data, data.length, ipAddress, 1331);
        try {
            socket.send(paquete);
        } catch (IOException e) {
            e.printStackTrace();
        }       
    
    }
} */
