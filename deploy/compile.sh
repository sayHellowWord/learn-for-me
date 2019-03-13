#!/usr/bin/env bash
mvn clean -U package -P $PLUS_TEMPLATE_ENV  -DskipTests=true