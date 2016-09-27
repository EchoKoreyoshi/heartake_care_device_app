#ifeq ($(MTK_ENGINEERMODE_APP), yes)

LOCAL_MODULE_TAGS := user

LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES := com_lenwotion_gpio_GpioOperate.c gpio_operate.c
LOCAL_C_INCLUDES := $(JNI_H_INCLUDE) $(LOCAL_PATH) /home/cjz/work/MT6577N/mediatek/source/external/meta/common/inc /home/cjz/work/MT6577N/mediatek/source/kernel/include
LOCAL_SHARED_LIBRARIES := libft libutils
LOCAL_MODULE := liblenwotion_gpio
LOCAL_PRELINK_MODULE := false
include $(BUILD_SHARED_LIBRARY)

###############################################################################
# SELF TEST
###############################################################################
BUILD_SELF_TEST := false
ifeq ($(BUILD_SELF_TEST), true)
include $(CLEAR_VARS)
LOCAL_SRC_FILES := com_lenwotion_gpio_GpioOperate.c
LOCAL_C_INCLUDES := external/mediatek/meta/common/inc
LOCAL_MODULE := lenwotion_gpio
LOCAL_ALLOW_UNDEFINED_SYMBOLS := true
LOCAL_SHARED_LIBRARIES := libft
LOCAL_STATIC_LIBRARIES := libmeta_gpio
LOCAL_MODULE_PATH := $(TARGET_OUT_OPTIONAL_EXECUTABLES)
LOCAL_UNSTRIPPED_PATH := $(TARGET_ROOT_OUT_SBIN_UNSTRIPPED)
include $(BUILD_EXECUTABLE)
endif

#endif


