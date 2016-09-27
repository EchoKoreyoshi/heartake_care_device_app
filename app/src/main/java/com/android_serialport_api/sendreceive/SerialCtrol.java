/*
 * Copyright 2009 Cedric Priscal
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package com.android_serialport_api.sendreceive;

import java.io.File;
import java.io.IOException;

import android_serialport_api.SerialPort;

public class SerialCtrol {
	private SerialPort mSerialPort = null;
	private static final String DEFAULT_DEVICE_PATH = "/dev/ttyS3";
	private static final String DEFAULT_DEVICE_PATH_S1 = "/dev/ttyS1";

	public SerialPort openSerialPort(int baudrate) throws SecurityException,
			IOException {
		if (mSerialPort == null) {
			String path = DEFAULT_DEVICE_PATH_S1;
			// int baudrate = SERIAL_BAUDRATE;
			/* Open the serial port */
			mSerialPort = new SerialPort(new File(path), baudrate, 0);
		}
		return mSerialPort;
	}

	/**
	 * 打开端口
	 * 
	 * @param deviceNumber
	 *            端口号 1:"/dev/ttyS1" 3:"/dev/ttyS3"
	 * @param baudrate
	 *            波特率
	 * @return
	 * @throws SecurityException
	 * @throws IOException
	 */
	public SerialPort openSerialPort(int deviceNumber, int baudrate)
			throws SecurityException, IOException {
		if (mSerialPort == null) {

			String path = DEFAULT_DEVICE_PATH_S1;
			switch (deviceNumber) {
			case 0:
				path = "/dev/ttyMT0";
				break;

			case 1:

					path = "/dev/ttyMT1";



				break;

			case 2:
				path = "/dev/ttyMT2";
				break;

			case 3:

					path = "/dev/ttyMT3";

				break;
			case 4:
				path = "/dev/ttyMT3";
				break;
			default:
				path = DEFAULT_DEVICE_PATH;
				break;
			}
			// int baudrate = SERIAL_BAUDRATE;
			/* Open the serial port */
			mSerialPort = new SerialPort(new File(path), baudrate, 0);
		}
		return mSerialPort;
	}

	public void closeSerialPort() {
		if (mSerialPort != null) {
			mSerialPort.close();
			mSerialPort = null;
		}
	}
}
