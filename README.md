# ConcatenateMatrices
### Overview
This class creates matrix of strings from textfile named vstup.txt and saves it in a formatted way in textfile named vystup.txt.
### How to run ConcatenateMatrices
Make an input textfile named vstup.txt. The first line has to contain two integers separated by a space.
The first number, m, is the number of rows and the second, n, is number of columns.
Then add m*n of strings in the next lines. The strings can't contain white spaces(they are separated by them).

If you have vstup.txt, put it in the same directory as ConcatenateMatrices.java is. Then you can run ConcatenateMatrices.java.
The output will be in textfile named vystup.txt.
### How to test ConcatenateMatrices
You can test if m, n are valid integers; bigger than zero. Put "System.out.println(areDimensionsSet(m, n));" in the code right after initialization of m,n. If they are, you will see "true" in the terminal.

Example:
    Scanner scanner = new Scanner(new FileInputStream("vstup.txt")); // nacitanie vstupu
    PrintStream output = new PrintStream("vystup.txt"); // vystupny subor
    int m = scanner.nextInt();
    int n = scanner.nextInt();

    System.out.println(areDimensionsSet(m, n));

After filling of matrix you can put "System.out.println(isMatrixFilled(m, n, matrix));". If there's no empty string in the matrix, it will also print "true" in the terminal.

Example:
    while (scanner.hasNext()) { // kym je cim, plni sa matica
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] += scanner.next();
                }
            }
        }

    System.out.println(isMatrixFilled(m, n, matrix));

If you want to test the whole thing without creating your own vstup.txt, you can rename test-input.txt to vstup.txt and run it. The content of newly generated vystup.txt should be the same as in test-output.txt.