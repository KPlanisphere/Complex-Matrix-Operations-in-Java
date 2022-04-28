//BENEMERITA UNIVERSIDAD AUTONOMA DE PUEBLA
//FACULTAD DE CIENCIAS DE LA COMPUTACION
//PROGRAMACION II - JESUS HUERTA AGUILAR

// --------------------> TComplejo

package com.mycompany.matricescomplejas;

public class TComplejo{
    // - - - - - ATRIBUTOS - - - - -
    private long numreal,denreal,numimag,denimag;
    
    // - - - - - METODOS - - - - -
    //CONSTRUCTORES
    TComplejo(){
        numreal = 0;
        denreal = 1;
        numimag = 0;
        denimag = 1;
    }

    TComplejo(long numreal, long denreal, long numimag, long denimag){
        this.numreal = numreal;
        this.denreal = denreal;
        this.numimag = numimag;
        this.denimag = denimag;
        //DENOMINADOR REAL
        if(denreal!=0)
            this.denreal = denreal;
        else
            this.denreal = Integer.MIN_VALUE;
        //DENOMINADOR IMAGINARIO
        if(denimag!=0)
            this.denimag = denimag;
        else
            this.denimag = Integer.MIN_VALUE;
    }

    //METODOS SET
    public void setNumReal(long numreal){
        this.numreal = numreal;
    }

    public void setDenReal(long denreal){
        this.denreal = denreal;
    }
    
    public void setNumImag(long numimag){
        this.numimag = numimag;
    }
    
    public void setDenImag(long denimag){
        this.denimag = denimag;
    }
    
    //METODOS GET
    public long getNumReal(){
        return numreal;
    }

    public long getDenReal(){
        return denreal;
    }
    
    public long getNumImag(){
        return numimag;
    }

    public long getDenImag(){
        return denimag;
    }
    
    //METODOS DIVERSOS
    private long mcd(long a, long b){
        
        if(b == 0)
            return a;
        else
            return mcd(b, a%b);
    }

    public void simplificaComplejoReal(){
        long MCD;
        
        if(numreal>denreal){
            MCD = mcd(numreal,denreal);
        }
        else{
            MCD = mcd(denreal,numreal);
        }
        
        numreal = numreal/MCD;
        denreal = denreal/MCD;
    }
    
    public void simplificaComplejoImaginario(){
        long MCD;

        if(numimag>denimag){
            MCD = mcd(numimag,denimag);
        }
        else{
            MCD = mcd(denimag,numimag);
        }
        numimag = numimag/MCD;
        denimag = denimag/MCD;
    }

    @Override
    public String toString(){
        String cadena,cadenaReal,cadenaImag = "";
        int negative = 0;
        
        //SOLUCION DENOMINADOR NEGATIVO REAL
        if(denreal<0){
            denreal = denreal*-1;
            numreal = numreal*-1;
        }
        
        if(denreal == 1){
            cadenaReal = Long.toString(numreal);
        }
        else if(numreal == 0){
            cadenaReal = "0";
        }
        else{
            cadenaReal = Long.toString(numreal) + "/" + Long.toString(denreal);
        }
        
        //SOLUCION DENOMINADOR NEGATIVO IMAGINARIO
        if(denimag<0){
            denimag = denimag*-1;
            numimag = numimag*-1;
        }
        
        if(numimag < 0){
            negative = 1;
            numimag = numimag*-1;
        }

        if(denimag == 1){
            cadenaImag = Long.toString(numimag);
        }
        else if(numimag == 0){
            cadenaImag = "0";
        }
        else{
            cadenaImag = "(" + Long.toString(numimag) + "/" + Long.toString(denimag) + ")";
        }
        
        if(("0".equals(cadenaReal)) && ("0".equals(cadenaImag))){
            cadena = "[0]";
        }
        else if("0".equals(cadenaImag)){
            cadena = "[" + cadenaReal + "]";
        } 
        else if("0".equals(cadenaReal) && negative == 0){
            cadena = "[" + cadenaImag + "i]"; 
        }
        else if("0".equals(cadenaReal) && negative == 1){
            cadena = "[ -" + cadenaImag + "i]"; 
        }
        else if("1".equals(cadenaImag) && negative == 0){
            cadena = "[" + cadenaReal + " + i]";
        }
        else if("1".equals(cadenaImag) && negative == 1){
            cadena = "[" + cadenaReal + " - i]";
        }
        else if(negative == 1){
            cadena = "[" + cadenaReal + " - " + cadenaImag + "i]";
        }
        else{
            cadena = "[" + cadenaReal + " + " + cadenaImag + "i]";
        }
        return cadena;
    }

}//FIN CLASE TComplejo