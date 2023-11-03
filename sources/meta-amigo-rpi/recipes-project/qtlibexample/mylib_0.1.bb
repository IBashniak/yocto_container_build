SUMMARY = "QT Example Recipe"
LICENSE = "CLOSED"

SRC_URI = "file://mylib.pro \
		   file://include/mylib.h   \
           file://mylib.cpp"

DEPENDS += "qtbase"
S = "${WORKDIR}"

inherit qmake5


do_install () { 
	install -d ${D}${includedir}/mylib
	install -m 644 ${WORKDIR}/include/mylib.h ${D}${includedir}/mylib/ 
	install -d ${D}${libdir}
	install -m 0755 ${WORKDIR}/build/libmylib.a ${D}${libdir}/ 
}

FILES:${PN} += "${libdir}"
FILES:${PN}-dev = "${includedir}/mylib"
FILES:${PN}-dev += "${includedir}/mylib/mylib.h"

#/home/build/workspace/build/tmp/work/cortexa7t2hf-neon-vfpv4-amigodistro-linux-gnueabi/qtLibExample/0.1-r0/build/qtexamplelib

#do_install () { 
#	install -d ${D}${libdir}
#	install -m 0755 ${WORKDIR}/build/libmylib.a ${D}${libdir}/ 
#	install -d ${D}${includedir}/mylib
#}