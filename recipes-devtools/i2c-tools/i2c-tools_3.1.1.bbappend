# has to skip i2c-tools-misc which contains not required EEPROM utils, but pulls the whole perl package
RDEPENDS_${PN}_remove = "${PN}-misc"
RDEPENDS_${PN}-misc_remove = "perl"
