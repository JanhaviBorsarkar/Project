# import libraries
import random as rd
import time 
from tkinter import Tk, Button, DISABLED

def show_symbol(x,y):
    global first
    global previousx , previousy
    buttons[x,y]['text'] = button_symbols[x,y]
    buttons[x,y].update_idletasks()

    if first:
        previousx = x
        previousy = y
        first = False
    elif previousx != x or previousy != y:
        if buttons[previousx,previousy]['text'] != buttons[x,y]['text']:
            time.sleep(0.5)
            buttons[previousx,previousy]['text'] = ' '
            buttons[x,y]['text'] = ' '
        else:
            buttons[previousx,previousy]['command'] = DISABLED
            buttons[x,y]['command'] = DISABLED
        first = True

# defining window
win = Tk()
win.resizable(width = False, height = False)      # to prevent resization
win.title('Match the Cards')
first = True
previous_x = 0
previous_y = 0

# adding symbols
buttons = { }
button_symbols = { }
symbols = [u'\u2702',u'\u2705',u'\u2708',u'\u2709',u'\u270A',u'\u270B',
            u'\u270C',u'\u270F',u'\u2712',u'\u2714',u'\u2716',u'\u2728',
            u'\u2702',u'\u2705',u'\u2708',u'\u2709',u'\u270A',u'\u270B',
            u'\u270C',u'\u270F',u'\u2712',u'\u2714',u'\u2716',u'\u2728']
 
rd.shuffle(symbols)

for x in range(6):
    for y in range(4):
        button = Button(command = lambda x=x , y=y: show_symbol(x,y) , width = 10, height = 8)
        button.grid(column = x , row = y)
        buttons[x,y] = button
        button_symbols[x,y] = symbols.pop()

win.mainloop()
