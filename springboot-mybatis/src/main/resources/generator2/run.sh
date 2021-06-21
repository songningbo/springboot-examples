#!/bin/bash
java -Dfile.encoding=utf-8 -jar mybatis-codegen.jar -configfile configuration.xml -overwrite -verbose
exit