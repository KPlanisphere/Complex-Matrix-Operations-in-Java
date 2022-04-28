//BENEMERITA UNIVERSIDAD AUTONOMA DE PUEBLA
//FACULTAD DE CIENCIAS DE LA COMPUTACION
//PROGRAMACION II - JESUS HUERTA AGUILAR

// --------------------> TOperaComplejos

package com.mycompany.matricescomplejas;

public class TOperaComplejos{

	// - - - - - METODOS DIVERSOS - - - - -
	//SUMA
	public TComplejo sumaComplejo(TComplejo num1, TComplejo num2){
            TComplejo res = new TComplejo();
            long numeral,denoral,numario,denario;
            //REAL
            numeral = num1.getNumReal()*num2.getDenReal()+ num1.getDenReal()*num2.getNumReal();
            denoral = num1.getDenReal()*num2.getDenReal();
            //IMAGINARIO
            numario = num1.getNumImag()*num2.getDenImag()+ num1.getDenImag()*num2.getNumImag();
            denario = num1.getDenImag()*num2.getDenImag();
            
            res.setNumReal(numeral);
            res.setDenReal(denoral);
            res.setNumImag(numario);
            res.setDenImag(denario);
            return res;
	}
	
	//RESTA
	public TComplejo restaComplejo(TComplejo num1, TComplejo num2){
            TComplejo res = new TComplejo();
            long numeral,denoral,numario,denario;
            //REAL
            numeral = num1.getNumReal()*num2.getDenReal() - num1.getDenReal()*num2.getNumReal();
            denoral = num1.getDenReal()*num2.getDenReal();
            //IMAGINARIO
            numario = num1.getNumImag()*num2.getDenImag() - num1.getDenImag()*num2.getNumImag();
            denario = num1.getDenImag()*num2.getDenImag();

            res.setNumReal(numeral);
            res.setDenReal(denoral);
            res.setNumImag(numario);
            res.setDenImag(denario);
            return res;
	}
	
	//PRODUCTO
	public TComplejo multiplicaComplejo(TComplejo num1, TComplejo num2){
            TComplejo res = new TComplejo();
            long numeral,denoral,numario,denario;
            //REAL
            numeral = num1.getNumReal()*num2.getNumReal()*num1.getDenImag()*num2.getDenImag() - 
                    num1.getNumImag()*num2.getNumImag()*num1.getDenReal()*num2.getDenReal();
            denoral = num1.getDenReal()*num2.getDenReal()*num1.getDenImag()*num2.getDenImag();
            //IMAGINARIO
            numario = num1.getNumReal()*num2.getDenReal()*num1.getDenImag()*num2.getNumImag() + 
                    num1.getNumImag()*num2.getDenImag()*num1.getDenReal()*num2.getNumReal();
            denario = num1.getDenReal()*num2.getDenReal()*num1.getDenImag()*num2.getDenImag();

            res.setNumReal(numeral);
            res.setDenReal(denoral);
            res.setNumImag(numario);
            res.setDenImag(denario);
            return res;
	}
	
	//DIVISION
	public TComplejo divideComplejo(TComplejo num1, TComplejo num2){
            TComplejo res = new TComplejo();
            long numeral,denoral,numario,denario;
            //REAL
            numeral = num2.getDenReal()*num2.getDenImag()*(num1.getNumReal()*num2.getNumReal()*num1.getDenImag()*num2.getDenImag() +
                    num1.getNumImag()*num2.getNumImag()*num1.getDenReal()*num2.getDenReal());
            denoral = num1.getDenReal()*num1.getDenImag()*(num2.getNumReal()*num2.getNumReal()*num2.getDenImag()*num2.getDenImag() +
                    num2.getDenReal()*num2.getDenReal()*num2.getNumImag()*num2.getNumImag());
            //IMAGINARIO
            numario = num2.getDenReal()*num2.getDenImag()*(num1.getDenReal()*num2.getNumReal()*num1.getNumImag()*num2.getDenImag() -
                    num1.getDenImag()*num2.getNumImag()*num1.getNumReal()*num2.getDenReal());
            denario = num1.getDenReal()*num1.getDenImag()*(num2.getNumReal()*num2.getNumReal()*num2.getDenImag()*num2.getDenImag() +
                    num2.getDenReal()*num2.getDenReal()*num2.getNumImag()*num2.getNumImag());

            res.setNumReal(numeral);
            res.setDenReal(denoral);
            res.setNumImag(numario);
            res.setDenImag(denario);
            return res;	
	}
}//FIN CLASE TOperaComplejos
