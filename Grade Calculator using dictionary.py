# 1. Jack's dictionary
jack = {"name": "Jack Frost",
        "assignment": [80, 50, 40, 20],
        "test": [75, 75],
        "lab": [78.20, 77.20]
        }

# 2. James's dictionary
james = {"name": "James Potter",
         "assignment": [82, 56, 44, 30],
         "test": [80, 80],
         "lab": [67.90, 78.72]
         }

# 3. Dylan's dictionary
dylan = {"name": "Dylan Rhodes",
         "assignment": [77, 82, 23, 39],
         "test": [78, 77],
         "lab": [80, 80]
         }

# 4. Jessica's dictionary
jess = {"name": "Jessica Stone",
        "assignment": [67, 55, 77, 21],
        "test": [40, 50],
        "lab": [69, 44.56]
        }

# 5. Tom's dictionary
tom = {"name": "Tom Hanks",
       "assignment": [29, 89, 60, 56],
       "test": [65, 56],
       "lab": [50, 40.6]
       }

# Calculate average
def avg(marks):
    add = sum(marks)
    add = float(add)
    return add / len(marks)

# find total average
def final_avg(students):
    assignment = avg(students["assignment"])
    test = avg(students["test"])
    lab = avg(students['lab'])

    # Return the result based
    # on weightage supplied
    # 10 % from assignments
    # 70 % from test
    # 20 % from lab-works
    return (0.1 * assignment) + (0.7 * test) + (0.2 * lab)

# decide grade
def grade(score):
    if score >= 90: return "A"
    elif score >= 80: return "B"
    elif score >= 70: return "C"
    elif score >= 60: return "D"
    else: return "E"

# calculate class average
def class_avg(studs):
    res = []
    for s in studs:
        savg = final_avg(s)
        res.append(savg)
        return avg(res)

# Student list consisting the dictionary of all students
students = [jack, james, jess, dylan, tom]

# print students' marks
for stu in students:
    print(stu["name"])
    print("The average marks of {0} are {1}" .format(stu["name"], final_avg(stu)))
    print("Grade of {0} is {1}" .format(stu["name"], grade(final_avg(stu))))
    print()

# print marks of whole class
print("The average of whole class is ", class_avg(students))
print("The grade for whole class is " ,grade(class_avg(students)))