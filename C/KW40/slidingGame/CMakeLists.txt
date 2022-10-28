cmake_minimum_required(VERSION 3.23)
project(slidingGame C)

set(CMAKE_C_STANDARD 99)

add_executable(slidingGame main.c utils.h utils.c)
