# Img Flasher

**Img Flasher**: This app allows you to flash, extract, decompress, and recompress IMG files.

You can use the **Img Flasher** app or execute the `imgf` command in the terminal.

### ⚠️ Warning:
When using the flash command, you cannot stop the process. Be careful; flashing the wrong file may cause your device to stop working or enter a boot loop.

## App Features:

### 1. **Extract or Backup:**
You can extract IMG files from your phone such as `boot.img`, `nvram.img`, and `recovery.img`.

- Note: Click the IMG icon or 📀 to select the file.  
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot1.png)

- When you press the **Extract** button, the files will be extracted to:  
  `/storage/emulated/0/Download/ImgFlasher/`.  
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot2.png)

- Note: Click the **fab** button or 🔃 to refresh the app.  
- Note: You can scroll through the log to view the details.  
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot3.png)

### 2. **Flash:**
You can flash IMG files such as `boot.img`, `recovery.img`, and also other files like fastboot files.

- Note: Click on ✏️ to pick an IMG file or open a folder like `fastboot_redmi9a/`.  
- Note: Open files appear in different colors for easy identification.  
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot4.png)

- Note: The **Close** button will close open files.  
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot5.png)

- The `recovery.img` file was successfully flashed, but it seems to have been the wrong file.  
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/camera1.png)

### 3. **Unpack and Repack:**
You can unpack IMG files like `boot.img` and repack them.
- Note : You will find the **Image Kitchen** button in the side menu.  
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot6.png)
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot7.png)
### **Unpack :**
- Note : Click on ✏️ to pick an IMG file and pick a folder for unpack.
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot8.png)
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot9.png)
- You will find the repacked file in the picked folder.
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot10.png)
### **Repack :**
- Note : Click on ✏️ to pick an IMG file and pick a folder for unpack.
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot12.png)
example : boot.img repacked to new-boot.img
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot13.jpg)
You will find the repacked file in the same path that was picked for the file
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot14.jpg)

I developed this app using **Sketchware Pro**. I apologize for any mistakes or the simple interface, as I am still in the learning phase.

The app will crashed if you use this pathes so don't use.
![Screenshot](https://github.com/YasserNull/img-flasher/blob/main/Images/screenshot.jpg)

## ***Terminal :***
```
  Usage: imgf [command] [arguments]
      Commands:
        list                     - Print partitions list
        size [partname]          - Get partition size
        dev [partname]           - Get partition devname
        flash [partname] [img]   - Flash given partition
        extract [partname] [img] - Extract given partition
        unpack [img] [path]      - Unpack given partition
        repack [img] [path] [new-img] - Repack given partition
        version          - output version information and exit
        help                     - Show this help message"
```
### ***Examples :***
+ list : Print devname ,partname, size.
```
imgf list
```
+ dev : get partition devname.
```
imgf dev boot
```
+ size : Get partition size
```
imgf size boot
```
+ flash : Like fastboot.
```
imgf flash boot /sdcard/download/boot.img
```
+ extract : Extract img files from your device.
```
imgf extract boot /sdcard/download/boot.img
```
+ unpack : Unpack img file.
```
imgf unpack /sdcard/download/boot.img /sdcard/download/unpacked_boot
```
+ repack : Repack img file.
```
imgf repack /sdcard/download/boot.img /sdcard/download/unpacked_boot /sdcard/download/repacked-boot.img
```
---
