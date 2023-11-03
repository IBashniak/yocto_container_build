SUMMARY = "QT Example Recipe"
LICENSE = "CLOSED"

SRC_URI = "file://qtexample.pro \
           file://qtexample.cpp"

DEPENDS += "qtbase"
S = "${WORKDIR}"

inherit qmake5


do_install () { 
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/build/qtexample ${D}${bindir}/ 
}

FILES:${PN} += "${bindir}/"