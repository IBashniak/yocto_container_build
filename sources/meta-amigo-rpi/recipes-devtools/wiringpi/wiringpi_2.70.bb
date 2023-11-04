DESCRIPTION = "A library to control Raspberry Pi GPIO channels"
HOMEPAGE = "https://projects.drogon.net/raspberry-pi/wiringpi/"
SECTION = "devel/libs"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"

# tag 2.44
SRCREV = "f97a6230160b819e6daea7eb242404afa708e421"
SRC_URI = "git://github.com/WiringPi/WiringPi.git;nobranch=1;protocol=https\
           file://0001-Add-initial-cross-compile-support.patch \
           "
DEPENDS += "libgcrypt"
DEPENDS += "qtbase"
RDEPENDS:${PN} = "libgcrypt"

S = "${WORKDIR}/git"
#COMPATIBLE_MACHINE = "raspberrypi"

CFLAGS:prepend = "-I${S}/wiringPi -I${S}/devLib"



#bb.warn("Bandit found issues (report written to %s)" % report)
#incl = "${S}/../recipe-sysroot-native/usr/include/tirpc/rpcsvc"

#incl = "/home/build/workspace/build/tmp/work/raspberrypi4_amigo-amigodistro-linux-gnueabi/amigo-image/1.0-r0/rootfs/usr/include"

#         /home/build/workspace/build/tmp/work/cortexa7t2hf-neon-vfpv4-amigodistro-linux-gnueabi/wiringpi/2.50-r0/image/usr/include

#EXTRA_OEMAKE += "'INCLUDE_DIR=${D}${includedir}' 'LIB_DIR=${D}${libdir}'"
#EXTRA_OEMAKE += "'DESTDIR=${D}/usr' 'PREFIX=""'"
#EXTRA_OEMAKE += "' INCLUDE=-I${incl}'"
#
EXTRA_OEMAKE += "\
    'CXX=${CXX}' \
    'LD=${CXX}' \
    'AR=${AR}' \
    'RANLIB=${RANLIB}' \
    \
    'CPPFLAGS=${CPPFLAGS}'      \
    'CXXFLAGS=${CXXFLAGS}'      \
    'LDFLAGS=${LDFLAGS}'        \
    'INCLUDE_DIR=${D}${includedir}' \
    'LIB_DIR=${D}${libdir}'     \
"

do_compile() {
    oe_runmake -C devLib 'LDFLAGS=${LDFLAGS} -I${S}/wiringPi'
#   oe_runmake -C gpio 'LDFLAGS=${LDFLAGS} -L${S}/wiringPi -L${S}/devLib'
    oe_runmake -C wiringPi
}


do_install() {
	install -d ${D}${includedir}/
	install -m 644 ${S}/wiringPi/*.h ${D}${includedir}/

    oe_runmake -C devLib install
    oe_runmake -C wiringPi install
#    oe_runmake -C gpio install
}

#    bberror "S = ${S}/wiringPi"
#    bberror "D = ${D}"
#    bberror "incl = ${incl}"
#    ls -la ${S}/wiringPi/wiringPi.h
#    bberror "=========================="
#    bberror "includedir  = *${D}${includedir}*"
#
#    bberror "ROOT_HOME  = *${ROOT_HOME}*"
#    bberror "IMAGE_ROOTFS  = *${IMAGE_ROOTFS}*"

#    ls -la ${incl}/crypt.h
#    bberror "=========================="