package matrixAHP;

import guiVoracious.InterfaceVoracious;

public class Logic_GeometricMean {

	public static double gm_ConsistencyRatio (double[][] array){

		double[][] arrayW  = new double[array.length][array[0].length];
		double  [] weigths = new double[array[0].length];
		
		double number_of_criteria = (array[0].length*1d)/1.0;
		
		for (int i = 0; i < array[0].length; i++){
			weigths[i] = 1.0;
		}
		for (int i = 0; i < array[0].length; i++){
			for (int j = 0; j < array[0].length; j++){
				weigths[i] = weigths[i]*array[i][j];
			}
		}
		for (int i = 0; i < array[0].length; i++){
			weigths[i] = Math.pow(weigths[i], (1.0/number_of_criteria));
		}
		double sum_w = MatrixOperations.get1DRowSum(weigths);
		for (int i = 0; i < array[0].length; i++){
			weigths[i] = weigths[i]/sum_w;
		}
		
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[0].length; j++){
				arrayW[i][j] = array[i][j]*weigths[j];
			}
			
		}

		double  [] weigths_RC = MatrixOperations.get2DColumnSumArray(MatrixOperations.get2DTransposedMatrix(arrayW));
		for (int i = 0; i < array[0].length; i++){
			weigths_RC[i] = weigths_RC[i]/weigths[i];
		}
		
		double sum_w_RC = MatrixOperations.get1DRowSum(weigths_RC)/number_of_criteria;
		
		double inconsistency = Math.abs(sum_w_RC  - number_of_criteria)/(number_of_criteria - 1);
		double consistency_ratio = 0;

		if (array[0].length == 2){
			consistency_ratio = 0;
		}else if (array[0].length == 3){
			consistency_ratio = inconsistency/0.58;
		}else if (array[0].length == 4){
			consistency_ratio = inconsistency/0.90;
		}else if (array[0].length == 5){
			consistency_ratio = inconsistency/1.12;
		}else if (array[0].length == 6){
			consistency_ratio = inconsistency/1.24;
		}else if (array[0].length == 7){
			consistency_ratio = inconsistency/1.32;
		}else if (array[0].length == 8){
			consistency_ratio = inconsistency/1.41;
		}else if (array[0].length == 9){
			consistency_ratio = inconsistency/1.45;
		}

		
		if (array[0].length == 2 && InterfaceVoracious.Adjusted_Matrix == 0){
			
			InterfaceVoracious.textField_0.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_1.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));

		}else if (array[0].length == 3 && InterfaceVoracious.Adjusted_Matrix == 0){
			
			InterfaceVoracious.textField_0.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_1.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_2.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));

		}else if (array[0].length == 4 && InterfaceVoracious.Adjusted_Matrix == 0){
			
			InterfaceVoracious.textField_0.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_1.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_2.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_3.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));

		}else if (array[0].length == 5 && InterfaceVoracious.Adjusted_Matrix == 0){
			
			InterfaceVoracious.textField_0.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_1.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_2.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_3.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_4.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));

		}else if (array[0].length == 6 && InterfaceVoracious.Adjusted_Matrix == 0){
			
			InterfaceVoracious.textField_0.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_1.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_2.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_3.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_4.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));
			InterfaceVoracious.textField_5.setText(Double.toString( Math.round(weigths[5]*10000d)/10000d));

		}else if (array[0].length == 7 && InterfaceVoracious.Adjusted_Matrix == 0){
			
			InterfaceVoracious.textField_0.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_1.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_2.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_3.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_4.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));
			InterfaceVoracious.textField_5.setText(Double.toString( Math.round(weigths[5]*10000d)/10000d));
			InterfaceVoracious.textField_6.setText(Double.toString( Math.round(weigths[6]*10000d)/10000d));

		}else if (array[0].length == 8 && InterfaceVoracious.Adjusted_Matrix == 0){
			
			InterfaceVoracious.textField_0.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_1.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_2.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_3.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_4.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));
			InterfaceVoracious.textField_5.setText(Double.toString( Math.round(weigths[5]*10000d)/10000d));
			InterfaceVoracious.textField_6.setText(Double.toString( Math.round(weigths[6]*10000d)/10000d));
			InterfaceVoracious.textField_7.setText(Double.toString( Math.round(weigths[7]*10000d)/10000d));

		}else if (array[0].length == 9 && InterfaceVoracious.Adjusted_Matrix == 0){
			
			InterfaceVoracious.textField_0.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_1.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_2.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_3.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_4.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));
			InterfaceVoracious.textField_5.setText(Double.toString( Math.round(weigths[5]*10000d)/10000d));
			InterfaceVoracious.textField_6.setText(Double.toString( Math.round(weigths[6]*10000d)/10000d));
			InterfaceVoracious.textField_7.setText(Double.toString( Math.round(weigths[7]*10000d)/10000d));
			InterfaceVoracious.textField_8.setText(Double.toString( Math.round(weigths[8]*10000d)/10000d));

		}
		
		if (array[0].length == 2 && InterfaceVoracious.Adjusted_Matrix == 1){
			
			InterfaceVoracious.textField_9.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_10.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));

		}else if (array[0].length == 3 && InterfaceVoracious.Adjusted_Matrix == 1){
			
			InterfaceVoracious.textField_9.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_10.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_11.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			

		}else if (array[0].length == 4 && InterfaceVoracious.Adjusted_Matrix == 1){
			
			InterfaceVoracious.textField_9.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_10.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_11.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_12.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));

		}else if (array[0].length == 5 && InterfaceVoracious.Adjusted_Matrix == 1){
			
			InterfaceVoracious.textField_9.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_10.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_11.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_12.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_13.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));

		}else if (array[0].length == 6 && InterfaceVoracious.Adjusted_Matrix == 1){
			
			InterfaceVoracious.textField_9.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_10.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_11.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_12.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_13.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));
			InterfaceVoracious.textField_14.setText(Double.toString( Math.round(weigths[5]*10000d)/10000d));

		}else if (array[0].length == 7 && InterfaceVoracious.Adjusted_Matrix == 1){
			
			InterfaceVoracious.textField_9.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_10.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_11.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_12.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_13.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));
			InterfaceVoracious.textField_14.setText(Double.toString( Math.round(weigths[5]*10000d)/10000d));
			InterfaceVoracious.textField_15.setText(Double.toString( Math.round(weigths[6]*10000d)/10000d));

		}else if (array[0].length == 8 && InterfaceVoracious.Adjusted_Matrix == 1){
			
			InterfaceVoracious.textField_9.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_10.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_11.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_12.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_13.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));
			InterfaceVoracious.textField_14.setText(Double.toString( Math.round(weigths[5]*10000d)/10000d));
			InterfaceVoracious.textField_15.setText(Double.toString( Math.round(weigths[6]*10000d)/10000d));
			InterfaceVoracious.textField_16.setText(Double.toString( Math.round(weigths[7]*10000d)/10000d));

		}else if (array[0].length == 9 && InterfaceVoracious.Adjusted_Matrix == 1){
			
			InterfaceVoracious.textField_9.setText(Double.toString( Math.round(weigths[0]*10000d)/10000d));
			InterfaceVoracious.textField_10.setText(Double.toString( Math.round(weigths[1]*10000d)/10000d));
			InterfaceVoracious.textField_11.setText(Double.toString( Math.round(weigths[2]*10000d)/10000d));
			InterfaceVoracious.textField_12.setText(Double.toString( Math.round(weigths[3]*10000d)/10000d));
			InterfaceVoracious.textField_13.setText(Double.toString( Math.round(weigths[4]*10000d)/10000d));
			InterfaceVoracious.textField_14.setText(Double.toString( Math.round(weigths[5]*10000d)/10000d));
			InterfaceVoracious.textField_15.setText(Double.toString( Math.round(weigths[6]*10000d)/10000d));
			InterfaceVoracious.textField_16.setText(Double.toString( Math.round(weigths[7]*10000d)/10000d));
			InterfaceVoracious.textField_17.setText(Double.toString( Math.round(weigths[8]*10000d)/10000d));

		}
		
		if (InterfaceVoracious.Adjusted_Matrix == 0){
			
			InterfaceVoracious.textField_18.setText(Double.toString( Math.round(consistency_ratio*10000d)/10000d));
			
		}else if (InterfaceVoracious.Adjusted_Matrix == 1 && InterfaceVoracious.Reduce == 0){
			
			InterfaceVoracious.textField_19.setText(Double.toString( Math.round(consistency_ratio*10000d)/10000d));
			InterfaceVoracious.textField_20.setText("");
			
		}else if(InterfaceVoracious.Adjusted_Matrix == 1 && InterfaceVoracious.Reduce == 1){
		
			InterfaceVoracious.textField_19.setText("");
			InterfaceVoracious.textField_20.setText(Double.toString( Math.round(consistency_ratio*10000d)/10000d));
			
		}
	
		return consistency_ratio;	

	}
}
