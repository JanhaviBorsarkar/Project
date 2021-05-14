# importing libraries
from itertools import cycle
from random import randrange
from tkinter import Tk, Canvas, messagebox, font

# defining canvas size
canvas_width = 800
canvas_height = 400

# defining window
win = Tk()
win.resizable(width = False, height = False)      # to prevent resization

# setting background
background = Canvas(win, width = canvas_width, height = canvas_height, background = 'deep sky blue')
background.create_rectangle(-5, canvas_height - 100, canvas_width + 5, canvas_height + 5, fill = 'sea green', width = 0)
background.create_oval(-80, -80, 120, 120, fill = 'orange', width = 0)

# color cycle for eggs
color_cycle = cycle(['blue', 'pink', 'yellow', 'purple', 'red', 'orange', 'brown', 'white'])

# defining eggs
egg_width = 45
egg_height = 55
egg_score = 10
egg_speed = 500
egg_interval = 4000
difficulty_factor = 0.95

# defining catcher
catcher_color = 'black'
catcher_width = 100
catcher_height = 100
catcher_start_x = canvas_width / 2 - catcher_width / 2
catcher_start_y = canvas_height - catcher_height - 20
catcher_start_x2 = catcher_start_x + catcher_width
catcher_start_y2 = catcher_start_y + catcher_height
catcher = background.create_arc(catcher_start_x, catcher_start_y, catcher_start_x2, catcher_start_y2, start = 200, extent = 140, style = 'arc', outline = catcher_color, width = 3)

# defining score
score = 0
score_text = background.create_text(10, 10, anchor = 'nw', font = ('Comic Sans MS', 18, 'bold'), fill = 'black', text = 'Score: ' + str(score))

# defining lives
lives_remaining = 3
lives_text = background.create_text(canvas_width - 10, 10, anchor = 'ne', font = ('Comic Sans MS', 18, 'bold'), fill = 'black', text = 'Lives: ' + str(lives_remaining))

# working of eggs
eggs = []
def create_egg():
    x = randrange(10, 740)
    y = 40
    new_egg = background.create_oval(x, y, x + egg_width, y + egg_height, fill = next(color_cycle), width = 0)
    eggs.append(new_egg)
    win.after(egg_interval, create_egg)

# defining motion of eggs
def move_eggs():
    for egg in eggs:
        (egg_x, egg_y, egg_x2, egg_y2) = background.coords(egg)
        background.move(egg, 0, 10)
        if egg_y2 > canvas_height:
            egg_dropped(egg)
    win.after(egg_speed, move_eggs)

# dropping of eggs
def egg_dropped(egg):
    eggs.remove(egg)
    background.delete(egg)
    lose_a_life()
    if lives_remaining == 0:
        messagebox.showinfo('Game Over!', 'Final Score: ' + str(score))
        win.destroy()

# losing a life
def lose_a_life():
    global lives_remaining
    lives_remaining -= 1
    background.itemconfigure(lives_text, text = 'Lives: ' + str(lives_remaining))

# catching eggs
def catch_egg():
    (catcher_x, catcher_y, catcher_x2, catcher_y2) = background.coords(catcher)
    for egg in eggs:
        (egg_x, egg_y, egg_x2, egg_y2) = background.coords(egg)
        if catcher_x < egg_x and egg_x2 < catcher_x2 and catcher_y2 - egg_y2 < 40:
            eggs.remove(egg)
            background.delete(egg)
            increase_score(egg_score)
    win.after(100, catch_egg)

# increasing the score
def increase_score(points):
    global score, egg_speed, egg_interval
    score +=points
    egg_speed = int(egg_speed + difficulty_factor)
    egg_interval = int(egg_interval * difficulty_factor)
    background.itemconfigure(score_text, text = 'Score: ' + str(score))
    
# moving with keys
def move_left(event):
    (x1, y1, x2, y2) = background.coords(catcher)
    if x1 > 0:
        background.move(catcher, -20,  0)

def move_right(event):
    (x1, y1, x2, y2) = background.coords(catcher)
    if x2 < canvas_width:
        background.move(catcher, 20,  0)

# binding keys
background.bind('<Left>', move_left)
background.bind('<Right>', move_right)
background.focus_set()

win.after(1000, create_egg)
win.after(1000, move_eggs)
win.after(1000, catch_egg)
    
background.pack()
win.mainloop()
