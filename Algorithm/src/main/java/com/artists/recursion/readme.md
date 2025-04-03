 # Master formula

**The subproblems must be of equal size,and then you can use master formula to get time complexity**

 T(N) = a* T(N/b) + O(N^d)


a -> In the root question, how many times subproblems of the same size are called


b -> The size  of subproblems (if you want to use master formula to get time complexity, the size of subproblems must same)


O(N^d) -> the other codes time complexity

e.g.
GetMax
Master: T(N) = 3*T(N/2) + O(1)

**Time Complexity**
1. log(b,a) > d -> Time Complexity: O(N^log(b,a))
2. log(b,a) = d -> Time Complexity: O(N^d * logN)
3. log(b,a) < d -> Time Complexity: O(N^d)

**How to set mid**

Normally you will use (L+R)/2, but if L and R large enough,
the result will overflow.So what you can do is use L+(R-L)/2, you can also simplify it,L+((R-L)>>1) 