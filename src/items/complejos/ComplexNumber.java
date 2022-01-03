package items.complejos;

import static java.lang.Math.sqrt;

public class ComplexNumber{

    private double real;
    private double imaginary;

    /*
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }*/

    /**
     * Constructor of the ComplexNumber
     * @param a real part
     * @param b imaginary part
     */
    public ComplexNumber(double a, double b){
        this.real = a;
        this.imaginary = b;
    }
    
    /**
     * 
     * @return the real part of the ComplexNumber
     */
    public double realPart(){
        return this.real;
    }
    
    /**
     * 
     * @return the imaginary part of the ComplexNumber
     */
    public double imaginaryPart(){
        return this.imaginary;
    }
    
    /**
     * Adds c to the ComplexNumber
     * 
     * @param c
     *        number to add
     * @return 
     *        this + c
     */
    public ComplexNumber add (ComplexNumber c){
        return new ComplexNumber(this.real+c.real, this.imaginary+c.imaginary);
    }
    
    /**
     * Returns the result of subtracting c from the ComplexNumber
     * 
     * @param c
     *        subtracting
     * @return 
     *        this - c
     */
    public ComplexNumber subtract (ComplexNumber c){
        return new ComplexNumber(this.real-c.real, this.imaginary-c.imaginary);
    }
    
    /**
     * Returns multiplication of c and the ComplexNumber
     * 
     * @param c
     *        multiplying
     * @return 
     *          this * c2
     */
    public ComplexNumber multiply (ComplexNumber c){
        double ac = this.real * c.real;
        double bd = this.imaginary * c.imaginary;
        double bc = this.imaginary * c.real;
        double ad = this.real * c.imaginary;
        return new ComplexNumber(ac - bd, bc + ad);
    }
    
   /**
     * Returns the division of the ComplexNumber by c 
     *
     * @param c
     *        divider
     * @return 
     *        this / c
     */
    public ComplexNumber division (ComplexNumber c){
        ComplexNumber num = this.multiply(new ComplexNumber(c.real, -c.imaginary));
        ComplexNumber aux = new ComplexNumber(c.real, c.imaginary);
        ComplexNumber denom = aux.multiply(new ComplexNumber(c.real, -c.imaginary));
        return new ComplexNumber(num.real/denom.real, num.imaginary/denom.real);
    }
    
    /**
     * Returns the conjugate of the ComplexNumber
     * 
     * @return 
     *        a - ib
     */
    public ComplexNumber conjugate (){
        return new ComplexNumber(this.real, -this.imaginary);
    } 
    
    /**
     * Returns the module of the ComplexNumber
     * 
     * @return 
     *      sqrt (a² + b²)
     */
    public double module (){
        return sqrt(this.real*this.real+this.imaginary*this.imaginary);
    }

    @Override
    public String toString(){
        return this.real+" "+this.imaginary+"i";
    }

    @Override
    public boolean equals(Object cn) {
        if(cn instanceof ComplexNumber) {
            return this.realPart() == ((ComplexNumber) cn).real && this.imaginaryPart() == ((ComplexNumber) cn).imaginary;
        }
        else{
            return false;
        }
    }
}
