# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   pimorse/LICENSE.txt
LICENSE = "Unknown"
#"LGPL-3.0-or-later"
#"Unknown"
LIC_FILES_CHKSUM = "file://README.md;md5=aaf01dd593f837e9f0108e9fbc43dfa6"

SRC_URI = "git://github.com/sunfounder/Sunfounder_SuperKit_C_code_for_RaspberryPi.git;protocol=https;branch=master"

# Modify these as desired

SRCREV = "bbbbdd5ca810a8fe933eed764d9109ab4985672c"

S = "${WORKDIR}/git"

# NOTE: no Makefile found, unable to determine what needs to be done

files_and_folders=" \
		01_LED 05_RGB 09_Timer555 13_LCD1602 02_BtnAndLed 06_Beep 10_74HC595_LED 14_ADXL345 \
		03_8Led 07_Motor 11_Segment 04_PwmLed 08_RotaryEncoder 12_DotMatrix \
		docs README.md"


FILES:${PN} += "${ROOT_HOME}/*"
do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	:
}

do_install () {
    install -d ${D}${ROOT_HOME}/${PN}
	cd ${S}
	cp -r ${files_and_folders} ${D}${ROOT_HOME}/${PN}/
    #install -m 0755 ${s}/* ${D}${ROOT_HOME}/${PV}/
}

