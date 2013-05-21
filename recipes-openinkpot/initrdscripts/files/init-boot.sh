#!/bin/sh

PATH=/sbin:/bin:/usr/sbin:/usr/bin

mkdir /proc
mkdir /sys
mount -t proc proc /proc
mount -t sysfs sysfs /sys

mknod /dev/mmcblk0 b 179 0
mknod /dev/mmcblk0p1 b 179 1
mknod /dev/mmcblk0p2 b 179 2

modprobe loop
modprobe nls_base
modprobe nls_cp437
modprobe nls_utf8
modprobe fat
modprobe vfat
modprobe mmc_core
modprobe mmc_block
modprobe s3cmci
modprobe ext2

[ -d /media/sd ] || mkdir -p /media/sd

echo 'Mounting root filesystem'
while true; do
	if mount -t vfat -o sync,iocharset=utf8 /dev/mmcblk0 /media/sd 2>/dev/null; then
		break
	fi
	if mount -t vfat -o sync,iocharset=utf8 /dev/mmcblk0p1 /media/sd 2>/dev/null; then
		break
	fi
	echo -n .
done
echo ' done!'

mount -o loop -t ext2 /media/sd/openinkpot/rootfs.ext2 /root || /bin/sh

[ -d /root/media/sd ] || mkdir -p /root/media/sd

mount --move /media/sd /root/media/sd || /bin/sh

exec switch_root /root /sbin/init
