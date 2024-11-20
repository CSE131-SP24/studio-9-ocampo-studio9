package studio9;

import java.util.LinkedList;

public class Polynomial {
	
	private LinkedList<Double> list; //or coefficients

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		//FIXME
		
		this.list = new LinkedList<>();
		
	}

	
	/**
	 * 
	 * @param coeff
	 * @return polynomial with added term
	 */
	public void addTerm(double coeff) {
		//FIXME
		
		list.add(coeff);  ///1st one to get added has the largest exponent
		
	}
	
	/*
	 * Returns a String of the polynomial with the proper form:
	 * 
	 * Cx^N + Cx^N-1 + ... + Cx + C
	 */
	public String toString() {
		
		String result = "";
		int exp = list.size() - 1; //10 items in list will make x^9 the highest exponent
		for(double d : list) {
			if(exp > 0) {
				result = result + d + "x^" + exp + " + ";
			}
			else {
				result = result + d;
			}
			exp--;
		}
		return result;
		/*OR CAN BE:
		String result = "";
		int exp = list.size()-1;
		for(int i = 0; i<list.size()-1;i++) {
			if(exp > 0) {
				result = result + list.get(i) + "x^" + exp + " + ";
			}
			else {
				result = result + list.get(i);
			}
			exp--;
		}
		
		return result;*/ //FIXME
	}
	
	/**
	 * 
	 * @param x
	 * @return value of polynomial at that x
	 */
	public double evaluate(double x) {
		
		double result = 0;
		int exp = list.size() - 1;
		
		for(double d : list) {
			result = result + d * Math.pow(x, exp);
			exp--;
		}
		
		return result;//FIXME
	}

	
	public Polynomial derivative() {
		
		Polynomial deriv = new Polynomial();
		int exp = list.size() - 1;
		for(double d : list) { //visit each coefficient
			if(exp > 0) {
				deriv.addTerm(exp * d);
			}
			exp--;
		}
		
		return deriv;//FIXME
	}
	

	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}

}