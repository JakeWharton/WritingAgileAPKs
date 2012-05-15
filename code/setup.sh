#!/bin/bash

ROOT="$( dirname "$( cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd )" )"

( cd $ROOT && git submodule sync && git submodule update --init )
