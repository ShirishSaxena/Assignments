# Prerequisites
- Java 8+
- IntelliJ (optional)

# Features
- Very basic I/O address book that checks if file exists or not if not create that file to be used as database.
- It only takes specific extension file and will keep asking until fileName ends with that extension (default - '.ncx')
- It can add multiple entries at once.
- Sort by every field.
- Delete records by email.

# Assumptions
- It would have been easier to use sql, but a basis understanding of how I/O buffer works is neccesary, and thus I choose to use files as database.
- For sorting, I used custom comparator, comparators time compelxity is (nLogn) and it's easier to implement.

# Further improvement
- Taking entries from one file and adding it to another one.
- Using serializable and deserializable to convert object in byte streams and so forth.
- Search for specific entries (String.contains, String.endsWith, String.startsWith etc)
- Browse records but with pageable so they don't clutter the cmd.


# Working gif...
![Gif](http://213.32.15.53:6969/idea64_QXMwyMagUp.gif)
