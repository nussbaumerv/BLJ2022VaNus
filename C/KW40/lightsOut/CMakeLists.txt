cmake_minimum_required(VERSION 3.23)
project(lightsOut C)

set(CMAKE_C_STANDARD 11)

add_executable(lightsOut main.c utils.h utils.c)
