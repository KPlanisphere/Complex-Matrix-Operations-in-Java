//BENEMERITA UNIVERSIDAD AUTONOMA DE PUEBLA
//FACULTAD DE CIENCIAS DE LA COMPUTACION
//PROGRAMACION II - JESUS HUERTA AGUILAR

//----------->TOpMatricesComplejas

package com.mycompany.matricescomplejas;

public class TOpMatricesComplejas{
    // - - - - - METODOS DIVERSOS - - - - -
    //SUMA
    TMatrizCompleja sumaMatricesComplejas(TMatrizCompleja matriz1, TMatrizCompleja matriz2){
        TMatrizCompleja res;
        if((matriz1.getNumeroFilas() == matriz2.getNumeroFilas()) && 
        (matriz1.getNumeroColumnas() == matriz2.getNumeroColumnas())){
            TOperaComplejos op = new TOperaComplejos();
            TComplejo ayuda = new TComplejo();
            res = new TMatrizCompleja(matriz1.getNumeroFilas(),matriz1.getNumeroColumnas());
            //SUMA POR COMPÓNENTES
            for(int i=0;i<matriz1.getNumeroFilas();i++){
                for(int j=0;j<matriz1.getNumeroColumnas();j++){
                    ayuda = op.sumaComplejo(matriz1.getComponente(i,j),matriz2.getComponente(i,j));
                    //SIMPLIFICACION
                    ayuda.simplificaComplejoReal();
                    ayuda.simplificaComplejoImaginario();
                    res.setComponente(i,j,ayuda);
                }
            }
            return res;
        }
        else
            return null;
    }

    //RESTA
    TMatrizCompleja restaMatricesComplejas(TMatrizCompleja matriz1, TMatrizCompleja matriz2){
        TMatrizCompleja res;
        if((matriz1.getNumeroFilas() == matriz2.getNumeroFilas()) && 
        (matriz1.getNumeroColumnas() == matriz2.getNumeroColumnas())){
            TOperaComplejos op = new TOperaComplejos();
            TComplejo ayuda = new TComplejo();
            res = new TMatrizCompleja(matriz1.getNumeroFilas(),matriz1.getNumeroColumnas());
            //RESTA POR COMPÓNENTES
            for(int i=0;i<matriz1.getNumeroFilas();i++){
                for(int j=0;j<matriz1.getNumeroColumnas();j++){
                    ayuda = op.restaComplejo(matriz1.getComponente(i,j),matriz2.getComponente(i,j));
                    //SIMPLIFICACION
                    ayuda.simplificaComplejoReal();
                    ayuda.simplificaComplejoImaginario();
                    res.setComponente(i,j,ayuda);
                }
            }
            return res;
        }
        else
            return null;
    }

    //MULTIPLICACION
    TMatrizCompleja multiplicaMatricesComplejas(TMatrizCompleja matriz1, TMatrizCompleja matriz2){
        TMatrizCompleja res;
        if(matriz1.getNumeroColumnas() == matriz2.getNumeroFilas()){
            TOperaComplejos op = new TOperaComplejos();
            TComplejo ayuda1 = new TComplejo();
            TComplejo ayuda2 = new TComplejo();
            res = new TMatrizCompleja(matriz1.getNumeroFilas(),matriz2.getNumeroColumnas());
            //MULTIPLICACION POR COMPÓNENTES
            for(int i=0;i<matriz1.getNumeroFilas();i++){
                for(int j=0;j<matriz1.getNumeroColumnas();j++){
                    ayuda1.setNumReal(0);
                    ayuda1.setDenReal(1);
                    ayuda1.setNumImag(0);
                    ayuda1.setDenImag(1);
                    res.setComponente(i,j,ayuda1);
                    for(int k=0;k<matriz1.getNumeroColumnas();k++){
                        ayuda2 = op.multiplicaComplejo(matriz1.getComponente(i,k),matriz2.getComponente(k,j));
                        ayuda1 = op.sumaComplejo(ayuda1,ayuda2);
                    }
                    //SIMPLIFICACION
                    ayuda1.simplificaComplejoReal();
                    ayuda1.simplificaComplejoImaginario();
                    res.setComponente(i,j,ayuda1);
                }
            }
            return res;
        }
        else
            return null;
    }

    //INVERSA
    public TMatrizCompleja inversaMatrizCompleja(TMatrizCompleja matriz){
        TMatrizCompleja ma,mi;
        int n;
        if(matriz.getNumeroColumnas() == matriz.getNumeroFilas()){
            n = matriz.getNumeroFilas();
            mi = new TMatrizCompleja(n,n);
            ma = new TMatrizCompleja(n,2*n);
            TComplejo cero = new TComplejo();
            TComplejo uno = new TComplejo(1,1,0,1);
            TComplejo menos_uno = new TComplejo(-1,1,0,1); //  -1/1 + 0i
            
            TOperaComplejos op = new TOperaComplejos();
            TComplejo pivote = new TComplejo();
            TComplejo ayuda1 = new TComplejo();
            TComplejo ayuda2 = new TComplejo();

            //CONSTRUIMOS LA SEGUNDA PARTE DE LA MATRIZ AMPLIADA
            //COPIA MATRIZ A LA MATRIZ AMPLIADA (MA)
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    ma.setComponente(i,j,matriz.getComponente(i,j));
                }
                for(int j=n;j<2*n;j++){
                    ma.setComponente(i,j,cero);
                }
                ma.setComponente(i,i+n,uno);
            }
            
            //METODO DE GAUSS-JORDAN (MATRIZ ESCALONADA)
            //HACE LA MATRIZ TRIANGULAR INFERIOR DE CEROS
            for(int k=0;k<n-1;k++){
                for(int i=k+1;i<n;i++){
                    if(ma.getComponente(k,k) == cero){
                        return null;
                    }
                    else{
                        ayuda1 = op.multiplicaComplejo(menos_uno,ma.getComponente(i,k));
                        
                        //SIMPLIFICACION AYUDA1
                        ayuda1.simplificaComplejoReal();
                        ayuda1.simplificaComplejoImaginario();
                        
                        ayuda2 = ma.getComponente(k,k);
                        pivote = op.divideComplejo(ayuda1,ayuda2);
                        
                        //SIMPLIFICACION PIVOTE
                        pivote.simplificaComplejoReal();
                        pivote.simplificaComplejoImaginario();
                        
                        for(int j=k;j<2*n;j++){
                            ayuda1 = op.multiplicaComplejo(pivote,ma.getComponente(k,j));

                            //SIMPLIFICACION AYUDA1 PT II
                            ayuda1.simplificaComplejoReal();
                            ayuda1.simplificaComplejoImaginario();
                        
                            ayuda2 = op.sumaComplejo(ayuda1,ma.getComponente(i,j));
                            
                            //SIMPLIFICACION RESULTADOS
                            ayuda2.simplificaComplejoReal();
                            ayuda2.simplificaComplejoImaginario();
                            
                            ma.setComponente(i,j,ayuda2);
                        }
                    }
                }
            }
            
            //HACE LA MATRIZ TRIANGULAR SUPERIOR DE CEROS
            for(int k=n-1;k>=0;k--){
                for(int i=k-1;i>=0;i--){
                    
                    //SIMPLIFICACION MA INICIAL DE ENTRADA (AYUDA2)
                    ayuda2 = ma.getComponente(i,k);
                    ayuda2.simplificaComplejoReal();
                    ayuda2.simplificaComplejoImaginario();
                    
                    ayuda1 = op.multiplicaComplejo(menos_uno,ayuda2);
                    
                    //SIMPLIFICACION VALOR MA INVERSO ADITIVO (AYUDA1)
                    ayuda1.simplificaComplejoReal();
                    ayuda1.simplificaComplejoImaginario();
                    
                    ayuda2 = ma.getComponente(k,k);
     
                    //SIMPLIFICACION VALOR MA K K (AYUDA2)
                    ayuda2.simplificaComplejoReal();
                    ayuda2.simplificaComplejoImaginario();

                    pivote = op.divideComplejo(ayuda1,ayuda2);
                    
                    //SIMPLIFICACION PIVOTE (DIVISION)
                    pivote.simplificaComplejoReal();
                    pivote.simplificaComplejoImaginario();

                    for(int j=k;j<2*n;j++){
                        
                        ayuda2 = ma.getComponente(k,j);
                        
                        //SIMPLIFICACION VALOR MA K J (AYUDA1)
                        ayuda2.simplificaComplejoReal();
                        ayuda2.simplificaComplejoImaginario();
                        
                        ayuda1 = op.multiplicaComplejo(pivote,ayuda2);
                        
                        //SIMPLIFICACION MULTIPLICACION (AYUDA1)
                        ayuda1.simplificaComplejoReal();
                        ayuda1.simplificaComplejoImaginario();
                        
                        ayuda2 = ma.getComponente(i,j);
                        
                        //SIMPLIFICACION VALOR MA I J (AYUDA2)
                        ayuda2.simplificaComplejoReal();
                        ayuda2.simplificaComplejoImaginario();
                        
                        ayuda2 = op.sumaComplejo(ayuda1,ayuda2);
                        
                        //SIMPLIFICACION RESULTADOS (AYUDA2)
                        ayuda2.simplificaComplejoReal();
                        ayuda2.simplificaComplejoImaginario();
                        
                        ma.setComponente(i,j,ayuda2);
                    }
                }
            }
            
            //HACER UNOS EN LA DIAGONAL	
            for(int i=0;i<n;i++){
                for(int j=n; j<2*n;j++){
                    ayuda2 = op.divideComplejo(ma.getComponente(i,j),ma.getComponente(i,i));
                    ayuda2.simplificaComplejoReal();
                    ayuda2.simplificaComplejoImaginario();
                    
                    ma.setComponente(i,j,ayuda2);
                    
                    //SIMPLIFICACION RESULTADOS
                    ayuda1= ma.getComponente(i,j);
                    ayuda1.simplificaComplejoReal();
                    ayuda1.simplificaComplejoImaginario();
                    ma.setComponente(i,j,ayuda1);
                }
                ayuda2 = op.divideComplejo(ma.getComponente(i,i),ma.getComponente(i,i));
                ayuda2.simplificaComplejoReal();
                ayuda2.simplificaComplejoImaginario();
                
                ma.setComponente(i,i,ayuda2);
                
                //SIMPLIFICACION RESULTADOS
                ayuda1 = ma.getComponente(i,i);
                ayuda1.simplificaComplejoReal();
                ayuda1.simplificaComplejoImaginario();
                ma.setComponente(i,i,ayuda1);
            }
            
            //PASAR RESULTADO DE MATRIZ AMPLIADA A LA MATRIZ INVERSA
            for(int i=0;i<n;i++){
                for(int j=0; j<n;j++){
                    ayuda1 = ma.getComponente(i,i);
                    ayuda1.simplificaComplejoReal();
                    ayuda1.simplificaComplejoImaginario();
                    ma.setComponente(i,i,ayuda1);
                    mi.setComponente(i,j,ma.getComponente(i,j+n));
                }
            }
            //return ma;
            return mi;
        }
        else{
            return null;
        }
    }
}//FIN TOpMatricesComplejas
