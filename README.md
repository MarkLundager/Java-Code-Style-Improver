# Java Code Style Improver
Java Code Style Improver is a tool developed to analyze Java Code and find verbose code to then give suggestions of improved code without changing the behaviour. It is an extension of the ExtendJ compiler and with the help of Magpiebridge it functions as an extension in the Visual Studio code app. The checks that are performed are very strict to ensure no false positives (which could alter the behaviour of the code). Consenquently, there will be multiple false negatives. Below you can find examples of all the checks performed. The left side shows the code before it is improved while the right side displays the code post-improvement. Note that the tool is not capable of handling indentation within blocks. Finally, comments are not removed but they will be inserted before the correction in order.

(Add description of working towards being sound.)

## Examples

IF RETURN CONDITION (IFRC) (Also works with inversed return values). Provided by Andrew Luxton-Reilly and Gerard Rowe
```

if(y>3){                                               |
    return true;                                       |
}                                                      |            return y > 3;
else{                                                  |
    return false;                                      |
}                                                      |
```

IF RETURN TRUE (IFRT) (Also works with inversed return values). Provided by Andrew Luxton-Reilly and Gerard Rowe
```

                                                       |         /*Auto Generated comments*
if(x>/*crazy comment                                   |         /*crazy comment
sadsad                                                 |         sadsad
asdsa*/y){//apa                                        |         asdsa*/
    return true;                                       |//apa
}//apa                                                 |//apa
return false; //comment                                |return x > y; //comment
```
 EMPTY IF BODY (EIFB) (Also works with inversed condition). Provided by Andrew Luxton-Reilly and Gerard Rowe
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

3. In order for the tool to work, a snapshot of ExtendJ is required. Hence, we want ExtendJ as a submodule in our repository. This can be done by  the following commands:
   ```
   cd EDAN70
   git submodule update --init --recursive
   ```
4. Then to build the project you should run the following (make sure that you are in the root of the repository):
   ```
   ./gradlew clean build vsce
   ```

5. Now you should have the extension available in VSCode. If VSCode was already open make sure you reload the window (ctrl + shift + p), in the search bar that appears type reload and the suggestion to reload the window should appear. Otherwise simply just open VSCode and open a project to see if it contains any of the issues listed in the description of the tool.


## Testing
Testing is performed by typing the following command in the terminal (you have to be located in the root of the repository)
```
   ./gradlew test
```
This will run the check on a file called allTests.java and make sure the generated warnings correspond to the generated warning that were checked manually in advance for the java code located in that file.


## Requirements

* Java 11. (tested with Java 11 v11.0.20.1) 
* npm      (tested with version 10.2.0)
* vsce     (tested with version 2.15.0)
* Linux OS (tested with WSL with the Ubuntu 20.04.6 LTS distribution for Windows) (Linux 5.15.133.1-microsoft-standard-WSL2 amd64)
* Gradle   (tested with version 4.4.1)

## Credits

The following files in the repository come from:

- extendj/*: Header files from the FMI2 standard, licensed under a Modified BSD License, https://extendj.org/
- The whole project structure and a substantial amount of skeleton code: Idriss Riouak
- Magpiebridge integration: https://github.com/MagpieBridge/MagpieBridge under Eclipse Public License - v 2.0
- The IFRC, IFRT and EIFB style issues introduced by Andrew Luxton-Reilly and Gerard Rowe in their paper "Understanding semantic style by analysing student code" DOI: 10.1145/3160489.3160500

  


## License
This repository is covered by the license BSD 2-clause, see file LICENSE.
