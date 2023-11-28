# EDAN70

Project in Compilers



# Thoughts/Todo:

* Move utility code for an ast node into its own ASTJragFile? (we decide later)
* Is there a way to implement automated tests, somehow check the values given by the analyser for a given source file? (simply validate warnings manually and make test that checks hardcoded values. If they change, something is wrong. (very primitive automated testing)
* Change the way the creation of a warning works. Does NOT make sense to generate a new position in the warning class, instead a Position should be provided as we have more information in the analysis. This will be better than the current fix (creating a new Warning method for each new improvement implementation). Approved by IDRISS, RESOLVED!!!
* It seems like Magpiebridge creates an analyze function which some vscode calls when an action happens and in that call provides the files which are supposed to be changed. Not sure how to fix the load whole project issue? OUT OF SCOPE
* EIFB prettyprint issue, how to solve? OUT OF SCOPE
* Comment saver (Compilation unit has access to filepath, use regexes to find comments and prepend them before prettyprint) FINISHED!
* For each loop, start implementing.
# WEEK3

* FIX AUTOMATED TEST
* Andreas: Fix his shit
* Additions to report

# WEEK 4
* Complete automated tests (Proves to be very difficult).
* Evaluation, Idriss will ask Görel for repositories in order to evaluate our program (Solved)
* Create Script for iterating through repositories.
* Show portability for our implementation by collaboration with Johannes and his group.
* Create release with alpha tag, give credit to magpiebridge, Idriss etc.
# WEEK 5
* Add references to codeprober, extendJ, PMD, checkstyle, SonarCube, JavAST. How to cite a website? IDRISS HELP
* 
