/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_lenwotion_gpio_GpioOperate */

#ifndef _Included_com_lenwotion_gpio_GpioOperate
#define _Included_com_lenwotion_gpio_GpioOperate
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GetGpioMaxNumber
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_GetGpioMaxNumber
  (JNIEnv *, jclass);

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIOInit
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIOInit
  (JNIEnv *, jclass);

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIOUnInit
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIOUnInit
  (JNIEnv *, jclass);

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    SetGpioOutput
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_SetGpioOutput
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    SetGpioDataHigh
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_SetGpioDataHigh
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    SetGpioDataLow
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_lenwotion_gpio_GpioOperate_SetGpioDataLow
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIO_OP_GetGpioDir
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIO_1OP_1GetGpioDir
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIO_OP_GetGpioMode
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIO_1OP_1GetGpioMode
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    GPIO_OP_GetGpioDataOut
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_GPIO_1OP_1GetGpioDataOut
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_lenwotion_gpio_GpioOperate
 * Method:    getDeviceFd
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_lenwotion_gpio_GpioOperate_getDeviceFd
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif