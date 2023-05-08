# Concatenate Matrices

This is Java project made for string matrix concatenation.

Project contains:
* **[src](src)** folder with all source code
    * [main](src/main) folder with application sources
    * [test](src/test) folder with test sources
* **[input.txt](input.txt)** file for user input
* **[output.txt](output.txt)** file for application output
* [lib](lib) folder with JUnit libraries for testing
* [out](out) folder with compiled code
* [.vscode](.vscode) with [settings.json](.vscode/settings.json) file for project configuration in Visual Studio Code


## How to run it

1. Write your input to [input.txt](input.txt) file in the following format:

        [number of rows] [number of columns] [first matrix] [second matrix] ...

    Each matrix should be written as listed elements separated by whitespace, for example like this:

        2 3
        ab cd ef
        ab cd ef
        1 2 3
        4 5 6
        AB CD EF
        GH IJ KL


2. Run main method in [ConcatenateMatrices.java](src/main/ConcatenateMatrices.java) class. For that, you can simply use the following command

        java -cp out main.ConcatenateMatrices

3. You should find your output in [output.txt](output.txt) file.


## Testing

In [Tests.java](src/test/Tests.java) class, there are prepared total six unit tests (they should all result as OK, one test should throw exception with message "Error with reading elements into the matrix."). You can run them with the following command:

    java -cp "out;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.Tests

_Note: When running on Windows, use backslash in classpath (`java -cp "out;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore test.Tests`)._