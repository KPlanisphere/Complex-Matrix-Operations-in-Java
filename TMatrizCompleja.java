//BENEMERITA UNIVERSIDAD AUTONOMA DE PUEBLA
//FACULTAD DE CIENCIAS DE LA COMPUTACION
//PROGRAMACION II - JESUS HUERTA AGUILAR

// --------------------> TMatrizCompleja

package com.mycompany.matricescomplejas;

public class TMatrizCompleja{
    // - - - - - ATRIBUTOS - - - - -
    private final int n,m;
    private final TComplejo matriz[][];

    // - - - - - METODOS - - - - -
    //CONTRUCTOR
    TMatrizCompleja(int n, int m){
        this.n = n;
        this.m = m;
        matriz = new TComplejo[n][m];

        //INSTANCIACION DE LOS COMPONENTES DE LA MATRIZ
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                matriz[i][j] = new TComplejo();
            }
        }
    }

    //SET
    public void setComponente(int i, int j, TComplejo valor){
        matriz[i][j].setNumReal(valor.getNumReal());
        matriz[i][j].setDenReal(valor.getDenReal());
        matriz[i][j].setNumImag(valor.getNumImag());
        matriz[i][j].setDenImag(valor.getDenImag());
    }

    //GET
    public int getNumeroFilas(){
        return n;
    }

    public int getNumeroColumnas(){
        return m;
    }

    public TComplejo getComponente(int i, int j){
        return matriz[i][j];
    }

    //DIVERSOS
    @Override
    public String toString(){
        String cadena = "";
        int i, j;

        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                cadena = cadena +  matriz[i][j].toString() + "       \t  \t   ";
            }
            cadena = cadena + "\n";
        }
        return cadena;
    }

}//FIN TMatrizCompleja
