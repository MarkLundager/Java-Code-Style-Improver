# How to build, test and run.

## Building && running

1. Clone to repository locally.

2. type git submodule update --init --recursive to make sure you have extendj IDRISS WE NEED HELP HERE.

3. build the project, i.e. type "./gradlew clean build" on Linux and "gradlew clean build" on windows in the terminal. Please note you need to
   be located in the root of the project.

4. To install the vscode extension (only works on linux) type ./generate_vsce.sh in the terminal. Make sure you have npm and vsce installed!

5. Now reload vscode and open a java project. If vscode was already open, make sure you reload. (ctrl + shift + p) and type "reload" and a reload option in vscode should appear. Now if there are any style issues (IFRT,EIFB,IFRC), they will be highlighted in yellow. Click the lamp for a quickfix.

## Examples
If you wish to see examples, simply open vscode and click file in the top right corner. Click open folder and navigate to the folder "testfiles" in the project. Once it loads, all the files in this folder should contain one of the issues detected by this tool.

## Testing

1. Testing is done by typing either ./gradlew test or "gradlew test" depending on your operative System. This will run the check on a file called allTests.java and make sure the generated warnings correspond to the generated warning that were checked manually in advance for the java code located in that file.


## Requirements

* Java 11
* npm
* vsce
* Linux OS

## Credits

The following files in the repository come from:

- extendj/*: Header files from the FMI2 standard, licensed under a Modified BSD License, https://extendj.org/
- The whole project structure and a substantial amount of skeletoncode: Idriss Riouak
- Magpiebridge integration: https://github.com/MagpieBridge/MagpieBridge

  


## License
This repository is covered by the license BSD 2-clause, see file LICENSE.
