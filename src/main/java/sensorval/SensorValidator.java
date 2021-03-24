package sensorval;

import java.util.List;

public class SensorValidator 
{
    public static boolean isDeltaValueFine(double value, double nextValue, double maxDelta) {
        if(nextValue - value > maxDelta) {
            return false;
        }
        return true;
    }
    public static boolean validateSOCreadings(List<Double> values) {
    	if(values == null) {
    		return false;
    	}
    	double maxDeltaForSOC = 0.05;
        return validateReadings(values, maxDeltaForSOC);
        
    }
    public static boolean validateCurrentreadings(List<Double> values) {
    	if(values == null) {
    		return false;
    	}
    	double maxDeltaForCurrent = 0.1;
        return validateReadings(values, maxDeltaForCurrent);
    }
    public static boolean validateReadings(List<Double> values, double maxDelta) {
    	int lastButOneIndex = values.size() - 1;
        for(int i = 0; i < lastButOneIndex; i++) {
            if(!isDeltaValueFine(values.get(i), values.get(i + 1), maxDelta)) {
            return false;
            }
        }
        return true;
    }
}
