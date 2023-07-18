package g3051a_bmi;

public class BMI {
	public static double BMI(int kg, int cm) {
		return kg / Math.pow((cm/100.0),2);
	}
}
