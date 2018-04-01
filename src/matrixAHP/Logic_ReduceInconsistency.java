package matrixAHP;

public class Logic_ReduceInconsistency {
	
	public static double[][] matrix_to_id(double[][] array){
		
		double [] matrix_conversion = new double []
		{ 
			1.0/9.0, 1.0/8.0, 1.0/7.0, 1.0/6.0, 1.0/5.0, 1.0/4.0, 1.0/3.0, 1.0/2.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0
	    }; 
		int []matrix_id = new int []
		{	
			0,  1,  2,  3,  4,  5,  6,  7,  8, 9, 10, 11, 12, 13, 14, 15, 16	
		};
		
		double [][] conversion = new double [array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++){
				for (int k = 0; k < matrix_conversion.length; k++){
					if (array[i][j] == matrix_conversion[k]){
						conversion[i][j] =  matrix_id[k];
					}
				}
			}
		}
		return conversion;
	}
	
	public static double[][] id_to_matrix(double[][] array){
		
		double [] matrix_conversion = new double []
		{ 
			1.0/9.0, 1.0/8.0, 1.0/7.0, 1.0/6.0, 1.0/5.0, 1.0/4.0, 1.0/3.0, 1.0/2.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0
	    }; 
		int []matrix_id = new int []
		{	
			0,  1,  2,  3,  4,  5,  6,  7,  8, 9, 10, 11, 12, 13, 14, 15, 16	
		};
		
		double [][] conversion = new double [array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++){
				for (int k = 0; k < matrix_id.length; k++){
					if (array[i][j] == matrix_id[k]){
						conversion[i][j] =  matrix_conversion[k];
					}
				}
			}
		}
		return conversion;
	}
	
	public static String[][] id_to_string(double[][] array){

		String [] matrix_conversion = new String []
		{ 
			"1/9", "1/8", "1/7", "1/6", "1/5", "1/4", "1/3", "1/2", "1", "2",   "3",   "4",   "5",   "6",   "7",   "8", "9"
		};
		int []matrix_id = new int []
		{	
			0,  1,  2,  3,  4,  5,  6,  7,  8, 9, 10, 11, 12, 13, 14, 15, 16	
		};
		
		String [][] conversion = new String [array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++){
				for (int k = 0; k < matrix_id.length; k++){
					if (array[i][j] == matrix_id[k]){
						conversion[i][j] =  matrix_conversion[k];
					}
				}
			}
		}
		return conversion;
	}
	
	public static double[][] reduce_inconsistency (double[][] array, int allowed_deviations){
		
		int comparisons   = guiVoracious.InterfaceVoracious.Matrix_Size;
		int n_comparisons = (int) ((Math.pow(comparisons, 2)- comparisons)/2);
		double M = 0;
		double P = 1;
		double min = 100000;
		
		double [][]judgments    = new double[array.length][array[0].length];
		double [][]judgments_LB = new double[array.length][array[0].length];
		double [][]judgments_UB = new double[array.length][array[0].length];
		
		double [][]judgments_exchange   = new double[array.length][array[0].length];
		double [][]judgments_deviations = new double[array.length][array[0].length];
		String [][]judgments_string     = new String[array.length][array[0].length];
		
		double [][] search_Grid = new double[n_comparisons*(2*allowed_deviations + 1)][4];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++){
				judgments[i][j]    = array[i][j];
				judgments_LB[i][j] = array[i][j];
				judgments_UB[i][j] = array[i][j];
			}
		}
		
		judgments    = matrix_to_id(judgments);
		judgments_LB = matrix_to_id(judgments_LB);
		judgments_UB = matrix_to_id(judgments_UB);
		
		for (int i = 0; i < judgments.length; i++) {
			for (int j = i + 1; j < judgments[0].length; j++){
				if (judgments[i][j] - allowed_deviations < 0){
					judgments_LB[i][j] = 0;
					judgments_LB[j][i] = 16;
				}else{
					judgments_LB[i][j] =  judgments[i][j] - allowed_deviations;
					judgments_LB[j][i] = -judgments_LB[i][j] + 16;
				}
			}
		}
		for (int i = 0; i < judgments.length; i++) {
			for (int j = i + 1; j < judgments[0].length; j++){
				if (judgments[i][j] + allowed_deviations > 16){
					judgments_UB[i][j] = 16;
					judgments_UB[j][i] = 0;
				}else{
					judgments_UB[i][j] =  judgments[i][j] + allowed_deviations;
					judgments_UB[j][i] = -judgments_UB[i][j] + 16;
				}
			}
		}
		
		for (int i = 0; i < judgments.length; i++) {
			for (int j = 0; j < judgments[0].length; j++){;
				judgments_exchange[i][j] = judgments[i][j];
			}
		}
		for (int i = 0; i < judgments.length; i++) {
			for (int j = 0; j < judgments[0].length; j++){;
				judgments_deviations[i][j] = 0;
			}
		}

		boolean condition = true;
		
		while(condition){			
			M = min;
			int count = -1;
			for (int i = 0; i < array.length; i++) {
				for (int j = i + 1; j < array[0].length; j++){
					for (int k = 0; k < 2*allowed_deviations + 1; k++){
						if (judgments_deviations[i][j] < allowed_deviations){
							
							count = count + 1;
							search_Grid[count][0] = i;
							search_Grid[count][1] = j;
							if (judgments_LB[i][j] + k > judgments_UB[i][j]){
								
								search_Grid[count][2] = judgments_UB[i][j];
								
								judgments_exchange[i][j] =  judgments_UB[i][j];
								judgments_exchange[j][i] = -judgments_LB[i][j] + 16;
								
							}else{
								
								search_Grid[count][2] = judgments_LB[i][j] + k;
								
								judgments_exchange[i][j] =   judgments_LB[i][j] + k;
								judgments_exchange[j][i] = -(judgments_LB[i][j] + k) + 16;
							}
							
							if (guiVoracious.InterfaceVoracious.Deriving_Weigths == 0){
								
								search_Grid[count][3] = Logic_MeanNormalization.mn_ConsistencyRatio(id_to_matrix(judgments_exchange));
								
							}else if (guiVoracious.InterfaceVoracious.Deriving_Weigths == 1){
								
								search_Grid[count][3] = Logic_GeometricMean.gm_ConsistencyRatio(id_to_matrix(judgments_exchange));
	
							}
						}
					}
					judgments_exchange[i][j] =  judgments[i][j];
					judgments_exchange[j][i] = -judgments[i][j] + 16;

				}
			}
			min = MatrixOperations.get2DMinValueInColumnJ(search_Grid, 3);
			P = min;
			for (int i = 0; i < search_Grid.length; i++) {
				if ( search_Grid[i][3] == min && judgments_deviations[(int)search_Grid[i][0]][(int)search_Grid[i][1]] < allowed_deviations){
					
					judgments_exchange[(int)search_Grid[i][0]][(int)search_Grid[i][1]] =  search_Grid[i][2];
					judgments_exchange[(int)search_Grid[i][1]][(int)search_Grid[i][0]] = -search_Grid[i][2] + 16;
					
					judgments[(int)search_Grid[i][0]][(int)search_Grid[i][1]] =  search_Grid[i][2];
					judgments[(int)search_Grid[i][1]][(int)search_Grid[i][0]] = -search_Grid[i][2] + 16;
					
					if (id_to_matrix(judgments_exchange)[(int)search_Grid[i][0]][(int)search_Grid[i][1]] != array[(int)search_Grid[i][0]][(int)search_Grid[i][1]]){
						
						judgments_deviations[(int)search_Grid[i][0]][(int)search_Grid[i][1]] = judgments_deviations[(int)search_Grid[i][0]][(int)search_Grid[i][1]] + 1;
					}
				}
			}

			if (guiVoracious.InterfaceVoracious.Reduce == 0){
				
				if(P > 0.1){
					condition = true;
					if(M - P == 0){
					condition = false;
					}
				}else{
					condition = false;
				}
				
			}else if (guiVoracious.InterfaceVoracious.Reduce == 1){
				
				if (M - P != 0){
					condition = true;
				}else{
					condition = false;
				}
			}	
		}
		
		if (guiVoracious.InterfaceVoracious.Deriving_Weigths == 0){
			
			guiVoracious.InterfaceVoracious.Adjusted_Matrix = 1;
			Logic_MeanNormalization.mn_ConsistencyRatio(id_to_matrix(judgments_exchange));

		}else if (guiVoracious.InterfaceVoracious.Deriving_Weigths == 1){
			
			guiVoracious.InterfaceVoracious.Adjusted_Matrix = 1;
			Logic_GeometricMean.gm_ConsistencyRatio(id_to_matrix(judgments_exchange));
		}
		
		judgments_string = id_to_string(judgments_exchange);
		
		for (int i = 1; i < guiVoracious.InterfaceVoracious.Matrix_Size + 1; i++){
			for (int j = 1; j < guiVoracious.InterfaceVoracious.Matrix_Size + 1; j++){
				guiVoracious.InterfaceVoracious.table_Adjusted.getModel().setValueAt(judgments_string[i-1][j-1], i, j);
				if (judgments_deviations[i-1][j-1] > 0){
					guiVoracious.InterfaceVoracious.table_Adjusted.getModel().setValueAt(judgments_string[i-1][j-1] + "*", i, j);
				}
			}
		}
		
		return search_Grid;
	}
}
