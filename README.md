# Description (Change title to name of the tool)
(Insert name of tool) is a tool developed to analyze Java Code and find verbose code to then give suggestions of improved code without changing the behaviour. It is an extension of the ExtendJ compiler and with the help of Magpiebridge it functions as an extension in the Visual Studio code app. The checks that are performed are very strict to ensure no false positives (which could alter the behaviour of the code). However, consenquently there will be multiple false negatives. Below you can find examples of all the checks performed. The left side shows the code before it is improved while the right side displays the code post-improvement. Note that the tool is not capable of handling indentation within blocks. Finally, comments are not removed but they will be inserted before the correction.


```
                              IF RETURN CONDITION (IFRC) (Also works with inversed return values)

if(y>3){                                               |
    return true;                                       |
}                                                      |            return y > 3;
else{                                                  |
    return false;                                      |
}                                                      |

                              IF RETURN TRUE (IFRT) (Also works with inversed return values)

                                                       |         /*Auto Generated comments*
if(x>/*crazy comment                                   |         /*crazy comment
sadsad                                                 |         sadsad
asdsa*/y){//apa                                        |         asdsa*/
    return true;                                       |//apa
}//apa                                                 |//apa
return false; //comment                                |return x > y; //comment

                           EMPTY IF BODY (EIFB) (Also works with inversed condition)

if(x>/*Comment in middle of expression*/y){
}//comment here as well
else{
    return/*this is a crazy comment location*/ false;
}





```
  
# How to build, test and run.

## Building && running

1. Clone to repository locally.

2. type git submodule update --init --recursive to make sure you have extendj as a submodule in the repository which this tool relies on.

3. build the project, i.e. type "./gradlew clean build".

4. To install the vscode extension type ./generate_vsce.sh in the terminal. Make sure you have npm and vsce installed and that you are located in root of the project where the script is located!

5. Now reload vscode and open a java project. If vscode was already open, make sure you reload. (ctrl + shift + p) and type "reload" and a reload option in vscode should appear. Now if there are any style issues (IFRT,EIFB,IFRC,etc), they will be highlighted in yellow. Click the yellow lightbulb for a quickfix.

## Examples
If you wish to see examples, simply open vscode and click file in the top right corner. Click open folder and navigate to the folder "testfiles" in the project. Once it loads, all the files in this folder should contain one of the issues detected by this tool.

## Testing

1. Testing is performed by typing ./gradlew test . This will run the check on a file called allTests.java and make sure the generated warnings correspond to the generated warning that were checked manually in advance for the java code located in that file.


## Requirements

* Java 11
* npm
* vsce
* Linux OS
* Gradle

## Credits

The following files in the repository come from:

- extendj/*: Header files from the FMI2 standard, licensed under a Modified BSD License, https://extendj.org/
- The whole project structure and a substantial amount of skeletoncode: Idriss Riouak
- Magpiebridge integration: https://github.com/MagpieBridge/MagpieBridge

  


## License
This repository is covered by the license BSD 2-clause, see file LICENSE.
