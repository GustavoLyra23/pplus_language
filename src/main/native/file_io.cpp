
#include <jni.h>
#include <fstream>
#include <string>

using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_processors_FileIOProcessor_lerArquivo(
    JNIEnv *env, jobject, jstring path
) {
    const char *nativePath = env->GetStringUTFChars(path, 0);
    ifstream file(nativePath);
    std::string content((istreambuf_iterator<char>(file)),
                         istreambuf_iterator<char>());
    env->ReleaseStringUTFChars(path, nativePath);
    return env->NewStringUTF(content.c_str());
}

extern "C" JNIEXPORT void JNICALL
Java_processors_FileIOProcessor_escreverArquivo(
    JNIEnv *env, jobject, jstring path, jstring data, jboolean append
) {
    const char *nativePath = env->GetStringUTFChars(path, 0);
    const char *nativeData = env->GetStringUTFChars(data, 0);

    std::ofstream file;
    if (append) {
        file.open(nativePath, std::ios::app);
    } else {
        file.open(nativePath);
    }

    file << nativeData;

    env->ReleaseStringUTFChars(path, nativePath);
    env->ReleaseStringUTFChars(data, nativeData);
}