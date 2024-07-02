 # master formula
 T(N) = a* T(N/b) + O(N^d)


a -> In the root question, how many times subproblems of the same size are called


b -> The size of subproblems (if you want to use master formula to get time complexity, the size of subproblems must same)


O(N^d) -> the other codes time complexity

e.g.
GetMax
Master: T(N) = 3*T(N/2) + O(1)

**Time Complexity**
1. log(b,a) > d -> Time Complexity: O(N^log(b,a))
2. log(b,a) = d -> Time Complexity: O(N^d * logN)
3. log(b,a) < d -> Time Complexity: O(N^d)