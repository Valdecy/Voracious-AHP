package matrixAHP;

public class MatrixOperations {

	public static double get1DRowSum(double [] array) {

		double sum = 0; 
		for(int i = 0; i < array.length; i++){

			sum += array [i];

		}

		return sum;
	}

	public static double [] get1DNormalized(double [] array) {

		double [] arrayNW = new double [array.length];
		double sum        = get1DRowSum(array);

		for(int i = 0; i < array.length; i++){

			arrayNW [i]= array [i]/sum;

		}

		return arrayNW;
	}

	public static double [] get2DColumnSumArray(double[][] array) {

		double [] arrayC = new double[array[0].length];

		for (int j = 0; j < array[0].length; j++){//column length

			for (int i = 0; i < array.length; i++) {//row length

				arrayC[j] += array[i][j];
			}   
		}

		return arrayC;
	}

	public static double [] get2DRowSumArray(double[][] array) {

		double [] arrayR = new double[array.length];

		for (int i = 0; i < array.length; i++){//row length

			for (int j = 0; j < array[0].length; j++) {//column length

				arrayR[i] += array[i][j];
			}   
		}

		return arrayR;
	}

	public static double [][] get2DNormalized(double [][] array) {

		double [][] arrayNPM = new double [array.length][array[0].length];
		double []   a        = get2DColumnSumArray(array);

		for (int j = 0; j < array[0].length; j++){
			for(int i = 0; i < array.length; i++){

				arrayNPM [i][j]= array [i][j]/a[j];	
			}
		}

		return arrayNPM;
	}
	
	public static double get2DMinValueInColumnJ (double[][] array, int j) {

		double min = 100001;

		for (int i = 0; i < array.length; i++) {

				if (array[i][j] <= min) {

					min = array[i][j]; 
			}
		}
		
		return min;
	}
	
	public static double [][] get2DTransposedMatrix(double[][] array) {

		double [][] arrayT2D = new double [array[0].length][array.length];

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++){

				arrayT2D[j][i] = array[i][j];
			}
		}
		return arrayT2D;
	}
}