import numpy as np
line = input()
lst = line.split(" ")
m = int(lst[0])
n = int(lst[1])
p = int(lst[2])

mtx1 = []
mtx2 = []
mtx3 = []
for i in range(m):
	mtx1.append(list(map(int, input().rstrip().split())))
for j in range(n):
	mtx2.append(list(map(int, input().rstrip().split())))
mtx1 = np.array(mtx1)
mtx2 = np.array(mtx2)
mtx3 = np.dot(mtx1, mtx2)
rev = ""
for i in range(m):
	for j in range(p):
		rev += str(mtx3[i][j]) + " "
		rev = rev.rstrip()
	print(rev)
	rev = ""

	