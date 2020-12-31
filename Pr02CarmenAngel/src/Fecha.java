
public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    private static final int[] diasPorMes = 
        {0,31,28,31,30,31,30,31,31,30,31,30,31};
    
    public Fecha() {
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    private boolean esBisiesto(){
        return (anio%4==0||anio%400==0)&&anio%100!=0;
    }
    private boolean fechaCorrecta(){
        if (mes <= 0 || mes > 12){
            return false;        
        }
        else if (dia <=0 || (dia > diasPorMes[mes] && esBisiesto()==false)){
            return false;
        }
        else return !(mes == 2 && dia == 29 && esBisiesto()==true);
        
    }
    public void diaSiguiente(){
        
        dia++;
        if(!fechaCorrecta()){
            
            dia = 1;
            mes++;
            if(!fechaCorrecta()){
                mes = 1;
                anio++;
            }
        }
    }
    
    @Override
    public String toString(){
        if(fechaCorrecta()==true){
            System.out.println(fechaCorrecta());
            String cadena;
            if(dia<10&&mes<10){
                cadena = String.format("%02d-%02d-%d",dia,mes,anio);
            }
            else if(dia<10&&mes>10){
                    cadena=String.format("%02d-%2d-%d",dia,mes,anio);
            }
            else if(dia>10&&mes<10){
                cadena=String.format("%2d-%02d-%d",dia,mes,anio);
            }
            else{
                cadena=String.format("%2d-%2d-%d",dia,mes,anio);
            }
            return cadena;
        }else{
            System.out.println(fechaCorrecta());
            return "Fecha inválida";
        }
    }
    
}