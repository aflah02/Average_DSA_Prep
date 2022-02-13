import numpy
c = numpy.zeros((4,4))
numpy.fill_diagonal(c,-1)
for i in range(len(c)):
    c[i][(i+1)%len(c)]=1
# print(c)
ls = [1,-3,4]
ls.append(-1*sum(ls))
ls = numpy.array(ls)
# print(ls)
lower = 1
upper = 6
print(numpy.linalg.lstsq(c,ls))