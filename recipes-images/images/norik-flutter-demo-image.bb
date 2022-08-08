require recipes-images/images/phytec-headless-image.bb

SUMMARY = "Image that demonstrates a Flutter app running on a Wayland backend"
LICENSE = "MIT"

REQUIRED_DISTRO_FEATURES = "wayland"

IMAGE_FEATURES:append = " weston"

IMAGE_INSTALL:append = " \
    packagegroup-base \
    weston \
    weston-init \
    flutter-wayland-client \
    norik-flutter-demo \
"
