
#include "gpio_operate.h"
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <sys/ioctl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <linux/mtgpio.h>


/*****************************************************************************/
struct gpio_op_object {
    int      fd;
    bool     init;
};
/*****************************************************************************/
static struct gpio_op_object gpio_obj = {.init = FALSE};
static const char *dev = "/dev/mtgpio";

bool GPIO_OP_Init(void) 
{
    struct gpio_op_object *obj = &gpio_obj;
    if (obj->init) {
        return TRUE;
    }

    obj->fd = open(dev, O_RDWR);

    if (obj->fd == -1) {
        return FALSE;
    } else {
        obj->init = TRUE;
        return TRUE;
    }
}

int getDeviceFd()
{
    	struct gpio_op_object *obj = &gpio_obj;
	return obj->fd;
}
/*
bool GPIO_OP_SetGpioMode(int pin)
{
    struct gpio_op_object *obj = &gpio_obj;
	int res = -1;
	res = ioctl(obj->fd, GPIO_IOCSDIROUT, pin);
	return (res < 0) ? FALSE : TRUE;
}
*/

bool GPIO_OP_SetGpioOutput(int pin)
{
    struct gpio_op_object *obj = &gpio_obj;
	int resn = -1;
	int res = -1;
	resn = ioctl(obj->fd, GPIO_IOCTMODE0, pin);
	res = ioctl(obj->fd, GPIO_IOCSDIROUT, pin);
	return ((res < 0) || (resn < 0)) ? FALSE : TRUE;
}

bool GPIO_OP_SetGpioDataHigh(int pin)
{
    struct gpio_op_object *obj = &gpio_obj;
	int res = -1;
	res = ioctl(obj->fd, GPIO_IOCSDATAHIGH, pin);
	return (res < 0) ? FALSE : TRUE;
}

bool GPIO_OP_SetGpioDataLow(int pin)
{
    struct gpio_op_object *obj = &gpio_obj;
	int res = -1;
	res = ioctl(obj->fd, GPIO_IOCSDATALOW, pin);
	return (res < 0) ? FALSE : TRUE;
}

int GPIO_OP_GetGpioDir(int pin)
{
    struct gpio_op_object *obj = &gpio_obj;
	int res = -1;
	res = ioctl(obj->fd, GPIO_IOCQDIR, pin);
	return res;
}

int GPIO_OP_GetGpioMode(int pin)
{
    struct gpio_op_object *obj = &gpio_obj;
	int res = -1;
	res = ioctl(obj->fd, GPIO_IOCQMODE, pin);
	return res;
}


int GPIO_OP_GetGpioDataOut(int pin)
{
    struct gpio_op_object *obj = &gpio_obj;
	int res = -1;
	res = ioctl(obj->fd, GPIO_IOCQDATAOUT, pin);
	return res;
}
	
bool GPIO_OP_GPIO_Deinit(void)
{
    struct gpio_op_object *obj = &gpio_obj;
    int res;
	
    if (!obj->init)
        return TRUE;
    
    res = close(obj->fd);
   // if (res)
	    
        //MGP_LOG("close %s fail, %s\n", dev, strerror(errno));

    obj->init = FALSE;    
    //MGP_LOG("okay\n");
    return TRUE;
}

