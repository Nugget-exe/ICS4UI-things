num = int(input())



for i in range(num):
    n,k = list(map(int, input().split()))
    
def factorial(n):
    if n == 0 or n == 1: # base case
        return 1
    return n * factorial(n-1)
def bitpattern(n,k):

    #recursion 
    if k == 0:
        return '0'*n
    
    

    return 

print(bitpattern(2,1))





