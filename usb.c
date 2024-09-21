#include <stdio.h>
#include <libusb-1.0/libusb.h>

int main(void) {
    libusb_device **devices;
    libusb_context *context = NULL;
    ssize_t device_count;
    int i;

    // Initialize libusb
    if (libusb_init(&context) < 0) {
        fprintf(stderr, "Failed to initialize libusb\n");
        return 1;
    }

    // Get list of connected devices
    device_count = libusb_get_device_list(context, &devices);
    if (device_count < 0) {
        fprintf(stderr, "Failed to get device list\n");
        libusb_exit(context);
        return 1;
    }

    // Iterate through the list and print device information
    for (i = 0; i < device_count; i++) {
        libusb_device *device = devices[i];
        struct libusb_device_descriptor descriptor;

        // Get device descriptor
        if (libusb_get_device_descriptor(device, &descriptor) < 0) {
            fprintf(stderr, "Failed to get device descriptor\n");
            continue;
        }

        printf("Device Found:\n");
        printf("  Vendor ID: 0x%04x\n", descriptor.idVendor);
        printf("  Product ID: 0x%04x\n", descriptor.idProduct);
        printf("  Manufacturer: %u\n", descriptor.iManufacturer);
        printf("  Product: %u\n", descriptor.iProduct);
        printf("  Serial Number: %u\n", descriptor.iSerialNumber);
    }

    // Free the device list and exit
    libusb_free_device_list(devices, 1);
    libusb_exit(context);

    return 0;
}
