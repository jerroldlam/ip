# Duke personal assistant

This is a project for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Features

The current version of Duke supports tracking of 3 unique types of tasks.
They are `Event`, `Deadline` and `ToDo`.
Other functions include `list`,`find` and `delete`.

Duke is also able to save and load previously created task list.

### Starting the program
When starting the program, _Duke_ will attempt to locate a file called `tasklist.txt` and attempt to load previously saved task list.

### Adding task to track
| Task type to add | Format of command | Example command
|---|---|---
|ToDo | `Todo` _[Task name]_ | `Todo CS2113 Tutorial`
|Event | `Event` _[Event name]_ /at _[Event Time]_ | `Event BlackPink concert /at Saturday 13 September`
|Deadline| `Deadline` _[Deadline name]_ /by _[YYYY-MM-DD]_ | `Deadline CS2113 iP /by 2020-09-18`

Note: Task type keywords can be case-insensitive

Note: Not following the format will result in an error which will be prompted by Duke.

### Deleting a task in the task list
To delete a task from the task list, type `delete` followed by the task number to delete.

Format : `delete` {Task Number}

Duke will check if the task number entered exists. If it exists, Duke will echo the task and remove it from the task list. If the task does not exist, Duke will show the user an error message.

Example : `delete 3` , will delete task number 3 from task list.

### Finding a task in the task list
To find tasks with a keyword, type `find` followed by the keyword.

Format : `find` {keyword}

Duke will iterate thought the task list to find tasks that contain the keyword. Prints out tasks that contain the keyword.

Example : `find carrots` , will print out all tasks and their indexes if the task name contains `carrots`

### Requesting task list
To request for task list, type `list` when prompted. The `list` command is case-insensitive.

### Exiting the program
To exit the program, type `bye` when prompted. The `bye` command is case-insensitive.

While exiting the program, Duke will save a copy of your task list as `tasklist.txt`.

## Done by

Display | Name | Github Profile
---|:---:|:---:
![](https://avatars3.githubusercontent.com/u/60382285?s=400) | Jerrold Lam  | [jerroldlam](https://github.com/jerroldlam "Github User Profile")


