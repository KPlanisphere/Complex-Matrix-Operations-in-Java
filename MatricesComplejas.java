//BENEMERITA UNIVERSIDAD AUTONOMA DE PUEBLA
//FACULTAD DE CIENCIAS DE LA COMPUTACION
//PROGRAMACION II - JESUS HUERTA AGUILAR

// --------------------> Principal

package com.mycompany.matricescomplejas;

import java.util.Scanner;

public class MatricesComplejas{
    public static void main(String[] args){
        TMatrizCompleja A,B,C;
        int n,m;
        long numreal,numimag,denreal,denimag;
        TComplejo ayuda = new TComplejo();

        Scanner sc = new Scanner(System.in);
        TOpMatricesComplejas op = new TOpMatricesComplejas();

        System.out.println("\n / / / / / CALCULADORA DE MATRICES COMPLEJAS / / / / /\n");
        System.out.println("INGRESA EL TAMAÑO DE LAS MATRICES A Y B:");
        System.out.print(" | FILAS: ");
        n = sc.nextInt();
        System.out.print(" | COLUMNAS: ");
        m = sc.nextInt();

        A = new TMatrizCompleja(n,m);
        B = new TMatrizCompleja(n,m);
        C = new TMatrizCompleja(n,m);

        //ENTRADA DE DATOS MATRIZ A
        System.out.println("\nIngresa los componentes complejos de la matriz A");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("//// MATRIZ[%d][%d]\n",(i+1),(j+1));
                System.out.println("---REAL: ");
                System.out.printf(" | NUMERADOR:");
                numreal = sc.nextInt();
                System.out.printf(" | DENOMINADOR:");
                denreal = sc.nextInt();
                System.out.println("---IMAGINARIO: ");
                System.out.printf(" | NUMERADOR:");
                numimag = sc.nextInt();
                System.out.printf(" | DENOMINADOR:");
                denimag= sc.nextInt();
                
                ayuda.setNumReal(numreal);
                ayuda.setDenReal(denreal);
                ayuda.setNumImag(numimag);
                ayuda.setDenImag(denimag);
                A.setComponente(i,j,ayuda);
                System.out.println();
            }
            System.out.println("----------\n");
        }

        //ENTRADA DE DATOS MATRIZ B
        System.out.println("\nIngresa los componentes complejos de la matriz B");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("//// MATRIZ[%d][%d]\n",(i+1),(j+1));
                System.out.println("---REAL: ");
                System.out.printf(" | NUMERADOR:");
                numreal = sc.nextInt();
                System.out.printf(" | DENOMINADOR:");
                denreal = sc.nextInt();
                System.out.println("---IMAGINARIO: ");
                System.out.printf(" | NUMERADOR:");
                numimag = sc.nextInt();
                System.out.printf(" | DENOMINADOR:");
                denimag= sc.nextInt();
                
                ayuda.setNumReal(numreal);
                ayuda.setDenReal(denreal);
                ayuda.setNumImag(numimag);
                ayuda.setDenImag(denimag);
                B.setComponente(i,j,ayuda);
                System.out.println();
            }
            System.out.print("----------\n\n");
        }

        //SALIDA SUMA MATRIZ A B
        C = op.sumaMatricesComplejas(A,B);
        System.out.println("\nSUMA DE MATRICES: ");
        System.out.println(C.toString());

        //SALIDA RESTA MATRIZ A B
        C = op.restaMatricesComplejas(A,B);
        System.out.println("\nRESTA DE MATRICES: ");
        System.out.println(C.toString());

        //SALIDA MULTIPLICACION MATRIZ A B
        C = op.multiplicaMatricesComplejas(A,B);
        System.out.println("\nMULTIPLICACION DE MATRICES: ");
        System.out.println(C.toString());

        //SALIDA MULTIPLICACION MATRIZ A*Inv(B)
        B = op.inversaMatrizCompleja(B);
        C = op.multiplicaMatricesComplejas(A,B);
        System.out.println("\nMULTIPLICACION DE MATRICES A*INV(B): ");
        System.out.println(C.toString());

    }//FIN MAIN
}//FIN CALSE PRINCIPAL