# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e598beac443c0123a66e746968d54137"

SRC_URI = "git://github.com/IBashniak/network-helloworld.git;branch=main"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "d289c7a26c5e98aa3a432eca263c411f40aa4be9"

S = "${WORKDIR}/git"



do_compile () {
    #bberror "=========================="
    cd ${S}/Client
    ${CC} -o Client main.c ${LDFLAGS}
    cd ${S}/Server
    ${CC} -o Server main.c ${LDFLAGS}
}

do_install () {
	install -d ${D}${bindir}/ClientServer
	install -m 0755 ${S}/Client/Client ${D}${bindir}/ClientServer/
    install -m 0755 ${S}/Server/Server ${D}${bindir}/ClientServer/
}

#inherit qmake5