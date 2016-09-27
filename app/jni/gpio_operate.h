
#ifndef _GPIO_OPRERATE_
#define _GPIO_OPRERATE_

#define FALSE          				0
#define TRUE           				1
typedef  int	bool;

bool GPIO_OP_Init(void) ;
bool GPIO_OP_SetGpioOutput(int pin);
bool GPIO_OP_SetGpioDataHigh(int pin);
bool GPIO_OP_SetGpioDataLow(int pin);
bool GPIO_OP_GPIO_Deinit(void);
int GPIO_OP_GetGpioDir(int pin);
int GPIO_OP_GetGpioMode(int pin);
int GPIO_OP_GetGpioDataOut(int pin);
#endif
