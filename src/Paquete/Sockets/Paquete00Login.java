
/*public class Paquete00Login  extends Paquete{
    
    private String nombreDeUsuario;
    
    public Paquete00Login(byte[] datos) {
        super(00);
        this.nombreDeUsuario = readData(datos);
    }
    
    public Paquete00Login(String nombreDeUsuario) {
        super(00);
        this.nombreDeUsuario = nombreDeUsuario;
    }
    
    @Override
    public void escribirDatos(Cliente cliente) {
        cliente.enviarDatos(getData());
    }
    
    @Override
    public void escribirDatos(Servidor servidor) {
        servidor.enviarDatosATodos(getData());
    }
        
    public String getNombreDeUsuario() {
        return this.nombreDeUsuario;
    }
    @Override
    public byte[] getData() {
        return ("00" + this.nombreDeUsuario).getBytes();
    }
}*/
