Git & GitHub Comprehensive Notes
1. Introduction to Version Control System (VCS)

    What is VCS? A system that records changes to files over time so you can recall specific versions later.

    Benefits: Tracks who changed what, allows reverting to stable states, and enables team collaboration.

2. Git Basics (Local Machine)

    git init: Initializes a new local repository.

    Configuration: Set your identity using git config --global user.name and user.email.

    Workflow:

        Modify files.

        Stage changes with git add ..

        Commit with git commit -m "message".

3. Tracking & History

    git status: See the state of your working directory and staging area.

    git log: View your commit history (use --oneline for a cleaner view).

    git diff: See specific line changes before committing.

    git blame: See who changed which line of a file.

4. Reverting & Undoing

    git reset --hard: Moves history back to a specific commit (destroys subsequent changes).

    git revert: Creates a new commit that undoes a previous one (safest for collaboration).

5. Working with Remote (GitHub)

    GitHub: A cloud hosting service for Git repositories.

    git remote add origin: Connects local code to a GitHub repo.

    git push: Sends local work to the cloud.

    git pull: Fetches and merges updates from teammates.

6. Branching & Merging

    Branches: Isolate your work (e.g., git checkout -b feature-name).

    Merging: Combining branches. Use Standard Merge for simple combines or Rebase for a cleaner, linear history.

    Pull Requests (PRs): Propose changes on GitHub for review before merging into the main branch.

7. Pro-Tip: Git Stash

    git stash: Use this to "hide" unfinished work if you need to switch branches quickly without committing half-finished code. Use git stash apply to bring it back.
