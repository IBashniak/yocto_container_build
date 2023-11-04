SUMMARY = "A small container just packing up the PAYLOAD and a user account"

IMAGE_INSTALL = "base-passwd payloaduser ${PAYLOAD}"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

inherit image
inherit image-container
inherit populate_sdk_qt5

IMAGE_INSTALL += "rsync"

IMAGE_INSTALL += "git"
IMAGE_INSTALL += "i2c-tools"
IMAGE_INSTALL += "packagegroup-core-buildessential"
IMAGE_INSTALL += "vim nano"
IMAGE_INSTALL += "tzdata tzdata-europe"

# wi-fi and bluetooth
IMAGE_INSTALL += "linux-firmware-bcm43455 linux-firmware-bcm43430"
IMAGE_INSTALL += "kernel-modules"

#IMAGE_FEATURES += "ssh-server-dropbear"

IMAGE_FSTYPE = "rpi-sdimg"
IMAGEFEATURES:remove = "psplash"
CORE_IMAGE_EXTRA_INSTALL += "ldd"

#arch basename chcon cksum comm csplit cut dir dircolors dirname du printenv printf ...
IMAGE_INSTALL += "coreutils"
IMAGE_INSTALL += "gdbserver"
#qt5
IMAGE_INSTALL += "qtbase"
IMAGE_INSTALL += "qtbase-plugins"
IMAGE_INSTALL += "cinematicexperience"
EXTRA_IMAGE_FEATURES ?= "debug-tweaks tools-debug"
IMAGE_INSTALL += " qtbase-dev qtbase-mkspecs qtbase-tools"

IMAGE_INSTALL += "qtexample"
IMAGE_INSTALL += "myechoserver"

IMAGE_INSTALL += "wiringpi-dev"
IMAGE_INSTALL += "sunfounders"
