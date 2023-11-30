# Description (Change title to name of the tool)
(Insert name of tool) is a tool developed to analyze Java Code and find verbose code to then give suggestions of improved code without changing the behaviour. It is an extension of the ExtendJ compiler and with the help of Magpiebridge it functions as an extension in the Visual Studio code app. The checks that are performed are very strict to ensure no false positives (which could alter the behaviour of the code). Consenquently, there will be multiple false negatives. Below you can find examples of all the checks performed. The left side shows the code before it is improved while the right side displays the code post-improvement. Note that the tool is not capable of handling indentation within blocks. Finally, comments are not removed but they will be inserted before the correction in order.


IF RETURN CONDITION (IFRC) (Also works with inversed return values)
```

if(y>3){                                               |
    return true;                                       |
}                                                      |            return y > 3;
else{                                                  |
    return false;                                      |
}                                                      |
```

IF RETURN TRUE (IFRT) (Also works with inversed return values)
```

                                                       |         /*Auto Generated comments*
if(x>/*crazy comment                                   |         /*crazy comment
sadsad                                                 |         sadsad
asdsa*/y){//apa                                        |         asdsa*/
    return true;                                       |//apa
}//apa                                                 |//apa
return false; //comment                                |return x > y; //comment
```
 EMPTY IF BODY (EIFB) (Also works with inversed condition)
```
if(x>/*Comment in middle of expression*/y){            |         /*Auto Generated comments*/
}//comment here as well                                |/*Comment in middle of expression*/
else{                                                  |//comment here as well
    return/*this is a crazy comment location*/ false;  |/*this is a crazy comment location*/
}                                                      |if(!(x > y)){
                                                       |            return false;
                                                       | }
```
Long Addition To Short Addition (LATSA) (Works with integer literals as well)

```                              
mark = mark + apa;                                     |       mark += apa;
```
Long Subtraction To Short Subtraction (LSTSS) (Works with integer literals as well)       

```                              
mark = mark - apa;                                     |       mark -= apa;
```

Long Multiplication To Short Multiplication (LMTSM) (Works with integer literals as well)       

```                              
mark = mark * apa;                                     |       mark *= apa;
```

Long Division To Short Division (LDTSD) (Works with integer literals as well)       

```                              
mark = mark / apa;                                     |       mark /= apa;
```
  
# How to build, test and run.

## Building && running

1. Clone to repository locally. This can be done by navigating to the desired location in your terminal. Once you are there type
   if you have SSH key:
   ```
   git clone git@github.com:Markie06/EDAN70.git
   ```
   if you wish to clone with your github credentials:
   ```
   git clone https://github.com/Markie06/EDAN70.git
   ```

2. In order for the tool to work, a snapshot of ExtendJ is required. Hence, we want ExtendJ as a submodule in our repository. This can be done by  the following commands:
   ```
   cd EDAN70
   git submodule update --init --recursive
   ```
3. Then to build the project you should run the following (make sure that you are in the root of the repository):
   ```
   ./gradlew clean build vsce
   ```

4. Now you should have the extension available in VSCode. If VSCode was already open make sure you reload the window (ctrl + shift + p), in the search bar that appears type reload and the suggestion to reload the window should appear. Otherwise simply just open VSCode and open a project to see if it contains any of the issues listed in the description of the tool.


## Examples
If you wish to see examples, simply open vscode and click file in the top right corner. Click open folder and navigate to the folder "testfiles" in the project. Once it loads, all the files in this folder should contain one of the issues detected by this tool.

##Checking a directory for errors:

If you wish to check a directory for issues, navigate to the root of the repository in the terminal and type:
   ```
   java -jar improver.jar root_path_of_folder_to_perform_check_on
   ```
Replace root_path_of_folder_to_perform_check_on with the actual path to your folder. This will produce a Result.txt file containing information regarding what files were scanned and if they contained any of the errors.

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
