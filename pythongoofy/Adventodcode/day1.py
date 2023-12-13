f = open('pythongoofy\Adventodcode\day1.txt','r')
data = [i.strip() for i in f.readlines()]
realnumbers= ["one","two", ""]
#data = ["1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"]
print(data)
sum = 0

for i in range(len(data)):
    tempnum = ""
    temp = []
    string = data[i]
    for i in range(0, len(string)):#find digit in string from L to R
        if (string[i].isnumeric()==True):
            temp.append(string[i])
            break
    for y in reversed(range(0,len(string))):#find digit in reverse order
        if (string[y].isnumeric()==True):
            temp.append(string[y])
            break
        
   
    tempthingstr = ''.join(map(str,temp))
 
    sum += int(tempthingstr)
   
    temp.clear()
        
        
    
    
print(sum)