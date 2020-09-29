# User Guide - Duke Personal Assistant

Duke is a command-line application which is able to keep track of your upcoming schedule. 
There are 3 main types of tasks, `ToDo`, `Deadline` and `Event`. Each task type stores its own unique details and are easily accessed and managed by Duke.
Supplementary functions include `Find`,`Delete`, `Done`, and `List`. Duke is also able to automatically load a saved schedule from text file and save your current task list into a text file.

## Table of contents
* [Features](#features)
    * [Starting the program](#starting-the-program)
    * [Adding task to track](#adding-task-to-track)
        * [Adding ToDo Task: ](#adding-todo-task) `ToDo`
        * [Adding Event Task: ](#adding-event-task) `Event`
        * [Adding Deadline Task: ](#adding-deadline-task) `Deadline`
    * [Setting a task as complete: ](#setting-a-task-as-complete) `Done`
    * [Requesting task list: ](#requesting-task-list) `List`
    * [Deleting a task in task list: ](#deleting-a-task-in-the-task-list) `Delete`
    * [Finding a task in task list: ](#finding-a-task-in-the-task-list) `Find`
    * [Exiting the program: ](#exiting-the-program) `Bye`
* [End of user guide](#end-of-user-guide)
 
## Features

The current version of Duke supports tracking of 3 unique types of tasks.
They are `Event`, `Deadline` and `ToDo`.
Other functions include `list`,`find` and `delete`.

**Overview**

|Feature name | Feature description
|:---:|:---:
|Track `Events`| Tracks Events in your task list
|Track `Deadline`| Tracks Deadline in your task list
|Track `Todo`| Tracks Todo in your task list
|`done` Task | Marks the task as done
|`List` | Prints out the your task list with all events
|`find` keyword | Searches task list for the given keyword
|`delete` index | Deletes Task at task index

Duke is also able to save and load previously created task list.

**Note :** Commands entered in Duke will be read as case-insensitive. 

### Starting the program
When starting the program, _Duke_ will attempt to locate a file called `tasklist.txt` and attempt to load previously saved task list.

**Outcome if successful :**

```
----------------------------------------------------
Loading Text File........
Loaded Tasks Successfully from tasklist.txt
----------------------------------------------------
```

**Outcome if unsuccessful :**

```
Loading Text File........
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
tasklist.txt does not exist!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
```

### Adding task to track
**Overview**

| Task type to add | Format of command | Example command 
|:---:|:---:|:---:
|ToDo | `Todo` _[Task name]_ | `Todo CS2113 Tutorial` 
|Event | `Event` _[Event name]_ /at _[Event Time]_ | `Event BlackPink concert /at Saturday 13 September`
|Deadline| `Deadline` _[Deadline name]_ /by _[YYYY-MM-DD]_ | `Deadline CS2113 iP /by 2020-09-18`

**Note:** Not following the format will result in an error which will be prompted by Duke.

**Note:** Tasks created will automatically be initialised as undone.

#### Adding ToDo task

**Format :** `ToDo` {Task Name}

**Example :** Todo CS2113 Tutorial

Duke will attempt to add a task of type `ToDo` with the name of {Task Name} into the task list. 

**Outcome if successful :**
```
Todo CS2113 Tutorial
----------------------------------------------------
New task added:
	[T][✗] CS2113 Tutorial
I'll keep track of it for you!
----------------------------------------------------
```

#### Adding Event task

**Format :** `Event` {Event Name} /at {Event Details}

**Example :** Event BlackPink concert /at Saturday 13 September

Duke will attempt to add a task of type `Event` with the name of {Event Name} and details of {Event Details} into the task list. 

**Outcome if successful :**
```
Event BlackPink concert /at Saturday 13 September
----------------------------------------------------
New task added:
	[E][✗] BlackPink concert (at: Saturday 13 September)
I'll keep track of it for you!
----------------------------------------------------
```

#### Adding Deadline task

**Format :** `Deadline` {Deadline Name} /by {Deadline Details}

**Note :** Deadline Details should be of the format YYYY-MM-DD 

**Example :** Deadline CS2113 iP /by 2020-09-18

Duke will attempt to add a task of type `Deadline` with the name of {Deadline Name} and details of {Deadline Details} into the task list. 

**Outcome if successful :**
```
Deadline CS2113 iP /by 2020-09-18
----------------------------------------------------
New task added:
	[D][✗] CS2113 iP (by: Sep 18 2020)
I'll keep track of it for you!
----------------------------------------------------
```

### Setting a task as complete
To mark a task as completed, type `done` followed by the integer of the task index to be completed.

**Format :** `Done` {task number}

Duke will check if the task number exists in your task list, then set the task as completed. When marked as completed, the `✗` will be replaced by a `✓`. Duke will echo back the task marked as completed to acknowledge successful completion. 

**Outcome if successful :**
```
done 2
----------------------------------------------------
Oh jolly! You finally completed this:
	[E][✓] BlackPink concert (at: Saturday 13 September)
----------------------------------------------------
```
**Outcome if unsuccessful :**
```
done 4
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
There's no such task to finish! Check your list!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
```

### Requesting task list
To request for task list, type `list` when prompted. 

**Outcome example if there is at least one task your task list :**

```
list
----------------------------------------------------
Here is your current task list!
You have 3 tasks on your list!
You have completed 0 of them.
Hope you are on target!
1. [T][✗] CS2113 Tutorial
2. [E][✓] BlackPink concert (at: Saturday 13 September)
3. [D][✗] CS2113 iP (by: Sep 18 2020)
----------------------------------------------------
```

**Outcome if there are no tasks in your task list :**

```
list
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
You have no tasks yet!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
```

### Deleting a task in the task list
To delete a task from the task list, type `delete` followed by the task number to delete.

**Format :** `delete` {Task Number}

Duke will check if the task number entered exists. If it exists, Duke will echo the task and remove it from the task list. If the task does not exist, Duke will show the user an error message.

**Example :** `delete 1` , will delete task number 1 from task list.

**Outcome if task to be deleted exists :** 

```
delete 1
----------------------------------------------------
OK! I have removed this task for you:
	[T][✗] CS2113 Tutorial
You have 2 tasks on your list!
----------------------------------------------------
```

**Outcome if task to be deleted does not exist :** 
```
delete 4
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
There's no such task to finish! Check your list!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
```

### Finding a task in the task list
To find tasks with a keyword, type `find` followed by the keyword.

**Format :** `find` {keyword}

Duke will iterate thought the task list to find tasks that contain the keyword. Prints out tasks that contain the keyword.

**Example :** `find concert`  will print out all tasks and their indexes, if the task name contains the keyword `concert`.

**Outcome if there is a matching task(s) :**

```
find concert
----------------------------------------------------
Here are the matching tasks in your list:
1. [E][✓] BlackPink concert (at: Saturday 13 September)
There are 1 tasks that fit your search!
----------------------------------------------------
```

**Outcome if there is no matching task :**

```
find potato
----------------------------------------------------
Here are the matching tasks in your list:
There are 0 tasks that fit your search!
----------------------------------------------------
```

### Exiting the program
To exit the program, type `bye` when prompted.

While exiting the program, Duke will save a copy of your task list as `tasklist.txt` in the root folder.

**Outcome if successful :**

```
bye
----------------------------------------------------
Task list saved successfully as tasklist.txt
----------------------------------------------------
Bye.
I'm going back to sleep.
------------Duke has gone back to sleep--------------
```

**Outcome if unsuccessful :**

```
bye
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
ERROR SAVING TASKS
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Bye.
I'm going back to sleep.
------------Duke has gone back to sleep--------------
```

## End of user guide
