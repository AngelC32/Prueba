

public class Persona {
    private int historiaClinica;
    private String nombres;
    private int edad;
    private char sexo;
    private double peso;
    private double altura;
    private double imc;
    private String clasificacion;
    private Fecha registro= new Fecha();

    public Persona(int historiaClinica,String nombres, int edad, char sexo, double peso, double altura, Fecha registro) {
        this.historiaClinica=historiaClinica;
        this.nombres = nombres;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.registro=registro;
        calcularIMC();
        comprobarSexo(sexo);
    }
    
    public void calcularIMC(){
        imc=peso/(altura*altura);
        if(imc<16.00){
            clasificacion="Infrapeso: Delgadez";
        }
        else if(imc>=16.00 && imc<17.00){
            clasificacion="Severa";
        }
        else if((imc>=17.00 && imc<18.50)||(imc>=25.00 && imc<30.00)){
            clasificacion="Infrapeso: Delgadez";
        }
        else if(imc>=18.50 && imc<25){
            clasificacion="moderada";
        }
        else if(imc>=30.00 && imc<35){
            clasificacion="aceptable";
        }
        else if(imc>=35.00 && imc<=40.00){
            clasificacion="Peso Normal";
        }
        else if(imc>40.00){
            clasificacion="Sobrepeso"+"\n"+
                          "Obeso: Tipo I"+"\n"+
                          "Obeso: Tipo II"+"\n"+  
                          "Obeso: Tipo III"
                    ;
        }
    }
    public boolean esMayorDeEdad(){
        return edad>=18;
    }
    public void comprobarSexo(char sexo){
        if(!(this.sexo=='m'||this.sexo=='M'||this.sexo=='f'||this.sexo=='F')){
            this.sexo='H';
        }
    }
    @Override
    public String toString(){
        return "Datos del paciente: \n\n"+
                "N° Historial Clinico:\t"+historiaClinica+"\n"+
                "Nombres:\t"+nombres+"\n"+
                "Edad:\t"+edad+"\n"+
                "Sexo:\t"+sexo+"\n"+
                "Peso:\t"+peso+" kg."+"\n"+
                "Altura:\t"+altura+" mt."+"\n"+
                "Fecha de Registro:\t"+registro+"\n"+
                String.format("IMC:\t %.2f",imc)+"\n"+
                "Clasificacion:\t"+clasificacion+"\n";

    }
}
