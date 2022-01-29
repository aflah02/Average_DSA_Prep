for i in range(int(input())):
    n = int(input())
    ls = [i for i in range(1,n+1)]
    out = []
    st = set(ls)
    xorsum = 0
    for i in range(len(ls)):
        maxxorsofar = -1
        ind = -1
        for j in st:
            if ls[i]^j > maxxorsofar:
                maxxorsofar = ls[i]^j
                ind = i
                print(maxxorsofar, ls[i])
        out.append(ls[ind])
        st.remove(ls[ind])
        xorsum += maxxorsofar
    print(out)
    print(xorsum)