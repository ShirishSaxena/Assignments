# Prerequisites
- Java 8+
- IntelliJ (optional)

# Features
- Very basic I/O address book that checks if file exists or not if not create that file to be used as database.
- It only takes specific extension file and will keep asking until fileName ends with that extension (default - '.ncx')
- It can add multiple entries at once.
- Sort by every field.
- Delete records by email.
- Error handling (No wrong choices, error when trying to do changes without first loading file and much more.)

# Supports
- Load from file (create new file if it doesn't exists)
- Save to file (save any changes made during runtime, like sorting, deletion etc)
- Add entry/entries (add single entry or multiple entry directly to file)
- Sort records (you can sort it by every field)
- Show all records (shows all records in that file and also any pending changes that needs to be saved)
- Delete record (Deletes record by email, because email is always unique)
- Quit;Exits

# Assumptions
- It would have been easier to use sql, but a basis understanding of how I/O buffer works is neccesary, and thus I choose to use files as database.
- For sorting, I used custom comparator, comparators time compelxity is (nLogn) and it's easier to implement.

# Further improvement
- Taking entries from one file and adding it to another one.
- Using serializable and deserializable to convert object in byte streams and so forth.
- Search for specific entries (String.contains, String.endsWith, String.startsWith etc)
- Browse records but with pageable so they don't clutter the cmd for high record file.

# Screenshots and gifs
## Welcome screen/Menu
![welcomescreen](https://user-images.githubusercontent.com/6762915/149003894-4ebbaad8-234c-43e9-b80a-906030f9ed28.png)

## Working gif
![workinggif](http://200.showy.life:6969/ZuPeG8j7EY.gif)

## Error handling (Not loading file first)
![errorhandling](http://200.showy.life:6969/k1XImtW1bM.gif)





