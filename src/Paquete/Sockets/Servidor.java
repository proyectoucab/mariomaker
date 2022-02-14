/*import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.DatagramPacket;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Servidor extends Thread {
    private DatagramSocket socket;
    public JGameMaker juego;
    private List<JugadorMP> jugadoresConectados = new ArrayList<JugadorMP>(); 
    
    public Servidor(JGameMaker juego) {
        this.juego = juego;
        try {
            this.socket = new DatagramSocket(1331);
        } catch (SocketException e) {
            e.printStackTrace();
        } 
        //System.out.println("ME INICIE SERVIDOR");
    }
    
    //@Override
    public void run() {
        //System.out.println("Run servidor");
        while(true) {
            byte datos[] = new byte[1024];
            DatagramPacket paquete = new DatagramPacket(datos, datos.length);
            //System.out.println("Datagram servidor");
            try {
               // System.out.println("No recibio servidoraaaa");
                socket.receive(paquete);
               // System.out.println("Servi");
            } catch(IOException e) {
               // System.out.println("No recibio servidor");
                e.printStackTrace();
            }
            System.out.println("El pepe: " +paquete.getData() + " "+ paquete.getAddress() + " " + paquete.getPort());
            parsearPaquete(paquete.getData(), paquete.getAddress(), paquete.getPort());
            //System.out.println("Recibio servidor");
            String mensaje = new String(paquete.getData());
            
            if (mensaje.trim().equals("ping")) {
                enviarDatos("pong".getBytes(), paquete.getAddress(), paquete.getPort());
            }
            System.out.println("Cliente: " + mensaje);
        }
    }
    
    private void parsearPaquete(byte[] datos, InetAddress address, int puerto) {
        String mensaje = new String(datos).trim();
        Paquete.TiposDePaquetes tipo = Paquete.busquedaPaquete(mensaje.substring(0, 2));
        switch(tipo) {
            default:
            case INVALID:
                break;
            case LOGIN:
                Paquete00Login paquete = new Paquete00Login(datos);
                System.out.println(address.getHostAddress() + " " +  puerto + " " + " " + paquete.getNombreDeUsuario());
                //JugadorMP jugadorMP = null;
                //if (address.getHostAddress().equalsIgnoreCase("127.0.0.1")) {
                JugadorMP jugadorMP = new JugadorMP(address, puerto);
                //}
                this.jugadoresConectados.add(jugadorMP);
                System.out.println(jugadoresConectados.get(0));
                this.juego.getManager().getGame().getJugadoresConectados().add(jugadorMP);
                
                //juego.jugador = player
                
                break;
            case DISCONECT:
                break;
        }
    
    }
    
    public void enviarDatos(byte[] data, InetAddress ipAddress, int puerto) {
        DatagramPacket paquete = new DatagramPacket(data, data.length, ipAddress, puerto);
        
        try {
            socket.send(paquete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    
    }
    
    public void enviarDatosATodos(byte[] datos) {
        for(JugadorMP p: jugadoresConectados) {
            enviarDatos(datos, p.ipAddress, p.puerto);
        }
    }
    


} */