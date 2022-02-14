



import javax.swing.*;
import java.awt.*;
/**
 * Almacena las constantes del juego e inicializa el juego.
 *
 */
public class JGameMaker extends JPanel{
	
	
	/*public static JPanel panel;

	static String ip = "localhost";
	static int port = 22222;
	private Scanner scanner = new Scanner(System.in);

	static  Socket socket;
	static DataOutputStream dos;
	static DataInputStream dis;
	
        public static Paquete00Login login = new Paquete00Login(JOptionPane.showInputDialog("Introduce nombre de usuario"));
        
        //public static Paquete00Login login = new Paquete00Login("saadadafafafa");
	private Thread thread;

        public static Cliente cliente;
        private Servidor sservidor;
        
	static boolean servidor = false;

	static ServerSocket serverSocket;	
	
	
	
	
	
	*/	
	
	
	
	
	
	public static JPanel panel;
	
	private static final long serialVersionUID = 8930735783398997076L;
	private static long ultimoTiempo;
	private static long tiempoPasado;
	private static final long FRECUENCIA_ACTUALIZACION = 15000000;
	public static final int NIVEL_SUELO = 50,TIEMPO_SALTO_COMPLETO = 20;

	public static final Font	FONT_ENORME = new Font("Arial Black", Font.PLAIN, 80),
								FONT_GRANDE = new Font("Arial Black", Font.PLAIN, 40),
								FONT_MEDIO = new Font("Tahoma", Font.PLAIN, 20);
	public static int screenWidth = 800,screenHeight = 600;
	
	public static final double GRAVEDAD = 0.701;
	
	private ScreenManager manager;
	
	
	/*static boolean connect() {
		try {
			socket = new Socket(ip, port);
			dos = new DataOutputStream(socket.getOutputStream());
			//dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			dis = new DataInputStream(socket.getInputStream());
			accepted = true;
		} catch (IOException e) {
			System.out.println("Incapaz de conectar a : " + ip + ":" + port + " | Iniciando servidor");
			return false;
		}
		System.out.println("Se conecto exitosamente al servidor.");
		return true;
	}*/	
	
	
	/*private void initializeServer() {
		try {
			serverSocket = new ServerSocket(port, 8, InetAddress.getByName(ip));
			this.servidor = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//yourTurn = true;
		//circle = false;
	} */


	/*public static void listenForServerRequest() {
		Socket socket = null;
		try {
			socket = serverSocket.accept();
			dos = new DataOutputStream(socket.getOutputStream());
			//dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			dis = new DataInputStream(socket.getInputStream());
			accepted = true;
			System.out.println("CLIENT HAS REQUESTED TO JOIN, AND WE HAVE ACCEPTED");
		} catch (IOException e) {
			e.printStackTrace();
		}
	} */	
	
	
	
	/**
	 * devuelve la cantidad de tiempo que ha pasado desde la última actualización de pantalla
* @return la cantidad de tiempo que ha pasado desde la última actualización de pantalla
	 */
	public static double time(){
		double d = 1.0*tiempoPasado/FRECUENCIA_ACTUALIZACION;
		//si nos retrasamos demasiado entonces finge que no ha pasado el tiempo
		if(d > 10){
			return 0;
		}
		return d;
	}
	
	public static void actualizarTiempo(){
		tiempoPasado = System.nanoTime() - ultimoTiempo;
		ultimoTiempo = System.nanoTime();
	}
	
	/**
	 * utilizado para redondear objetos en el juego para dibujar en la pantalla (coordenada x)
	 */
	public static int scaleW(double x){
		return (int)(x + 0.5);
	}
	/**
	 * utilizado para redondear objetos en el juego para dibujar en la pantalla (coordenada y)
	 */
	public static int scaleH(double y){
		return (int)(y + 0.5);
	}
	
	public void paintComponent(Graphics g){
		if(!manager.didThink()) return;
		super.paintComponent(g);
		manager.draw(g);
		g.setColor(Color.YELLOW);
		g.setFont(FONT_GRANDE);
	}
	
	/**
	 * hace que el juego pase a pantalla completa
*             JFrame a pantalla completa
	 */
	public void colocarPantallaCompleta(JFrame w){
		w.setUndecorated(true);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screensize.width;
		screenHeight = screensize.height;
	}
	
	/**
	 * crea todo el juego, con los diferentes módulos, librerias.
	 */
	public JGameMaker(){
        /*    new Thread(this).start();
            if (JOptionPane.showConfirmDialog(this, "¿Quieres ejecutar el servidor?") == 0) {
                sservidor = new Servidor(this);
                sservidor.start();

            }
            cliente = new Cliente(this, "localhost");

                
                //System.out.println("WAKAWAKA");
            cliente.start();
            cliente.enviarDatos("ping".getBytes());

		*/		
		
		
		
		
		setBackground(Color.BLACK);
		manager = new ScreenManager(new FileOpener(this));
		this.setFocusable(true);
		this.addMouseMotionListener(manager);
		this.addMouseListener(manager);
		this.addKeyListener(manager);
		JFrame w = new JFrame("JGameMaker");
		colocarPantallaCompleta(w);
		w.setBounds(0, 0, screenWidth, screenHeight);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.getContentPane().add(this);
		w.setVisible(true);
		w.setResizable(false);
		
		ultimoTiempo = System.nanoTime() - 10000000;
		
		
		while(true){
			actualizarTiempo();
			manager.think();
		
			if(tiempoPasado/FRECUENCIA_ACTUALIZACION > 1){
				// retrasar por actualizacion de tiempo
			}else{
				try { 
					Thread.sleep(5);
				} catch (Exception e) {
					
				}
			}
			repaint();
		}
	}
	
	public static void main(String[] args){
		panel = new JGameMaker();
    }
    
}
