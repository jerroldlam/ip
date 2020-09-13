# Duke personal assistant

This is a project for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.


## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/duke/Duke.java` file, right-click it, and choose `Run Duke.main()`. 

## Features

The current version of Duke supports tracking of 3 unique types of tasks.
They are `Event`, `Deadline` and `ToDo`.

Duke is also able to save and load previously created task list.

### Starting the program
When starting the program, _Duke_ will attempt to locate a file called `tasklist.txt` and attempt to load previously saved task list.

### Adding task to track
| Task type to add | Format of command | Example command
|---|---|---
|ToDo | `Todo` _[Task name]_ | `Todo CS2113 Tutorial`
|Event | `Event` _[Event name]_ /at _[Event Time]_ | `Event BlackPink concert /at Saturday 13 September`
|Deadline| `Deadline` _[Deadline name]_ /by _[Deadline]_ | `Deadline CS2113 iP /by Week 6`

Note: Task type keywords can be case-insensitive

### Deleting a task in the task list
To delete a task from the task list, type `delete` followed by the task number to delete.

Format : `delete` {Task Number}

Example : `delete 3` , will delete task number 3 from task list.

### Requesting task list
To request for task list, type `list` when prompted. The `list` command is case-insensitive.

### Exiting the program
To exit the program, type `bye` when prompted. The `bye` command is case-insensitive.

While exiting the program, Duke will save a copy of your task list as `tasklist.txt`.




