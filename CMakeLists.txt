cmake_minimum_required(VERSION 3.10)
project(portugolpp)

set(CMAKE_CXX_STANDARD 17)

find_package(JNI REQUIRED)

if(JNI_FOUND)
    message(STATUS "JNI_INCLUDE_DIRS=${JNI_INCLUDE_DIRS}")
    message(STATUS "JNI_LIBRARIES=${JNI_LIBRARIES}")
else()
    message(FATAL_ERROR "JNI não encontrado!")
endif()

set(SOURCES
    src/main/native/file_io.cpp
)

add_library(portugolpp SHARED ${SOURCES})

target_include_directories(portugolpp PRIVATE ${JNI_INCLUDE_DIRS})

target_link_libraries(portugolpp ${JNI_LIBRARIES})

if(WIN32)
    set_target_properties(portugolpp PROPERTIES
        OUTPUT_NAME "portugolpp"
        SUFFIX ".dll"
    )
else()
    set_target_properties(portugolpp PROPERTIES
        OUTPUT_NAME "portugolpp"
        PREFIX "lib"
        SUFFIX ".so"
    )
endif()