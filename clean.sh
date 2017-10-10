#!/bin/bash
rm -rf protobuf/class/*
cd mvn_prj
./clean.sh
cd ..

rm -f datafiles/bb.txt
touch datafiles/bb.txt
