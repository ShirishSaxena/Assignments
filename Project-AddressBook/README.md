# Prerequisites
- Java 8+
- IntelliJ (optional)

# Features
- Very basic I/O address book that checks if file exists or not if not create that file to be used as database.
- It only takes specific extension file and will keep asking until fileName ends with that extension (default - '.ncx')
- It can add multiple entries at once.

# Assumptions
- It would have been easier to use sql, but a basis understanding of how I/O buffer works, I choose to use text files as database.
- For sorting, I used custom comparator, comparators time compelxity is (nLogn) and it's easier to implement.

# To add
- Custom sorting
- Taking entries from one file and adding it to another one.
- Using serializable and deserializable to convert object in byte streams and so forth.
- Remove an entry from file
- Search for specific entries (String.contains, String.endsWith, String.startsWith etc)
- Browse records but with pageable so they don't clutter the cmd.


# Working gif...
![Gif](http://213.32.15.53:6969/idea64_QXMwyMagUp.gif)
