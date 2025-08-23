<div align="center">
<img width="240" src="./asset/ppcube.png" alt="ppcube" />
<br />
<img align="center" src="https://img.shields.io/badge/status-desenvolvimento-green.svg" alt="Status" />
<hr/>
</div>

## Sobre o Projeto
_P++_ é uma linguagem de programação destinada a falantes de português, facilitando o aprendizado de programação através
de uma sintaxe semelhante ao Portugol, mas com recursos modernos de linguagens orientadas a objetos.

## Características

- **Sintaxe amigável** em português baseada em Portugol
- **Programação Orientada a Objetos** com classes, herança e interfaces
- **Tipagem dinâmica** para facilitar o aprendizado
- **Estruturas de controle** (condicionais, loops)
- **Funções e métodos** com parâmetros e valores de retorno
- **Funções nativas de E/S** para operações de entrada e saída
- **Coleções** como listas e mapas
- **Processamento de arquivos** com bibliotecas nativas _C++_
- **Suporte a threads** para execução assíncrona
- **Suporte a multiplos modulos** import de outros arquivos

## Requisitos do Sistema

### Versão Java/Kotlin (original)
- Java JDK 21 ou superior
- Gradle 8.0 ou superior
- CMake (para compilação das bibliotecas nativas)

### Versão C++ (nova implementação)
- C++17 ou superior
- CMake 3.16 ou superior
- ANTLR4 C++ runtime
- GCC/Clang ou MSVC

## Documentação

- **Documentação da Engine do Interpretador**: [P++ Docs](https://deepwiki.com/GustavoLyra23/PPlus)
- **Site Oficial do _P++_**: [Web Page](https://gustavolyra23.github.io/pplus_web/index.html)
- **Extensão Vscode**: [_P++_ Vscode Extension](https://marketplace.visualstudio.com/items?itemName=gustavomirandalyra16.portugolpp)

## Instalação

### Clonar o repositório

```bash
git clone <url-do-repositorio>
cd pplus_language
``` 

## Compilar o projeto

### Versão C++ (recomendada)

#### Pré-requisitos
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install -y cmake build-essential wget unzip pkg-config uuid-dev

# Download e instalar ANTLR4 C++ runtime
wget https://github.com/antlr/antlr4/archive/refs/tags/4.13.1.tar.gz
tar xzf 4.13.1.tar.gz
cd antlr4-4.13.1/runtime/Cpp
mkdir build && cd build
cmake .. -DCMAKE_BUILD_TYPE=Release
make -j4
sudo make install
cd ../../../../
```

#### Compilar o interpretador C++
```bash
# Gerar parser C++ do ANTLR
java -jar antlr-4.13.1-complete.jar -Dlanguage=Cpp -visitor -o cpp_src/antlr_generated src/main/antlr/org/gustavolyra/PortugolPP.g4

# Compilar projeto
mkdir build_cpp && cd build_cpp
cmake ..
make -j4
```

#### Executar programa P++
```bash
./bin/portugolpp_cpp programa.ppp
```

### Versão Java/Kotlin (original)

#### Compilar bibliotecas nativas

```bash
./gradlew buildNative
```

#### Compilar projeto principal

```bash
./gradlew build
```

#### Criar JAR executável

```bash
./gradlew shadowJar
```

#### Gerar executável Windows (opcional)

```bash
./gradlew launch4j 
```

#### Executar um programa P++

Usando JAR

```bash
java -jar build/libs/portugolpp.jar programa.ppp
```

#### Usando executável Windows

```bash
./portugolpp.exe programa.ppp
```



