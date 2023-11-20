def fib(fib_list, n):
    if n <= 2:
        fib_list[n - 1] = 1
        return 1
    else:
        if fib_list[n - 1] > 0:
            return fib_list[n - 1]
        else:
            f = fib(fib_list, n - 1) + fib(fib_list, n -2)
            fib_list[n - 1] = f
        return f

cnt = int(input())
for i in range(0, cnt):
    rev = ""
    line = input()
    lst = line.split(", ")
    n = int(lst[0])
    d = int(lst[1])
    # print(n, d)
    if d > n:
        rev = "invalid"
    else:
        fib_list = [0]*n
        fib(fib_list, n)
        fib_list.reverse()
        revfib = fib_list[0 : d]
        for i in range(0, len(revfib)):
            if i < len(revfib) - 1:
                rev += str(revfib[i]) + ", "
            else:
                rev += str(revfib[i])
    print(rev)