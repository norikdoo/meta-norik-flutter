SUMMARY = "Norik Flutter Demo application"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3ac21e3d8ebe7dd79f273ca11b9e7b4e"

# We are using the Flutter Wayland embeddder
RDEPENDS:${PN} = "flutter-wayland-client"

# Currently using the Flutter example for testing purposes
SRCREV = "9eb785cb997ff56c46e933c1c591f0a6f31454f6"
SRC_URI = " \
    git://github.com/flutter/gallery.git;lfs=0;branch=master;protocol=https;destsuffix=git \
    file://norik-flutter-demo-wl.service \
    file://demo.conf \
"

S = "${WORKDIR}/git"

PUBSPEC_APPNAME = "gallery"
FLUTTER_APPLICATION_INSTALL_PREFIX = "/norik"

SYSTEMD_SERVICE:${PN} = "norik-flutter-demo-wl.service"

do_install:append() {
    install -Dm 0644 ${WORKDIR}/norik-flutter-demo-wl.service ${D}${systemd_system_unitdir}/norik-flutter-demo-wl.service
    install -d ${D}${sysconfdir}/ld.so.conf.d
    install -m 0644 ${WORKDIR}/demo.conf ${D}${sysconfdir}/ld.so.conf.d/
}

FILES:${PN}:append = " ${systemd_unitdir}"
FILES:${PN}:append = " ${sysconfdir}/ld.so.conf.d"

inherit flutter-app-norik systemd
