# Refactoring existing code

Your task is to refactor an existing class [written in Java](ConcatenateMatrices.java). The task is open-ended, that is, it is not prescribed what the eventual outcome should be.

Note that the given program might not work as intended (see [`ConcatenateMatrices.pdf`](ConcatenateMatrices.pdf)).

Before delving into any coding, study the code and its original purpose and devise an outline of the changes you want to make. Focus on the following:
  * better functionality separation (e.g. don't mix parsing and subsequent calculations);
  * improved [testability](https://www.toptal.com/qa/how-to-write-testable-code-and-why-it-matters);
  * prefer [pure functions](https://blog.knoldus.com/functional-java-understanding-pure-functions-with-java/) without side effects;
  * try to generalize to a reasonable extent (e.g. let the user of your class do arbitrary operations instead of just string concatenation);
  * maintain appropriate amounts of comments in the code --- commenting every other line indicates you have named elements in your code wrong; well-written code is mostly self-explanatory.

#### You are supposed to:
  * Learn about Git and GitHub
    - https://guides.github.com/introduction/git-handbook/
    - https://guides.github.com/activities/hello-world/
    - https://git-scm.com/docs/user-manual
  * Create a GitHub account.
  * Fork this repository into a public copy, make the intented changes in the copy, and arrange them into a reasonable sequence of commits.
  * Your new code should include at least a couple of simple tests (e.g. in a static method in the classes you create).
  * Learn a bit of [Markdown](https://www.markdownguide.org/basic-syntax) and add into [README.md](README.md) brief instructions on how to run/test your program.
  * Prepare a pull request (PR) against the original repository, with [`janmazak`](https://github.com/janmazak) set as a reviewer.
  * The PR should contain a description of the changes and a concise explanation of why you want to make them.
  * Fix your code according to the comments on the PR and get it approved eventually.

When organizing the commits in the PR:
  * Aim for understandability, which typically means small commits (they can be easily squashed together later).
  * Commit messages should succintly describe what the purpose of the commit is. 
  * Use [`git add -p`](https://medium.com/transmute-techtalk/improve-your-commit-hygiene-with-git-add-patch-3b7dd9c117c4) when creating the commits.
  * Be careful: the main branch in the original repository might have undergone some changes in the meantime; it is you responsibility to maintain your copy up-to-date.

Not required, but extremely useful to know about:
  * Try to use [`git rebase -i`](https://git-scm.com/book/en/v2/Git-Branching-Rebasing) and play with reordering and squashing your commits.
  * Use tools like [`gitk`](https://git-scm.com/docs/gitk/) while doing it.
  * Try `git stash save`, `git stash apply`.
  * Try putting your commits in separate branches and then merge them into the main one (`master` or `main`).
  * Create a [merge conflict](https://www.atlassian.com/git/tutorials/using-branches/merge-conflicts#:~:text=Git%20can%20handle%20most%20merges,working%20in%20a%20team%20environment.) and resolve it using [`meld`](https://meldmerge.org/).
  * Explore some thriving github repositories, e.g. https://github.com/nlohmann/json. Take a look at existing pull requests.

It is reasonable to spend altogether at least 4-6 hours on this task.

### How to rewrite an existing program

* Before doing any large refactors, you should minimize the risks of breaking something accidentally.
* Don't start the refactoring without studying and understanding the existing code and overall limitations (e.g. on hardware memory). You don't need to understand every detail, but things might be implemented in a certain way because it's the best way, though that might not be obvious at first sight.
* Start with minor changes that have huge impact on time savings later.
* Sanitize all inputs whenever possible: add checks for ranges of variables, non-zero and non-null values, checks for length constraints etc. Especially if you are using a lower-level language like C and security is an important concern. Detect bugs sooner rather than later; add assertions if they are missing.
* Consider adding tests if it makes sense (if coverage is insufficient, and mainly for parts of code you are going to more-or-less keep).
* You should have some kind of quick integration tests (if you are only going to change internal structure of the code, and not the whole API). Run them often.
* Get rid of non-named constants and put definitions of constants in proper places (with respect to their scope).
* Spend some time on identifying and removing redundant code.
* Try to avoid huge all-encompassing changes that will break most existing tests.
* Don't add new features until refactoring is complete.
* Avoid messy commit history if possible. It is not necessary that the program is functional after each commit, but it should at least be compilable without errors, and it should be properly formatted (not complying with this is a potentially endless source of future annoyance and wasted time). For instance, splitting the renaming of a function into two different commits almost never makes sense.


