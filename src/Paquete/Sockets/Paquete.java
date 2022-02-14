
/*public abstract class Paquete {
    public static enum TiposDePaquetes {
        INVALID(-1), LOGIN(00), DISCONECT(01);
        private int idPaquete;
        
        private TiposDePaquetes(int idPaquete) {
            this.idPaquete = idPaquete;
        }
        
        public int getId() {
            return idPaquete;
        }
    } 
    
    public byte idPaquete;
    
    public Paquete(int idPaquete) {
        this.idPaquete = (byte) idPaquete;
    }
    
    public abstract void escribirDatos(Cliente cliente);
    public abstract void escribirDatos(Servidor servidor);
    
    public abstract byte[] getData();
    
    public String readData(byte[] datos) {
        String mensaje = new String(datos).trim();
        return mensaje.substring(2);
    }

    public static TiposDePaquetes busquedaPaquete(String id) {
        
        try {
            return busquedaPaquete(Integer.parseInt(id));
        } catch (NumberFormatException e){
            return TiposDePaquetes.INVALID;
            
        }
        
       /* for (TiposDePaquetes p: TiposDePaquetes.values()) {
            if (p.getId() == id) {
                return p;
            }
        }
        
        return TiposDePaquetes.INVALID; */
   // }
    
    
    /*public static TiposDePaquetes busquedaPaquete(int id) {
        
        for (TiposDePaquetes p: TiposDePaquetes.values()) {
            if (p.getId() == id) {
                return p;
            }
        }
        
        return TiposDePaquetes.INVALID;
    }
} */
