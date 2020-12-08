 package modelo;

public class Rut {
    private int rut;
    private String dv;

    public Rut(int rut, String dv) {
        this.rut = rut;
        this.dv = dv;
    }

    public Rut() {
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }
    
    public static boolean validarRut(int rut, String dv){
        Rut aux = new Rut(rut, dv);
        return aux.validarRut();
    }
    
    public static boolean validarRut(String rut){
        try{
            String[] aux = rut.split("-", 2);
            return Rut.validarRut(Integer.parseInt(aux[0]), aux[1]);
        } catch (java.lang.ArrayIndexOutOfBoundsException | NumberFormatException e){
            return false;
        }
    }
    
    public boolean validarRut(){
        int r=rut,suma=0,c=2;
        while (r>0){
            int d=r%10;
            suma+=d*c;
            c++;
            if (c>7){
                c=2;
            }
            // System.out.println("d="+d);
            r=r/10;
        }
        // System.out.println("Suma="+suma);
        int resto=suma%11;
        String dvRes="";
        if (resto==0){
            dvRes="0";
        }else{
            if (resto==1){
                dvRes="K";
            }else{
                dvRes=""+(11-resto);
            }                    
        }
        
        if (dv.equalsIgnoreCase(dvRes)){
            return true;
        }else{
            return false;
        }   
    }
    /*
    public static void main(String[] args) {
        Rut rr=new Rut(16618975,"6");
        rr.validarRut();
        
        
    }
    */
}
