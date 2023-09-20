#include <jni.h>
#include <string>
#include "native-lib.h"
#include <cstring>


int testInt(int a, int b) {
    return a + b;
}

char * getString(char * pre) {
    std::string src1(pre);
    std::string src2("hello world from C++");
    std::string dest = src1 + src2;
    return const_cast<char *>(dest.c_str());
}