#include "com_lenwotion_gpio_GpioOperate.h"
#include "string.h"
#include "gpio_operate.h"
#include "gpio_exp.h"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GetGpioMaxNumber
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_GetGpioMaxNumber
  (JNIEnv * env, jclass class)
  {
  	return (jint)HW_GPIO_MAX;
  }

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIOInit
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIOInit
  (JNIEnv * env, jclass class)
  {
  	return GPIO_OP_Init()? JNI_TRUE: JNI_FALSE;
  }

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIOUnInit
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIOUnInit
  (JNIEnv * env, jclass class)
  {  	
  	return GPIO_OP_GPIO_Deinit()? JNI_TRUE: JNI_FALSE;
  }

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    SetGpioOutput
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_SetGpioOutput
  (JNIEnv * env, jclass class, jint n)
  {
  	int pin = (int)n;
	bool ret;
	ret = GPIO_OP_SetGpioOutput(pin);
  	return ret == TRUE ? JNI_TRUE : JNI_FALSE;
  }
/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    SetGpioDataHigh
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_SetGpioDataHigh
  (JNIEnv * env, jclass class, jint n)
  {
	int pin = (int)n;
	bool ret;
	ret = GPIO_OP_SetGpioDataHigh(pin);
  	return ret == TRUE ? JNI_TRUE : JNI_FALSE;
  }
/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    SetGpioDataLow
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_SetGpioDataLow
  (JNIEnv * env, jclass class, jint n)
  {
	int pin = (int)n;
	bool ret;
	ret = GPIO_OP_SetGpioDataLow(pin);
  	return ret == TRUE ? JNI_TRUE : JNI_FALSE;
  }

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIO_OP_GetGpioDir
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIO_1OP_1GetGpioDir
  (JNIEnv * env, jclass class, jint n)
{
	int pin = (int)n;
	int ret;
	ret = GPIO_OP_GetGpioDir(pin);
  	return ret;
  }

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIO_OP_GetGpioMode
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIO_1OP_1GetGpioMode
  (JNIEnv * env, jclass class, jint n)
{
	int pin = (int)n;
	int ret;
	ret = GPIO_OP_GetGpioMode(pin);
  	return ret;
  }

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIO_OP_GetGpioDataOut
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIO_1OP_1GetGpioDataOut
  (JNIEnv * env, jclass class, jint n)
{
	int pin = (int)n;
	int ret;
	ret = GPIO_OP_GetGpioDataOut(pin);
  	return ret;
  }

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    getDeviceFd
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_getDeviceFd
  (JNIEnv * env, jclass class)
{
	return getDeviceFd();
}


#ifdef __cplusplus
}
#endif
