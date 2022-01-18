# Prerequisites
- Java 8+
- IntelliJ (optional)

#Updates
```
  - (18-Jan-2020)
      Added infix calculations -> (2*9)+5*(2*6) ...
```
# Features
- Remembers your previous calculation/result which you can access by replacing operand with 'prev'.
- recalls/stores all your previous calculations and show you by simply typing 'recall'
- Exits the program whenever 0 (int/double) is encounted on first operand or by typing 'exit' or 'quit'.
- Error handling for wrong syntax or unknown commands and more.
- Others features that weren't asked or I can't recall rightaway... :3

# Assumptions
- Assumed that input is string or a line which is parsed based on space, using custom method that is way faster than String.split(" +") regex to skip extra spaces in middle of the line.
- If there is no input and user pressed enter, it is counted as 'Line break' and thus it also exits the program.
- By my naive calculation space and time complexity is o(n). Even if it's wrong, it won't go anywhere near nLogn or god forbid n^2.


#Screenshots and gifs
## Infix calculatiom
![image](https://user-images.githubusercontent.com/6762915/149878476-39458af1-d89a-4c11-b76d-1b501c108c77.png)


## Working gif...
![Gif](http://213.32.15.53:6969/idea64_Tp1YqKCIQm.gif)
Imgur link in case my server is down -> https://i.imgur.com/OvusCWg.gif
