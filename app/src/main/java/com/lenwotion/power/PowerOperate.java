package com.lenwotion.power;

import com.lenwotion.gpio.GpioOperate;

public class PowerOperate {
	private static final int RFID_5V_PIN = 44;//身份证
	private static final int FINGERPRINT_MODULE_5V_PIN = 43;//指纹
	private static final int VOLT_3_3_PIN = 45;
	private static final int PREMISE_5V_PIN = 8;//总电源

	public void enableRfid_5Volt() {
		boolean isHigh = true;
		mtSetGPIOValue(13, false);
		mtSetGPIOValue(12, false);
		mtSetGPIOValue(FINGERPRINT_MODULE_5V_PIN, false);
		mtSetGPIOValue(VOLT_3_3_PIN,isHigh);
		mtSetGPIOValue(PREMISE_5V_PIN,isHigh);
		mtSetGPIOValue(RFID_5V_PIN, isHigh);
	}
	
	public void disableRfid_5Volt() {
		boolean isHigh = false;
		mtSetGPIOValue(RFID_5V_PIN, isHigh);
	}
	
	public void enableFingerprintModule_5Volt() {
		boolean isHigh = true;
		mtSetGPIOValue(13, false);
		mtSetGPIOValue(12, true);
		mtSetGPIOValue(FINGERPRINT_MODULE_5V_PIN, isHigh);
	}
	
	public void disableFingerprintModule_5Volt() {
		boolean isHigh = false;
		mtSetGPIOValue(FINGERPRINT_MODULE_5V_PIN, isHigh);
	}
	
	public void enable_3_3Volt() {
		boolean bHigh = true;
		mtSetGPIOValue(VOLT_3_3_PIN, bHigh);
	}
	
	public void disable_3_3Volt() {
		boolean isHigh = false;
		mtSetGPIOValue(VOLT_3_3_PIN, isHigh);
	}
	
	public void enablePremise_5Volt() {
		boolean isHigh = true;
		mtSetGPIOValue(13, false);
		mtSetGPIOValue(12, isHigh);
		mtSetGPIOValue(PREMISE_5V_PIN, isHigh);
	}
	
	public void disablePremise_5Volt() {
		boolean isHigh = false;
	mtSetGPIOValue(PREMISE_5V_PIN, isHigh);
}
	
	public void mtSetGPIOValue(int pin, boolean bHigh) {
		if(pin < 0)
		{
			return;
		}
		
		System.out.println("GPIOInit:"+GpioOperate.GPIOInit());
		if(bHigh)
		{
			System.out.println("SetGpioOutput:"+GpioOperate.SetGpioOutput(pin));
			System.out.println("SetGpioDataHigh:"+GpioOperate.SetGpioDataHigh(pin));
		}
		else
		{
			System.out.println("SetGpioOutput:"+GpioOperate.SetGpioOutput(pin));
			System.out.println("SetGpioDataLow:"+GpioOperate.SetGpioDataLow(pin));
		}
		System.out.println("GPIOUnInit:"+GpioOperate.GPIOUnInit());
	}
}
