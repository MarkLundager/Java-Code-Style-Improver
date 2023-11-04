# EDAN70

Project in Compilers



# Thoughts/Todo:

* Move utility code for an ast node into its own ASTJragFile? (maybe bad idea)
* Is there a way to implement automated tests, somehow check the values given by the analyser for a given source file?
* Change the way the creation of a warning works. Does NOT make sense to generate a new position in the warning class, instead a Position should be provided as we have more information in the analysis. This will be better than the current fix (creating a new Warning method for each new improvement implementation).
* It seems like Magpiebridge creates an analyze function which some vscode calls when an action happens and in that call provides the files which are supposed to be changed. Not sure how to fix the load whole project issue?