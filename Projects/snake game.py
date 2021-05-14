# importing the libraries
import turtle as t
import random as rd
import time as ti

# background color
t.bgcolor('black')

# defining snake
caterpiller = t.Turtle()
caterpiller.shape('square')
caterpiller.color('brown')
caterpiller.speed(0)
caterpiller.penup()
caterpiller.hideturtle()

# defining leaf
leaf = t.Turtle()
leaf_shape = ((0,0), (14,2), (18,6), (20,20), (6,18), (2,14))
t.register_shape('leaf', leaf_shape)
leaf.shape('leaf')
leaf.color('green')
leaf.penup()
leaf.hideturtle()
leaf.speed()

# how to start
game_started = False
text_turtle = t.Turtle()
text_turtle.color('white')
text_turtle.write('Press SPACE to start', align = 'center', font = ('Comic Sans MS', 18, 'bold'))

# score
score_turtle = t.Turtle()
score_turtle.hideturtle()
score_turtle.speed(0)

# to check if the snake is inside or ou of the window
def outside_window():
    left_wall = -t.window_width() / 2 
    right_wall = t.window_width() / 2 
    top_wall = t.window_height() / 2
    bottom_wall = -t.window_height() / 2
    (x,y) = caterpiller.pos()
    outside = x < left_wall or x > right_wall or y > top_wall or y < bottom_wall
    return outside

# leaf position
def place_leaf():
    leaf.hideturtle()
    leaf.setx(rd.randint(-200, 200))
    leaf.sety(rd.randint(-200, 200))
    leaf.showturtle()

# game over
def game_over():
  caterpiller.color('black')
  leaf.color('black')
  t.penup()
  t.hideturtle()
  t.color('white')
  t.write('OOPS, GAME OVER!', align = 'center',  font = ('Comic Sans MS', 30, 'normal'))
  
# display the score
def display_score(current_score):
    score_turtle.clear()
    score_turtle.penup()
    x = (t.window_width()/2) - 50
    y = (t.window_height()/2) - 50
    score_turtle.setpos(x,y)
    score_turtle.color('white')
    score_turtle.write(str(current_score), align = 'right', font = ('Comic Sans MS', 40, 'bold'))

def start_game():
    global game_started
    if game_started:
        return
    game_started = True
    score = 0
    text_turtle.clear()
    caterpiller_speed = 2
    caterpiller_length = 3
    caterpiller.shapesize(1, caterpiller_length, 1)
    caterpiller.showturtle()
    display_score(score)
    place_leaf()

    while True:
        caterpiller.forward(caterpiller_speed)
        if caterpiller.distance(leaf)<20:
            place_leaf()
            caterpiller_length = caterpiller_length + 1
            caterpiller.shapesize(1,caterpiller_length,1)
            caterpiller_speed = caterpiller_speed + 1
            score = score + 10
            display_score(score)
        if outside_window():
            game_over()
            break

def move_up():
    if caterpiller.heading() == 0 or caterpiller.heading() == 180:
        caterpiller.setheading(90)

def move_down():
    if caterpiller.heading() == 0 or caterpiller.heading() == 180:
        caterpiller.setheading(270)

def move_left():
    if caterpiller.heading() == 90 or caterpiller.heading() == 270:
        caterpiller.setheading(180)

def move_right():
    if caterpiller.heading() == 90 or caterpiller.heading() == 270:
        caterpiller.setheading(0)

    
t.onkey(start_game, 'space')
t.onkey(move_up,'Up')
t.onkey(move_right,'Right')
t.onkey(move_down,'Down')
t.onkey(move_left,'Left')
t.listen()
t.mainloop()
ti.sleep(3)
