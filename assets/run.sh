#!/usr/bin/env bash

WORKING_DIR="$( cd "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"

OS_NAME=$(uname)

if [ "${OS_NAME}" == 'Darwin' ]; then
  JAVAFX_LIBS="${WORKING_DIR}/javafx/osx/"
elif [ "${OS_NAME}" == 'Linux' ]; then
  if [[ $(uname -m) == armv* ]]; then
    JAVAFX_LIBS="${WORKING_DIR}/javafx/arm/"
  else
    JAVAFX_LIBS="${WORKING_DIR}/javafx/linux/"
  fi
else
  JAVAFX_LIBS="${WORKING_DIR}/javafx/windows/"
fi

MODULE_PATH=""

for module in `ls ${WORKING_DIR}/*.jar`
do
  MODULE_PATH="${MODULE_PATH}:$module"
done

for module in `ls ${JAVAFX_LIBS}*.jar`
do
  MODULE_PATH="${MODULE_PATH}:$module"
done

if [[ $(uname -m) == armv* ]]; then
  MODULE_PATH="${MODULE_PATH} -Dglass.platform=gtk" #mandatory for open-javafx 16 from Gluon
fi

java --module-path ${MODULE_PATH} --module io.github.fjossinet.raspberry/io.github.fjossinet.raspberry.App "$@"
